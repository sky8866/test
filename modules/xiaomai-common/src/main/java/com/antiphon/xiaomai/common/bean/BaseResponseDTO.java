package com.antiphon.xiaomai.common.bean; 
 

public class BaseResponseDTO {


	public BaseResponseDTO(Object status, String msg){
		this.status=Integer.parseInt(status+"");
		this.msg=msg;
	}
	public BaseResponseDTO(Object data) {
		status = 1;
		msg = "处理成功";
		this.data=data;
	}
	
	
	public BaseResponseDTO(Object status, String msg,Object data){
		this.status=Integer.parseInt(status+"");
		this.msg=msg;
		this.data=data;
	}
	
	public BaseResponseDTO() {
		status = 1;
		msg = "处理成功";
	}
	
      
	private Integer status;
	
	private String msg;
	
	private Object data;
	
  
	

 
 

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

 
}
