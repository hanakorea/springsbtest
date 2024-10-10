const userObject = {
	init : function(){
		
		$("#btn-delete").on('click',(e)=>{
			e.preventDefault();
			this.userDelete();
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
			alert(response);
			location.href="/";
		}).fail(function(error){
			console.log(error);
		})
	}
}
userObject.init();