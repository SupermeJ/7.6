package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TKucun;

/**
 * Data access object (DAO) for domain model class TKucun.
 * 
 * @see com.model.TKucun
 * @author MyEclipse Persistence Tools
 */

public class TKucunDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TKucunDAO.class);

	// property constants
	public static final String GOODS_ID = "goodsId";

	public static final String SHULIANG = "shuliang";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TKucun transientInstance)
	{
		log.debug("saving TKucun instance");
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

	public void delete(TKucun persistentInstance)
	{
		log.debug("deleting TKucun instance");
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

	public TKucun findById(java.lang.Integer id)
	{
		log.debug("getting TKucun instance with id: " + id);
		try
		{
			TKucun instance = (TKucun) getHibernateTemplate().get(
					"com.model.TKucun", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TKucun instance)
	{
		log.debug("finding TKucun instance by example");
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
		log.debug("finding TKucun instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TKucun as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByGoodsId(Object goodsId)
	{
		return findByProperty(GOODS_ID, goodsId);
	}

	public List findByShuliang(Object shuliang)
	{
		return findByProperty(SHULIANG, shuliang);
	}

	public List findAll()
	{
		log.debug("finding all TKucun instances");
		try
		{
			String queryString = "from TKucun";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TKucun merge(TKucun detachedInstance)
	{
		log.debug("merging TKucun instance");
		try
		{
			TKucun result = (TKucun) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TKucun instance)
	{
		log.debug("attaching dirty TKucun instance");
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

	public void attachClean(TKucun instance)
	{
		log.debug("attaching clean TKucun instance");
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

	public static TKucunDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TKucunDAO) ctx.getBean("TKucunDAO");
	}
}