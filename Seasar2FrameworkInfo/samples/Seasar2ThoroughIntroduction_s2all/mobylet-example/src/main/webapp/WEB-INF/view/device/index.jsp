<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html:xhtml/>
<html>
<head>
<m:css src="style.css"/>
<title>端末情報</title>
</head>
<body>
<center>端末情報</center>
<br/>
キャリア：${carrier}<br/>
<c:if test="${carrier != 'OTHER'}">
  機種名：${device.deviceProfile['機種名']}<br/>
  メーカー：${device.deviceProfile['メーカー']}<br/>
  解像度：${device.deviceDisplay.width}×${device.deviceDisplay.height}<br/>
  GPS：${hasGps ? '搭載' : '非搭載'}<br/>
  UID：${uid}<br/>
  GUID：${guid}<br/>
</c:if>

<c:if test="${hasGps}">
  <m:gps kickBackUrl="gps/">位置情報を取得する</m:gps><br/>
</c:if>

<m:a href="../">戻る</m:a>

</body>
</html>