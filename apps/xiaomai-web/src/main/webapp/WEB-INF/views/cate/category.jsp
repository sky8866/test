<%@ page contentType="text/html;charset=UTF-8" %> 
 
 <%@ include file="/WEB-INF/share/taglib.jsp"%>
 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
 
   
        <title>门店类别管理</title> 
     

<script>
 
	function _action(){
	    if(confirm("您确定要删除吗？")){
		if(selectItem()){
			document.myform.submit();
			return true;
		}else{
			alert("请选择要操作的记录");
		}
		return false;
		}
	}
	
	
 
	
	function goDel(id){
	if (confirm("您确定要删除吗？")){
		location = "${basePath }/admin/cate/category/delete/"+id+"/${pageView.currentpage}";

	return false;
	}
	
	
	}
	
	//到指定的分页页面
	function topage(page){
		
		location = "${basePath}/admin/cate/category?page="+page+"&parentid=${parentid }";
	}
	
	 
</script>

</head>

<body> 
 
  
 
       	<div class="row " style="margin-bottom: 10px;">

	  
        <div class="col-lg-12 col-xs-12 col-sm-12 ">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">门店类别列表</h3>

              <div class="box-tools ">
                <a class="text-muted" href="${basePath }/admin/cate/category/create?parentid=${parentid }"> <i class="glyphicon glyphicon glyphicon-plus"></i> 创建门店类别</a>
              </div>
             
            </div>
            
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding" id="quilvQuery" style="margin: 10px;">
              <table class="table table-hover">
                <tr>
                  <th width="10%">序号</th>
                   
                  <th width="20%">门店类别</th>
                  <th width="20%">所属父类</th> 
                  <th width="20%">创建下级</th>
                  
                  <th width="20%">操作</th>
                </tr>
                	<c:choose>
				<c:when test="${!empty pageView.records }">
					<c:forEach items="${pageView.records}" var="entry"
						varStatus="statu">
                <tr>
                  <td>${statu.count }</td>
                   
                  <td >
                    <a href="${basePath }/admin/cate/category?parentid=${entry.id }" >${entry.name }</a>      
            <c:if test="${fn:length(entry.childtypes)>0}"><font color=red>(有${fn:length(entry.childtypes)}个子类)</font>
            </c:if>
                  </td>
                   <td><c:if test="${!empty entry.parent}">${entry.parent.name}</c:if></td>
                   <td ><a href="${basePath }/admin/cate/category/create?parentid=${entry.id }" >创建子类别</a></td>
                  <td>
 
							<i class="fa fa-edit fa-fw"></i>  <a href="${basePath }/admin/cate/category/update/${entry.id}/${pageView.currentpage}">编辑</a>	 
<i class="fa fa-trash fa-fw"></i>   <a  href="javascript:void(0)" target="main" onClick="goDel('${entry.id}')">删除</a>
								 
</td>
                </tr>
                  	</c:forEach>



				</c:when>
				<c:otherwise>

					<tr>
						<td colspan="5"><div align="center"><a href="${basePath }/admin/cate/category/create?parentid=${parentid }">创建门店类别</a></div>
						</td>

					</tr>
				</c:otherwise>
			</c:choose>   
              </table>
<%@include file="/WEB-INF/share/fenye.jsp"%>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
      </div>
      
      
      
       	<div class="modal fade" id="impallModal"> 

		          
		          
		          
		          
		          
    
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title">查询条件</h4>
      </div>
      <div class="modal-body">
       
            <div class="modal-body">
                
             <form class="form-horizontal"   method="post" action="${basePath }/admin/cate/category">    
                 <div class="form-group">
    
    <div class="input-group">
      <div class="input-group-addon">关键字：</div>
       <input type="text" class="form-control" placeholder="昵称,类型,内容,手机号码"
							id="query" name="query">
       
       
        
       
    </div>
  </div>
  
 
 
           </form>                    
            </div>
             
            
      </div>
      <div class="modal-footer">
     
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="ajaxQueryList(1)">确定</button>
      </div>
      
    </div>
  </div>
     
  
	</div>
      
      
  
    
    
</body>
</html>
