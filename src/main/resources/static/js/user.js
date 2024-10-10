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
		
		const userInfo ={
			username : $("#username").val(),
			password : $("#password").val(),
			email : $("#email").val()
		}
		
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


