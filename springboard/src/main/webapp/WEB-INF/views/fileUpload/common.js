// 이미지 파일 여부 판단
function checkImageType(fileName) {
	var pattern = /jpg|gif|png|jpeg/i;
	return fileName.match(pattern);
}

// 업로드 파일 정보
function getFileInfo(fileName) {
	var fileName, imgsrc, getLink, fileLink;
	// 이미지 파일일 경우
	if (checkImageType(ullfName)) {
		// 이미지 파열 경로(썸네일)
		imgsrc = "/board/upload/displayFile?fileName=" + fileName;
		console.log(imgsrc);
		// 업로드 파일명
		fileLink = fileName.substr(14);
		console.log(fileLink);
		// 날짜별 디렉토리 추출
		var front = fileName.substr(0, 12);
		console.log(front);
		// s_를 제거한 업로드이미지파일명
		var end = fileName.substr(14);
		console.log(end);
		// 원본이미지 파일 디렉토리
		getLink = "/board/upload/displayFile?fileName=" + front + end;
		console.log(getLink);
		// 이미지 파일이 아닐경우
	} else {
		// UUID를 제외한 원본파일명
		fileLink = fileName.substr(12);
		console.log(fileLink);
		// 일반파일디렉토리
		getLink = "/board/upload/displayFile?fileName=" + fullName;
		console.log(getLink);
	}
	// 목록에 출력할 원본파일명
	sfileName = fileLink.substr(fileLink.indexOf("_") + 1);
	console.log(sfileName);
	// { 변수:값 } json 객체 리턴
	return {
		fileName : sfileName,
		imgsrc : imgsrc,
		getLink : getLink,
		fullName : fullName
	};
}

$(document).ready(function() {
	
	// 1. 드래그 영역 기본 효과(바로보기)를 제한
	$(".fileDrop").on("dragenter dragover", function(event) {
		event.preventDefault(); // 기본효과를 제한
	});
	
	// 2. 파일 업로드
	// event : jQuery 이벤트, originalEvent : javascript 이벤트
	$(".fileDrop").on("drop", function(event) {
		event.preventDefault(); // 기본효과를 제한
		// 드래그된 파일의 정보
		var files = event.originalEvent.dataTransfer.files;
		// 첫번째 파일
		var file = files[0];
		// 콘솔에서 파일정보 확인
		console.log(file);
		// ajax로 전달할 폼 객체
		var formData = new FormData();
		// 폼 객체에 파일추가, append("변수명", 값)
		formData.append("file", file);
		
		$.ajax({
			type: "post",
			url: "${path}/upload/uploadAjax",
			data: formData,
			dataType: "text",
			// processData: true=> get방식, false => post방식
			processData: false,
			// contentType: true => application/x-www-form-urlencoded, 기본옵션
			//				false => multipart/form-data, 멀티파트
			contentType: false,
			success: function(data) {
				//alert(data);
				console.log(data);
				var str = "";
				// 이미지파일이면 썸네일 이미지 출력
				if(checkImageType(data)){ 
					str = "<div><a href='${path}/upload/displayFile?fileName="+getImageLink(data)+"'>";
					str += "<img src='${path}/upload/displayFile?fileName="+data+"'></a>";
				// 이미지 파일이 아니면 다운로드
				} else { 
					str = "<div><a href='${path}/upload/displayFile?fileName="+data+"'>"+getOriginalName(data)+"</a>";	
				}
					str += "<span data-src="+data+">[삭제]</span></div>";
				$(".uploadedList").append(str);
			}
		});
	});
	// 2. 파일 삭제
	// 태그.on("이벤트", "자손태그", "이벤트핸들러")
	$(".uploadedList").on("click", "span", function(event){
		alert("이미지 삭제")
		var that = $(this); // 여기서 this는 클릭한 span태그
		$.ajax({
			url: "${path}/upload/deleteFile",
			type: "post",
			// data: "fileName="+$(this).attr("date-src") = {fileName:$(this).attr("data-src")}
			// 태그.attr("속성")
			data: {fileName:$(this).attr("data-src")}, // json방식
			dataType: "text",
			success: function(result){
				if( result == "deleted" ){
					// 클릭한 span태그가 속한 div를 제거
					that.parent("div").remove();
				}
			}
		});
	});

});