<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
	$(function () {
		$.ajax("ajax/memberList.do",{
			dataType:"json",
			
			
		}).done(function(datas) {//ajax/memberList.do 의 결과가 data<- 함수 매개변수로 들어옴
			for(i=0; i<datas.length;i++) {
				$("<div>").append($("<span>").text(datas[i].id))
							.append($("<span>").text(datas[i].name))
							.append($("<span>").text(datas[i].tel))
							.appendTo("#memList");
			}
		});
		
		//등록버튼 클릭 이벤트
		$("#btnSave").on("click",function() {
			$.ajax("ajax/memberInsert.do",{
				dataType :"json",
				data : $("#frm").serialize()
			}).done(function(datas){
				$("<div>").append($("<span>").text(datas.id))
				.append($("<span>").text(datas.name))
				.append($("<span>").text(datas.tel))
				.prependTo("#memList");
			});
		});
	});
</script>
</head>
<body>
<h3>회원관리</h3>
<div class="row">

	<div class="col">
		<div id="memList">
		</div>
	</div>
	<div class="col">
		<form id="frm" name="frm" method="post">
					<table border="1">
						<tr>
							<th width="150">아이디</th>
							<td><input type="text" id="id" name="id"></td>
						</tr>
						<tr>
							<th width="150">패스워드</th>
							<td><input type="password" id="password" name="password"></td>
						</tr>
						<tr>
							<th width="150">이름</th>
							<td><input type="text" id="name" name="name"></td>
						</tr>
						<tr>
							<th width="150">주소</th>
							<td><input type="text" id="address" name="address" size="20"></td>
						</tr>
						<tr>
							<th width="150">전화번호</th>
							<td><input type="text" id="tel" name="tel"></td>
						</tr>
						<tr>
							<th width="150">가입일자</th>
							<td><input type="date" id="enterdate" name="enterdate"></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<input type="button" id="btnSave" value="가입하기">&nbsp;&nbsp;
								<input type="reset" value="취  소">
							</td>
						</tr>
					</table>
				</form>
	</div>
</div>


</body>
</html>