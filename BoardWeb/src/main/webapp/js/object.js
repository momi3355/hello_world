/**
 * 내가 만든 자바크스립트(object.js)
 */

console.log("확인");

//DOM 제어.
let li = document.createElement("li"); //DOM에 요소를 생성.
li.innerText = "cherry"; //<li>cherry</li>

document.querySelector("ul#list").appendChild(li); //자식요소 추가.
document.querySelector("ul#list").style.display = "none";
//console.log(document.querySelector('ul#list'));

let name = "Hong";
console.log(typeof name); //String

const obj = {
  name: "홍길동",
  age: 20,
  friends: ["김길동", "박길동"],
  pets: [
    {
      name: "멍멍이",
      age: 3,
    },
    {
      name: "야옹이",
      age: 2,
    },
  ],
};
obj.height = 165.8;

console.log(typeof obj); //Object
console.log(obj.name, obj["age"]);
console.log("첫번째친구 : ", obj["friends"][0]);
console.log("첫번째동물 : ", obj.pets[0]["name"]);
//최길동 추가.
obj.friends[2] = "최길동";
//친구목록

//for (let i = 0; i < obj.friends.length; i++)
for (const fri of obj.friends) {
  console.log("친구이름: ", fri);
}

//애완동물('찍찍이') 추가.
obj.pets.push({
  name: "찍찍이",
  age: 1,
});
//애완동물 목록. 화면출력.
// table: {
//    thead: '2tr'
//    tbody: '...'
// };
let tblHTML = `<table class='table'>`;
tblHTML += `<thead><tr><th>이름</th><th>나이</th></tr></thead>`;
tblHTML += `<tbody>`;
for (const pet of obj.pets) {
  //forEach 사용
  console.log(`이름: ${pet.name}, 나이: ${pet.age}`);
  tblHTML += `<tr><td>${pet.name}</td><td>${pet.age}</td></tr>`;
}
tblHTML += `</tbody>`;
tblHTML += "</table>";

document.querySelector("nav+div.container-fluid").innerHTML += tblHTML;
