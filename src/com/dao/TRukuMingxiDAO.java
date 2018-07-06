package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TRukuMingxi;

/**
 * Data access object (DAO) for domain model class TRukuMingxi.
 * 
 * @see com.model.TRukuMingxi
 * @author MyEclipse Persistence Tools
 */

public class TRukuMingxiDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TRukuMingxiDAO.class);

	// property constants
	public static final String RUKU_ID = "rukuId";

	public static final String GOODS_ID = "goodsId";

	public static final String SHULIANG = "shuliang";

	public static final String BEIZHU = "beizhu";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TRukuMingxi transientInstance)
	{
		log.debug("saving TRukuMingxi instance");
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

	public void delete(TRukuMingxi persistentInstance)
	{
		log.debug("deleting TRukuMingxi instance");
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

	public TRukuMingxi findById(java.lang.Integer id)
	{
		log.debug("getting TRukuMingxi instance with id: " + id);
		try
		{
			TRukuMingxi instance = (TRukuMingxi) getHibernateTemplate().get(
					"com.model.TRukuMingxi", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TRukuMingxi instance)
	{
		log.debug("finding TRukuMingxi instance by example");
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
		log.debug("finding TRukuMingxi instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TRukuMingxi as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByRukuId(Object rukuId)
	{
		return findByProperty(RUKU_ID, rukuId);
	}

	public List findByGoodsId(Object goodsId)
	{
		return findByProperty(GOODS_ID, goodsId);
	}

	public List findByShuliang(Object shuliang)
	{
		return findByProperty(SHULIANG, shuliang);
	}

	public List findByBeizhu(Object beizhu)
	{
		return findByProperty(BEIZHU, beizhu);
	}

	public List findAll()
	{
		log.debug("finding all TRukuMingxi instances");
		try
		{
			String queryString = "from TRukuMingxi";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TRukuMingxi merge(TRukuMingxi detachedInstance)
	{
		log.debug("merging TRukuMingxi instance");
		try
		{
			TRukuMingxi result = (TRukuMingxi) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TRukuMingxi instance)
	{
		log.debug("attaching dirty TRukuMingxi instance");
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

	public void attachClean(TRukuMingxi instance)
	{
		log.debug("attaching clean TRukuMingxi instance");
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

	public static TRukuMingxiDAO getFromApplicationContext(
			ApplicationContext ctx)
	{
		return (TRukuMingxiDAO) ctx.getBean("TRukuMingxiDAO");
	}
}