/**
 * board1.js
 * XMLHttpRequest, fetch -> 실행순서.
 */

//추가 이벤트.
document.querySelector('button#addReply').addEventListener('click', function(e) {
   if (replyer == '') {
      alert('로그인하세요.');
      return;
   }
   //bno, replyer, reply: #reply.value 속성.
   let reply = document.querySelector('#reply').value;
   if (reply == '') {
      alert('댓글을 입력하세요.');
      return;
   }

   svc.addReply({bno, reply, replyer},
      result => {
         if (result.retCode == 'OK') {
            let item = result.retVal; //반환결과값 활용.
            makeRow2(item);
            alert('등록성공!');
            document.querySelector('input#reply').value = ""; //인풋박스 클리어
         } else {
            alert('등록실패!');
         }
      }, errorCallback);
});

//동기, 비동기(Asynchronous Javascript And Xml)
svc.replyList(bno, successCallback, errorCallback);

/**
 * 성공시 실행하는 메소드.
 */
function successCallback(result) {
   result.forEach(item => makeRow2(item));
}

/**
 * 실패시 실행한는 메소드.
 */
function errorCallback(err) {
   console.error(err);
}

/**
 * 댓글정보를 화면에 출력하는 메소드.
 */
function makeRow2(item) {
   //li 태그에 속성 추가.
   let html = /*html*/`<li data-rno="${item.replyNo}" id="rno_${item.replyNo}">
         <span class="col-sm-2">${item.replyNo}</span>
         <span class="col-sm-5">${item.reply}</span>
         <span class="col-sm-2">${item.replyer}</span>
         <span class="col-sm-2"><button class="btn btn-danger" onclick="deleteFnc(${item.replyNo})">삭제</button></span>
      </li>`;
   let templ = document.querySelector('div.content>ul');
   templ.insertAdjacentHTML('beforeend', html); //li 태그의 뒤에 추가.
}

/**
 * 삭제 이벤트 메소드.
 */
function deleteFnc(rno) {
   let deleteOK = confirm('삭제하겠습니까?');
   if (!deleteOK) return;

   svc.removeReply(rno //삭제할 댓글번호
      , function(result) {
         //console.log(result); //{'retCode': 'OK/NG'};
         if (result.retCode == 'OK') { //성공
            document.querySelector(`#rno_${rno}`).remove();
            alert('삭제성공!!');
         }
      }, errorCallback); //실패
}