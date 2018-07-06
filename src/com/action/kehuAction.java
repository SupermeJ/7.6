package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TAdminDAO;
import com.dao.TCatelogDAO;
import com.dao.TKehuDAO;
import com.dao.TYuangongDAO;
import com.model.TAdmin;
import com.model.TCatelog;
import com.model.TKehu;
import com.model.TYuangong;
import com.opensymphony.xwork2.ActionSupport;

public class kehuAction extends ActionSupport
{
	private int id;
	private String mingcheng;
	private String dizhi;
	private String lianxiren;
	private String dianhua;
	private String youbian;
	private String chuanzhen;
	private String youxiang;
	 
	private String message;
	private String path;
	
    private TKehuDAO kehuDAO;
	
	public String kehuAdd()
	{
		TKehu kehu=new TKehu();
		
		kehu.setMingcheng(mingcheng);
		kehu.setDizhi(dizhi);
		kehu.setLianxiren(lianxiren);
		kehu.setDianhua(dianhua);
		kehu.setYoubian(youbian);
		kehu.setChuanzhen(chuanzhen);
		kehu.setYouxiang(youxiang);
		kehu.setDel("no");
		
		kehuDAO.save(kehu);
		this.setMessage("操作成功");
		this.setPath("kehuMana.action");
		return "succeed";
	}
	
	
	
	public String kehuMana()
	{
		String sql = "from TKehu where del='no'";
		List kehuList=kehuDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("kehuList", kehuList);
		return ActionSupport.SUCCESS;
	}
	
	public String kehuDel()
	{
		String sql = "update TKehu set del='yes' where id=?";
		Object[] o={id};
		kehuDAO.getHibernateTemplate().bulkUpdate(sql, o);
		this.setMessage("删除成功");
		this.setPath("kehuMana.action");
		return "succeed";
	}



	public String getChuanzhen()
	{
		return chuanzhen;
	}



	public void setChuanzhen(String chuanzhen)
	{
		this.chuanzhen = chuanzhen;
	}



	public String getDianhua()
	{
		return dianhua;
	}



	public void setDianhua(String dianhua)
	{
		this.dianhua = dianhua;
	}



	public String getDizhi()
	{
		return dizhi;
	}



	public void setDizhi(String dizhi)
	{
		this.dizhi = dizhi;
	}



	public int getId()
	{
		return id;
	}



	public void setId(int id)
	{
		this.id = id;
	}



	public TKehuDAO getKehuDAO()
	{
		return kehuDAO;
	}



	public void setKehuDAO(TKehuDAO kehuDAO)
	{
		this.kehuDAO = kehuDAO;
	}



	public String getLianxiren()
	{
		return lianxiren;
	}



	public void setLianxiren(String lianxiren)
	{
		this.lianxiren = lianxiren;
	}



	public String getMessage()
	{
		return message;
	}



	public void setMessage(String message)
	{
		this.message = message;
	}



	public String getMingcheng()
	{
		return mingcheng;
	}



	public void setMingcheng(String mingcheng)
	{
		this.mingcheng = mingcheng;
	}



	public String getPath()
	{
		return path;
	}



	public void setPath(String path)
	{
		this.path = path;
	}



	public String getYoubian()
	{
		return youbian;
	}



	public void setYoubian(String youbian)
	{
		this.youbian = youbian;
	}



	public String getYouxiang()
	{
		return youxiang;
	}



	public void setYouxiang(String youxiang)
	{
		this.youxiang = youxiang;
	}


}
