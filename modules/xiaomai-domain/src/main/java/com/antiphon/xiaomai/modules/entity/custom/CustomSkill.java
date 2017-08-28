package com.antiphon.xiaomai.modules.entity.custom;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.antiphon.xiaomai.modules.entity.RecordEntity;
/**
 * 定制师技能
 * @author pjz
 *
 */

@Entity
@Table(name = "xm_custom_skill") 
public class CustomSkill extends RecordEntity  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7839920855900945914L;
	private long customId; // CustomInfo主键
	private String skillName;
	private String skillLicense;
	public long getCustomId() {
		return customId;
	}
	public void setCustomId(long customId) {
		this.customId = customId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public String getSkillLicense() {
		return skillLicense;
	}
	public void setSkillLicense(String skillLicense) {
		this.skillLicense = skillLicense;
	}
	
	
}
