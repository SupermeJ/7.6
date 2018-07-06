package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TAdminDAO;
import com.dao.TYuangongDAO;
import com.model.TAdmin;
import com.model.TYuangong;
import com.opensymphony.xwork2.ActionSupport;

public class yuangongAction extends ActionSupport
{
	private int id;
	private String name;
	private String sex;
	private String age;
	
	private String address;
	private String tel;
	private String quanxian;
	private String loginname;
	
	private String loginpw;
	 
	private String message;
	private String path;
	
	private TYuangongDAO yuangongDAO;

	
	public String yuangongAdd()
	{
		TYuangong yuangong=new TYuangong();
		
		yuangong.setName(name);
		yuangong.setSex(sex);
		yuangong.setAge(age);
		yuangong.setAddress(address);
		
		yuangong.setTel(tel);
		yuangong.setQuanxian("putongyuangong");
		yuangong.setLoginname("");
		yuangong.setLoginpw("");
		
		yuangong.setDel("no");
		
		yuangongDAO.save(yuangong);
		this.setMessage("操作成功");
		this.setPath("yuangongMana.action");
		return "succeed";
	}
	
	
	
	public String yuangongMana()
	{
		String sql = "from TYuangong where del='no'";
		List yuangongList=yuangongDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("yuangongList", yuangongList);
		return ActionSupport.SUCCESS;
	}
	
	public String yuangongDel()
	{
		String sql = "update TYuangong set del='yes' where id=?";
		Object[] o={id};
		yuangongDAO.getHibernateTemplate().bulkUpdate(sql, o);
		this.setMessage("删除成功");
		this.setPath("yuangongMana.action");
		return "succeed";
	}
	
	public String yuangongQuanxian()
	{
		String sql = "update TYuangong set quanxian=?,loginname=?,loginpw=? where id=?";
		Object[] o={quanxian,loginname,loginpw,id};
		yuangongDAO.getHibernateTemplate().bulkUpdate(sql, o);

		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "操作成功");
		return "msg";
	}



	public String getAddress()
	{
		return address;
	}



	public void setAddress(String address)
	{
		this.address = address;
	}



	public String getAge()
	{
		return age;
	}



	public void setAge(String age)
	{
		this.age = age;
	}



	public TYuangongDAO getYuangongDAO()
	{
		return yuangongDAO;
	}



	public void setYuangongDAO(TYuangongDAO yuangongDAO)
	{
		this.yuangongDAO = yuangongDAO;
	}



	public int getId()
	{
		return id;
	}



	public void setId(int id)
	{
		this.id = id;
	}



	public String getLoginname()
	{
		return loginname;
	}



	public void setLoginname(String loginname)
	{
		this.loginname = loginname;
	}



	public String getLoginpw()
	{
		return loginpw;
	}



	public void setLoginpw(String loginpw)
	{
		this.loginpw = loginpw;
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



	public String getQuanxian()
	{
		return quanxian;
	}



	public void setQuanxian(String quanxian)
	{
		this.quanxian = quanxian;
	}



	public String getSex()
	{
		return sex;
	}



	public void setSex(String sex)
	{
		this.sex = sex;
	}



	public String getTel()
	{
		return tel;
	}



	public void setTel(String tel)
	{
		this.tel = tel;
	}
	
	 
}
