package com.antiphon.xiaomai.modules.bean;
/**
 * 
 * @author sky
 *
 */
public enum MatchType {
	/**
	 * 等于
	 * */
	EQ{
		public String getName(){return "=";}
	},

	/**
	 * like '%value%'
	 * */
	LIKE{
		public String getName(){return "like";}
	},
	
	
	/**
	 * 小于
	 * */
	LT{
		public String getName(){return "<";}
	},
	
	/**
	 * 大于
	 * */
	GT{
		public String getName(){return ">";}
	},
	
	/**
	 * 小于等于
	 * */
	LE{
		public String getName(){return "<=";}
	},
	/**
	 * 大于等于
	 */
	GE{
		public String getName(){return ">=";}
	},
	
	/**
	 * 
	 * 不等于
	 * 
	 */
	NE{
		public String getName(){return "!=";}
	},
	NULL{
		public String getName(){return "isnull";}
	},  // isNull
	NNULL{
		public String getName(){return "isnotnull";}
	},  // is notNull
	IN{
		public String getName(){return "isin";}
	},
	OR{
		public String getName(){return "isor";}	
	},
	BETWEEN{
		public String getName(){return "between";}
	}
	;  // in
	
	public abstract String getName();
	
}
