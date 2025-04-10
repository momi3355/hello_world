/**
 * array.js
 * push(뒤), unshift(앞) 추가관련.
 * pop(뒤), shift(앞) 제거관련.
 * splice 추가, 수정, 삭제
 * forEach() //반복 메소드
 */

const ary = []; //array();
//push, unshift
ary.push("홍길동");
ary.push("김길동");
ary.unshift("최길동");

ary.forEach((e) => console.log(e));
ary.pop(); //'김길동'
ary.shift(); //'최길동'

ary.splice(0, 1, "박길동", "황길동");
//시작 인덱스, 삭제할 갯수, 대체값(이로써 삭제, 수정, 추가가 가능하다.)

ary.forEach(function (item, idx, ary) {
  console.log(`item=>${item}, idx=>${idx}, ary=>${ary}`);
});

//함수
function addElement(element = "noElement") {
  ary.push(element);
}

//화면요소 제거.
function deleteElement(e) {
  //console.log(e.target.parentElement);
  e.target.parentElement.remove();
  //alert('삭제버튼 눌름');
}

//추가버튼에 클릭 이벤트.
document
  .querySelector("button#addBtn")
  .addEventListener("click", function (params) {
    //input의 값.
    let val = document.querySelector("input#userInput").value;
    addElement(val); //ary배열에 추가.
    //화면에 출력
    let html = "";
    ary.forEach((item, idx, ary) => {
      html += `<li>${item}<button onclick="deleteElement(event)">삭제</button></li>`;
    });
    //ul 태그의 영역에 추가.
    document.querySelector("ul#list").innerHTML = html;
  });
