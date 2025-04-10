<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    async function drawChart() {
      var dataAry = [];
      dataAry.push(['MamberName', 'Count per Member']);
      await fetch("chartJson.do")
        .then(result => result.json())
        .then(result => {
          result.forEach(item => {
            dataAry.push([item.userName, item.cnt]);
          })
        })
        .catch(err => console.error(err));
      //console.log(dataAry);
      var data = google.visualization.arrayToDataTable(dataAry);

      var options = {
        title: '사용자별 작성건수',
        is3D: true,
      };

      var chart = new google.visualization.PieChart(document.getElementById('piechart'));

      chart.draw(data, options);
    }
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
  </body>
</html>