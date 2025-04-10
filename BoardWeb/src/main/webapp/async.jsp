<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>

<body>
  <button type="button" id="button">버튼</button>
  <script>
    //비동기코드 -> 동기방식.
    document.querySelector('#button')
      .addEventListener('click', async function () {
        let result = await fetch('eventList.do');
        let resolve = await result.json();
        console.log(resolve);
        //.then( result => result.json() )
        //.then( result => {
        //  console.log(result);
        //}).catch( err => console.error(err) );
      });
  </script>
</body>

</html>