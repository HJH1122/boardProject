<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Detail</title>
</head>
<body>
	<table>
        <tr>
            <th>id</th>
            <td>${board.id}</td>
        </tr>
        <tr>
        <tr>
            <th>제목</th>
            <td>${board.boardTitle}</td>
        </tr>
        <tr>
            <th>내용</th>
            <td>${board.boardContents}</td>
        </tr>
            <th>작성자</th>
            <td>${board.boardWriter}</td>
        </tr>
        <tr>
            <th>날짜</th>
            <td>${board.boardCreatedDate}</td>
        </tr>
        <tr>
            <th>조회수</th>
            <td>${board.boardHits}</td>
        </tr>
    </table>
    <button onclick="listFn()">목록</button>
    <button onclick="updateFn()">수정</button>
    <button onclick="deleteFn()">삭제</button>
</body>
<script>
	const listFn = () => {
	    
	    location.href = "/board/";
	}
	const updateFn = () => {
	    const id = '${board.id}';
	    location.href = "/board/update?id=" + id;
	}
	const deleteFn = () => {
	    const id = '${board.id}';
	    location.href = "/board/delete?id=" + id;
	}
</script>
</html>