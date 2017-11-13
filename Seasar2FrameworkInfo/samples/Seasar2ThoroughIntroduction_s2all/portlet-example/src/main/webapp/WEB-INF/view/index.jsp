<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>エコーアプリ</title>
</head>
<body>
<s:form>
  <html:errors/>
  お名前をどうぞ：
  <html:text property="name" />
  <html:submit property="echo" value="送信"/>
</s:form>
</body>
</html>