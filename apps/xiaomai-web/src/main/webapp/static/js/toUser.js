 var deptouserids="";
 var deptousername="";
 var moduleid="";
 var modaltype="";
 var dialog
function touserModal(mid,userid,usernames,type){
	 modaltype=type;
               
        if(mid!=moduleid&&userid!=null&&userid!=""){
        	
       	    deptouserids=userid; 
       	    if(usernames!=null&&usernames!=""){
       	    	deptousername=usernames;
       	    }
       	 
          	moduleid=mid;
          	  
          }  
        dialog=art.dialog({
			        		 hight:400,
			        		 width:680,
		        			 title:"选择同事",
		        			 follow: document.getElementById('myNavbar'),
		        			 content:document.getElementById("touserModal"),
		        			 ok: function () {
		        		         if(type==1){
		        		        	 
		        		        	 $("#userids").val(deptouserids);
		        		        	
		        		        	 document.touserform.submit();
		        		        	
		        		         }
		        			    },
		        			    okValue: '确认'
         
				});
				touser(""); 
		
		 
				 }
				 
				  function touser(){ 
					 
				 	 $.ajax({                                                 
		                                     
		 url: "/oa-web/system/ajax/user/depAndUserList",                                      
		 dataType: "html",
		  data: {userids:deptouserids},
		 success: function(html){  
			 
				  
				 $("#touserModal").html(html); 
			 
			 
		 } 
		 });
				 }
				 
					function sele(id, name){
						$("#userid_" + id).each(function() {
						

							if (!this.checked) {

								 
								 
								var s=id+",";
								var sname=name+",";
			                   deptouserids=deptouserids.replace(s, "");
			                   deptousername=deptousername.replace(sname,""); 
			                  
							}else{
								setUser(id,name);
								
							} 

						});
						$("#setusers").html(deptousername);
						$("#setuserids").val(deptouserids);
						$("#setuseridAll").val("");
					}

					function selectedHandler(id, name) {
			           
						$("#userid_" + id).each(function() {
							if (this.checked) {

								this.checked = false;
								 
								var s=id+",";
								
			                   deptouserids=deptouserids.replace(s, "");
			               	var sname=name+",";
			                   deptouserids=deptouserids.replace(s, "");
			                   deptousername=deptousername.replace(sname,""); 
			                  
							} else {
								setUser(id,name);
								this.checked = true;

							}

						});
						$("#setusers").html(deptousername);
						$("#setuserids").val(deptouserids);
						$("#setuseridAll").val("");
					}			 
				 
					 

		/**
		 * 
		 * 全选，反选
		 */			 
 
					function allSelect() {
						var c = 0;
						$("#allselectbox").each(function() {

								if (!this.checked) {
								c=1;
								}

						});

						if (c == 0) {

							$("input[name='userid']").each(function() {
								 
								this.checked = true;
								var s = $(this).val();
								var strs= new Array();
								strs=s.split("_");  
								var sid=strs[0];
								 var sname=strs[1];
								 setUser(sid,sname);
							});

						} else {

							$("input[name='userid']").each(function() {

								this.checked = false;
								var s = $(this).val();
								var strs= new Array();
								strs=s.split("_");  
								var sid=strs[0]+",";
								 var sname=strs[1]+",";
								deptouserids = deptouserids.replace(sid, "");  
				                 deptousername=deptousername.replace(sname,""); 
							});

						}
						$("#setusers").html(deptousername);
						$("#setuserids").val(deptouserids);
						$("#setuseridAll").val("");
					}
				 
	 function setUser(ids,name){
		  
              if(deptouserids.indexOf(ids) == -1) {
               deptouserids += ids+",";
              }
              if(deptousername.indexOf(name) == -1) {
            	  deptousername += name+",";
                 }   
     
	 }
	 
	 
	 function allquery(){
		 $("#setuseridAll").val("all");
		 $("#setusers").html("选择所有同事");
		 $("#setuserids").val("");
		 dialog.close();
		 if(modaltype==1){
        	 
        	 $("#userids").val("all");
        	
        	 document.touserform.submit();
        	
         }
	 }