package com.antiphon.xiaomai.modules.bean;


/**
 * 主要记录页面中简单的搜索过滤条件
 * @author sky
 *
 */
public class PropertyFilter {
	

	String jpql = null;
	Object params = null;
	Object[] paramses = null;
	private MatchType matchType = null;
	
	private Boolean type=true;
	public PropertyFilter(){
		
	}
	
     public PropertyFilter(Boolean type){
    	 this.type=type;
		
	}
	
     public PropertyFilter(MatchType matchType){
    		this.matchType = matchType;
     }
     
	public PropertyFilter(final String fieldName, MatchType matchType,
			Object values) {
		this.jpql = fieldName;
		this.matchType = matchType;

		params = values;
		
	}
	/**
	 * 当使用IN时，使用此构造方法
	 * @param fieldName
	 * @param matchType
	 * @param values
	 */
	public PropertyFilter(final String fieldName, MatchType matchType,
			Object[] values) { 
		this.jpql = fieldName;
		this.matchType = matchType;

		paramses = values;
		
	}
	public String getJpql() {
		return jpql;
	}

	public void setJpql(String jpql) {
		this.jpql = jpql;
	}

	

	public Boolean getType() {
		return type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

	public Object getParams() {
		return params;
	}

	public void setParams(Object params) {
		this.params = params;
	}

	public MatchType getMatchType() {
		return matchType;
	}

	public void setMatchType(MatchType matchType) {
		this.matchType = matchType;
	}

	public Object[] getParamses() {
		return paramses;
	}

	public void setParamses(Object[] paramses) {
		this.paramses = paramses;
	}

	
	
	
	
	
}
