<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/Lab2_SOF3011/tam-giac" method="post">
<input name="a" placeholder="Cạnh a?"><br>
<input name="b" placeholder="Cạnh b?"><br>
<input name="c" placeholder="Cạnh c?"><hr>
<button formaction="/Lab2_SOF3011/dien-tich">Tính diện tích</button>
<button formaction="/Lab2_SOF3011/chu-vi">Tính chu vi</button>
${message}
</form>
</body>
</html>