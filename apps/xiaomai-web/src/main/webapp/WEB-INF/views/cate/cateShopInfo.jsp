<%@ page contentType="text/html;charset=UTF-8" %> 
 
 <%@ include file="/WEB-INF/share/taglib.jsp"%>
 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
 
   
        <title>门店管理</title>  
  <script src="${basePath }/static/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
  <link href="${basePath }/static/imgUp/css/common.css" type="text/css" rel="stylesheet"/>
		<link href="${basePath }/static/imgUp/css/index.css" type="text/css" rel="stylesheet"/>
		 <script src="${basePath }/static/imgUp/js/imgPlugin.js"></script>
	<script>
		$(document).ready(function() {
			$("#cateShopInfoForm").validate();
		});
		
		$("#file").takungaeImgup({
      formData: {
          "module": "cate",
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
		updateShopImg(id);	 
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
   
   
         function updateShopImg(id){
   
   var shopId='${cateShop.id}';
  
      if(shopId!=null&&shopId!=""){
               $.ajax({                                                 
  		  type: "post",                                     
  		 url: "${basePath}/admin/ajax/cateshop/updateImgId",                                      
  		 dataType: "text", 
  		   data: {id:id,shopId:shopId},
  		 success: function(html){ 
  		 
  		  if(html=="true"){
  		 
  			 
          }else{
           
          } 
  		 } 
  		 });
   }
   
   }
   
	</script>
	
	<style type="text/css">
#allmap {width: 100%;height: 500px;overflow: hidden;margin:0;} 
 
</style> 
</head>

<body>  
            <!-- /.box-header -->
            <!-- form start -->
            <form id="cateShopInfoForm" class="form-horizontal" method="post" enctype="multipart/form-data" action="${basePath }/admin/cate/catshop/<c:if test="${action!=null }">${action }</c:if><c:if test="${action==null }">create</c:if>">
              
             <input type="hidden" name="page" value="${page }">
             <c:if test="${action=='update' }"><input type="hidden" name="id" value="${cateShop.id}"/>
             </c:if>
             
              <div class="box-body">
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">门店名称：</label>

                  <div class="col-sm-8">
                    <input type="text" class="form-control required" id="name" name="name"  value="${cateShop.name }" placeholder="请输入门店名称">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">门店品类：</label>

                  <div class="col-sm-8">
                   <select class="form-control" name="type" >
                    	<c:forEach items="${gorys}" var="entry" >
                    	 <option  value="${entry.name }" <c:if test="${entry.name==cateShop.type }"> selected</c:if>  >${entry.name }</option>
						</c:forEach>
                    
                    
                  </select>
                  
                  
                  </div>
                </div>
                  <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">门店电话：</label>

                  <div class="col-sm-8">
                    <input type="text" class="form-control required" id="phone" name="phone"  value="${cateShop.phone }" placeholder="请输入门店电话">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">门店城市：</label>

                  
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
                  <label for="inputEmail3" class="col-sm-2 control-label">门店商圈：</label>

                  <div class="col-sm-8">
                    <input type="text" class="form-control required" id="area" name="area"   value="${cateShop.area }" placeholder="请输入门店商圈">
                  </div>
                </div>
                
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">门店地址：</label>

                  <div class="col-sm-8">
                    <textarea class="form-control required" rows="3" id="address" name="address"  placeholder="请输入门店地址">${cateShop.address }</textarea>
                  </div>
                </div>
                 <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">营业状态：</label>

                  <div class="col-sm-8">
                    <select class="form-control" name="status" >
                    <option  value="1" <c:if test="${cateShop.status==1 }"> selected</c:if>  >营业中</option>
                    <option value="2" <c:if test="${cateShop.status==2 }"> selected</c:if> >筹建中</option>
                    <option value="3"  <c:if test="${cateShop.status==3 }"> selected</c:if> >已关门</option>
                    <option value="4" <c:if test="${cateShop.status==4 }"> selected</c:if> >暂停营业</option>
                    
                  </select>
                  </div>
                </div>
                
                  <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">人均消费：</label>

                  <div class="col-sm-6">
                    <input type="text" class="form-control required" id="consumption" name="consumption"  value="${cateShop.consumption }" placeholder="请输入人均消费">
                  </div>
                </div>
                
                  <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">门店封面：</label>

                  <div class="col-sm-6">
                   <c:if test="${!empty cateShop.coverPath}"><img src="${basePath }/${cateShop.coverPath}" border="0" height="150"></c:if> 
                    <input type="file" class="form-control " name="filename"   >
                  </div>
                </div>
                
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">门店介绍：</label>

                  <div class="col-sm-8">
                    <textarea class="form-control required" rows="3" id="info" name="info"  placeholder="请输入门店介绍">${cateShop.info }</textarea>
                  </div>
                </div>
                
                 <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">wifi：</label>

                  <div class="col-sm-8">
                     <div class="radio">
                    <label>
                      <input type="radio" name="wifi" id="wifi" value="1" <c:if test="${cateShop.wifi!=0 }">checked</c:if>>
                                             有
                    </label>
                  </div>
                  <div class="radio">
                    <label>
                      <input type="radio" name="wifi" id="wifi2" value="0" <c:if test="${cateShop.wifi==0 }">checked</c:if>>
                      无
                    </label>
                  </div>
                  </div>
                </div>
                
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">营业时间：</label>

                  <div class="col-sm-8">
                     <div class="row">
                <div class="col-xs-4">
           <input type="text" placeholder="开始时间，如：10：00"  id="starttime"  value="${cateShop.starttime }"
																onfocus="WdatePicker({skin:'whyGreen',dateFmt:'HH:mm',onpicked:function(){endtime.focus();},maxDate:'#F{$dp.$D(\'endtime\')}'})"
															 	name="starttime"  class="form-control   ">
                </div>
                <div class="col-xs-4">
                 <input type="text" placeholder="结束时间，如：22：00"
																name="endtime" value="${cateShop.endtime }"
																onfocus="WdatePicker({skin:'whyGreen',dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'starttime\')}'})"
																id="endtime"   class="form-control  " /> 
                </div>
                 
              </div>
                  </div>
                  
                  
                </div>
                
                
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">停车位：</label>

                  <div class="col-sm-8">
                     <div class="radio">
                    <label>
                      <input type="radio" name="parkingSpace" id="parkingSpace" value="1" <c:if test="${cateShop.parkingSpace!=0 }">checked</c:if> >
                                             有
                    </label>
                  </div>
                  <div class="radio">
                    <label>
                      <input type="radio" name="parkingSpace" id="parkingSpace2" value="0" <c:if test="${cateShop.parkingSpace==0 }">checked</c:if>>
                      无
                    </label>
                  </div>
                  </div>
                </div>
                
            <div class="form-group" >
    <label for="inputEmail3" class="col-sm-2 control-label">门店图片：</label>
  <div class="col-sm-8">
	<div class="img-box full">
			<section class=" img-section">
				 
				<div class="z_photo upimg-div clear" >
				<c:forEach items="${cateShop.shopImgs}" var="entry"
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
                  <label for="inputEmail3" class="col-sm-2 control-label">门店地点：</label>

                  <div class="col-sm-8"> 
                  <input type="hidden" name="longitude" id="longitude" value="${cateShop.longitude}" class="  required">
                   <input type="hidden" name="latitude" id="latitude" value="${cateShop.latitude}"  class="  required">
                 <div id="r-result"><input type="text" id="suggestId"   class="form-control" /></div>
	<div id="searchResultPanel" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;"></div>  
                <div id="allmap" style="margin-top: 10px;"></div>
                
                	
                  </div>
                </div> 
                 
                  
                 
              </div>
              <!-- /.box-body -->
              <div class="box-footer">
                
                <button type="submit" class="btn btn-info pull-left">提交</button>
              </div>
              <!-- /.box-footer -->
            </form>
           
   
  <script type="text/javascript">     	
	 $(document).ready(function() {
         var  province='${cateShop.province}';
           
            
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
	     var  city='${cateShop.city}';  
	      
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
	         var  district='${cateShop.district}';  
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
var lang='${cateShop.longitude}';
var lat='${cateShop.latitude}';
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
	
</script>
 
    
    
</body>
</html>
