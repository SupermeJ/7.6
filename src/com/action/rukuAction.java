package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TRukuDAO;
import com.model.TRuku;
import com.opensymphony.xwork2.ActionSupport;

public class rukuAction extends ActionSupport
{
	private int id;
	private String danjuhao;
	private String shijian;
	private int zongjiage;
	
	private String jingshouren;
	private String beizhu;
	 
	private String message;
	private String path;
	
	private TRukuDAO rukuDAO;
	
	
	
	
	public String rukuAdd()
	{
		TRuku ruku=new TRuku();
		
		ruku.setDanjuhao(danjuhao);
		ruku.setShijian(shijian);
		ruku.setZongjiage(zongjiage);
		ruku.setJingshouren(jingshouren);
		ruku.setBeizhu(beizhu);
		ruku.setDel("no");
		ruku.setLb("1");
		
		rukuDAO.save(ruku);
		this.setMessage("操作成功");
		this.setPath("rukuMana.action");
		return "succeed";
	}
	
	
	
	public String rukuMana()
	{
		String sql = "from TRuku where del='no'  and lb=1 ";
		List rukuList=rukuDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("rukuList", rukuList);
		return ActionSupport.SUCCESS;
	}
	
	public String rukuDel()
	{
		String sql = "update TRuku set del='yes' where id=?";
		Object[] o={id};
		rukuDAO.getHibernateTemplate().bulkUpdate(sql, o);
		this.setMessage("删除成功");
		this.setPath("rukuMana.action");
		return "succeed";
	}
	
	
	public String rukuAdd1()
	{
		TRuku ruku=new TRuku();
		
		ruku.setDanjuhao(danjuhao);
		ruku.setShijian(shijian);
		ruku.setZongjiage(zongjiage);
		ruku.setJingshouren(jingshouren);
		ruku.setBeizhu(beizhu);
		ruku.setDel("no");
		ruku.setLb("2");
		
		rukuDAO.save(ruku);
		this.setMessage("操作成功");
		this.setPath("rukuMana1.action");
		return "succeed";
	}
	
	
	
	public String rukuMana1()
	{
		String sql = "from TRuku where del='no' and lb=2";
		List rukuList=rukuDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("rukuList", rukuList);
		return ActionSupport.SUCCESS;
	}
	
	public String rukuDel1()
	{
		String sql = "update TRuku set del='yes' where id=?";
		Object[] o={id};
		rukuDAO.getHibernateTemplate().bulkUpdate(sql, o);
		this.setMessage("删除成功");
		this.setPath("rukuMana1.action");
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



	public String getDanjuhao()
	{
		return danjuhao;
	}



	public void setDanjuhao(String danjuhao)
	{
		this.danjuhao = danjuhao;
	}





	public TRukuDAO getRukuDAO()
	{
		return rukuDAO;
	}



	public void setRukuDAO(TRukuDAO rukuDAO)
	{
		this.rukuDAO = rukuDAO;
	}



	public int getId()
	{
		return id;
	}



	public void setId(int id)
	{
		this.id = id;
	}



	public String getJingshouren()
	{
		return jingshouren;
	}



	public void setJingshouren(String jingshouren)
	{
		this.jingshouren = jingshouren;
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



	public String getShijian()
	{
		return shijian;
	}



	public void setShijian(String shijian)
	{
		this.shijian = shijian;
	}



	public int getZongjiage()
	{
		return zongjiage;
	}



	public void setZongjiage(int zongjiage)
	{
		this.zongjiage = zongjiage;
	}


	
}
