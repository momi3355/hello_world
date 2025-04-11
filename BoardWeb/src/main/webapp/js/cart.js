/**
 * cart.js
 */

let basket = {
  changePNum, //변경
  delItem, //삭제
  delCheckedItem, //선택상품 삭제
  delAllItem, //전체 삭제
};

function getElement(target) {
  const rowData = target.closest(".row");
  return {
    rowData,
    check: rowData.querySelector(".check>input"),
    name: rowData.querySelector(".pname"),
    price: rowData.querySelector(".basketprice>input"),
    num: rowData.querySelector(".updown>input"),
    total: rowData.querySelector(".sum"),
  };
}

function setTotal() {
  let count = 0;
  let sum = 0;
  const dataList = document.querySelectorAll(".data");

  dataList.forEach((item) => {
    //let id = item.getAttribute("data-id");
    if (item.querySelector(".check>input").checked) {
      let price = item.querySelector(".p_price").value;
      let num = item.querySelector(".p_num").value;
      count += Number(num);
      sum += price * num;
    }
  });

  let sumCount = document.querySelector("#sum_p_num>span");
  sumCount.textContent = count;

  let sumPrice = document.querySelector("#sum_p_price>span");
  sumPrice.textContent = sum.toLocaleString();
}

function changePNum(e) {
  const target = e.target;
  const updown = target.classList.contains("up") ? 1 : -1;
  let el = getElement(target);
  let newNum = Number(el.num.value) + updown;
  if (newNum < 0 || newNum > 999) {
    return;
  }

  el.num.value = newNum;
  let total = newNum * Number(el.price.value);
  el.total.textContent = total.toLocaleString() + "원";
  setTotal();
}

function delItem(e) {
  const row = e.target.closest(".row");
  //전체 값 수정
  row.remove();
  setTotal();
}

function delCheckedItem() {
  document.querySelectorAll(".data .check>input").forEach((checkbox) => {
    checkbox.closest(".data").remove();
  });
  setTotal();
}

function delAllItem() {
  document.querySelectorAll(".data").forEach((item) => item.remove());
  setTotal();
}

window.onload = () => {
  setTotal();
  // document.querySelector("#basket").addEventListener("click", (e) => {
  //   if (e.target.matches(".up") || e.target.matches(".down")) {
  //     basket.changePNum(e);
  //   } else if (e.target.matches(".delete-btn")) {
  //     basket.delItem(e);
  //   }
  // });
  document.querySelectorAll(".check>input").forEach((item) => {
    item.addEventListener("change", setTotal);
  });
};
