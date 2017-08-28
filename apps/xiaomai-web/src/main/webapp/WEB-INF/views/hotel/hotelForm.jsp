<%@ page contentType="text/html;charset=UTF-8" %> 
 
 <%@ include file="/WEB-INF/share/taglib.jsp"%>
 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
 
   
        <title>酒店管理</title>  
 <script src="${basePath }/static/My97DatePicker/WdatePicker.js" type="text/javascript"></script>  
  <link href="${basePath }/static/imgUp/css/common.css" type="text/css" rel="stylesheet"/>
		<link href="${basePath }/static/imgUp/css/index.css" type="text/css" rel="stylesheet"/>
		 <script src="${basePath }/static/imgUp/js/imgPlugin.js" type="text/javascript"></script>

<link rel="stylesheet"
	href="${basePath }/static/kindEditor/themes/default/default.css" />
<link rel="stylesheet"
	href="${basePath }/static/kindEditor/plugins/code/prettify.css" />
<script charset="utf-8"
	src="${basePath }/static/kindEditor/kindeditor.js"></script>
<script charset="utf-8"
	src="${basePath }/static/kindEditor/lang/zh_CN.js"></script>
<script charset="utf-8"
	src="${basePath }/static/kindEditor/plugins/code/prettify.js"></script>
<script>
	KindEditor
			.ready(function(K) {
				var editor1 = K
						.create(
								'textarea[name="content"]',
								{
									cssPath : '${basePath }/static/kindEditor/plugins/code/prettify.css',
									uploadJson : '${basePath }/jsp/upload_json.jsp',
									fileManagerJson : '${basePath }/jsp/file_manager_json.jsp',
									allowFileManager : true,
									afterCreate : function() {
										var self = this;
										K.ctrl(document, 13, function() {
											self.sync();
											document.forms['myform'].submit();
										});
										K.ctrl(self.edit.doc, 13, function() {
											self.sync();
											document.forms['myform'].submit();
										});
									}
								});
								
					var editor2 = K.create(
								'textarea[name="hotelPolicy"]',
								{
									cssPath : '${basePath }/static/kindEditor/plugins/code/prettify.css',
									uploadJson : '${basePath }/jsp/upload_json.jsp',
									fileManagerJson : '${basePath }/jsp/file_manager_json.jsp',
									allowFileManager : true,
									afterCreate : function() {
										var self = this;
										K.ctrl(document, 13, function() {
											self.sync();
											document.forms['myform'].submit();
										});
										K.ctrl(self.edit.doc, 13, function() {
											self.sync();
											document.forms['myform'].submit();
										});
									}
								});
								
				prettyPrint();
			});
			
		
</script>

 
 	<style type="text/css">
#allmap {width: 100%;height: 500px;overflow: hidden;margin:0;} 
#divId {width: 100%;height: 500px;overflow: hidden;margin:0;} 
</style> 
</head>

<body> 
 
  
 
       	<div class="row "  >

	  
        <div class="col-lg-12 col-xs-12 col-sm-12 ">
          <div class="box">
           
            
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding"  >
                  <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="nav-tabs-custom">
            <ul class="nav nav-tabs">
              <li class="active"><a href="#cateShopInfo"  data-toggle="tab">酒店管理</a></li>
            
                
            </ul>
            <div class="tab-content ">
              <!-- 门店信息管理 -->
              <div class="tab-pane  active " id="cateShopInfo">
                 <form id="hotelform" class="form-horizontal" method="post"  enctype="multipart/form-data"  action="${basePath}/admin/hotel/saveAndUpdatehotel">
                <input type="hidden" name="id" id="hotel_id" value="${hotel.id }">
              <input type="hidden" name="page" id="hotel_page" value="${page }">
             
              <div class="box-body">
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">酒店名：</label>

                  <div class="col-sm-8">
                     <input type="text" class="form-control required" id="hotel_name" name="hotelName" value="${hotel.hotelName }"    placeholder="请输入酒店名">
                  </div>
                </div>
 
            <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">酒店英文名：</label>

                  <div class="col-sm-8">
                     <input type="text" class="form-control " id="hotel_hotelEname" name="hotelEname" value="${hotel.hotelEname }"    placeholder="请输入酒店英文名">
                  </div>
                </div>
                 
               <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">酒店简称：</label>

                  <div class="col-sm-8">
                     <input type="text" class="form-control required" id="hotel_hotelAbbr" name="hotelAbbr" value="${hotel.hotelAbbr }"    placeholder="请输入酒店简称">
     
                  </div>
                </div>
                          
                          
                                           <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">门店封面：</label>

                  <div class="col-sm-6">
                   <c:if test="${!empty hotel.coverPath}"><img src="${basePath }/${hotel.coverPath}" border="0" height="150"></c:if> 
                    <input type="file" class="form-control " name="filename"   >
                  </div>
                </div>
                          
                              
               <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">品牌：</label>

                  <div class="col-sm-8">
                     <input type="text" class="form-control required" id="brand" name="brand" value="${hotel.brand }"    placeholder="请输入酒店品牌">
     
                  </div>
                </div>
              <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">最低价格：</label>

                  <div class="col-sm-8">
                     <input type="text" class="form-control required" id="floorPrice" name="floorPrice" value="${hotel.floorPrice }"    placeholder="请输入房间最低价格">
     
                  </div>
                </div>
                 <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">星级：</label>

                  <div class="col-sm-8">
                    <select class="form-control" name="stars" >
                    <option  value="客栈" <c:if test="${hotel.stars=='客栈' }"> selected</c:if>  >客栈</option>
                    <option value="经济连锁" <c:if test="${hotel.stars=='经济连锁' }"> selected</c:if> >经济连锁</option>
                    <option value="二星"  <c:if test="${hotel.stars=='二星' }"> selected</c:if> >二星</option>
                    <option value="三星舒适" <c:if test="${hotel.stars=='三星舒适' }"> selected</c:if> >三星舒适</option>
                    <option value="四星高档" <c:if test="${hotel.stars=='四星高档' }"> selected</c:if> >四星高档</option>
                    <option value="五星豪华" <c:if test="${hotel.stars=='五星豪华' }"> selected</c:if> >五星豪华</option>
                  </select>
                  </div>
                </div>
                                 <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">地区：</label>

                  <div class="col-sm-8">
                     <div class="row">
                     <div class="col-xs-4" id="provinceId"> 
  <select class="form-control  required">
       <option value=""  >请选择</option>
</select>
  </div>
  <div class="col-xs-4"  id="cityId">
       <select class="form-control  required">
       <option value=""  >请选择</option>
</select>
  </div>
  <div class="col-xs-4" id="districtId">
   <select class="form-control  required">
       <option value=""  >请选择</option>
</select>
  </div>
                    
              </div>
                  </div>
                  
                </div>
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">酒店地址：</label>

                  <div class="col-sm-8">
                     <input type="text" class="form-control required" id="hotel_address" name="address" value="${hotel.address }"    placeholder="请输入酒店地址">
     
                  </div>
                </div>
                 <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">酒店电话：</label>

                  <div class="col-sm-8">
                     <input type="text" class="form-control required" id="hotel_address" name="tel" value="${hotel.tel }"    placeholder="请输入酒店电话">
     
                  </div>
                </div>
                
                
				<div class="form-group">
					<label for="ticketIntroduce" class="col-sm-2 control-label">酒店介绍</label>
					<div class="col-sm-8">
								<textarea class="form-control " rows="6" placeholder="请输入"
							name="content" required>${hotel.content}</textarea>
					</div>
				</div> 
				
				
				<div class="form-group">
					<label for="bookings" class="col-sm-2 control-label">酒店政策</label>
					<div class="col-sm-8">
							<textarea class="form-control" rows="6" placeholder="请输入"
							name="hotelPolicy" required>${hotel.hotelPolicy}</textarea>
					</div>
				</div>
				
				                 <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">门店地点：</label>

                  <div class="col-sm-8">
                  <input type="hidden" name="longitude" id="longitude" value="${hotel.longitude}" class="  required">
                   <input type="hidden" name="latitude" id="latitude" value="${hotel.latitude}"  class="  required">
          <div id="r-result"><input type="text" id="suggestId"  name="map" value="${hotel.map }"   class="form-control" /></div>
	<div id="searchResultPanel" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;"></div>   
                <div id="allmap" style="margin-top: 10px;"></div>
                
                	
                  </div>
                </div>
                            <div class="form-group" >
    <label for="inputEmail3" class="col-sm-2 control-label">门店图片：</label>
  <div class="col-sm-8">
	<div class="img-box full">
			<section class=" img-section">
				 
				<div class="z_photo upimg-div clear" >
			
		               		<c:forEach items="${hotel.imgs}" var="entry"
						varStatus="statu">
		               <section class="up-section fl">
		               		<span class="up-span"></span>
		               		<img src="${basePath }/static/imgUp/img/a7.png" class="close-upimg" onclick="delId(${entry.id})">
		               		 
		               		<img src="${basePath }/${entry.imagePath}" class="up-img">
		               	    <p class="img-namep"></p>
		               	    <input id="taglocation" name="taglocation" value="" type="hidden">
		               	    <input id="tags" name="tags" value="" type="hidden">
		               	</section>
		               		</c:forEach>
		              
		               	 <section class="z_file fl">
		              
		               	 	<img src="${basePath }/static/imgUp/img/a11.png" class="add-img">
		               	 	<input type="file" name="file" id="file" class="file" value="" accept="image/jpg,image/jpeg,image/png,image/bmp" multiple />
		               	 </section>
		         </div>
			 </section>
		</div>
        <aside class="mask works-mask">
			<div class="mask-content">
			<input type="hidden" id="delImgId">
				<p class="del-p">您确定要删除图片吗？</p>
				<p class="check-p"><span class="del-com wsdel-ok "><a onclick="delImg()">确定</a></span><span class="wsdel-no"><a>取消</a></span></p>
			</div>
		</aside>
 </div>
 </div>
 
 <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">是否开放：</label>

                  <div class="col-sm-8">
                      <label class="radio-inline">
                         <input type="radio" name="visible"  value="0"    <c:if test="${hotel.visible==0 }"> checked</c:if> > 关闭
                       </label>
                      <label class="radio-inline">
                         <input type="radio" name="visible" id="addBed2" value="1" <c:if test="${ empty hotel }"> checked</c:if>  <c:if test="${hotel.visible==1 }"> checked</c:if>> 开启
                      </label>
     
                  </div>
                </div>
                
              </div>
              <!-- /.box-body -->
              <div class="box-footer">
                
                <button type="submit" class="btn btn-info pull-left">提交</button>
              </div>
              <!-- /.box-footer -->
            </form>
           
                 
            </div>
             
    
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
          <!-- /.box -->
        </div>
      </div>
  
  <script type="text/javascript">     	
	 $(document).ready(function() {
         var  province='${hotel.province}'; 
         if(province==""||province==null){
          province='440000';
         }	      
           
            $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/admin/ajax/province",                                      
  		 dataType: "html",  
  		  data: {provincecode:province},
  		 success: function(html){  
              
  			 $("#provinceId").empty();
  			 $("#provinceId").append(html);
  			 citySelect(province);
  		 } 
  		 });
		 

		});
	function citySelect(value){
	     var  city='${hotel.city}';  
	      
         if(city==""||city==null){
          city='440100';
         }	  
        
            $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/admin/ajax/city",                                      
  		 dataType: "html", 
  		 data: {provincecode:value,citycode:city},
  		 success: function(html){  
         
  			 $("#cityId").empty();
  			 $("#cityId").append(html);
  			city= $("#citycode").val();
  			 
  			 districtSelect(city);
  		 } 
  		 });
		 
			}
			
				function districtSelect(value){
	         var  district='${hotel.district}';  
         if(district==""||district==null){
          district='440106';
         }	
            $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/admin/ajax/district",                                      
  		 dataType: "html", 
  		 data: {citycode:value,districtcode:district},
  		 success: function(html){  
           
  			 $("#districtId").empty();
  			 $("#districtId").append(html);
  		 } 
  		 });
		 
			}
 </script>
 
    <script type="text/javascript">
var lang='${hotel.longitude}';
var lat='${hotel.latitude}';
 if(lang==null||lang==""){
   lang='113.360432';
   lat='23.154327';
 }

 var map = new BMap.Map("allmap");
var point = new BMap.Point(lang,lat);
map.centerAndZoom(point, 15);
map.addControl(new BMap.MapTypeControl({mapTypes: [BMAP_NORMAL_MAP,BMAP_HYBRID_MAP]}));

map.addControl(new BMap.MapTypeControl({anchor: BMAP_ANCHOR_TOP_LEFT}));
map.addControl(new BMap.NavigationControl());               // 添加平移缩放控件
map.addControl(new BMap.ScaleControl());                    // 添加比例尺控件
map.addControl(new BMap.OverviewMapControl());              //添加缩略地图控件
map.enableScrollWheelZoom();                  // 启用滚轮放大缩小。
map.enableKeyboard();                         // 启用键盘操作。
 $(document).ready(function() {
           	         
            $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/admin/ajax/province",                                      
  		 dataType: "html",  
  		 success: function(html){  
              
  			 $("#provinceId").empty();
  			 $("#provinceId").append(html);
  		 } 
  		 });
			 addMarker(lang,lat);

		});
		
	
		
		
		
		
		
function addMarker(lng,lat){
   $("#longitude").val(lng);
    $("#latitude").val(lat);
   var  point = new BMap.Point(lng,lat); 
	
	   var  marker = new BMap.Marker(point); 
		map.addOverlay(marker); 
		 	

}
 
 map.addEventListener("click", showInfo);
 
	function showInfo(e){
	map.clearOverlays();
	 
	  addMarker(e.point.lng,e.point.lat);
		 
	}
 
   
	
	function G(id) {
		return document.getElementById(id);
	}
	
	var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
		{"input" : "suggestId"
		,"location" : map
	});

	ac.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
	var str = "";
		var _value = e.fromitem.value;
		var value = "";
		if (e.fromitem.index > -1) {
			value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
		}    
		str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;
		
		value = "";
		if (e.toitem.index > -1) {
			_value = e.toitem.value;
			value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
		}    
		str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
		G("searchResultPanel").innerHTML = str;
	});

	var myValue;
	ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
	var _value = e.item.value;
		myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
		G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;
		
		setPlace();
	});
	

	function setPlace(){
		map.clearOverlays();    //清除地图上所有覆盖物
		function myFun(){
			var pp = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
			map.centerAndZoom(pp, 18);
			 $("#longitude").val(pp.lng);
         $("#latitude").val(pp.lat);
			map.addOverlay(new BMap.Marker(pp));    //添加标注
		}
		var local = new BMap.LocalSearch(map, { //智能搜索
		  onSearchComplete: myFun
		});
		local.search(myValue);
	}
	$(document).ready(function() {
			$("#hotelform").validate();
		});
</script>



     
 <script type="text/javascript">
  
		$("#file").takungaeImgup({
      formData: {
          "module": "hotel",
          "name": "imgId"
      },
      url:  "${basePath }/admin/ajax/img/upload",
      success: function(data) {},
      error: function(err) {
          alert(err);
      }
});
 function  delId(id){
    $("#delImgId").val(id);
   }
 
      function delImg(){
   var id=$("#delImgId").val();
  
   if(id!=null&&id!=""){
                  $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/admin/ajax/img/del",                                      
  		 dataType: "text", 
  		   data: {id:id},
  		 success: function(html){ 
  		 
  		  if(html=="true"){
  		 
  			  art.dialog({
				 width: '18em',
				 title:'消息',
				 content: '删除图片成功！',
			    time: 3000
			});
		updateHotelImg(id);	 
          }else{
            art.dialog({
				 width: '18em',
				 title:'消息',
				 content: '删除图片失败！',
			    time: 3000
			});
          } 
  		 } 
  		 });
   }

   }
   
   
         function updateHotelImg(id){
   
   var hotelId='${hotel.id}';
  
      if(hotelId!=null&&hotelId!=""){
               $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/admin/hotel/updateImgId",                                      
  		 dataType: "text", 
  		   data: {id:id,hotelId:hotelId},
  		 success: function(html){ 
  		 
  		  if(html=="true"){
  		 
  			 
          }else{
           
          } 
  		 } 
  		 });
   }
   
   }
   
	</script>
 
</body>
</html>


