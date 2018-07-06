package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TGoods;

/**
 * Data access object (DAO) for domain model class TGoods.
 * 
 * @see com.model.TGoods
 * @author MyEclipse Persistence Tools
 */

public class TGoodsDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TGoodsDAO.class);

	// property constants
	public static final String CATELOG_ID = "catelogId";

	public static final String NAME = "name";

	public static final String CHANDI = "chandi";

	public static final String DANWEI = "danwei";

	public static final String GUIGE = "guige";

	public static final String BEIZHU = "beizhu";

	public static final String DEL = "del";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TGoods transientInstance)
	{
		log.debug("saving TGoods instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TGoods persistentInstance)
	{
		log.debug("deleting TGoods instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public TGoods findById(java.lang.Integer id)
	{
		log.debug("getting TGoods instance with id: " + id);
		try
		{
			TGoods instance = (TGoods) getHibernateTemplate().get(
					"com.model.TGoods", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TGoods instance)
	{
		log.debug("finding TGoods instance by example");
		try
		{
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding TGoods instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TGoods as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCatelogId(Object catelogId)
	{
		return findByProperty(CATELOG_ID, catelogId);
	}

	public List findByName(Object name)
	{
		return findByProperty(NAME, name);
	}

	public List findByChandi(Object chandi)
	{
		return findByProperty(CHANDI, chandi);
	}

	public List findByDanwei(Object danwei)
	{
		return findByProperty(DANWEI, danwei);
	}

	public List findByGuige(Object guige)
	{
		return findByProperty(GUIGE, guige);
	}

	public List findByBeizhu(Object beizhu)
	{
		return findByProperty(BEIZHU, beizhu);
	}

	public List findByDel(Object del)
	{
		return findByProperty(DEL, del);
	}

	public List findAll()
	{
		log.debug("finding all TGoods instances");
		try
		{
			String queryString = "from TGoods";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TGoods merge(TGoods detachedInstance)
	{
		log.debug("merging TGoods instance");
		try
		{
			TGoods result = (TGoods) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TGoods instance)
	{
		log.debug("attaching dirty TGoods instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TGoods instance)
	{
		log.debug("attaching clean TGoods instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TGoodsDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TGoodsDAO) ctx.getBean("TGoodsDAO");
	}
}