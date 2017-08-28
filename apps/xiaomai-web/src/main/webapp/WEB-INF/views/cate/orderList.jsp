<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="/WEB-INF/share/taglib.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>

<link href="${basePath }/static/imgUp/css/common.css" type="text/css" rel="stylesheet"/>
		<link href="${basePath }/static/imgUp/css/index.css" type="text/css" rel="stylesheet"/>
			<script type="text/javascript"
		src="${basePath}/static/fancybox/jquery.mousewheel-3.0.6.pack.js"></script>

	<script type="text/javascript"
		src="${basePath}/static/fancybox/jquery.fancybox.js?v=2.1.5"></script>
	<link rel="stylesheet" type="text/css"
		href="${basePath}/static/fancybox/jquery.fancybox.css?v=2.1.5"
		media="screen" />

	<link rel="stylesheet" type="text/css"
		href="${basePath}/static/fancybox/helpers/jquery.fancybox-buttons.css?v=1.0.5" />
	<script type="text/javascript"
		src="${basePath}/static/fancybox/helpers/jquery.fancybox-buttons.js?v=1.0.5"></script>

	<link rel="stylesheet" type="text/css"
		href="${basePath}/static/fancybox/helpers/jquery.fancybox-thumbs.css?v=1.0.7" />
	<script type="text/javascript"
		src="${basePath}/static/fancybox/helpers/jquery.fancybox-thumbs.js?v=1.0.7"></script>

	<script type="text/javascript"
		src="${basePath}/static/fancybox/helpers/jquery.fancybox-media.js?v=1.0.6"></script>


	<script type="text/javascript">
		$(document).ready(function() {

			$('.fancybox').fancybox();

		});
	</script>
		
		
<style type="text/css">
 

.zxboxr1 {
	width: 35px;
	height: 35px;
	margin: 2px;
	font-size: 35px;
	text-align: left;
	vertical-align: middle;
	display: inline
}

.zxboxr1  img {
	width: 33px;
	height: 33px;
}
</style>

</head>

<body>
  
 
   
      
    <table class=" table table-hover">
                <tr>
                 
                  <th width="10%">美食店名称</th> 
                    <th width="10%">姓名</th>
                     <th width="10%">电话</th>   
                   <th width="10%">总额</th> 
                   <th width="10%">实付金额</th> 
                      <th width="6%">状态</th>
                      <th width="6%">创建时间</th>
                </tr>
                	<c:choose>
				<c:when test="${!empty pageView.records }">
					<c:forEach items="${pageView.records}" var="entry"
						varStatus="statu">
                <tr id="del_${entry.id }"> 
                   
                  <td >${entry.name }</td>
                    <td  >${entry.userName }</td> 
                       <td  >${entry.phone }</td> 
                   <td  >${entry.totalAmount }</td> 
                    <td  >${entry.amountPaid }</td>  
 
                    <td  >${entry.statu }</td> 
                      <td  >${entry.createTime }</td> 
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

 

  	<div class="modal fade" id="dishModal"> 
  
      </div>
      
   
     
<script type="text/javascript">
 
		 
 function delId(id){
 $("#delId").val(id); 
 $("#delUrl").val("/admin/ajax/hotel/room/del"); 
 }

 
      
/*               
            	 function  saveAndUpdateDish(){ 
           
		      var name=$("#dish_name").val();  
             var price=$("#dish_price").val();  
               var unit=$("#dish_unit").val();
                var type=$("#dish_type").val(); 
                 var did=$("#dish_id").val();
                    
                 var page=$("#dish_page").val();
            $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/admin/ajax/hotel/room/saveAndUpdateDish",                                      
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
			dishList(page);
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
