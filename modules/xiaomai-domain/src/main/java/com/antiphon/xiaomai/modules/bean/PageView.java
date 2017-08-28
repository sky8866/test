package com.antiphon.xiaomai.modules.bean;

import java.util.LinkedHashMap;
import java.util.List;

public class PageView<T> {
	/** 分页数据 **/
	private List<T> records;
	/** 页码开始索引和结束索引 **/
	private PageIndex pageindex;
	/** 总页数 **/
	private long totalpage = 1;
	/** 每页显示记录数 **/
	private int maxresult = 12;
	/** 当前页 **/
	private int currentpage = 1;
	/** 总记录数 **/
	private long totalrecord;
	/** 页码数量 **/
	private int pagecode = 10;
	/** 获取全部，即不做数据库分页 ,设置为true**/
	protected boolean listTotal = false;  
	
	

   private LinkedHashMap<String, String> orderby=new LinkedHashMap<String, String>();//排序
	
   
   public PageView(){
	   listTotal=true;
	  
   };
	public PageView(int maxresult, int currentpage) {
		this.maxresult = maxresult;
		this.currentpage = currentpage;
		
	}
	
	/** 要获取记录的开始索引 **/
	
	public int getFirstResult() {
		return (this.currentpage-1)*this.maxresult;
	}
	public int getPagecode() {
		return pagecode;
	}

	public void setPagecode(int pagecode) {
		this.pagecode = pagecode;
	}

	
	public void setQueryResult(QueryResult<T> qr){
		setTotalrecord(qr.getTotalrecord());
		setRecords(qr.getResultlist());
	}
	
	public long getTotalrecord() {
		return totalrecord;
	}
	public void setTotalrecord(long totalrecord) {
		this.totalrecord = totalrecord;
		setTotalpage(this.totalrecord%this.maxresult==0? this.totalrecord/this.maxresult : this.totalrecord/this.maxresult+1);
	}
	public List<T> getRecords() {
		return records;
	}
	public void setRecords(List<T> records) {
		this.records = records;
	}
	public PageIndex getPageindex() {
		return pageindex;
	}
	public long getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(long totalpage) {
		this.totalpage = totalpage;
		this.pageindex = PageIndex.getPageIndex(pagecode, currentpage, totalpage);
	}
	public int getMaxresult() {
		return maxresult;
	}
	public int getCurrentpage() {
		return currentpage;
	}
	
	public LinkedHashMap<String, String> getOrderby() {
		return orderby;
	}
	
	public boolean isListTotal() {
		return listTotal;
	}
	public void setListTotal(boolean listTotal) {
		this.listTotal = listTotal;
	}
	
	
	
	
	/**
	 * 排序
	 * @param orderBy 根据的排序属性
	 * @param orderDir 升或降序 如：asc或desc;
	 */
	public void setOrderby(String orderBy,String orderDir){
		if("asc".equals(orderDir)||"desc".equals(orderDir)){
			orderby.put(orderBy, orderDir);
		}else{
			orderby.put(orderBy, "desc");
		}
		
	}
	
	
	
}
