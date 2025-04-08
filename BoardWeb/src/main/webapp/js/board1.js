/**
 * board1.js
 * XMLHttpRequest, fetch -> 실행순서.
 */

let page = 1;

//추가 이벤트.
document.querySelector('button#addReply').addEventListener('click', function() {
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
            //let item = result.retVal; //반환결과값 활용.
            document.querySelector('input#reply').value = ""; //인풋박스 클리어
            alert('등록성공!');
            page = 1;
            //다시 호출.
            svc.replyList({ bno: bno, page: page }, successCallback, errorCallback);
            //페이징목록 보여주기
            svc.pagingList(bno, pagingCallback, errorCallback);
         } else {
            alert('등록실패!');
         }
      }, errorCallback);
});

/*
 * 페이지 링크
 */
function pageLink() {
   document.querySelectorAll('div.reply ul a')
      .forEach(function(atag) {
         atag.addEventListener('click', function(e) {
            e.preventDefault(); //이벤트의 기본기능 차단.
            page = atag.dataset.page; // <a data-page='3'>3</a>
            //console.log(page);
            //dataset은 "data-"로 시작하는 속성을 가지고오는 set
               
            //다시 호출.
            svc.replyList({ bno: bno, page: page }, successCallback, errorCallback);
            
            //페이징목록 보여주기
            svc.pagingList(bno, pagingCallback, errorCallback);
         });
      });
}

/**
 * 실패시 실행한는 메소드.
 */
function errorCallback(err) {
   console.error(err);
}

/**
 * 성공시 실행하는 메소드.
 */
function successCallback(result) {
   //console.log(result);
   //기존목록 지우기.
   document.querySelectorAll('div.reply div.content>ul>li')
      .forEach((litag, idx) => {
         //값이 비여있으면 삭제를 한함.
         if (idx) { //falsy(null, undefined, 0, '')
            litag.remove();
         }
      });
   result.forEach(item => makeRow2(item));
}

//목록 보여주기.
svc.replyList({ bno: bno, page: page }, successCallback, errorCallback);

/**
 * 페이지를 계산하는 메소드.
 */
function pagingCallback(result) {
   //console.log(result.totalCnt);
   let totalCnt = result.totalCnt;
   //첫페이지, 마지막페이지, => 현재페이지로 계산.
   let startPage, endPage;
   //이전페이지, 이후페이지
   let prev, next;
   //시작, 마지막(10)
   endPage = Math.ceil(page / 10) * 10; //소수점으로 적지않아도 된다.
   startPage = endPage - 9;

   //진짜 마지막의 last of the last
   let realEnd = Math.ceil(totalCnt / 5); //진짜 마지막 페이지
   endPage = endPage > realEnd ? realEnd : endPage; //마지막 페이지인지 확인

   //이전, 이후 확인
   prev = startPage == 1 ? false : true; 
   next = endPage < realEnd ? true : false;

   //페이징 초기화
   document.querySelector('nav>ul.pagination').innerHTML = "";

   //이전페이지
   if (prev) {
      let html = //html
      `<li class="page-item">
         <a class="page-link" href="#" data-page="${startPage-1}">Previous</a>
      </li>`;
      let target = document.querySelector('nav>ul.pagination');
      target.insertAdjacentHTML('beforeend', html);
   } else {
      let html = //html
      `<li class="page-item disabled">
         <span class="page-link">Previous</span>
      </li>`;
      let target = document.querySelector('nav>ul.pagination');
      target.insertAdjacentHTML('beforeend', html);
   }

   //페이징
   for (let p = startPage; p <= endPage; p++) {
      let html = /*html*/`<li class="page-item"><a class="page-link" href="#" data-page="${p}">${p}</a></li>`;
      if (p == page) { //현재 페이지랑 같으면
         html = //html
         `<li class="page-item active" aria-current="page">
            <span class="page-link">${p}</span>
         </li>`;
      }
      let target = document.querySelector('nav>ul.pagination');
      target.insertAdjacentHTML('beforeend', html);
   }

   //이후페이지
   if (next) {
      let html = //html
      `<li class="page-item">
         <a class="page-link" href="#" data-page="${endPage+1}">Next</a>
      </li>`;
      let target = document.querySelector('nav>ul.pagination');
      target.insertAdjacentHTML('beforeend', html);
   } else {
      let html = //html
      `<li class="page-item disabled">
         <span class="page-link">Next</span>
      </li>`;
      let target = document.querySelector('nav>ul.pagination');
      target.insertAdjacentHTML('beforeend', html);
   }

   //링크이벤트 등록
   pageLink();
}

//페이징목록 보여주기
svc.pagingList(bno, pagingCallback, errorCallback);

/**
 * 댓글정보를 화면에 출력하는 메소드.
 */
function makeRow2(item) {
   //li 태그에 속성 추가.
   let html = //html
   `<li data-rno="${item.replyNo}" id="rno_${item.replyNo}">
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
            alert('삭제성공!!');
            //다시 호출.
            svc.replyList({ bno: bno, page: page }, successCallback, errorCallback);
            //페이징목록 보여주기
            svc.pagingList(bno, pagingCallback, errorCallback);
         }
      }, errorCallback); //실패
}