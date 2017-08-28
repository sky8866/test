package com.antiphon.xiaomai.apps.action.api.vo.cate;

import com.antiphon.xiaomai.common.utils.ConfigUtil;
import com.antiphon.xiaomai.modules.entity.img.Imgs;

public class ImgsVo {
	
	public String imgUrl;
	
public ImgsVo(Imgs img){
	this.imgUrl=ConfigUtil.getValue("server")+img.getImagePath();
}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	

}
