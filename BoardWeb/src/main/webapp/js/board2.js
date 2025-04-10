/**
 * board2.js
 */

/*json
{
   "data": [
      [
         "Tiger Nixon",
         "System Architect",
         "Edinburgh",
         "5421",
         "2011-04-25",
         "$320,800"
      ], ...
   ]
} */

//console.log(`replyListDataTable.do?bno=${bno}`);
const table = new DataTable("#table", {
  ajax: `replyListDataTable.do?bno=${bno}`,
  order: [[0, "desc"]],
  lengthMenu: [
    [5, 10, 25, 50, -1],
    [5, 10, 25, 50, "All"],
  ],
  columns: [
    { data: "REPLY_NO" },
    { data: "REPLY" },
    { data: "REPLYER" },
    { data: "REPLY_DATE" },
  ],
});
table.on("click", "tbody tr", (e) => {
  let textReplyer = e.currentTarget.querySelectorAll("td")[2].innerHTML;
  if (textReplyer != replyer) {
    alert("작성자가 달라 선택할 수 없습니다.");
    return;
  }

  let classList = e.currentTarget.classList;

  if (classList.contains("selected")) {
    classList.remove("selected");
  } else {
    table
      .rows(".selected")
      .nodes()
      .each((row) => row.classList.remove("selected"));
    classList.add("selected");
  }
});

function addNewRow() {
  //control을 통해서 BD 한건 추가.
  //택스트 박스에 데이터 추출
  //console.log(reply.value);
  //let reply = document.querySelector('#reply').value;
  fetch(`addReply.do?bno=${bno}&replyer=${replyer}&reply=${reply.value}`)
    .then((result) => result.json())
    .then((result) => {
      //console.log(result);
      if (result.retCode == "OK") {
        table.row
          .add({
            REPLY_NO: result.retVal.replyNo,
            REPLY: result.retVal.reply,
            REPLYER: result.retVal.replyer,
            REPLY_DATE: result.retVal.replyDate,
          })
          .draw(false);
      }
    })
    .catch((err) => console.error(err));
}

document.querySelector("#addRow").addEventListener("click", addNewRow);
document.querySelector("#delRow").addEventListener("click", function () {
  const selected = table.row(".selected");
  if (!selected.data()) {
    //없으면 'undefined'
    alert("선택을 하세요");
    return;
  }
  const selectReplyNo = selected.node().firstChild; //첫번째 자식
  //console.log(selectReplyNo);
  const rno = selectReplyNo.textContent;
  //let rno = table.row('.selected').data().REPLY_NO;
  //console.log(selected.data());
  fetch(`removeReply.do?rno=${rno}`)
    .then((result) => result.json())
    .then(() => alert("삭제성공"))
    .catch((err) => console.error(err));
  selected.remove().draw(false);
});
