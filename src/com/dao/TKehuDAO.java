package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TKehu;

/**
 * Data access object (DAO) for domain model class TKehu.
 * 
 * @see com.model.TKehu
 * @author MyEclipse Persistence Tools
 */

public class TKehuDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TKehuDAO.class);

	// property constants
	public static final String MINGCHENG = "mingcheng";

	public static final String DIZHI = "dizhi";

	public static final String LIANXIREN = "lianxiren";

	public static final String DIANHUA = "dianhua";

	public static final String YOUBIAN = "youbian";

	public static final String CHUANZHEN = "chuanzhen";

	public static final String YOUXIANG = "youxiang";

	public static final String KAHUHANG = "kahuhang";

	public static final String ZHANGHAO = "zhanghao";

	public static final String TYPE = "type";

	public static final String DEL = "del";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TKehu transientInstance)
	{
		log.debug("saving TKehu instance");
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

	public void delete(TKehu persistentInstance)
	{
		log.debug("deleting TKehu instance");
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

	public TKehu findById(java.lang.Integer id)
	{
		log.debug("getting TKehu instance with id: " + id);
		try
		{
			TKehu instance = (TKehu) getHibernateTemplate().get(
					"com.model.TKehu", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TKehu instance)
	{
		log.debug("finding TKehu instance by example");
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
		log.debug("finding TKehu instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TKehu as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMingcheng(Object mingcheng)
	{
		return findByProperty(MINGCHENG, mingcheng);
	}

	public List findByDizhi(Object dizhi)
	{
		return findByProperty(DIZHI, dizhi);
	}

	public List findByLianxiren(Object lianxiren)
	{
		return findByProperty(LIANXIREN, lianxiren);
	}

	public List findByDianhua(Object dianhua)
	{
		return findByProperty(DIANHUA, dianhua);
	}

	public List findByYoubian(Object youbian)
	{
		return findByProperty(YOUBIAN, youbian);
	}

	public List findByChuanzhen(Object chuanzhen)
	{
		return findByProperty(CHUANZHEN, chuanzhen);
	}

	public List findByYouxiang(Object youxiang)
	{
		return findByProperty(YOUXIANG, youxiang);
	}

	public List findByKahuhang(Object kahuhang)
	{
		return findByProperty(KAHUHANG, kahuhang);
	}

	public List findByZhanghao(Object zhanghao)
	{
		return findByProperty(ZHANGHAO, zhanghao);
	}

	public List findByType(Object type)
	{
		return findByProperty(TYPE, type);
	}

	public List findByDel(Object del)
	{
		return findByProperty(DEL, del);
	}

	public List findAll()
	{
		log.debug("finding all TKehu instances");
		try
		{
			String queryString = "from TKehu";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TKehu merge(TKehu detachedInstance)
	{
		log.debug("merging TKehu instance");
		try
		{
			TKehu result = (TKehu) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TKehu instance)
	{
		log.debug("attaching dirty TKehu instance");
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

	public void attachClean(TKehu instance)
	{
		log.debug("attaching clean TKehu instance");
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

	public static TKehuDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TKehuDAO) ctx.getBean("TKehuDAO");
	}
}