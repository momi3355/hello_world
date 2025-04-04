/**
 * ajax.js
 */
let dataAry = [];
const xhtp = new XMLHttpRequest();
xhtp.open('get', 'data/MOCK_DATA.json'); //경로지정.
xhtp.send();
xhtp.onload = function() {
   let obj = JSON.parse(xhtp.responseText);
   dataAry = obj;
   //화면출력
   obj.forEach((item,  idx, ary) => {
      let tr = makeRow(item);
      document.querySelector('tbody#target').appendChild(tr);
   });
};

//한 건 데이터를 매개값으로 tr을 생성하는 함수.
function makeRow(emp = { id, first_name, last_name, email, gender, salary }) {
   const fields = ['id', 'first_name', 'last_name', 'gender'];
   let tr = document.createElement('tr'); //<tr></tr>
   //체크박스
   let td = document.createElement('td'); //<td></td>
   let chbox = document.createElement('input'); //<input></input>
   chbox.setAttribute('type', 'checkbox');
   td.appendChild(chbox); // td < input
   tr.appendChild(td); // tr < td < input
   //값
   for (let i = 0; i < fields.length; i++) {
      let td = document.createElement('td'); //<td></td>
      td.innerHTML = emp[fields[i]];
      tr.appendChild(td); //tr < td
   }
   //버튼
   td = document.createElement('td'); //<td></td>
   let btn = document.createElement('button'); //<button></button>
   btn.setAttribute('class', 'btn btn-danger');
   btn.innerText = '삭제';
   btn.addEventListener('click', deleteRow);
   td.appendChild(btn); // td < btn
   tr.appendChild(td); // tr < td < btn
   return tr;
}

function deleteRow(e) {
   e.target.parentElement.parentElement.remove(); // (tr < td < button).remove();
}

//thead의 checkbox에 이벤트(change)등록.
document.querySelector('thead input[type="checkbox"]')
   .addEventListener('change', function(e) {
      let checked = e.target.checked; //thead[checked]
      // tbody#taget안에 있는 input[type="checkbox"]를 전부 가지고 온다.
      // 그 후, 현재 버튼의 'checked'랑 동일하게 한다.
      document.querySelectorAll('tbody#target input[type="checkbox"]')
         .forEach(function(element) {
            element.checked = checked;
         });
   });

//select의 change 이벤트.
document.querySelector('select#searchGender')
   .addEventListener('change', function(e) {
      let value = e.target.value;
      document.querySelector('tbody#target').innerHTML = ''; //clear();
      let options = e.target.options;
	  	dataAry.forEach(element => {
	      let gender = element.gender;

         if (value == 'all' || value == gender) {
            let tr = makeRow(element);
            document.querySelector('tbody#target').appendChild(tr);
         } else if (value == 'etc') { //그외
            let isin = false;
            for (let i = 0; i < options.length; i++)
               if (options[i].value == gender)
                  isin = true;
            if (!isin) {
               let tr = makeRow(element);
               document.querySelector('tbody#target').appendChild(tr);
            }
         }
      });
   });