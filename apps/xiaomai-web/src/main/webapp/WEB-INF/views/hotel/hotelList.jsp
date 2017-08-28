<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="/WEB-INF/share/taglib.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>

 
 

</head>

<body>
 
 <div class="row">
        <div class="col-xs-12">
          <h2 class="page-header">
            
              <div class="box-tools text-right ">
             <small >  <a class="text-muted" href="${basePath }/admin/cate/memebership/create"    > <i class="glyphicon glyphicon glyphicon-plus"></i>  添加会员卡</a></small> 
                
              </div>
        </div>
        <!-- /.col -->
      </div>
      
    <table class=" table table-hover">
                <tr>
                  
                   
                  <th width="20%">会员卡名称</th> 
                  <th width="5%">面值</th>
                  <th width="6%">总额度</th> 
                  <th width="30%">有效时间</th> 
                  <th width="25%">操作</th>
                </tr>
                	<c:choose>
				<c:when test="${!empty pageView.records }">
					<c:forEach items="${pageView.records}" var="entry"
						varStatus="statu">
                <tr id="del_${entry.id }">
                    
                  <td >${entry.name }</td>
                   <td  >${entry.faceValue }元</td>
                    <td  >${entry.money }元</td> 
                       
                     <td  >   ${entry.starttime }--${entry.endtime }</td>
				  
                  <td>
 
							<i class="fa fa-edit fa-fw"></i> <a  
								href="${basePath }/admin/cate/memebership/update/${entry.id}/${pageView.currentpage}"    >修改</a>
							<i class="fa fa-edit fa-fw"></i> <a  onclick="delId('${entry.id}')"  data-toggle="modal" data-target="#delModal"
								href="###"  >删除</a>	 
								 
</td>
                </tr>
                  	</c:forEach>



				</c:when>
				<c:otherwise>

					<tr>
						<td colspan="6"><div align="center">暂无数据！</div>
						</td>

					</tr>
				</c:otherwise>
			</c:choose>   
              </table>
<%@include file="/WEB-INF/share/fenye.jsp"%>

 

  	<div class="modal fade" id="memebershipModal"> 
  
      </div>
      
   
     
<script type="text/javascript">
	 
 
		   		 function  inputmemebershipForm(id,page){
		   
		   var qu=""+
            "<div class='col-xs-10 col-md-10'>"+
            "<p class='text-center' style='margin: 50px;'>"+
             "<img   src='${basePath}/static/images/loader.gif'> 正在玩命的给加载，请稍等...</p></div>";
		 
		  $("#memebershipModal").empty();
		  $("#memebershipModal").append(qu);
		 
            
             
            $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/admin/ajax/cate/memebership/inputmemebershipForm",                                      
  		 dataType: "html", 
  		   data: {id:id,page:page},
  		 success: function(html){  
           
  			 $("#memebershipModal").empty();
  			 $("#memebershipModal").append(html);
  		 } 
  		 });
            }
		 
 function delId(id){
 $("#delId").val(id); 
 $("#delUrl").val("/admin/ajax/cate/memebership/del"); 
 }

 
      
/*               
            	 function  saveAndUpdatememebership(){ 
           
		      var name=$("#memebership_name").val();  
             var price=$("#memebership_price").val();  
               var unit=$("#memebership_unit").val();
                var type=$("#memebership_type").val(); 
                 var did=$("#memebership_id").val();
                    
                 var page=$("#memebership_page").val();
            $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/admin/ajax/cate/memebership/saveAndUpdatememebership",                                      
  		 dataType: "text", 
  		   data: {name:name,price:price,unit:unit,type:type,did:did,page:page},
  		 success: function(html){ 
  		 
  		  if(html=="true"){
  		 
  			  art.dialog({
				 width: '18em',
				 title:'消息',
				 content: '操作成功！',
			    time: 3000
			});
			memebershipList(page);
          }else{
            art.dialog({
				 width: '18em',
				 title:'消息',
				 content: '操作失败！',
			    time: 3000
			});
          }
  		  
          
  			 
  		 } 
  		 });
            }    */   
        
	</script>
 
</body>
</html>
