package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TChuku;

/**
 * Data access object (DAO) for domain model class TChuku.
 * 
 * @see com.model.TChuku
 * @author MyEclipse Persistence Tools
 */

public class TChukuDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TChukuDAO.class);

	// property constants
	public static final String DANJUHAO = "danjuhao";

	public static final String SHIJIAN = "shijian";

	public static final String ZONGJIAGE = "zongjiage";

	public static final String JINGSHOUREN = "jingshouren";

	public static final String BEIZHU = "beizhu";

	public static final String DEL = "del";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TChuku transientInstance)
	{
		log.debug("saving TChuku instance");
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

	public void delete(TChuku persistentInstance)
	{
		log.debug("deleting TChuku instance");
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

	public TChuku findById(java.lang.Integer id)
	{
		log.debug("getting TChuku instance with id: " + id);
		try
		{
			TChuku instance = (TChuku) getHibernateTemplate().get(
					"com.model.TChuku", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TChuku instance)
	{
		log.debug("finding TChuku instance by example");
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
		log.debug("finding TChuku instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TChuku as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDanjuhao(Object danjuhao)
	{
		return findByProperty(DANJUHAO, danjuhao);
	}

	public List findByShijian(Object shijian)
	{
		return findByProperty(SHIJIAN, shijian);
	}

	public List findByZongjiage(Object zongjiage)
	{
		return findByProperty(ZONGJIAGE, zongjiage);
	}

	public List findByJingshouren(Object jingshouren)
	{
		return findByProperty(JINGSHOUREN, jingshouren);
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
		log.debug("finding all TChuku instances");
		try
		{
			String queryString = "from TChuku";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TChuku merge(TChuku detachedInstance)
	{
		log.debug("merging TChuku instance");
		try
		{
			TChuku result = (TChuku) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TChuku instance)
	{
		log.debug("attaching dirty TChuku instance");
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

	public void attachClean(TChuku instance)
	{
		log.debug("attaching clean TChuku instance");
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

	public static TChukuDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TChukuDAO) ctx.getBean("TChukuDAO");
	}
}