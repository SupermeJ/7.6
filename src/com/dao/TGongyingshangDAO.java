package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TGongyingshang;

/**
 * Data access object (DAO) for domain model class TGongyingshang.
 * 
 * @see com.model.TGongyingshang
 * @author MyEclipse Persistence Tools
 */

public class TGongyingshangDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TGongyingshangDAO.class);

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

	public void save(TGongyingshang transientInstance)
	{
		log.debug("saving TGongyingshang instance");
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

	public void delete(TGongyingshang persistentInstance)
	{
		log.debug("deleting TGongyingshang instance");
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

	public TGongyingshang findById(java.lang.Integer id)
	{
		log.debug("getting TGongyingshang instance with id: " + id);
		try
		{
			TGongyingshang instance = (TGongyingshang) getHibernateTemplate()
					.get("com.model.TGongyingshang", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TGongyingshang instance)
	{
		log.debug("finding TGongyingshang instance by example");
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
		log.debug("finding TGongyingshang instance with property: "
				+ propertyName + ", value: " + value);
		try
		{
			String queryString = "from TGongyingshang as model where model."
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
		log.debug("finding all TGongyingshang instances");
		try
		{
			String queryString = "from TGongyingshang";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TGongyingshang merge(TGongyingshang detachedInstance)
	{
		log.debug("merging TGongyingshang instance");
		try
		{
			TGongyingshang result = (TGongyingshang) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TGongyingshang instance)
	{
		log.debug("attaching dirty TGongyingshang instance");
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

	public void attachClean(TGongyingshang instance)
	{
		log.debug("attaching clean TGongyingshang instance");
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

	public static TGongyingshangDAO getFromApplicationContext(
			ApplicationContext ctx)
	{
		return (TGongyingshangDAO) ctx.getBean("TGongyingshangDAO");
	}
}