<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

こんにちわ、${f:h(name)} さん！


<!-- 繰り返し -->
<table border="1">
  <tr><th>名前</th><th>メールアドレス</th></tr>
  <c:forEach var="u" items="${users}" varStatus="s">
    <tr>
      <td><c:out value="${u.userName}" /></td>
      <td><c:out value="${u.mail}" /></td>
    </tr>
  </c:forEach>
</table>


</body>
</html>