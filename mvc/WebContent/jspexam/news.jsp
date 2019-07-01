<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.vo.NewsVO, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-2.1.3.min.js"></script>
<title>news</title>
<style>
	td{
		border-bottom: 1px dotted green;
	}
	tr:hover{
		background-color : pink;
		font-weight: bold;
	}
	th:nth-child(1){
		color : blue;
	}
	th:nth-child(2){
		color : red;
	}
	th:nth-child(3){
		color : magenta;
	}
	th:nth-child(4){
		color : orange;
	}
	th:nth-child(5){
		color : green;
	}
	td:nth-child(2){
		width : 400px;
	}
	td:nth-child(3){
		width : 100px;
	}
	td:nth-child(4){
		width : 100px;
	}
	h1{
		color : purple;
		text-align : center;
	}
	div,tr{ /* 테이블 제목(번호,제목,작성자,작성일,조회수), 뉴스작성 버튼 가운데로 */
		text-align : center; 
	} 
	table{
		margin : 0 auto;
	}	
	div#write, div#read{
		display : none;
	}
	button#homebtn{
		display : none;
	}
</style>
</head>
<body>
<h1>뉴스게시판</h1>
<script>
window.onpageshow = function(event) { // window.performance.navigation.type == 2 : backbutton을 이용한 뒤로가기
    if ( event.persisted || (window.performance && window.performance.navigation.type == 2)) {
    	location.href="/mvc/news";
    }
}
</script>
<div id="newsBoard">
<%
	List<NewsVO> list = (List<NewsVO>)request.getAttribute("list");
	if(list != null){
%>
	<table>
	<tr id="table_head"><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th></tr>
<%
		for(NewsVO vo : list){
%>
			<tr>
				<td><%=vo.getId() %></td>
				<td onclick="location.href='news?action=read&newsid=<%=vo.getId()%>';"><%=vo.getTitle() %></td> 
				<td><%=vo.getWriter() %></td>
				<td><%=vo.getWritedate() %></td>
				<td><%=vo.getCnt() %></td>
			</tr>
<% 
		}
%> 
	</table>
<%
	}
	if(request.getAttribute("msg") != null){
%>
	<script>
		alert('${msg}'); 
	</script> 
<%
	}
%>
	<br>
	<form method='post' action='/mvc/news'>
	<input type="hidden" name="action" value="search">
		<select name='searchType'>
			<option value='title'>제목</option>
			<option value='writer'>작성자</option>
			<option value='writedate'>작성일</option>
		</select>
		<input type="search" name="keyword">
		<input type="submit" value="뉴스검색">
	</form><br>
	<div id="btn">
		<button id='homebtn' onclick="displayDiv(3)">뉴스 홈</button>
		<button onclick="displayDiv(1)">뉴스 작성</button>
	</div>
</div>
<%
	if(request.getAttribute("homebtn") != null){
%>
<script>
	document.getElementById('homebtn').style.display='inline-block';
</script>
<%
	}
%>
<div id="write">
	<form method='post' action='/mvc/news'>
	<input type="hidden" name="action" value="insert">
		<input id="w_writer" name="writer" placeholder="작성자명을 입력해주세요." required autofocus><br>
		<input id="w_title" name="title" placeholder="제목을 입력해주세요." required><br>
		<textarea id="w_content" name="content" rows="10" cols="25" placeholder="내용을 입력해주세요." required></textarea><br>
		<input type="submit" value="저장">
		<input type="reset" value="재작성">
		<input type="button" value="취소" onclick="displayDiv(2)">
	</form>
</div>
<script>
function displayDiv(type){
		if(type==1){ //뉴스작성 버튼 클릭시
			document.getElementById('write').style.display='block';
			document.getElementById('read').style.display='none';
		}else if(type==2){ //취소 버튼 클릭시
			document.getElementById('write').style.display='none';
			document.getElementById('w_writer').value=""; 
			document.getElementById('w_title').value="";
			document.getElementById('w_content').value="";
		}else if(type==3){ //뉴스 홈 클릭시
			location.href="${header.referer}";
		}
}
</script>
<%
NewsVO listone = (NewsVO)request.getAttribute("listone");		
if(listone != null){
%>
<div id="read">
	<form method='post' action='/mvc/news'>
	<input type="hidden" name="action" value="update">
	<input type="hidden" name="newsid" value="<%= listone.getId() %>">
		<input id="r_writer" name="writer" required autofocus><br>
		<input id="r_title" name="title" required><br>
		<textarea id="r_content" name="content" rows="10" cols="25" required></textarea><br>
		<input onclick="location.href='news';" type="button" value="확인"><!-- <input type="submit" value="확인"> -->
		<input type="submit" value="수정">
		<input onclick="location.href='news?action=delete&newsid=<%= listone.getId() %>';" type="button" value="삭제">
	</form>		
</div>
<script>
	document.getElementById('newsBoard').style.display='none';
	document.getElementById('write').style.display='none'; 
	document.getElementById('read').style.display='block';
	document.getElementById('r_writer').value="<%= listone.getWriter() %>"; 
	document.getElementById('r_title').value="<%= listone.getTitle() %>";
	document.getElementById('r_content').value="<%= listone.getContent() %>";
</script>
<%
}
%>
</body>
</html>