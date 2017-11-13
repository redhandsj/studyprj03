<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html:xhtml/>
<html>
<head>
<m:css src="style.css"/>
<title>画像のリサイズ</title>
</head>
<body>
<center>画像のリサイズ</center>
<br/>
<center>
<m:img magniWidth="0.5" src="/images/js_book.jpg" scaleType="FITWIDTH"/><br>
FITWIDTH<br/>
<br/>
<m:img magniWidth="0.5" src="/images/js_book.jpg" scaleType="CLIPSQUARE"/><br>
CLIPSQUARE<br/>
<br/>
<m:img magniWidth="0.5" src="/images/js_book.jpg" scaleType="INSQUARE"/><br>
INSQUARE<br/>
<br/>
</center>

<m:a href="../">戻る</m:a>

</body>
</html>