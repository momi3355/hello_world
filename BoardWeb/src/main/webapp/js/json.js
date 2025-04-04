/**
 * json.js
 */

const jsonStr = `
   [{"id":1,"first_name":"Leanor","last_name":"Camerati","email":"lcamerati0@marriott.com","gender":"Female","ip_address":"225.253.107.83","salary":8681},
   {"id":2,"first_name":"Betty","last_name":"Ceschelli","email":"bceschelli1@pbs.org","gender":"Female","ip_address":"107.31.223.43","salary":5710},
   {"id":3,"first_name":"Amby","last_name":"Ellacombe","email":"aellacombe2@simplemachines.org","gender":"Polygender","ip_address":"63.217.104.228","salary":4336},
   {"id":4,"first_name":"Jedidiah","last_name":"Danilovitch","email":"jdanilovitch3@irs.gov","gender":"Male","ip_address":"134.231.70.12","salary":4790},
   {"id":5,"first_name":"Rena","last_name":"Chanter","email":"rchanter4@wix.com","gender":"Non-binary","ip_address":"15.86.53.147","salary":7251},
   {"id":6,"first_name":"Louisa","last_name":"Scotchmur","email":"lscotchmur5@about.me","gender":"Female","ip_address":"145.43.33.141","salary":9593},
   {"id":7,"first_name":"Annmaria","last_name":"Krzyzaniak","email":"akrzyzaniak6@earthlink.net","gender":"Female","ip_address":"95.96.238.36","salary":1817},
   {"id":8,"first_name":"Carlo","last_name":"Gillbey","email":"cgillbey7@dmoz.org","gender":"Male","ip_address":"61.208.171.251","salary":1732},
   {"id":9,"first_name":"Kylila","last_name":"Nelius","email":"knelius8@cam.ac.uk","gender":"Female","ip_address":"201.125.129.88","salary":9007},
   {"id":10,"first_name":"Nicolis","last_name":"Kembley","email":"nkembley9@hexun.com","gender":"Male","ip_address":"93.103.34.197","salary":9109},
   {"id":11,"first_name":"Danie","last_name":"Pellitt","email":"dpellitta@webmd.com","gender":"Male","ip_address":"80.102.158.35","salary":4631},
   {"id":12,"first_name":"Gerrie","last_name":"Scrogges","email":"gscroggesb@ebay.com","gender":"Male","ip_address":"150.111.192.185","salary":6262},
   {"id":13,"first_name":"Madge","last_name":"Lampitt","email":"mlampittc@nymag.com","gender":"Female","ip_address":"5.65.45.81","salary":7764},
   {"id":14,"first_name":"Noelle","last_name":"Cobson","email":"ncobsond@blinklist.com","gender":"Female","ip_address":"221.25.91.67","salary":5355},
   {"id":15,"first_name":"Janine","last_name":"Thieme","email":"jthiemee@ft.com","gender":"Female","ip_address":"32.239.30.109","salary":3979}]
`;

let obj = JSON.parse(jsonStr); // json문자열 -> object 변경.
let str = JSON.stringify(obj); // object -> json문자열 변경.
console.log(obj[2].last_name);

//한건 데이터를 매개값으로 tr을 생성하는 함수.
function makeRow(emp = { id, first_name, last_name, email, gender, salary }) {
   const fields = ['id', 'first_name', 'last_name', 'email'];
   let tr = document.createElement('tr'); //<tr></tr>
   for (let i = 0; i < fields.length; i++) {
      let td = document.createElement('td'); //<td></td>
      td.innerHTML = emp[fields[i]];
      tr.appendChild(td); //tr<td
   }
   return tr;
}

//console.log(makeRow(obj[0]).innerHTML);
//화면출력
obj.forEach((item,  idx, ary) => {
   let tr = makeRow(item);
   document.querySelector('tbody#target').appendChild(tr);
});