<%@ page contentType="text/html;charset=UTF-8" %> 
 
 <%@ include file="/WEB-INF/share/taglib.jsp"%>
 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
 
   
        <title>酒店设施管理</title> 
     
 
	<script>
		$(document).ready(function() {
			$("#categoryForm").validate();
		});
	</script>
</head>

<body> 
 
  
 
       	<div class="row " style="margin-bottom: 10px;">

	  
        <div class="col-lg-12 col-xs-12 col-sm-12 ">
         
          

           <div class="box box-info">
             <div class="box-header with-border">
              <h3 class="box-title">酒店设施编辑</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form id="categoryForm" class="form-horizontal" method="post" action="${basePath }/admin/hotel/facility/${action }">
             <input type="hidden" name="parentid" value="${parentid }"/>
             <input type="hidden" name="page" value="${page }">
             <c:if test="${action=='update' }"><input type="hidden" name="id" value="${type.id}"/>
             </c:if>
             
              <div class="box-body">
                   <c:if test="${!empty photelFacility }">
               <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">设施类型：</label>

                  <div class="col-sm-10">
                    <input type="text" class="form-control  "   value="${photelFacility.name }"  disabled>
                  </div>
                </div>
              </c:if>
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">名称：</label>

                  <div class="col-sm-10">
                    <input type="text" class="form-control required" id="inputEmail3" name="name"  value="${type.name }" placeholder="请输入设施名称">
                  </div>
                </div>
                
                
              </div>
              <!-- /.box-body -->
              <div class="box-footer">
                
                <button type="submit" class="btn btn-info pull-right">提交</button>
              </div>
              <!-- /.box-footer -->
            </form>
          </div>
 
 
           
        </div>
      </div>
      
      
      

      
      
  
    
    
</body>
</html>
