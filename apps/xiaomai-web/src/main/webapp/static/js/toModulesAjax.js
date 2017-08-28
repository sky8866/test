var bpath="/oa-web";
var modules="";
 


           function  ajaxList(page){
        	  
        	   setajaxList(page,null);
          }
           function  ajaxListToUser(page,userid){
        	  
        	   
        	  	 var depquery=$("#depquery").val();  
              	 
                 var query=$("#query").val();
                
                  
                 
               $.ajax({                                                 
     		  type: "post",                                     
     		 url: bpath+"/system/ajax/"+modules+"/touserList",                                      
     		 dataType: "html",
     		  data: {page:page,query:query,depquery:depquery,userid:userid},
     		 success: function(html){  
               
     			 $("#"+modules+"list").empty();
     			 $("#"+modules+"list").append(html);
     		 } 
     		 });
        	   
          } 
           
           function  setajaxList(page,userid){
          	 var depquery=$("#depquery").val();  
          	 
              var query=$("#query").val();
              var starttime=$("#starttime").val();
              var endtime=$("#endtime").val();
            $.ajax({                                                 
  		  type: "post",                                     
  		 url: bpath+"/system/ajax/"+modules+"/toList",                                      
  		 dataType: "html",
  		  data: {page:page,query:query,depquery:depquery,userid:userid,starttime:starttime,endtime:endtime  },
  		 success: function(html){  
            
  			 $("#"+modules+"list").empty();
  			 $("#"+modules+"list").append(html);
  		 } 
  		 });
            }
  
  
  function inputForm(action,id){
	
    	 $.ajax({                                                 
		                                  
		 url:  bpath+"/system/ajax/"+modules+"/toForm",                                      
		 dataType: "html",
		  data: {action:action,id:id},
		 success: function(html){
			 $("#"+modules+"Modal").empty();
			 $("#"+modules+"Modal").append(html);
		 } 
		 });
  
    
   
 
 
  
  } 
 
 
 	//到指定的分页页面
	function topage(page){
		var userid=$("#queryuserId").val();
	
	 if(userid==""||userid==null){
		 ajaxList(page);
	 }else{
			 
		 ajaxListToUser(page,userid); 
	 }
	 
	  
	   
 
	}
	
	function goDel(id) {
		if (confirm("删除后所有人将无法看到这条记录，您确定要这样做吗？")) {

			$.post(bpath+"/system/"+modules+"/del/" + id, {
				"_method" : "post"
			}, function(data, status) {
				if ("success" === status) {
					if ("success" == data) {
						 
						content("删除成功！");
						$("#" + id + "_tr").remove();
					} else if ("fail" == data) {
						content("删除失败！");
					}
				}
			});
			return false;
		}

	}

	function content(content) {
		art.dialog({
			width : '18em',
			title : '消息',
			content : content,
			time : 3000
		});
	}
	
	
	   (function ($) {
		      $(document).ready(function() {
		     
		       ajaxList(1);
		      });
		    
		    })(jQuery);
		  	
	