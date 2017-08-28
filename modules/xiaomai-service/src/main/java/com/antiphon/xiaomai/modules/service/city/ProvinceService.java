package com.antiphon.xiaomai.modules.service.city;

import java.io.Serializable;
import java.util.List;

import com.antiphon.xiaomai.modules.entity.city.Province;
 
public interface ProvinceService {
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public  Province  findProvince(Long  id);
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	public void saveProvince(Province r);
	/**
	 * 更新
	 * @param id
	 * @return
	 */
	public void updateProvince(Province r);
	 
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public void delProvince(Serializable... entityids);
	/**
	 * 根据某属性查询
	 * @param p
	 * @param v
	 * @return
	 */
	
	public Province findProvince(Object p,Object v);
	
	public List<Province> findProvinces();
	
	public List<Province> findProvinces(Object p,Object v);
  
}
