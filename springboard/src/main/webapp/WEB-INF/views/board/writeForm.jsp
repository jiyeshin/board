<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<style>
	.fileDrop {
		width:600px;
		height: 200px;
		border: 1px dotted blue;
	}
	
	small {
		margin-left: 3px;
		font-weight: bold;
		color: gray;
	}
</style>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script type="text/javascript" src="${path}/fileUpload/common.js"></script>
<body>
	<div>
		<form id="writeForm" name="writeForm" method="post" enctype="multipart/form-data">
			<div>
				<h2>글쓰기</h2>
				<div>
					<table>
						<tr>
							<th>제목</th>
							<td><input style="width: 500px" type="text" id="title"
								name="title" /></td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea style="width: 500px" rows="10" cols="10"
									id="content" name="content"></textarea></td>
						</tr>
						<tr>
							<th>작성자</th>
							<td><input style="width: 500px" type="text" id="writer"
								name="writer" /></td>
						</tr>
					</table>
					<div id="fileDiv">
					 <input type='file' id="file1" name="file" />
					 <a href="#" onClick='fn_deleteFile()' id="delete" name="delete">삭제</a>				 
					 </div>
					 <br/>
					 <a href="#" onClick='fn_addFile()' id="addFile">추가</a> 
					<!-- 업로드된 파일 목록 -->
					<div class="uploadedList"></div>
					
					<div>
						<a href='#' onClick='fn_addtoBoard()'>글 등록</a> <a href='#'
							onClick='fn_cancel()'>목록</a>
					</div>
				</div>
			</div>
		</form>
		<script>
		
		/* // 파일 추가 
		function fn_addFile(){
			
			var str = "<p><input type='file' name='no_" + (gfv_count++)
			+ "'><a href='#this' class='btn' name='delete'>삭제</a></p>";
	$("#fileDiv").append(str);
	$("a[name='delete']").on("click", function(e) { //삭제 버튼
		e.preventDefault();
		fn_deleteFile($(this));
	});
		} */
		
		// 파일 삭제 
		function fn_deleteFile(){
			obj.parent().remove();
		}
		
			//글쓰기
			function fn_addtoBoard() {

				var form = document.getElementById("writeForm");

				form.action = "<c:url value='/write.do'/>";
				form.submit();

			}

			//목록
			function fn_cancel() {

				var form = document.getElementById("writeForm");

				form.action = "<c:url value='/boardList.do'/>";
				form.submit();

			}
		</script>
	</div>
</body>
</html>
