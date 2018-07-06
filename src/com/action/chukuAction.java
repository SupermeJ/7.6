package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TChukuDAO;
import com.dao.TRukuDAO;
import com.model.TChuku;
import com.model.TRuku;
import com.opensymphony.xwork2.ActionSupport;

public class chukuAction extends ActionSupport
{
	private int id;
	private String danjuhao;
	private String shijian;
	private int zongjiage;
	
	private String jingshouren;
	private String beizhu;
	 
	private String message;
	private String path;
	
	private TChukuDAO chukuDAO;
	
	
	
	
	public String chukuAdd()
	{
		TChuku chuku=new TChuku();
		
		chuku.setDanjuhao(danjuhao);
		chuku.setShijian(shijian);
		chuku.setZongjiage(zongjiage);
		chuku.setJingshouren(jingshouren);
		chuku.setBeizhu(beizhu);
		chuku.setDel("no");
		chuku.setLb("1");
		
		chukuDAO.save(chuku);
		this.setMessage("操作成功");
		this.setPath("chukuMana.action");
		return "succeed";
	}
	
	
	
	public String chukuMana()
	{
		String sql = "from TChuku where del='no' and lb=1  ";
		List chukuList=chukuDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("chukuList", chukuList);
		return ActionSupport.SUCCESS;
	}
	
	public String chukuDel()
	{
		String sql = "update TChuku set del='yes' where id=?";
		Object[] o={id};
		chukuDAO.getHibernateTemplate().bulkUpdate(sql, o);
		this.setMessage("删除成功");
		this.setPath("chukuMana.action");
		return "succeed";
	}
	
	
	public String chukuAdd1()
	{
		TChuku chuku=new TChuku();
		
		chuku.setDanjuhao(danjuhao);
		chuku.setShijian(shijian);
		chuku.setZongjiage(zongjiage);
		chuku.setJingshouren(jingshouren);
		chuku.setBeizhu(beizhu);
		chuku.setDel("no");
		chuku.setLb("2");
		
		chukuDAO.save(chuku);
		this.setMessage("�����ɹ�");
		this.setPath("chukuMana1.action");
		return "succeed";
	}
	
	
	
	public String chukuMana1()
	{
		String sql = "from TChuku where del='no' and lb=2 ";
		List chukuList=chukuDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("chukuList", chukuList);
		return ActionSupport.SUCCESS;
	}
	
	public String chukuDel1()
	{
		String sql = "update TChuku set del='yes' where id=?";
		Object[] o={id};
		chukuDAO.getHibernateTemplate().bulkUpdate(sql, o);
		this.setMessage("ɾ���ɹ�");
		this.setPath("chukuMana1.action");
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








	public TChukuDAO getChukuDAO()
	{
		return chukuDAO;
	}



	public void setChukuDAO(TChukuDAO chukuDAO)
	{
		this.chukuDAO = chukuDAO;
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
