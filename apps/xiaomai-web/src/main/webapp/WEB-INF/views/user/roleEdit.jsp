<%@ page contentType="text/html;charset=UTF-8" %> 
 
 <%@ include file="/WEB-INF/share/taglib.jsp"%>
 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
 
   
        <title>添加权限</title> 
       <script src="${basePath }/static/My97DatePicker/WdatePicker.js" type="text/javascript"></script>  

</head>

<body> 
 
  
 
   

	  
        <div class="row col-lg-12 col-xs-12 col-sm-12 ">
          <div class="box">
       
            
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding" >
                  <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="nav-tabs-custom">
            <ul class="nav nav-tabs">
              
              <li   class="active" ><a href="#cateorder" data-toggle="tab" onClick="orderList(1)">添加权限</a></li>
        
                
            </ul>
        
              <!-- /#门店信息管理 -->

              <!-- 菜品-->
              <div class="active" >
                   <div class="col-xs-12">
          <h2 class="page-header">
            
              <div class="box-tools text-right ">
                
                
                	
                
              </div>
        </div>
          <div id="rolelist">
          
          <form class="form-horizontal" name="saverole_form" id="saverole_form"  action="${basePath}/admin/role/toAddPrivilege" method="post">
                  <input type="hidden" name="roleid" value="${role.id }">
                   <table class="table " >
              <tr height="30"> 
               
                <td align="left" width="40%" >
       <div class="input-group col-sm-4">
  <span class="input-group-addon" id="sizing-addon2">权限名：</span>
  <input type="text" class="form-control required" placeholder="权限名" name="rolename" value="${role.rolename }" aria-describedby="sizing-addon2">
</div>
                </td>
							    </tr>
							   </table>
                 
 
            
               <c:forEach items="${privilegeList }" var="entry" >
                
               <table class="table table-striped " >
              <tr height="30"> <td width="10%" align="right"> 
                  <input type="checkbox" 
						 	   name="parents" 
							   value="${entry.id }" 
						         onClick="choiceParent('${entry.id }')"
						          id="p_${entry.id }" 
						          <c:forEach items="${rolePrivilege }" var="g1">
						            <c:if test="${g1.privilegeId==entry.id }"> checked="checked" </c:if>
						          </c:forEach>
							   >
							     ${entry.name } 
							   </td>
							  
							  <td>|</td>
							   <td width="90%" align="left"> 
							    <c:forEach items="${entry.childtypes }" var="e" >
							    <input type="checkbox" 
							      onClick="choiceChild('${entry.id }','${e.id }')" 
							   id="s_${e.id }"
							   name="parents_${entry.id }" 
							   value="${e.id }"
							        <c:forEach items="${rolePrivilege }" var="g">
						            <c:if test="${g.privilegeId==e.id }"> checked="checked" </c:if>
						          </c:forEach>
							       >
							    ${e.name } &nbsp;&nbsp;
							   
							    </c:forEach> 
							    </td>
							    </tr>
							   </table>
							   </c:forEach> 
          
                         
                     
            <div class="modal-footer">
                <button type="submit" class="btn btn-primary"  >确定</button>
               
            </div>
             </form>
          
          </div>
              </div>
              <!-- /#菜品 -->
               
    
            </div>
            <!-- /.tab-content -->
          </div>
          <!-- /.nav-tabs-custom -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
            </div>
            <!-- /.box-body -->
          </div>
     
    
    
         <script type="text/javascript">
    

		 function choiceParent(pid){
	     
	      var parents = document.getElementsByName("parents"); 
		  var pbox = document.getElementById("p_"+pid);
		  if(pbox.checked){    
		  	   pbox.checked=true;
		       var childs = document.getElementsByName("parents_"+pid);
			   for(i=0;i<childs.length;i++){
			       childs[i].checked=true;
			   }
		  }else{      
		  		//alert(pid);
		       var childs = document.getElementsByName("parents_"+pid);
			   for(i=0;i<childs.length;i++){
			       childs[i].checked=false;
			   }
		  }
	}
	
	function choiceChild(pid,id){
	      var pbox = document.getElementById("p_"+pid);
	     
		  if(pbox.checked==false){   
		       pbox.checked=true;     
		  }
		  
		  
		  var sbox = document.getElementById("s_"+id);
		  if(sbox.checked==false){   
		        var childs = document.getElementsByName("parents_"+pid);
				var ishas = false;
				for(i=0;i<childs.length;i++){
			       if(childs[i].checked){ 
				        ishas = true;
						break;
				   }
			    }
				if(!ishas){  
				   if(pbox.checked){  
		                pbox.checked=false;     
		           }
				}
			   
		  }
		  
	}
	
	$(document).ready(function() {
			$("#saverole_form").validate();
		});	

</script>
    
    
</body>
</html>
