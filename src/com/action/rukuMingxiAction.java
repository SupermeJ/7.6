package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TGoodsDAO;
import com.dao.TKucunDAO;
import com.dao.TRukuMingxiDAO;
import com.model.TKucun;
import com.model.TRukuMingxi;
import com.opensymphony.xwork2.ActionSupport;

public class rukuMingxiAction extends ActionSupport
{
	private int id;
	private int ruku_id;
	private int goods_id;
	private int shuliang;
	private String beizhu;
	
	private String message;
	private String path;
	private TRukuMingxiDAO rukuMingxiDAO;
	private TGoodsDAO goodsDAO;
    private TKucunDAO kucunDAO;
	
		
	
	public String rukuMingxiAdd()
	{
		TRukuMingxi rukuMingxi=new TRukuMingxi();
		rukuMingxi.setRuku_id(ruku_id);
		rukuMingxi.setGoods_id(goods_id);
		rukuMingxi.setShuliang(shuliang);
		rukuMingxi.setBeizhu(beizhu);
		rukuMingxiDAO.save(rukuMingxi);
		
		kucun_jia(goods_id, shuliang);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "操作成功");
		return "msg";
	}
	
	
	
	public String rukuMingxiMana()
	{
		String sql = "from TRukuMingxi where ruku_id="+ruku_id;
		List rukuMingxiList=rukuMingxiDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<rukuMingxiList.size();i++)
		{
			TRukuMingxi rukuMingxi=(TRukuMingxi)rukuMingxiList.get(i);
			rukuMingxi.setGoods_name(goodsDAO.findById(rukuMingxi.getGoods_id()).getName());
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("rukuMingxiList", rukuMingxiList);
		return ActionSupport.SUCCESS;
	}
	
	public String rukuMingxiDel()
	{
		String sql = "delete from TRukuMingxi where id=?";
		Object[] o={id};
		rukuMingxiDAO.getHibernateTemplate().bulkUpdate(sql, o);

		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "操作成功");
		return "msg";
	}


	
	
	public void kucun_jia(int goods_id,int shuliang1)
	{
		String sql="from TKucun where goods_id="+goods_id;
		List list=kucunDAO.getHibernateTemplate().find(sql);
		if(list.size()==0)
		{
			 TKucun kucun=new TKucun();
			 kucun.setGoods_id(goods_id);
			 kucun.setShuliang(shuliang1);
			 kucunDAO.save(kucun);
		}
		else
		{
			sql="update TKucun set shuliang=shuliang+? where goods_id="+goods_id;
			Object[] o={shuliang1};
			kucunDAO.getHibernateTemplate().bulkUpdate(sql,o);
		}
	}

	public String getBeizhu()
	{
		return beizhu;
	}



	public TKucunDAO getKucunDAO()
	{
		return kucunDAO;
	}



	public void setKucunDAO(TKucunDAO kucunDAO)
	{
		this.kucunDAO = kucunDAO;
	}



	public void setBeizhu(String beizhu)
	{
		this.beizhu = beizhu;
	}





	public TGoodsDAO getGoodsDAO()
	{
		return goodsDAO;
	}



	public void setGoodsDAO(TGoodsDAO goodsDAO)
	{
		this.goodsDAO = goodsDAO;
	}



	public int getGoods_id()
	{
		return goods_id;
	}



	public void setGoods_id(int goods_id)
	{
		this.goods_id = goods_id;
	}



	public int getId()
	{
		return id;
	}



	public void setId(int id)
	{
		this.id = id;
	}



	public String getMessage()
	{
		return message;
	}



	public void setMessage(String message)
	{
		this.message = message;
	}



	public String getPath()
	{
		return path;
	}



	public void setPath(String path)
	{
		this.path = path;
	}



	public int getRuku_id()
	{
		return ruku_id;
	}



	public void setRuku_id(int ruku_id)
	{
		this.ruku_id = ruku_id;
	}



	public TRukuMingxiDAO getRukuMingxiDAO()
	{
		return rukuMingxiDAO;
	}



	public void setRukuMingxiDAO(TRukuMingxiDAO rukuMingxiDAO)
	{
		this.rukuMingxiDAO = rukuMingxiDAO;
	}



	public int getShuliang()
	{
		return shuliang;
	}



	public void setShuliang(int shuliang)
	{
		this.shuliang = shuliang;
	}
	
}
