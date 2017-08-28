package com.antiphon.xiaomai.modules.dao.base.impl;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.antiphon.xiaomai.common.utils.GenericsUtils;
import com.antiphon.xiaomai.common.utils.StringUtils;
import com.antiphon.xiaomai.modules.bean.PageView;
import com.antiphon.xiaomai.modules.bean.PropertyFilter;
import com.antiphon.xiaomai.modules.bean.QueryResult;
import com.antiphon.xiaomai.modules.dao.base.HibernateDao;

 



@SuppressWarnings("unchecked")
@Transactional
public abstract class HibernateDaoImpl<T> implements HibernateDao<T>{
	protected Class<T> entityClass = GenericsUtils.getSuperClassGenricType(this
			.getClass());
	@PersistenceContext
	protected EntityManager em;
	private String hql = null;

	private Object[] queryParams = null;

	public void clear() {
		em.clear();
	}
	
	/**
	 * 查询些记录是否存在
	 * @param property
	 * @param name
	 * @return
	 */
	public boolean exsit(Object property,Object name) {
		try{
			final String entityName=getEntityName(entityClass);
			long count = (Long) em
					.createQuery("select count(o) from "+entityName+" o where o."+property+"=?1")
					.setParameter(1, name).getSingleResult();
			return count > 0;
		}catch (Exception e) {
			return false;
		}
		
	}
	
	
	/**
	 * 根据自定语句查询
	 */
		@Transactional(propagation=Propagation.NOT_SUPPORTED)
		public T findHQL(String hql) {
			try{
				 
				Query q = (Query) em
						.createQuery(hql);
 
				List list = q.getResultList();
				if (!list.isEmpty()) {
					return (T) list.get(0);

				} else {
					return null;
				}
					
			}catch (Exception e) {
				return null;
			}
			
			
		}
		
		/**
		 * 根据自定语句查询
		 */
		
		@Transactional(propagation=Propagation.NOT_SUPPORTED)
		public T findHQL(String hql,Object[] queryParams) {
			try{
				 
				Query q = (Query) em
						.createQuery(hql);

				if(queryParams!=null&&queryParams.length>0){
					setQueryParams(q, queryParams);
				}
				List list = q.getResultList();
				if (!list.isEmpty()) {
					return (T) list.get(0);

				} else {
					return null;
				}
					
			}catch (Exception e) {
				return null;
			}
			
			
		}
		
		/**
		 * 根据某属性查询
		 */
			@Transactional(propagation=Propagation.NOT_SUPPORTED)
			public T findPropertys( Object[] property,Object[] value) {
				try{
					StringBuffer jpql = new StringBuffer();
					int count=1;
					for(Object o:property){
						
						jpql.append("o.").append(o).append("=?"+count);
						if(property.length!=count){
							jpql.append("  and ");
						}
						jpql.append("  ");
						count++;
					}
					 
				   
					
					final String entityName=getEntityName(entityClass);
					if (property == null)
						throw new RuntimeException(this.entityClass.getName()+ ":传入的属性不能为空");
					Query q = (Query) em
							.createQuery(
									"select o from "+entityName+" o where  "+jpql.toString());
							
					for(int i=0;i<value.length;i++){
						
						q.setParameter(i+1, value[i]);
					}
					@SuppressWarnings("rawtypes")
					List list = q.getResultList();
					if (!list.isEmpty()) {
						return (T) list.get(0);

					} else {
						return null;
					}
						
				}catch (Exception e) {
					return null;
				}
				
				
			}
			
			
			/**
			 * 根据多个属性查询
			 */
				@Transactional(propagation=Propagation.NOT_SUPPORTED)
				public List<T> findPropertyMoreList( Object[] property,Object[] value) {
					try{
						StringBuffer jpql = new StringBuffer();
						int count=1;
						for(Object o:property){
							
							jpql.append("o.").append(o).append("=?"+count);
							if(property.length!=count){
								jpql.append("  and ");
							}
							jpql.append("  ");
							count++;
						}
						 
					   
						
						final String entityName=getEntityName(entityClass);
						if (property == null)
							throw new RuntimeException(this.entityClass.getName()+ ":传入的属性不能为空");
						Query q = (Query) em
								.createQuery(
										"select o from "+entityName+" o where  "+jpql.toString());
								
						for(int i=0;i<value.length;i++){
							
							q.setParameter(i+1, value[i]);
						}
						@SuppressWarnings("rawtypes")
						List list = q.getResultList();
						if (!list.isEmpty()) {
							return list;

						} else {
							return null;
						}
							
					}catch (Exception e) {
						return null;
					}
					
					
				}
				
			
	/**
	 * 根据某属性查询
	 */
		@Transactional(propagation=Propagation.NOT_SUPPORTED)
		public T findProperty( Object property,Object value) {
			try{
				final String entityName=getEntityName(entityClass);
				if (property == null)
					throw new RuntimeException(this.entityClass.getName()+ ":传入的属性不能为空");
				Query q = (Query) em
						.createQuery(
								"select o from "+entityName+" o where o."+property+"=?1")
						.setParameter(1, value);

				@SuppressWarnings("rawtypes")
				List list = q.getResultList();
				if (!list.isEmpty()) {
					return (T) list.get(0);

				} else {
					return null;
				}
					
			}catch (Exception e) {
				return null;
			}
			
			
		}
		
		/**
		 * 根据某属性查询集合
		 */
			@Transactional(propagation=Propagation.NOT_SUPPORTED)
			public List<T> findPropertyList( Object property,Object value) {
				try{
					final String entityName=getEntityName(entityClass);
					if (property == null)
						throw new RuntimeException(this.entityClass.getName()+ ":传入的属性不能为空");
					Query q = (Query) em
							.createQuery(
									"select o from "+entityName+" o where o."+property+"=?1")
							.setParameter(1, value);

					@SuppressWarnings("rawtypes")
					List list = q.getResultList();
					if (!list.isEmpty()) {
						return list;

					} else {
						return new ArrayList<T>();
					}
						
				}catch (Exception e) {
					return new ArrayList<T>();
				}
				
				
			}
	/**
	 * 获取实体
	 * @param <T>
	 * @param entityClass 实体类
	 * @param entityId 实体id
	 * @return
	 */
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public T find(Serializable entityId) {
		if (entityId == null)
			throw new RuntimeException(this.entityClass.getName()
					+ ":传入的实体id不能为空");
		return em.find(this.entityClass, entityId);
	}
	/**
	 * 保存实体
	 * @param entity 实体id
	 */
	public void save(T entity) {
		em.persist(entity);
	}
	
	/**
	 * 保存实体
	 * @param entity 实体id
	 */
	public T saveOrUpdate(T entity) {
		return em.merge(entity);
	}
	
	
	/**
	 * 保存实体
	 * @param 批量
	 */
	public void saveAll(Collection<?> entities) {
		for (@SuppressWarnings("rawtypes")  
        Iterator localIterator = entities.iterator(); localIterator.hasNext();) {  
            Object entity = localIterator.next();  
            em.persist(entity);  
        }  
	}
	
	
	/**
	 * 更新实体
	 * @param entity 实体id
	 */
	public void update(T entity) {
		em.merge(entity);
	}
	/**
	 * 删除
	 * @param entityids
	 */

	public void delete(Serializable... entityids) {
		for (Object id : entityids) {
			em.remove(em.getReference(this.entityClass, id));
		}
	}
	/**
	 * 获取记录总数
	 * @param entityClass 实体类
	 * @return
	 */
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public long getCount() {
		return (Long) em.createQuery(
				"select count(" + getCountField(this.entityClass) + ") from "
						+ getEntityName(this.entityClass) + " o")
				.getSingleResult();
	}
	/**
	 * 自定义HQL语句操作
	 * @param hql
	 */
	public void setHQL(String hql){
		this.em.createQuery(hql).executeUpdate();
	}
	/**
	 * 自定义SQL语句
	 * @param sql
	 */
	public void setSQL(String sql){
		this.em.createNativeQuery(sql).executeUpdate();
	}
	/**
	 * 获取记录总数
	 * @param entityClass 实体类
	 * @return
	 */
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public long getCountHQL(String hql) {
		return (Long) em.createQuery(hql)
				.getSingleResult();
	}
	
	/**
	 * 获取记录总数
	 * @param entityClass 实体类
	 * @return
	 */
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public long getCountHQL(String hql,Object[] queryParams) {
		Query query = em.createQuery(hql);
		setQueryParams(query, queryParams);
		return (Long)query.getSingleResult();
	}
	
	
	/**
	  * 查询所有 
	  * @param hql 自定义查询语句
	  * @return
	  */
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<T> findAllPage(String hql){
		Query query = em.createQuery(hql);
		return query.getResultList();
		
	}
	public List<?> findAllPage(final String hql,final int start,final int limit) throws SQLException{
		Query query = em.createQuery(hql);
		query.setMaxResults(limit);
		query.setFirstResult(start);
		return query.getResultList();
	}
	
	
	
	/**
	 * 获取所有数据
	 * @return
	 */
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<T> findLists(){
		 
		return  findPage(null,null,false).getResultlist();
	}
	
	
	/**
	 * 条件查询获取数据
	 * @param pv
	 * @param filters
	 * @return
	 */
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<T> findLists(PageView<T> pv,List<PropertyFilter> filters){
		 
		return  findPage(pv,filters,false).getResultlist();
	}
	
	/**
	 * 自定义条件查询获取数据
	 * @param pv
	 * @param hql
	 * @param queryParams
	 * @return
	 */
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<T> findLists(PageView<T> pv, String hql, Object[] queryParams){
		return findPage(pv, hql, queryParams,false).getResultlist();
	}
	
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
	
	
	@SuppressWarnings("rawtypes")
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	
	public QueryResult<T> findPage(PageView<T> pv,List<PropertyFilter> filters) {
		return  findPage(pv,filters,true);
	}
	
	
	
	

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

	
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public QueryResult<T> findPage(PageView<T> pv, String hql, Object[] queryParams) {
		 
		return findPage(pv, hql, queryParams, true);
	}
	
	
	
	 /**
     * 完全自定义HQL语句的条件查询(只有HQL语句)
     * @param hql 
     
     * @return
     */
	
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public  List<T> findByMyHqlList( String hql) {
		 
		 
		
		return findByMyHqlPage(null, hql,null,null).getResultlist();
	}
	
	
	
	  /**
     * 完全自定义HQL语句的条件查询(有条件)
     * @param pv
     * @param hql 
   
     * @param queryParams
     * @return
     */
	
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public  List<T> findByMyHqlList(PageView<T> pv, String hql) {
		 
		 
		
		return findByMyHqlPage(pv, hql,null,null).getResultlist();
	}
	  /**
     * 完全自定义HQL语句的条件查询(有条件)
     * @param pv
     * @param hql 
     * * @param chql 记录总数的语句
     * @param queryParams
     * @return
     */
	
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public  List<T> findByMyHqlList( String hql,Object[] queryParams) {
		 
		 
		
		return findByMyHqlPage(null,hql,null,queryParams).getResultlist();
	}
	
	
	  /**
     * 完全自定义HQL语句的条件查询(有条件)
     * @param pv
     * @param hql 
     * * @param chql 记录总数的语句
     * @param queryParams
     * @return
     */
	
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public  List<T> findByMyHqlList(PageView<T> pv, String hql,Object[] queryParams) {
		 
		 
		
		return findByMyHqlPage(pv, hql,null,queryParams).getResultlist();
	}
	
	
    /**
     * 完全自定义HQL语句的条件（包括分页与不分页）查询
     * @param pv
     * @param hql 
     * * @param chql 记录总数的语句
     * @param queryParams
     * @return
     */
	
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public  QueryResult<T> findByMyHqlPage(PageView<T> pv, String hql,String chql,Object[] queryParams) {
		QueryResult qr = new QueryResult<T>();

		Query query = em.createQuery(hql);
		if(queryParams!=null&&queryParams.length>0){
			setQueryParams(query, queryParams);
		}
		

		if(pv!=null&&!pv.isListTotal()) query.setFirstResult(pv.getFirstResult()).setMaxResults(pv.getMaxresult());
		qr.setResultlist(query.getResultList());
		    if(StringUtils.isNotEmpty(chql)){
		    	query = em.createQuery(chql);
				setQueryParams(query, queryParams);
				qr.setTotalrecord((Long)query.getSingleResult());	
		    }
			
	
		
		return qr;
	}
	
	public QueryResult<T> findHQLPage(PageView<T> pv, String hql, String chql){
		QueryResult qr = new QueryResult<T>();
		Query query = em.createQuery(hql);
		 
		if(pv!=null&&!pv.isListTotal()) query.setFirstResult(pv.getFirstResult()).setMaxResults(pv.getMaxresult());
		qr.setResultlist(query.getResultList());
		if(!pv.isListTotal()){
			query = em.createQuery(chql);
			qr.setTotalrecord((Long)query.getSingleResult());
		}
		return qr;
	}
	
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	private  QueryResult<T> findPage(PageView<T> pv, String hql, Object[] queryParams,Boolean isTotalrecord) {
		QueryResult qr = new QueryResult<T>();
		String entityname = getEntityName(this.entityClass);
		LinkedHashMap<String, String> orderby=null;
		if(pv!=null) orderby=pv.getOrderby();
		Query query = em.createQuery("select o from "+ entityname+ " o "+(hql==null || "".equals(hql.trim())? "": " where "+ hql)+ buildOrderby(orderby));
		setQueryParams(query, queryParams);

		if(pv!=null&&!pv.isListTotal()) query.setFirstResult(pv.getFirstResult()).setMaxResults(pv.getMaxresult());
		qr.setResultlist(query.getResultList());
		if(isTotalrecord){
			query = em.createQuery("select count("+ getCountField(this.entityClass)+ ") from "+ entityname+ " o "+(hql==null || "".equals(hql.trim())? "": " where "+ hql));
			setQueryParams(query, queryParams);
			qr.setTotalrecord((Long)query.getSingleResult());
		}
		
		return qr;
	}
	
	
	@SuppressWarnings("rawtypes")
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	private  QueryResult<T> findPage(PageView<T> pv,List<PropertyFilter> filters,Boolean isTotalrecord) {
		QueryResult qr = new QueryResult<T>();
		
		try{
			LinkedHashMap<String, String> orderby=null;
			if(pv!=null) orderby=pv.getOrderby();
			getPropertyFilter(filters);
			String entityname = getEntityName(this.entityClass);
			Query query = em
					.createQuery("select o from "
							+ entityname
							+ " o "
							+ (hql == null || "".equals(hql.trim()) ? ""
									: " where " + hql)
							+ buildOrderby(orderby));
			setQueryParams(query, queryParams);

			if (pv!=null&&!pv.isListTotal())
				query.setFirstResult(pv.getFirstResult()).setMaxResults(
						pv.getMaxresult());
			qr.setResultlist(query.getResultList());
			if(isTotalrecord){
				query = em.createQuery("select count("
						+ getCountField(this.entityClass)
						+ ") from "
						+ entityname
						+ " o "
						+ (hql == null || "".equals(hql.trim()) ? ""
								: " where " + hql));
				setQueryParams(query, queryParams);
				qr.setTotalrecord((Long) query.getSingleResult());
			}
		
			
		}catch (Exception e) {
			qr.setResultlist(new ArrayList<T>());
			qr.setTotalrecord(0);
		}
		return qr;
		
	}
	/**
	 * 通过SQL语句查询
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List findBySQL(final String sql) throws SQLException{
		Query query=this.em.createNativeQuery(sql);
 
		return query.getResultList();
		
		
		 
	}
	
	/**
	 * 分页自定义查询
	 * @param hql
	 * @param start
	 * @param limit
	 * @return
	 * @throws SQLException
	 */
	
	public List<?> quertListforPage(final String hql,final int start,final int limit) throws SQLException{
		
		Query query=this.em.createQuery(hql);
		query.setMaxResults(limit);
		query.setFirstResult(start);
		return query.getResultList();
		 
	}
 
	
	
	
	
	
	

	protected static void setQueryParams(Query query, Object[] queryParams) {
		if (queryParams != null && queryParams.length > 0) {
			for (int i = 0; i < queryParams.length; i++) {
				query.setParameter(i + 1, queryParams[i]);
			}
		}
	}

	/**
	 * 合并查询条件
	 * 
	 * @param filters
	 */

	private void getPropertyFilter(List<PropertyFilter> filters) {
		StringBuffer jpql = new StringBuffer("");
		List<Object> params = new ArrayList<Object>();
		if (filters!=null&&!filters.isEmpty()) {
                 boolean flag=true;
			for (PropertyFilter pf : filters) {
				if (params.size() > 0)
					if("isor".equals(pf.getMatchType().getName())){
						jpql.append(" or ");
						flag=false;
					}else{
						if(flag){
							jpql.append(" and ");
						}
						
					}
				if(!"isor".equals(pf.getMatchType().getName())){
					if ("like".equals(pf.getMatchType().getName())) {
						jpql.append(" o." + pf.getJpql() + " like ?").append(
								params.size() + 1);
						params.add("%" + pf.getParams() + "%");
						
					} else if("isnull".equals(pf.getMatchType().getName())) {
						jpql.append(" o." + pf.getJpql() + " is null");
					}else if("isnotnull".equals(pf.getMatchType().getName())) {
						jpql.append(" o." + pf.getJpql() + " is not null");
					}else if("isin".equals(pf.getMatchType().getName())) {
						if(pf.getParamses().length>0){
							StringBuffer sb = new StringBuffer();
							
							for(int i=1; i<=pf.getParamses().length; i++){
								sb.append('?').append((i+params.size())).append(',');
						
							}
							sb.deleteCharAt(sb.length()-1);
							jpql.append(" o." + pf.getJpql() + "  in("+ sb.toString()+ ")");
							for(int i=0; i<pf.getParamses().length; i++){
								
								params.add(pf.getParamses()[i]);
							}
						}
						
					}else if("between".equals(pf.getMatchType().getName())) {
						jpql.append(" o." + pf.getJpql() + " between '"+pf.getParamses()[0]+"' and '"+pf.getParamses()[1]+"'" );
						
					}else{
						jpql.append(
								" o." + pf.getJpql() + pf.getMatchType().getName()
										+ "?").append(params.size() + 1);
						params.add(pf.getParams());
					}
					flag=true;
				}
				

			}
			hql = jpql.toString();
		//System.out.println("wherjpql:"+wherejpql);
			queryParams = params.toArray();
		}else{
			hql = null;
			queryParams =null;
		}
	}

	/**
	 * 组装order by语句
	 * 
	 * @param orderby
	 * @return
	 */
	protected static String buildOrderby(LinkedHashMap<String, String> orderby) {
		StringBuffer orderbyql = new StringBuffer("");
		if (orderby != null && orderby.size() > 0) {
			orderbyql.append(" order by ");
			for (String key : orderby.keySet()) {
				orderbyql.append("o.").append(key).append(" ")
						.append(orderby.get(key)).append(",");
			}
			orderbyql.deleteCharAt(orderbyql.length() - 1);
		}
		
		return orderbyql.toString();
	}

	/**
	 * 获取实体的名称
	 * 
	 * @param <E>
	 * @param clazz
	 *            实体类
	 * @return
	 */
	protected static <E> String getEntityName(Class<E> clazz) {
		String entityname = clazz.getSimpleName();
		Entity entity = clazz.getAnnotation(Entity.class);
		if (entity.name() != null && !"".equals(entity.name())) {
			entityname = entity.name();
		}
		return entityname;
	}

	/**
	 * 获取统计属性
	 * @param <E>
	 * @param clazz
	 * @return
	 */
	protected static <E> String getCountField(Class<E> clazz) {
		String out = "o";
		try {
			PropertyDescriptor[] propertyDescriptors = Introspector
					.getBeanInfo(clazz).getPropertyDescriptors();
			for (PropertyDescriptor propertydesc : propertyDescriptors) {
				Method method = propertydesc.getReadMethod();
				if (method != null
						&& method.isAnnotationPresent(EmbeddedId.class)) {
					PropertyDescriptor[] ps = Introspector.getBeanInfo(
							propertydesc.getPropertyType())
							.getPropertyDescriptors();
					out = "o."
							+ propertydesc.getName()
							+ "."
							+ (!ps[1].getName().equals("class") ? ps[1]
									.getName() : ps[0].getName());
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return out;
	}

	
	 
}
;