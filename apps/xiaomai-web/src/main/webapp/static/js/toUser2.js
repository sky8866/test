 var deptouserids2="";
 var deptousername2="";
 var moduleid2="";
 var modaltype2="";
 var dialog2
function touserModal2(mid,userid,usernames,type){
	 modaltype2=type;
               
        if(mid!=moduleid&&userid!=null&&userid!=""){
        	
       	    deptouserids2=userid; 
       	    if(usernames!=null&&usernames!=""){
       	    	deptousername2=usernames;
       	    }
       	 
          	moduleid2=mid;
          	  
          }  
        dialog2=art.dialog({
			        		 hight:400,
			        		 width:680,
		        			 title:"选择同事",
		        			 follow: document.getElementById('myNavbar'),
		        			 content:document.getElementById("touserModal2"),
		        			 ok: function () {
		        		         
		        			    },
		        			    okValue: '确认'
         
				});
				touser2(""); 
		
		 
				 }
				 
				  function touser2(){ 
					 
				 	 $.ajax({                                                 
		                                     
		 url: "/oa-web/system/ajax/user/depAndUserList2",                                      
		 dataType: "html",
		  data: {userids:deptouserids2},
		 success: function(html){  
			 
				  
				 $("#touserModal2").html(html); 
			 
			 
		 } 
		 });
				 }
				 
					function sele2(id, name){
						$("#userid2_" + id).each(function() {
						

							if (!this.checked) {

								 
								 
								var s=id+",";
								var sname=name+",";
			                   deptouserids2=deptouserids2.replace(s, "");
			                   deptousername2=deptousername2.replace(sname,""); 
			                  
							}else{
								setUser2(id,name);
								
							} 

						});
						$("#setusers2").html(deptousername2);
						$("#setuserids2").val(deptouserids2);
						$("#setuseridAll2").val("");
					}

					function selectedHandler2(id, name) {
			           
						$("#userid2_" + id).each(function() {
							if (this.checked) {

								this.checked = false;
								 
								var s=id+",";
								
			                   deptouserids2=deptouserids2.replace(s, "");
			               	var sname=name+",";
			                   deptouserids2=deptouserids2.replace(s, "");
			                   deptousername2=deptousername2.replace(sname,""); 
			                  
							} else {
								setUser2(id,name);
								this.checked = true;

							}

						});
						$("#setusers2").html(deptousername);
						$("#setuserids2").val(deptouserids);
						$("#setuseridAll2").val("");
					}			 
				 
					 

		/**
		 * 
		 * 全选，反选
		 */			 
 
					function allSelect2() {
						var c = 0;
						$("#allselectbox2").each(function() {

								if (!this.checked) {
								c=1;
								}

						});

						if (c == 0) {

							$("input[name='userid2']").each(function() {
								 
								this.checked = true;
								var s = $(this).val();
								var strs= new Array();
								strs=s.split("_");  
								var sid=strs[0];
								 var sname=strs[1];
								 setUser2(sid,sname);
							});

						} else {

							$("input[name='userid2']").each(function() {

								this.checked = false;
								var s = $(this).val();
								var strs= new Array();
								strs=s.split("_");  
								var sid=strs[0]+",";
								 var sname=strs[1]+",";
								deptouserids2 = deptouserids2.replace(sid, "");  
				                 deptousername2=deptousername2.replace(sname,""); 
							});

						}
						$("#setusers2").html(deptousername2);
						$("#setuserids2").val(deptouserids2);
						$("#setuseridAll2").val("");
					}
				 
	 function setUser2(ids,name){
		  
              if(deptouserids2.indexOf(ids) == -1) {
               deptouserids2 += ids+",";
              }
              if(deptousername2.indexOf(name) == -1) {
            	  deptousername2 += name+",";
                 }   
     
	 }
	 
	 
	 function allquery2(){
		 $("#setuseridAll2").val("all");
		 $("#setusers2").html("选择所有同事");
		 $("#setuserids2").val("");
		 dialog2.close();
		  
	 }