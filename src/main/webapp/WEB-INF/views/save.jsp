<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>save</title>
</head>
<body>
<jsp:include page="layout/header.jsp" flush="false"></jsp:include>
 <div class="container" id="detail">
    <form action="/board/save" method="post">
    	<input type="text" name="boardWriter" placeholder="작성자"><br><br>
    	<input type="text" name="boardPass" placeholder="비밀번호"><br><br>
    	<input type="text" name="boardTitle" placeholder="제목"><br><br>
    	<textarea name="boardContents" rows="10" cols="30" placeholder="내용을 입력하세요"></textarea>
    	<input type="submit" value="작성">
    
    </form>
 </div>   
</body>
</html>