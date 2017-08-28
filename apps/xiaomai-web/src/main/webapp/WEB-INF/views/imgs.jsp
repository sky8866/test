<%@ page contentType="text/html;charset=UTF-8" %> 
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    
    <title></title>
    	<link href="${basePath }/static/imgUp/css/index.css" type="text/css" rel="stylesheet"/>
		 <script src="${basePath }/static/imgUp/js/imgPlugin.js" type="text/javascript"></script>
		 
  </head>
  
  <body>
    <div class="form-group" >
    <label for="inputEmail3" class="col-sm-2 control-label">门店图片：</label>
  <div class="col-sm-8">
	<div class="img-box full">
			<section class=" img-section">
				 
				<div class="z_photo upimg-div clear" >
			
		               		<c:forEach items="${room.imgs}" var="entry"
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
  </body>
</html>
