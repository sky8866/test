package com.antiphon.xiaomai.modules.dao.base;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult;

 


 

public interface HibernateDao<T> {



	/**
	 * 查询些记录是否存在
	 * @param property
	 * @param name
	 * @return
	 */
	public abstract boolean exsit(Object property, Object name);

	/**
	 * 根据某属性查询
	 */

	public abstract T findProperty(Object property, Object value);
	public abstract T findPropertys( Object[] property,Object[] value);
	
	public abstract List<T> findPropertyMoreList( Object[] property,Object[] value) ;
	/**
	 * 获取实体
	 * @param <T>
	 * @param entityClass 实体类
	 * @param entityId 实体id
	 * @return
	 */
	
	public abstract T find(Serializable entityId);
	
	/**
	 * 根据自定语句查询
	 */
		 
		public T findHQL(String hql);
		
		/**
		 * 根据自定语句查询
		 */
		 
		public T findHQL(String hql,Object[] queryParams);

	/**
	 * 保存实体
	 * @param entity 实体id
	 */
	public abstract void save(T entity);
	
	/**
	 * 新增或修改实体
	 * @param entity 实体id
	 */
	public abstract T saveOrUpdate(T entity);
	
	
	
	/**
	 * 批量保存实体
	 * @param Collection<?>
	 */
	public abstract void saveAll(Collection<?> entities);

	/**
	 * 更新实体
	 * @param entity 实体id
	 */
	public abstract void update(T entity);

	/**
	 * 删除
	 * @param entityids
	 */

	public abstract void delete(Serializable... entityids);

	/**
	 * 获取记录总数
	 * @param entityClass 实体类
	 * @return
	 */
	 
	public abstract long getCount();
	
	/**
	 * 获取记录总数
	 * @return
	 */
	public long getCountHQL(String hql);
	
	/**
	 * 获取记录总数
	 * @return
	 */
	public long getCountHQL(String hql,Object[] queryParams) ;

	/**
	  * 查询所有 
	  * @param hql 自定义查询语句
	  * @return
	  */
	
	 
	public abstract  List<T> findAllPage(String hql);
	
	/**
	 * 获取所有List集合数据
	 * @return
	 */
	 
	public abstract List<T> findLists();
	
	/**
	 * 条件查询获取List集合数据
	 * @param pv
	 * @param filters
	 * @return
	 */
	
	 
	public abstract List<T> findLists(PageView<T> pv,List<PropertyFilter> filters);
	
	/**
	 * 自定义条件查询获取List集合数据
	 * @param pv
	 * @param hql
	 * @param queryParams
	 * @return
	 */
 
	public abstract List<T> findLists(PageView<T> pv, String hql, Object[] queryParams);
	
	/**
	 * 获取分页数据
	 * @param pv 如：
	 * PageView<User> pageView = new PageView<User>(5,  1);
	 * 5表示当前显示数量，1表示当前页码
	 * pageView.setOrderby("regDate", "asc");//排序
	 * pageView.setListTotal(true);//设置为true表示查询所有数据
	 * 
	 * @param filters 如：
	 * List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
	 * filters.add(new PropertyFilter("username",MatchType.EQ,"sky2"));
	 * username表示实体类的属性，用于比较的字段，
	 * MatchType表示根据什么来查，如：大于，等于，小于 ..调用时看枚举类MatchType设置合适自己的条件，sky条件值
	 * @return
	 */
 
	public abstract QueryResult<T> findPage(PageView<T> pv,List<PropertyFilter> filters);
	/**
	 * 可以添加HQL查询语句的条件查询
	 * @param pv 创建一个查询对象PageView<User> pageView = new PageView<User>(5,  1);
	 * @param wherehql //添加HQL语句：
	 * @param queryParams//值
	 * 例：
	 * StringBuffer hql = new StringBuffer("");
	 * List<Object> queryParams = new ArrayList<Object>();
	 *    hql.append("o.username=?").append(queryParams.size()+1);?后面的标识，必须从“1”开始
	 *	  queryParams.add("sky");
	 *	if(queryParams.size()>0) hql.append(" and ");
	 *			hql.append(" ( o.name like ? ").append(queryParams.size()+1);
	 *			queryParams.add("%"+变量值+ "%");
	 *			hql.append.( " or ").append(" ( o.name like ? ").append(queryParams.size()+1).append.( " ) ");
	 *			queryParams.add("%"+变量值+ "%");
	 * pageView.setQueryResult(this.service.findPage(pageView, hql.toString(), queryParams.toArray()));
	 * 
	 * @return
	 */

	
	 
	public abstract QueryResult<T> findPage(PageView<T> pv, String hql, Object[] queryParams) ;
	
	
	
	 /**
     * 完全自定义HQL语句的条件查询(只有HQL语句)
     * @param hql 
     
     * @return
     */
	 
	public  List<T> findByMyHqlList( String hql);
	
	
	  /**
     * 完全自定义HQL语句的条件查询(有条件)
     * @param pv
     * @param hql 
   
     * @param queryParams
     * @return
     */
	 
	public  List<T> findByMyHqlList(PageView<T> pv, String hql) ;
	public  List<T> findByMyHqlList( String hql,Object[] queryParams);
	
	  /**
     * 完全自定义HQL语句的条件查询(有条件)
     * @param pv
     * @param hql 
     * * @param chql 记录总数的语句
     * @param queryParams
     * @return
     */
 
	public  List<T> findByMyHqlList(PageView<T> pv, String hql,Object[] queryParams);
	
	
	
	 /**
     * 完全自定义HQL语句的条件（包括分页与不分页）查询
     * @param pv
     * @param hql
     * @param queryParams
     * @return
     */
	 
	public  QueryResult<T> findByMyHqlPage(PageView<T> pv, String hql,String chql,Object[] queryParams);
	/**
	 * 根据某个属性查询列表
	 * @param property
	 * @param value
	 * @return
	 */
	public List<T> findPropertyList( Object property,Object value) ;
	/**
	 * 自定义hql操作
	 * @param hql
	 */
	public void setHQL(String hql);
	
	/**
	 * 自定义sql操作
	 * @param hql
	 */
	public void setSQL(String sql);
	
	/**
	 * 通过SQL语句查询
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	
	public List findBySQL(final String sql) throws SQLException;
	
	/**
	 * 分页自定义语句查询
	 * @param hql
	 * @param start
	 * @param limit
	 * @return
	 * @throws SQLException
	 */
	public List<?> findAllPage(final String hql,final int start,final int limit) throws SQLException;
	/**
	 * 
	 * @param pv
	 * @param hql
	 * @return
	 */
	public QueryResult<T> findHQLPage(PageView<T> pv, String hql, String chql);
	
	
}