<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="sc.do" method="get">
	<table>
		<thead>
			<tr>
				<td>과목</td>
				<td>점수</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>국어</td>
				<td><input type="text" name="kor" size="5"></td>
			</tr>
			<tr>
				<td>영어</td>
				<td><input type="text" name="eng" size="5"></td>
			</tr>
			<tr>
				<td>수학</td>
				<td><input type="text" name="mat" size="5"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="전송">
					<input type="reset" value="취소">
				</td>
			</tr>
		</tbody>
	</table>
	</form>
</body>
</html>