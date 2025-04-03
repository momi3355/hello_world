<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="includes/header.jsp"/>
<h3>회원가입</h3>

<form action="signUp.do" method="post" enctype="multipart/form-data">
  <table class="table">
    <tr>
      <th>아이디<span style="color: red">*</span></th>
      <td><input class="form-control" type="text" name="userId" required/></td>
    </tr>
    <tr>
      <th>이름<span style="color: red">*</span></th>
      <td><input class="form-control" type="text" name="userName" required/></td>
    </tr>
    <tr>
      <th>비밀번호<span style="color: red">*</span></th>
      <td><input class="form-control" type="password" name="userPw" required/></td>
    </tr>
    <tr>
      <th>이미지</th>
      <td><input class="form-control" type="file" name="userImg"/></td>
    </tr>
    <tr>
      <td colspan="2">
        <textArea class="form-control" name="agreeText" rows="5" cols="40" readonly>유구한 역사와 전통에 빛나는 우리 대한국민은 3·1운동으로 건립된 대한민국 임시정부의 법통과 불의에 항거한 4·19민주이념을 계승하고, 조국의 민주개혁과 평화적 통일의 사명에 입각하여 정의·인도와 동포애로써 민족의 단결을 공고히 하고, 모든 사회적 폐습과 불의를 타파하며, 자율과 조화를 바탕으로 자유민주적 기본질서를 더욱 확고히 하여 정치·경제·사회·문화의 모든 영역에 있어서 각인의 기회를 균등히 하고, 능력을 최고도로 발휘하게 하며, 자유와 권리에 따르는 책임과 의무를 완수하게 하여, 안으로는 국민생활의 균등한 향상을 기하고 밖으로는 항구적인 세계평화와 인류공영에 이바지함으로써 우리들과 우리들의 자손의 안전과 자유와 행복을 영원히 확보할 것을 다짐하면서 1948년 7월 12일에 제정[7]되고 8차에 걸쳐 개정된 헌법을 이제 국회의 의결을 거쳐 국민투표에 의하여 개정한다.</textArea>
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <input id="agree" type="checkbox"> <label for="agree">동의 하시겠습니까?</label>
      </td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input class="btn btn-primary" type="submit" value="회원가입"/>
        <input class="btn btn-secondary" type="reset" value="초기화"/>
      </td>
    </tr>
  </table>
</form>

<jsp:include page="includes/footer.jsp"/>