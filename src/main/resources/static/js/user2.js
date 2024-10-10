const userObject = {
	init : function(){
		$("#btn-insert").on("click",(e)=>{
				e.preventDefault();
				this.insertuserAlert();
			}),
		
		$("#btn-check").on('click',()=>{
			this.usernameCheck();
		}),
		
		$("#btn-delete").on('click',(e)=>{
			e.preventDefault();
			this.userDelete();
		})
		
	},
	
	insertuserAlert : function(){
		const regexId = /^\w{8,20}$/;
		const regexPw = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,20}$/;
		const regexEmail = /^([a-z]+\d*)+(\.?\w+)+@\w+(\.\w{2,3})+$/;
		
		let isIdCheck = false;
		let isPwCheck = false;
		let isEmailCheck = false;
		
		const userInfo ={
			username : $("#username").val(),
			password : $("#password").val(),
			email : $("#email").val()
		}
		
		if(regexId.test(username.value)){
			isIdCheck = true;
		}else{
			alert("사용불가능한아이디입니다.")
			isIdCheck = false;
		}
		
		if(regexPw.test(password.value)){
			isPwCheck = true;
		}else{
			alert("사용불가능한비밀번호입니다.")
			isPwCheck = false;
		}
		
		if(regexEmail.test(email.value)){
			isEmailCheck = true;
			check()
		}else{
			alert("사용불가능한이메일입니다.")
			isEmailCheck = false;
		}
		function check(){
			if(isIdCheck&&isEmailCheck&&isPwCheck){
			$.ajax({
				type:"POST",
				url:"/insertuser",
				data:JSON.stringify(userInfo),
				contentType:"application/json; charset=uft-8"
			}).done(function(response){
				alert(response.data);
				if(response.status == 200)
				location.href = "/";
			}).fail(function(error){
				console(error);
			})
			}
		  }		
	
	},
	
	usernameCheck : function(){
		const username = $("#username").val()
		
		$.ajax({
			type:"GET",
			url:"/insertuser/check?username="+username
		}).done(function(response){
			alert(response.data);
		}).fail(function(error){
			console.log(error);
		})
	},
	
	
	userDelete : function(){
		
		if(!confirm("탈퇴하시겠습니까?")){
			return;
		}
		
		const id = $("#id").val();
		
		$.ajax({
			type:"DELETE",
			url:"/delete?id="+id
		}).done(function(response){
			alert(response.data);
			location.href="/";
		}).fail(function(error){
			console.log(error);
		})
	}
}
userObject.init();





