package com.antiphon.xiaomai.modules.entity.custom;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.antiphon.xiaomai.common.utils.ConfigUtil;
import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.entity.RecordEntity;
/**
 * 定制师个人信息
 * @author pjz
 *
 */
@Entity
@Table(name = "xm_custom_info") 
public class CustomInfo extends RecordEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2378863859639396653L;
	private String name;//定制师姓名
	private String nickname;//定制师昵称
	private String identcity;//定制师所属城市
	private String sex;
	private String birthday;
	private String hometown;//祖籍
	//private String inhabitCity;  //服务地
	private int inhabitTime;  //居住年限
	private String introduceMyself;  //自我介绍
	private String profession; //职业
	private String schoolTag; //毕业院校
	private String major;  //专业
	private String education;  //学历
	private String pictureLink; //头像路径
	private String weixin; //微信
	private String email;
	private String phone;
	private String wizardType;//向导类型
	private Integer indentTotal;//成交量
	private Double serveBest;//评分
	private Integer commentTotal;//每个定制师的评论条数
	private String chinese;
	private String english;//英语
	private String cantonese;//粤语
	
	private String province;
	private String city;
	private String district;
	/**
	 * 驾照
	 */
	private String drivingLicense;
	/**
	 * 是否有车
	 */
	private String vehicle;
	/**
	 * 汽车型号
	 */
	private String vehicleModel;
	
	private List<String> customLanguage;//语言
	
	private List<String> customLabel;//个性标签
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getIdentcity() {
		return identcity;
	}
	public void setIdentcity(String identcity) {
		this.identcity = identcity;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public int getInhabitTime() {
		return inhabitTime;
	}
	public void setInhabitTime(int inhabitTime) {
		this.inhabitTime = inhabitTime;
	}
	public String getIntroduceMyself() {
		return introduceMyself;
	}
	public void setIntroduceMyself(String introduceMyself) {
		this.introduceMyself = introduceMyself;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getSchoolTag() {
		return schoolTag;
	}
	public void setSchoolTag(String schoolTag) {
		this.schoolTag = schoolTag;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getPictureLink() {
		return pictureLink;
	}
	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
	}
	
	public String getWeixin() {
		return weixin;
	}
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	//@Transient
	public String getWizardType() {
		return wizardType;
	}
	public void setWizardType(String wizardType) {
		this.wizardType = wizardType;
	}
	@Transient
	public List<String> getCustomLanguage() {
		return customLanguage;
	}
	public void setCustomLanguage(List<String> customLanguage) {
		this.customLanguage = customLanguage;
	}
	@Transient
	public List<String> getCustomLabel() {
		return customLabel;
	}
	public void setCustomLabel(List<String> customLabel) {
		this.customLabel = customLabel;
	}
	@Column(updatable=false)
	public Integer getIndentTotal() {
		return indentTotal;
	}
	
	public void setIndentTotal(Integer indentTotal) {
		this.indentTotal = indentTotal;
	}
	@Column(updatable=false)
	public Double getServeBest() {
		return serveBest;
	}
	
	public void setServeBest(Double serveBest) {
		this.serveBest = serveBest;
	}
	public String getChinese() {
		return chinese;
	}
	public void setChinese(String chinese) {
		this.chinese = chinese;
	}
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	
	
	public String getCantonese() {
		return cantonese;
	}
	public void setCantonese(String cantonese) {
		this.cantonese = cantonese;
	}
	public String getDrivingLicense() {
		return drivingLicense;
	}
	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}
	public String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	@Column(updatable=false)
	public Integer getCommentTotal() {
		return commentTotal;
	}
	
	public void setCommentTotal(Integer commentTotal) {
		this.commentTotal = commentTotal;
	}
	@Transient
	public String getImagePath() {
		if (StringUtils.isNotEmpty(pictureLink))
			return ConfigUtil.getValue("server")+pictureLink;
		return "";
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	
	
}
