package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TChukuMingxiDAO;
import com.dao.TGoodsDAO;
import com.dao.TKucunDAO;
import com.dao.TRukuMingxiDAO;
import com.model.TChukuMingxi;
import com.model.TKucun;
import com.model.TRukuMingxi;
import com.opensymphony.xwork2.ActionSupport;

public class chukuMingxiAction extends ActionSupport
{
	private int id;
	private int chuku_id;
	private int goods_id;
	private int shuliang;
	private String beizhu;
	
	private String message;
	private String path;
	private TChukuMingxiDAO chukuMingxiDAO;
	private TGoodsDAO goodsDAO;
	private TKucunDAO kucunDAO;
	
		
	
	public String chukuMingxiAdd()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		if(kucun_panduan(goods_id, shuliang).endsWith("kucunbuzu"))
		{
			request.put("msg", "库存不足");
		}
		
		if(kucun_panduan(goods_id, shuliang).endsWith("kucunzu"))
		{
			TChukuMingxi chukuMingxi=new TChukuMingxi();
			chukuMingxi.setChuku_id(chuku_id);
			chukuMingxi.setGoods_id(goods_id);
			chukuMingxi.setShuliang(shuliang);
			chukuMingxi.setBeizhu(beizhu);
			chukuMingxiDAO.save(chukuMingxi);
			
			kucun_jian(goods_id, shuliang);
			
			request.put("msg", "操作成功");
			
			
		}
		return "msg";
	}
	
	
	
	public String chukuMingxiMana()
	{
		String sql = "from TChukuMingxi where chuku_id="+chuku_id;
		List chukuMingxiList=chukuMingxiDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<chukuMingxiList.size();i++)
		{
			TChukuMingxi chukuMingxi=(TChukuMingxi)chukuMingxiList.get(i);
			chukuMingxi.setGoods_name(goodsDAO.findById(chukuMingxi.getGoods_id()).getName());
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("chukuMingxiList", chukuMingxiList);
		return ActionSupport.SUCCESS;
	}
	
	public String chukuMingxiDel()
	{
		String sql = "delete from TChukuMingxi where id=?";
		Object[] o={id};
		chukuMingxiDAO.getHibernateTemplate().bulkUpdate(sql, o);

		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "操作成功");
		return "msg";
	}
	
	public String kucunMana()
	{
		String sql="from TKucun";
		List kucunList=kucunDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<kucunList.size();i++)
		{
			 TKucun kucun=(TKucun)kucunList.get(i);
			 kucun.setGoods_name(goodsDAO.findById(kucun.getGoods_id()).getName());
		}
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("kucunList", kucunList);
		return ActionSupport.SUCCESS;
	}

	public String kucun_panduan(int goods_id,int shuliang1)
	{
		String s="";
		
		String sql="from TKucun where goods_id="+goods_id;
		List list=kucunDAO.getHibernateTemplate().find(sql);
		if(list.size()==0)
		{
			 s="kucunbuzu";
		}
		if(list.size()>0)
		{
			TKucun kucun=(TKucun)list.get(0);
			if(kucun.getShuliang()<shuliang1)
			{
				s="kucunbuzu";
			}
			else
			{
				s="kucunzu";
			}
		}
		
				
		return s;
	}
	
	
	public void kucun_jian(int goods_id,int shuliang1)
	{
		
			String sql="update TKucun set shuliang=shuliang-? where goods_id="+goods_id;
			Object[] o={shuliang1};
			kucunDAO.getHibernateTemplate().bulkUpdate(sql,o);
		
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



	public int getChuku_id()
	{
		return chuku_id;
	}



	public void setChuku_id(int chuku_id)
	{
		this.chuku_id = chuku_id;
	}



	public TChukuMingxiDAO getChukuMingxiDAO()
	{
		return chukuMingxiDAO;
	}



	public void setChukuMingxiDAO(TChukuMingxiDAO chukuMingxiDAO)
	{
		this.chukuMingxiDAO = chukuMingxiDAO;
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



	public int getchuku_id()
	{
		return chuku_id;
	}



	public void setchuku_id(int chuku_id)
	{
		this.chuku_id = chuku_id;
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
