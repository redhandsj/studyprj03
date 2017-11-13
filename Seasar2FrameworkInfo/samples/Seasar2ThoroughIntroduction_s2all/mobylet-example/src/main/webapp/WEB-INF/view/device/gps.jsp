<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html:xhtml/>
<html>
<head>
<m:css src="style.css"/>
<title>GPS情報</title>
</head>
<body>
<center>GPS情報</center>
緯度(度分秒形式)：${mobylet.gps.strLat}<br/>
緯度(浮動小数点形式)：${mobylet.gps.lat}<br/>
経度(度分秒形式)：${mobylet.gps.strLon}<br/>
経度(浮動小数点形式)：${mobylet.gps.lon}<br/>
高度：${mobylet.gps.height}<br/>
<br/>
<m:a href="../../device/">戻る</m:a>

</body>
</html>