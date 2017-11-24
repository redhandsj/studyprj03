<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- JavaScriptのチェック -->
<!-- <html:javascript formName="tourokuActionForm_reg" />-->
</head>
<body>

<!-- エラーを表示する -->
<html:errors/>

<!-- 入力 -->
<s:form method="POST">
${f:h(actionMessage)}
<br>
お名前をどうぞ！（登録）
<html:text property="name"/>
<!-- ------------------------------------------------------------------- -->
<br>
エラー確認用
<html:text property="userNm"/>
<html:errors property="userNm" />
<html:text property="passwd"/>
<html:errors property="passwd" />


<!-- ------------------------------------------------------------------- -->
<br><br>
<!-- 複数選択 -->
<html:select property="products" multiple="true">
  <html:option value="S2Container" />
  <html:option value="SAStruts" />
  <html:option value="S2JDBC" />
</html:select>
<!-- ネスト -->
ユーザ名：<html:text property="user.userName"/>

<!-- 繰り返し -->
<table border="1">
  <tr><th>名前</th><th>メールアドレス</th></tr>
  <c:forEach items="${users}" varStatus="s">
    <tr>
      <td><html:text property="users[${s.index}].userName" size="20" /></td>
      <td><html:text property="users[${s.index}].mail" size="40" /></td>
    </tr>
  </c:forEach>
</table>

<s:submit property="reg" value="登録" clientValidate="true" />
</s:form>

</body>
</html>