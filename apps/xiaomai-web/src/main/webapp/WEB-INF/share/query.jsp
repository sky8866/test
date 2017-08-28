<%@ page language="java" pageEncoding="UTF-8"%>

 <form class="form-inline">
				 


				<div class="form-group">
					 
						<input type="text" class="form-control" placeholder="标题,类型,内容,发布人"
							id="query" name="query">
					 
				</div>
				
				<div class="form-group">
    
     
      <input type="text" placeholder="开始时间" id="starttime"
																onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',onpicked:function(){endtime.focus();},maxDate:'#F{$dp.$D(\'endtime\')}'})"
															 	name="starttime"  class="form-control   " />
															至 <input type="text" placeholder="结束时间"
																name="endtime"
																onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'starttime\')}'})"
																id="endtime"   class="form-control  " /> 
                                
  
  </div>

				<button type="button" class="btn btn-default" onclick="ajaxQueryList()">查询</button>
			</form>