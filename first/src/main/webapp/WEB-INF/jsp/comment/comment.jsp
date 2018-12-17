<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<form id="frm_comment" name="frm_comment" enctype="multipart/form-data">
	<table class="comment_insert">
		<colgroup>
			<col width="8%"/>
			<col width="15%"/>
			<col width="8%"/>		
			<col width="*" />
		</colgroup>
		<tbody>
			<tr>
				<td>이름:</td><td><input type="text" id="comment_id" name="comment_id" class="wdp_15" size="10"></input></td>
				<td>댓글:</td>
				<td><input type="text" id="comment_contents" name="comment_contents" class="wdp_100" size="60"></input></td>		
			</tr>
		</tbody>
	</table>
	<a href="#this" class="btn" id="write_comment">댓글 등록</a>
</form>

<script type="text/javascript">
		var gfv_count = 1;

		$(document).ready(function() {
			$("#write_comment").on("click", function(e) { //작성하기 버튼
				//e.preventDefault();
				//fn_insertComment();
				$.ajax({
					url 		: ,
					type 		: ,
					data		: ,
					dataType	: ,
					success		:	function(){
						
						
					}
						
				})
				
				
				
			});			
		});

		function fn_insertComment() {
			var comSubmit = new ComSubmit("frm");
			comSubmit.setUrl("<c:url value='/sample/insertBoard.do' />");
			comSubmit.submit();
		}
	</script>






