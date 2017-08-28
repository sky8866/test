package com.antiphon.xiaomai.modules.service.img;

import java.io.Serializable;
import java.util.List;

import com.antiphon.xiaomai.modules.entity.img.Imgs;
 

public interface ImgsService {
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public  Imgs  findImgs(Long  id);
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	public void saveImgs(Imgs r);
	/**
	 * 更新
	 * @param id
	 * @return
	 */
	public void updateImgs(Imgs r);
	 
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public void delImgs(Serializable... entityids);
	/**
	 * 根据某属性查询
	 * @param p
	 * @param v
	 * @return
	 */
	
	public Imgs findImgs(Object p,Object v);
	
	public List<Imgs> findImgsList(String imgsId);
	
	public List<Imgs> findImgsList(Object p,Object v);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public void delImgsByResourceId(long id);
}
