<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.vo.NewsVO, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
</style>
</head>
<body>
<div>
	<h1>뉴스게시판</h1>
<%
	List<NewsVO> list = (List<NewsVO>)request.getAttribute("list");
	if(list != null){
%>
	<table>
	<tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th></tr>
<%
		for(NewsVO vo : list){
%>
			<tr>
				<td><%=vo.getId() %></td>
				<td onclick="displayReadForm('<%= vo.getId()%>');"><%=vo.getTitle() %></td>
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
		alert('${msg}'); //' ' 인용부호 꼭 주기!!!
	</script> 
<%
	}
%>
	<button onclick="displayDiv(1)">뉴스 작성</button>
</div>
<div id="write" style="display :none;">
	<output></output>
	<form method='post' action='/mvc/news'>
	<input type="hidden" name="action" value="insert">
		<input id="n_writer" name="writer" placeholder="작성자명을 입력해주세요." autofocus><br>
		<input id="n_title" name="title" placeholder="제목을 입력해주세요."><br>
		<textarea id="n_content" name="content" rows="10" cols="25" placeholder="내용을 입력해주세요."></textarea><br>
		<input type="submit" value="저장">
		<input type="reset" value="재작성">
		<button onclick="displayDiv(2)">취소</button><!-- 수정과 삭제를 일반 버튼으로 -->
	</form>
</div>
<script>
function displayDiv(type){
		if(type==1){
			document.getElementById('write').style.display='block';
			document.getElementsByTagName('output')[0].textContent="";
			document.getElementById('n_writer').value=""; 
			document.getElementById('n_title').value="";
			document.getElementById('n_content').value="";
			document.querySelector("#write [type=submit]").value="저장";
			document.querySelector("#write [type=reset]").value="재작성";
			document.querySelector("#write [type=button]").value="취소";
			document.querySelector("#write [type=hidden]").value="insert";
		}else if(type==2){
			document.getElementById('write').style.display='none';
		}
}
function displayReadForm(id){
	location.href="news?action=read&id="+id;
}
<%
	NewsVO listone = (NewsVO)request.getAttribute("listone");		
	if(listone != null){
%>
		//alert("눌림");
		document.getElementById('write').style.display='block';
		document.getElementsByTagName('output')[0].textContent="뉴스내용";
		document.getElementById('n_writer').value="<%= listone.getWriter() %>"; 
		document.getElementById('n_title').value="<%= listone.getTitle() %>";
		document.getElementById('n_content').value="<%= listone.getContent() %>";
		document.querySelector("#write [type=submit]").value="확인";
		document.querySelector("#write [type=reset]").value="수정";
		document.querySelector("#write [type=button]").value="삭제";	
		document.querySelector("#write [type=hidden]").value=<%= listone.getId()%>;
<%
	}
%>
</script>
</body>
</html>