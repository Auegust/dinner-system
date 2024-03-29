package com.yummy.dao.impl;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yummy.dao.ICustomerDAO;
import com.yummy.pojo.Customer;

/**
 * A data access object (DAO) providing persistence and search support for
 * Customer entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.yummy.pojo.Customer
 * @author MyEclipse Persistence Tools
 */

public class CustomerDAO extends HibernateDaoSupport implements ICustomerDAO{
	private static final Logger log = LoggerFactory
			.getLogger(CustomerDAO.class);
	// property constants
	public static final String PASSWORD = "password";
	public static final String EMAIL = "email";
	public static final String GENDER = "gender";
	public static final String CREDITS = "credits";
	public static final String REGISTER_DATE = "registerDate";

	protected void initDao() {
		// do nothing
	}

	/** 
	 * TODO 简单描述该方法的实现功能（可选）. 
	 * @see com.yummy.pojo.ICustomerDAO#save(com.yummy.pojo.Customer) 
	 */ 
	public void save(Customer transientInstance) {
		log.debug("saving Customer instance");
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
	 * @see com.yummy.pojo.ICustomerDAO#delete(com.yummy.pojo.Customer) 
	 */ 
	public void delete(Customer persistentInstance) {
		log.debug("deleting Customer instance");
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
	 * @see com.yummy.pojo.ICustomerDAO#findById(java.lang.String) 
	 */ 
	public Customer findById(java.lang.String id) {
		log.debug("getting Customer instance with id: " + id);
		try {
			Customer instance = (Customer) getHibernateTemplate().get(
					"com.yummy.pojo.Customer", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public Customer findByUsername(java.lang.String username) {
		log.debug("getting Customer instance with username: " + username);
		try {
			Customer instance = (Customer) getHibernateTemplate().get(
					"com.yummy.pojo.Customer", username);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	

	/** 
	 * TODO 简单描述该方法的实现功能（可选）. 
	 * @see com.yummy.pojo.ICustomerDAO#findByExample(com.yummy.pojo.Customer) 
	 */ 
	public List findByExample(Customer instance) {
		log.debug("finding Customer instance by example");
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

	/** 
	 * TODO 简单描述该方法的实现功能（可选）. 
	 * @see com.yummy.pojo.ICustomerDAO#findByProperty(java.lang.String, java.lang.Object) 
	 */ 
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Customer instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Customer as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/** 
	 * TODO 简单描述该方法的实现功能（可选）. 
	 * @see com.yummy.pojo.ICustomerDAO#findByPassword(java.lang.Object) 
	 */ 
	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	/** 
	 * TODO 简单描述该方法的实现功能（可选）. 
	 * @see com.yummy.pojo.ICustomerDAO#findByEmail(java.lang.Object) 
	 */ 
	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	/** 
	 * TODO 简单描述该方法的实现功能（可选）. 
	 * @see com.yummy.pojo.ICustomerDAO#findByGender(java.lang.Object) 
	 */ 
	public List findByGender(Object gender) {
		return findByProperty(GENDER, gender);
	}

	/** 
	 * TODO 简单描述该方法的实现功能（可选）. 
	 * @see com.yummy.pojo.ICustomerDAO#findByCredits(java.lang.Object) 
	 */ 
	public List findByCredits(Object credits) {
		return findByProperty(CREDITS, credits);
	}

	/** 
	 * TODO 简单描述该方法的实现功能（可选）. 
	 * @see com.yummy.pojo.ICustomerDAO#findByRegisterDate(java.lang.Object) 
	 */ 
	public List findByRegisterDate(Object registerDate) {
		return findByProperty(REGISTER_DATE, registerDate);
	}

	/** 
	 * TODO 简单描述该方法的实现功能（可选）. 
	 * @see com.yummy.pojo.ICustomerDAO#findAll() 
	 */ 
	public List findAll() {
		log.debug("finding all Customer instances");
		try {
			String queryString = "from Customer";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/** 
	 * TODO 简单描述该方法的实现功能（可选）. 
	 * @see com.yummy.pojo.ICustomerDAO#merge(com.yummy.pojo.Customer) 
	 */ 
	public Customer merge(Customer detachedInstance) {
		log.debug("merging Customer instance");
		try {
			Customer result = (Customer) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Customer instance) {
		log.debug("attaching dirty Customer instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Customer instance) {
		log.debug("attaching clean Customer instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public List query(String sql) {
		return getHibernateTemplate().find(sql);
	}

	public Customer findByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	public List findByName(String username, String password2) {
		// TODO Auto-generated method stub
		String sql = "select username, password from `customer` where username = ? and password = ?";
		try {
			SQLQuery query = getSession().createSQLQuery(sql);
			query.setParameter(0, username);
			query.setParameter(1, password2);
			return query.list();
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}