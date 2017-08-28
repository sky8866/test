package com.antiphon.xiaomai.modules.entity.custom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.antiphon.xiaomai.common.utils.ConfigUtil;
import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.entity.RecordEntity;

/**
 * 定制游玩法
 * @author pjz
 *
 */
@Entity
@Table(name = "xm_custom_playInfo") 
public class CustomPlayInfo extends RecordEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4668669815952628868L;
	private Long customId;//定制师id
	private String playName;//玩法名称
	private String playCity;//玩法所在城市
	private String playCoverUrl; //玩法封面图
	private String playLightspot; //玩法亮点
	private int playIsAgio;
	private String playPrompt;//温馨提示
	private Integer status;//状态 ：1上线、2撤回
	private String playBookings;//预定须知
	private String playContent;//详细内容
	private Double playPrice;//参考价格
	private String playPriceExplain;//价格说明
	private String playContain;//包含
	private String playNotContain;//不包含
	private String playType;//玩法类型
	private Integer playTotalSales;//销量
	
	
	public Long getCustomId() {
		return customId;
	}
	public void setCustomId(Long customId) {
		this.customId = customId;
	}
	public String getPlayName() {
		return playName;
	}
	public void setPlayName(String playName) {
		this.playName = playName;
	}
	public String getPlayCity() {
		return playCity;
	}
	public void setPlayCity(String playCity) {
		this.playCity = playCity;
	}
	
	public String getPlayCoverUrl() {
		return playCoverUrl;
	}
	public void setPlayCoverUrl(String playCoverUrl) {
		this.playCoverUrl = playCoverUrl;
	}
	public String getPlayLightspot() {
		return playLightspot;
	}
	public void setPlayLightspot(String playLightspot) {
		this.playLightspot = playLightspot;
	}
	public int getPlayIsAgio() {
		return playIsAgio;
	}
	public void setPlayIsAgio(int playIsAgio) {
		this.playIsAgio = playIsAgio;
	}
	public String getPlayPrompt() {
		return playPrompt;
	}
	public void setPlayPrompt(String playPrompt) {
		this.playPrompt = playPrompt;
	}
	

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getPlayBookings() {
		return playBookings;
	}
	public void setPlayBookings(String playBookings) {
		this.playBookings = playBookings;
	}
	public String getPlayContain() {
		return playContain;
	}
	public void setPlayContain(String playContain) {
		this.playContain = playContain;
	}
	public String getPlayNotContain() {
		return playNotContain;
	}
	public void setPlayNotContain(String playNotContain) {
		this.playNotContain = playNotContain;
	}
	public String getPlayPriceExplain() {
		return playPriceExplain;
	}
	public void setPlayPriceExplain(String playPriceExplain) {
		this.playPriceExplain = playPriceExplain;
	}
	public String getPlayContent() {
		return playContent;
	}
	public void setPlayContent(String playContent) {
		this.playContent = playContent;
	}
	
	public Double getPlayPrice() {
		return playPrice;
	}
	public void setPlayPrice(Double playPrice) {
		this.playPrice = playPrice;
	}
	public String getPlayType() {
		return playType;
	}
	public void setPlayType(String playType) {
		this.playType = playType;
	}
	@Column(updatable=false)
	public Integer getPlayTotalSales() {
		return playTotalSales;
	}
	public void setPlayTotalSales(Integer playTotalSales) {
		this.playTotalSales = playTotalSales;
	}
	
	@Transient
	public String getImagePath() {
		if (StringUtils.isNotEmpty(playCoverUrl))
			return ConfigUtil.getValue("server")+playCoverUrl;
		return "";
	}
}
