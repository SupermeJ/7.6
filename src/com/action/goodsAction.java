package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TAdminDAO;
import com.dao.TCatelogDAO;
import com.dao.TGoodsDAO;
import com.dao.TYuangongDAO;
import com.model.TAdmin;
import com.model.TCatelog;
import com.model.TGoods;
import com.model.TYuangong;
import com.opensymphony.xwork2.ActionSupport;

public class goodsAction extends ActionSupport
{
	private int id;
	private int catelog_id;
	private String name;
	private String chandi;
	
	private String danwei;
	private String guige;
	private String beizhu;
	 
	private String message;
	private String path;
	
	private TGoodsDAO goodsDAO;

	
	public String goodsAdd()
	{
		TGoods goods=new TGoods();
		
		goods.setCatelog_id(catelog_id);
		goods.setName(name);
		goods.setChandi(chandi);
		goods.setDanwei(danwei);
		goods.setGuige(guige);
		goods.setBeizhu(beizhu);
		goods.setDel("no");
		
		goodsDAO.save(goods);
		this.setMessage("操作成功");
		this.setPath("goodsMana.action");
		return "succeed";
	}
	
	
	
	public String goodsMana()
	{
		String sql = "from TGoods where del='no' order by catelog_id";
		List goodsList=goodsDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("goodsList", goodsList);
		return ActionSupport.SUCCESS;
	}
	
	public String goodsDel()
	{
		String sql = "update TGoods set del='yes' where id=?";
		Object[] o={id};
		goodsDAO.getHibernateTemplate().bulkUpdate(sql, o);
		this.setMessage("删除成功");
		this.setPath("goodsMana.action");
		return "succeed";
	}



	public String getBeizhu()
	{
		return beizhu;
	}



	public void setBeizhu(String beizhu)
	{
		this.beizhu = beizhu;
	}



	public int getCatelog_id()
	{
		return catelog_id;
	}



	public void setCatelog_id(int catelog_id)
	{
		this.catelog_id = catelog_id;
	}


	public TGoodsDAO getGoodsDAO()
	{
		return goodsDAO;
	}



	public void setGoodsDAO(TGoodsDAO goodsDAO)
	{
		this.goodsDAO = goodsDAO;
	}



	public String getChandi()
	{
		return chandi;
	}



	public void setChandi(String chandi)
	{
		this.chandi = chandi;
	}



	public String getDanwei()
	{
		return danwei;
	}



	public void setDanwei(String danwei)
	{
		this.danwei = danwei;
	}



	public String getGuige()
	{
		return guige;
	}



	public void setGuige(String guige)
	{
		this.guige = guige;
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



	public String getName()
	{
		return name;
	}



	public void setName(String name)
	{
		this.name = name;
	}



	public String getPath()
	{
		return path;
	}



	public void setPath(String path)
	{
		this.path = path;
	}



	
	
}
