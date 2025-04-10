/**
 * board.js
 */

console.log(bno);

const xhtp = new XMLHttpRequest();
xhtp.open("get", `replyList.do?bno=${bno}`);
xhtp.send(); //패이지 요청.
xhtp.onload = function () {
  //console.log(xhtp.responseText);
  let data = JSON.parse(xhtp.responseText);
  console.log(data);

  data.forEach((item) => makeRow2(item));
};

function makeRow(item) {
  let templ = document.querySelector("div.content>ul>li").cloneNode(true); //복제
  //tamplate 가져오기.
  //true: 하위요소도 같이 복제.
  //console.log(templ);
  templ.querySelector("span:nth-of-type(1)").innerHTML = item.replyNo; //댓글번호
  templ.querySelector("span:nth-of-type(2)").innerHTML = item.reply; //댓글내용
  templ.querySelector("span:nth-of-type(3)").innerHTML = item.replyer; //작성자
  templ.querySelector(
    "span:nth-of-type(4)"
  ).innerHTML = /*html*/ `<button>삭제</button>`; //삭제
  document.querySelector("div.content>ul").appendChild(templ);
}

function makeRow2(item) {
  let html =
    /*html*/
    `<li>
         <span class="col-sm-2">${item.replyNo}</span>
         <span class="col-sm-5">${item.reply}</span>
         <span class="col-sm-2">${item.replyer}</span>
         <span class="col-sm-2"><button>삭제</button></span>
      </li>`;
  let templ = document.querySelector("div.content>ul");
  templ.insertAdjacentHTML("beforeend", html); //li 태그의 뒤에 추가.
}
