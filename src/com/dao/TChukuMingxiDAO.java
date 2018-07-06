package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TChukuMingxi;

/**
 * Data access object (DAO) for domain model class TChukuMingxi.
 * 
 * @see com.model.TChukuMingxi
 * @author MyEclipse Persistence Tools
 */

public class TChukuMingxiDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TChukuMingxiDAO.class);

	// property constants
	public static final String CHUKU_ID = "chukuId";

	public static final String GOODS_ID = "goodsId";

	public static final String SHULIANG = "shuliang";

	public static final String BEIZHU = "beizhu";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TChukuMingxi transientInstance)
	{
		log.debug("saving TChukuMingxi instance");
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

	public void delete(TChukuMingxi persistentInstance)
	{
		log.debug("deleting TChukuMingxi instance");
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

	public TChukuMingxi findById(java.lang.Integer id)
	{
		log.debug("getting TChukuMingxi instance with id: " + id);
		try
		{
			TChukuMingxi instance = (TChukuMingxi) getHibernateTemplate().get(
					"com.model.TChukuMingxi", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TChukuMingxi instance)
	{
		log.debug("finding TChukuMingxi instance by example");
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
		log.debug("finding TChukuMingxi instance with property: "
				+ propertyName + ", value: " + value);
		try
		{
			String queryString = "from TChukuMingxi as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByChukuId(Object chukuId)
	{
		return findByProperty(CHUKU_ID, chukuId);
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
		log.debug("finding all TChukuMingxi instances");
		try
		{
			String queryString = "from TChukuMingxi";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TChukuMingxi merge(TChukuMingxi detachedInstance)
	{
		log.debug("merging TChukuMingxi instance");
		try
		{
			TChukuMingxi result = (TChukuMingxi) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TChukuMingxi instance)
	{
		log.debug("attaching dirty TChukuMingxi instance");
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

	public void attachClean(TChukuMingxi instance)
	{
		log.debug("attaching clean TChukuMingxi instance");
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

	public static TChukuMingxiDAO getFromApplicationContext(
			ApplicationContext ctx)
	{
		return (TChukuMingxiDAO) ctx.getBean("TChukuMingxiDAO");
	}
}