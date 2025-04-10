<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link rel="stylesheet" href="css/common-styles.css" />
  </head>
  <body>
    <div class="sido">
      <select name="choice" id="choice" class="form-control"></select>
    </div>
    <!-- 센터목록테이블. -->
    <table class="table table-striped">
      <thead>
        <tr>
          <th>ID</th>
          <th>센터명</th>
          <th>연락처</th>
          <th>시도정보</th>
        </tr>
      </thead>
      <tbody id="centerList"></tbody>
    </table>

    <script>
      let url =
        "https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&returnType=json&serviceKey=yFGkTGadJdPRiIaJd2%2FZCghr5d%2BqSQc5p7XsAi%2B3VJfcLEJWuQ4zQ94vJYBum8SJ5K3dku%2B0fUkx17C%2FFzwHPg%3D%3D";
      let centerList = []; //Array.filter(); Array.reduce();
      fetch(url)
        .then((result) => result.json())
        .then((result) => {
          console.log(result.data);
          centerList = result.data; //센터 전체
          let sidoAry = []; //284건의 센터정보.
          centerList.forEach((center) => {
            if (sidoAry.indexOf(center.sido) == -1) {
              sidoAry.push(center.sido); //중복되지 않는 시도정보
            }
          });
          //console.log(sidoAry);
          //시도정보 생성('option'태그 생성).
          sidoAry.forEach((sido) => {
            let opt = document.createElement("option");
            opt.innerHTML = sido;
            document.querySelector("#choice").appendChild(opt);
          });
          //초기목록 출력(10개).
          centerList.forEach((center, idx) => {
            if (idx < 10) {
              let tr = makeCenter(center);
              document.querySelector("#centerList").appendChild(tr);
            }
          });
        })
        .catch((err) => console.error(err));

      //이벤트 ... this 1) 함수 : window 2) 이벤트: 이벤트대상.
      document
        .querySelector("#choice")
        .addEventListener("change", function (e) {
          //console.log(this);
          let val = this.value;
          document.querySelector("#centerList").innerHTML = ""; //목록지우기.
          centerList
            .filter((center) => center.sido == val) //시도같은거
            .forEach((center, idx) => {
              // 리스트 업데이트
              let tr = makeCenter(center);
              document.querySelector("#centerList").appendChild(tr);
            });
        });

      function makeCenter(center = {}) {
        let tr = document.createElement("tr");
        //클릭이벤트.
        tr.addEventListener("click", function (e) {
          openWindow(center);
        });
        let fields = ["id", "centerName", "phoneNumber", "sido"];
        //td 생성.
        fields.forEach((field) => {
          let td = document.createElement("td");
          td.innerHTML = center[field];
          tr.appendChild(td);
        });

        return tr;
      }

      //tr 클릭이벤트 핸들러.
      function openWindow(center = {}) {
        window.open(
          "map.jsp?lat=" +
            center.lat +
            "&lng=" +
            center.lng +
            "&centerName=" +
            center.centerName
        );
      }
    </script>
  </body>
</html>
