package com.antiphon.xiaomai.modules.service.city;

import java.io.Serializable;
import java.util.List;

import com.antiphon.xiaomai.modules.entity.city.District;
 
public interface DistrictService {
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public  District  findDistrict(Long  id);
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	public void saveDistrict(District r);
	/**
	 * 更新
	 * @param id
	 * @return
	 */
	public void updateDistrict(District r);
	 
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public void delDistrict(Serializable... entityids);
	/**
	 * 根据某属性查询
	 * @param p
	 * @param v
	 * @return
	 */
	
	public District findDistrict(Object p,Object v);
	
	public List<District> findDistricts(Object p,Object v);
 
	
	public List<District> findCitys();
}
