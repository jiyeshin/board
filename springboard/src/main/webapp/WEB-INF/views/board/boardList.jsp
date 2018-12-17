<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="/css/bootstrap.css">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<body>
	<div>
		<form id="boardForm" name="boardForm" method="post">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>날짜</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="result" items="${list }" varStatus="status">
						<tr>
							<td><c:out value="${result.code }" /></td>
							<td><a href='#' onClick='fn_view(${result.code})'><c:out
										value="${result.title }" /></a></td>
							<td><c:out value="${result.writer }" /></td>
							<td><c:out value="${result.regdate }" /></td>
							<td><c:out value="${result.readcnt }" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
		<form id="searchForm" method="get" action="/board/boardList.do">
			<select name="searchOption">
				<option value="all"
					<c:out value="${searchOption == 'all'?'selected':''}"/>>
					전체 </option>
				<option value="titleContent"
					<c:out value="${searchOption == 'titleContent'?'selected':''}"/>>
					제목 + 내용</option>
				<option value="content"
					<c:out value="${searchOption == 'content'?'selected':''}"/>>
					내용</option>
				<option value="title"
					<c:out value="${searchOption == 'title'?'selected':''}"/>>
					제목</option>
				<option value="writer"
					<c:out value="${searchOption == 'writer'?'selected':''}"/>>
					글쓴이</option>
			</select> <input name="keyword" value="${keyword}"> <input
				type="submit" value="검색">

		</form>
		<div>
			<a href='#' onClick='fn_write()' class="btn btn-success">글쓰기</a>
		</div>


		<div>
			<c:if test="${pagination.curRange ne 1 }">
				<a href="#" onClick="fn_paging(1)">[처음]</a>
			</c:if>
			<c:if test="${pagination.curPage ne 1}">
				<a href="#" onClick="fn_paging('${pagination.prevPage }')">[이전]</a>
			</c:if>
			<c:forEach var="pageNum" begin="${pagination.startPage }"
				end="${pagination.endPage }">
				<c:choose>
					<c:when test="${pageNum eq  pagination.curPage}">
						<span style="font-weight: bold;"><a href="#"
							onClick="fn_paging('${pageNum }')">${pageNum }</a></span>
					</c:when>
					<c:otherwise>
						<a href="#" onClick="fn_paging('${pageNum }')">${pageNum }</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if
				test="${pagination.curPage ne pagination.pageCnt && pagination.pageCnt > 0}">
				<a href="#" onClick="fn_paging('${pagination.nextPage }')">[다음]</a>
			</c:if>
			<c:if
				test="${pagination.curRange ne pagination.rangeCnt && pagination.rangeCnt > 0}">
				<a href="#" onClick="fn_paging('${pagination.pageCnt }')">[끝]</a>
			</c:if>
		</div>

		<div>총 게시글 수 : ${pagination.listCnt } / 총 페이지 수 :
			${pagination.pageCnt } / 현재 페이지 : ${pagination.curPage } / 현재 블럭 :
			${pagination.curRange } / 총 블럭 수 : ${pagination.rangeCnt }</div>

		<script>
//글쓰기
function fn_write(){
    
    var form = document.getElementById("boardForm");
    
    form.action = "<c:url value='/writeForm.do'/>";
    form.submit();
    
}
 
//글조회
function fn_view(code){
    
    var form = document.getElementById("boardForm");
    var url = "<c:url value='/viewContent.do'/>";
    url = url + "?code=" + code;
    
    form.action = url;    
    form.submit(); 
}
</script>
	</div>
</body>
</html>
