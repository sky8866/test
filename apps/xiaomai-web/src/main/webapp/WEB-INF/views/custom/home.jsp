<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="/WEB-INF/share/taglib.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>

<title>定制游个人信息</title>


<script src="${basePath }/static/My97DatePicker/WdatePicker.js"
	type="text/javascript"></script>

</head>

<body>


	<div class="box box-info">
		<div class="box-header with-border">
			<h3 class="box-title">个人信息</h3>
		</div>
		<!-- /.box-header -->
		<!-- form start -->
		<form class="form-horizontal"
			action="${basePath }/admin/custom/saveOrUpdateCustomInfo"
			method="post" enctype="multipart/form-data">
			<input type="hidden" value="${customInfo.id}" name="id">
			<div class="box-body">
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">真实姓名</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="name"
							value="${customInfo.name}" placeholder="请输入" required>
					</div>
				</div>

				<div class="form-group">
					<label for="nickname" class="col-sm-2 control-label">昵称</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="nickname"
							value="${customInfo.nickname}" placeholder="昵称" required>
					</div>
				</div>

				<div class="form-group">
					<label for="pictureLink" class="col-sm-2 control-label">个人头像</label>
					<div class="col-sm-5">
					<input type="hidden" value="${customInfo.pictureLink }" name="pictureLink">
						<img src="${customInfo.imagePath }" alt="1"
							class="img-rounded"  width="140px;" height="140px">
							<input type="file"  name="filename"  >
					</div>
				</div>

				<div class="form-group">
					<label for="nickname" class="col-sm-2 control-label">性别</label>
					<div class="col-sm-1">
						男 <input type="radio" name="sex" value="M"
							<c:if test="${customInfo.sex=='M'}">checked</c:if>>
					</div>
					<div class="col-sm-1">
						女 <input type="radio" name="sex" value="F"
							<c:if test="${customInfo.sex=='F'}">checked</c:if>>
					</div>
				</div>

				<div class="form-group">
					<label for="birthday" class="col-sm-2 control-label">生日</label>
					<div class="col-sm-3">
						<input type="text" placeholder="时间" id="birthday"
							onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',onpicked:function(){endtime.focus();}})"
							name="birthday" class="form-control  "
							value='${customInfo.birthday}' />
					</div>
				</div>

				<div class="form-group">
					<label for="hometown" class="col-sm-2 control-label">祖籍</label>
					<div class="col-sm-3">
						<div data-toggle="distpicker">
							<select class="form-control" name="hometown"
								data-province="${customInfo.hometown }"></select>
						</div>
					</div>
				</div>
<%-- 
				<div class="form-group">
					<label for="inhabitCity" class="col-sm-2 control-label">服务地</label>
					<div class="col-sm-3">
						<div data-toggle="distpicker">
							<select class="form-control" name="inhabitCity"
								data-province="${customInfo.inhabitCity }"></select>
							<!-- <select class="form-control"  data-city="${customInfo.inhabitCity }"   ></select> -->
						</div>

					</div>
				</div> --%>

				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">服务地：</label>

					<div class="col-sm-8">
						<div class="row">
							<div class="col-xs-3" id="provinceId">
								<select class="form-control  required">
									<option value="">请选择</option>
								</select>
							</div>
							<div class="col-xs-3" id="cityId">
								<select class="form-control  required">
									<option value="">请选择</option>
								</select>
							</div>
							<div class="col-xs-3" id="districtId">
								<select class="form-control  required">
									<option value="">请选择</option>
								</select>
							</div>

						</div>
					</div>

				</div>




				<div class="form-group">
					<label for="inhabitTime" class="col-sm-2 control-label">居住年限</label>
					<div class="col-sm-3">
						<input type="number" class="form-control" min='1'
							name="inhabitTime" value="${customInfo.inhabitTime}"
							placeholder="请输入">
					</div>
				</div>
				
				<div class="form-group">
					<label for="customLabel" class="col-sm-2 control-label">个性标签</label>
					<div class="col-sm-6">
					<c:forEach var="data" items="${customLabels}" varStatus="status">
					<input name="customLabel" type="checkbox" value="${data}" 
					<c:forEach var="data1" items="${customLabelList}" >
					<c:if test="${data1.name==data}">checked</c:if>
						</c:forEach>  
						/>${data}
					</c:forEach>
					</div>
				</div>


				<div class="form-group">
					<label for="language" class="col-sm-2 control-label">国际语言</label>
					<div class="col-sm-6">
							<c:forEach var="data" items="${glanguages}" varStatus="status">
					<input name="customLanguage" type="checkbox" value="${data}" 
					<c:forEach var="data1" items="${customLanguageList}" >
					<c:if test="${data1.name==data}">checked</c:if>
						</c:forEach>  
						/>${data}
					</c:forEach>
					
					</div>
				</div>
				<div class="form-group">
					<label for="flanguages" class="col-sm-2 control-label">家乡方言</label>
					<div class="col-sm-6">
					<c:forEach var="data" items="${flanguages}" varStatus="status">
					<input name="customLanguage" type="checkbox" value="${data}" 
					<c:forEach var="data1" items="${customLanguageList}" >
					<c:if test="${data1.name==data}">checked</c:if>
						</c:forEach>  
						/>${data}
					</c:forEach>

					</div>
				</div>

				<div class="form-group">
					<label for="email" class="col-sm-2 control-label">邮箱</label>
					<div class="col-sm-3">
						<input type="email" class="form-control" name="email"
							value="${customInfo.email}" placeholder="请输入">
					</div>
				</div>

				<div class="form-group">
					<label for="weixin" class="col-sm-2 control-label">微信</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="weixin"
							value="${customInfo.weixin}" placeholder="请输入">
					</div>
				</div>

				<div class="form-group">
					<label for="wizardType" class="col-sm-2 control-label">向导类型</label>
					<div class="col-sm-3">
						<select class="form-control" name="wizardType">
							<option value="留学生" <c:if test="${customInfo.wizardType=='留学生'}">selected</c:if> >留学生</option>
							<option value="职业兼职" <c:if test="${customInfo.wizardType=='职业兼职'}">selected</c:if> >职业兼职</option>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label for="introduceMyself" class="col-sm-2 control-label">个人简介</label>
					<div class="col-sm-8">
						<textarea class="form-control" rows="3" placeholder="请输入"
							name="introduceMyself">${customInfo.introduceMyself}</textarea>
					</div>
				</div>
				
				<div class="form-group">
					<label for="profession" class="col-sm-2 control-label">职业</label>
					<div class="col-sm-3">
						<select class="form-control" name="profession">
							<option value="导游" <c:if test="${customInfo.profession=='导游'}">selected</c:if> >导游</option>
							<option value="军人" <c:if test="${customInfo.profession=='军人'}">selected</c:if> >军人</option>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<label for="schoolTag" class="col-sm-2 control-label">毕业院校</label>
					<div class="col-sm-3">
					<input type="text" class="form-control" name="schoolTag" value="${customInfo.schoolTag}" placeholder="请输入">
					</div>
				</div>
				
					<div class="form-group">
					<label for="major" class="col-sm-2 control-label">专业</label>
					<div class="col-sm-3">
					<input type="text" class="form-control" name="major" value="${customInfo.major}" placeholder="请输入">
					</div>
				</div>

				<div class="form-group">
					<label for="education" class="col-sm-2 control-label">最高学历</label>
					<div class="col-sm-3">
						<select class="form-control" name="education">
							<option value="博士" <c:if test="${customInfo.education=='博士'}">selected</c:if> >博士</option>
							<option value="研究生" <c:if test="${customInfo.education=='研究生'}">selected</c:if> >研究生</option>
							<option value="本科" <c:if test="${customInfo.education=='本科'}">selected</c:if> >本科</option>
							<option value="大专" <c:if test="${customInfo.education=='大专'}">selected</c:if> >大专</option>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<label for="english" class="col-sm-2 control-label">英文</label>
					<div class="col-sm-3">
						<select class="form-control" name="english">
							<option value="精通" <c:if test="${customInfo.english=='精通'}">selected</c:if> >精通</option>
							<option value="熟悉" <c:if test="${customInfo.english=='熟悉'}">selected</c:if> >熟悉</option>
							<option value="一般" <c:if test="${customInfo.english=='一般'}">selected</c:if> >一般</option>
						</select>
					</div>
				</div>
				
					<div class="form-group">
					<label for="chinese" class="col-sm-2 control-label">中文</label>
					<div class="col-sm-3">
						<select class="form-control" name="chinese">
							<option value="精通" <c:if test="${customInfo.chinese=='精通'}">selected</c:if> >精通</option>
							<option value="熟悉" <c:if test="${customInfo.chinese=='熟悉'}">selected</c:if> >熟悉</option>
							<option value="一般" <c:if test="${customInfo.chinese=='一般'}">selected</c:if> >一般</option>
						</select>
					</div>
				</div>
				
					<div class="form-group">
					<label for="cantonese" class="col-sm-2 control-label">粤语</label>
					<div class="col-sm-3">
						<select class="form-control" name="cantonese">
							<option value="精通" <c:if test="${customInfo.cantonese=='精通'}">selected</c:if> >精通</option>
							<option value="熟悉" <c:if test="${customInfo.cantonese=='熟悉'}">selected</c:if> >熟悉</option>
							<option value="一般" <c:if test="${customInfo.cantonese=='一般'}">selected</c:if> >一般</option>
						</select>
					</div>
				</div>
				
				
				<div class="form-group">
					<label for="drivingLicense" class="col-sm-2 control-label">驾驶证</label>
					<div class="col-sm-3">
						<select class="form-control" name="drivingLicense">
							<option value="1" <c:if test="${customInfo.drivingLicense=='1'}">selected</c:if> >有</option>
							<option value="0" <c:if test="${customInfo.drivingLicense=='0'}">selected</c:if> >无</option>
						</select>
					</div>
				</div>
				
					<div class="form-group">
					<label for="vehicle" class="col-sm-2 control-label">是否有车</label>
					<div class="col-sm-3">
						<select class="form-control" name="vehicle">
							<option value="1" <c:if test="${customInfo.vehicle=='1'}">selected</c:if> >有</option>
							<option value="0" <c:if test="${customInfo.vehicle=='0'}">selected</c:if> >无</option>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<label for="vehicleModel" class="col-sm-2 control-label">汽车型号</label>
					<div class="col-sm-3">
						<input type="text" class="form-control"  name="vehicleModel" value="${customInfo.vehicleModel}">
					</div>
				</div>


			</div>
			<!-- /.box-body -->
			<div class="box-footer">
				<button type="submit" class="btn btn-info pull-center">保存</button>
			</div>
			<!-- /.box-footer -->
		</form>
	</div>

 <script type="text/javascript">     	
	 $(document).ready(function() {
         var  province='${customInfo.province}';
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
	     var  city='${customInfo.city}';  
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
	         var  district='${customInfo.district}';  
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
 

	<script src="${basePath }/static/provincejs/distpicker.data.js"></script>
	<script src="${basePath }/static/provincejs/distpicker.js"></script>
	<script src="${basePath }/static/provincejs/main.js"></script>
	<script language="javascript">
	
	</script>
</body>
</html>
