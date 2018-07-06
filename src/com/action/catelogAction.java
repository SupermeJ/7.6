package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TAdminDAO;
import com.dao.TCatelogDAO;
import com.dao.TYuangongDAO;
import com.model.TAdmin;
import com.model.TCatelog;
import com.model.TYuangong;
import com.opensymphony.xwork2.ActionSupport;

public class catelogAction extends ActionSupport
{
	private int id;
	private String name;
	private String jieshao;
	 
	private String message;
	private String path;
	
	private TCatelogDAO catelogDAO;

	
	public String catelogAdd()
	{
		TCatelog catelog=new TCatelog();
		
		catelog.setName(name);
		catelog.setJieshao(jieshao);
		catelog.setDel("no");
		
		catelogDAO.save(catelog);
		this.setMessage("操作成功");
		this.setPath("catelogMana.action");
		return "succeed";
	}
	
	
	
	public String catelogMana()
	{
		String sql = "from TCatelog where del='no'";
		List catelogList=catelogDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("catelogList", catelogList);
		return ActionSupport.SUCCESS;
	}
	
	public String catelogDel()
	{
		String sql = "update TCatelog set del='yes' where id=?";
		Object[] o={id};
		catelogDAO.getHibernateTemplate().bulkUpdate(sql, o);
		this.setMessage("删除成功");
		this.setPath("catelogMana.action");
		return "succeed";
	}



	public TCatelogDAO getCatelogDAO()
	{
		return catelogDAO;
	}



	public void setCatelogDAO(TCatelogDAO catelogDAO)
	{
		this.catelogDAO = catelogDAO;
	}



	public int getId()
	{
		return id;
	}



	public void setId(int id)
	{
		this.id = id;
	}



	public String getJieshao()
	{
		return jieshao;
	}



	public void setJieshao(String jieshao)
	{
		this.jieshao = jieshao;
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
