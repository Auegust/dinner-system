package com.yummy.dao.impl;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yummy.dao.IShopDAO;
import com.yummy.pojo.Shop;

/**
 * A data access object (DAO) providing persistence and search support for Shop
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.yummy.pojo.Shop
 * @author MyEclipse Persistence Tools
 */

public class ShopDAO extends HibernateDaoSupport implements IShopDAO {
	private static final Logger log = LoggerFactory.getLogger(ShopDAO.class);
	// property constants
	public static final String ADDRESS = "address";
	public static final String TELEPHONE = "telephone";
	public static final String QQ = "qq";
	public static final String INTRODUCTION = "introduction";
	public static final String LOGO = "logo";
	public static final String POINT = "point";
	public static final String DELIVERY_RANGE = "deliveryRange";

	protected void initDao() {
		// do nothing
	}

	/** 
	 * TODO 简单描述该方法的实现功能（可选）. 
	 * @see com.yummy.dao.IShopDAO#save(com.yummy.pojo.Shop) 
	 */ 
	public void save(Shop transientInstance) {
		log.debug("saving Shop instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/** 
	 * TODO 简单描述该方法的实现功能（可选）. 
	 * @see com.yummy.dao.IShopDAO#delete(com.yummy.pojo.Shop) 
	 */ 
	public void delete(Shop persistentInstance) {
		log.debug("deleting Shop instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/** 
	 * TODO 简单描述该方法的实现功能（可选）. 
	 * @see com.yummy.dao.IShopDAO#findById(java.lang.String) 
	 */ 
	public Shop findById(java.lang.String id) {
		log.debug("getting Shop instance with id: " + id);
		try {
			Shop instance = (Shop) getHibernateTemplate().get(
					"com.yummy.pojo.Shop", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public Shop findByShopName(java.lang.String shopname) {
		log.debug("getting Shop instance with id: " + shopname);
		try {
			Shop instance = (Shop) getHibernateTemplate().get(
					"com.yummy.pojo.Shop", shopname);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List findByExample(Shop instance) {
		log.debug("finding Shop instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Shop instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Shop as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findByTelephone(Object telephone) {
		return findByProperty(TELEPHONE, telephone);
	}

	public List findByQq(Object qq) {
		return findByProperty(QQ, qq);
	}

	public List findByIntroduction(Object introduction) {
		return findByProperty(INTRODUCTION, introduction);
	}

	public List findByLogo(Object logo) {
		return findByProperty(LOGO, logo);
	}

	public List findByPoint(Object point) {
		return findByProperty(POINT, point);
	}

	public List findByDeliveryRange(Object deliveryRange) {
		return findByProperty(DELIVERY_RANGE, deliveryRange);
	}

	/** 
	 * TODO 简单描述该方法的实现功能（可选）. 
	 * @see com.yummy.dao.IShopDAO#findAll() 
	 */ 
	public List findAll() {
		log.debug("finding all Shop instances");
		try {
			String queryString = "from Shop";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Shop merge(Shop detachedInstance) {
		log.debug("merging Shop instance");
		try {
			Shop result = (Shop) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Shop instance) {
		log.debug("attaching dirty Shop instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Shop instance) {
		log.debug("attaching clean Shop instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IShopDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IShopDAO) ctx.getBean("ShopDAO");
	}

	public void update(Shop shop) {
		// TODO Auto-generated method stub
		
	}
}