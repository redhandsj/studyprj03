<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html:xhtml/>
<html>
<head>
<m:css src="style.css"/>
<title>半角ｶﾅ変換</title>
</head>
<body>
<center>半角ｶﾅ変換</center>
<br/>
<s:form method="POST">
<html:errors/>
<html:textarea property="message"></html:textarea><br/>
<s:submit property="send" value="送信" />
</s:form>
<br/>
<m:a href="../">戻る</m:a>

</body>
</html>