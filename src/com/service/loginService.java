package com.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.dao.TAdminDAO;
import com.dao.TCatelogDAO;
import com.dao.TGoodsDAO;
import com.dao.TYuangongDAO;
import com.model.TAdmin;
import com.model.TYuangong;

public class loginService
{
	private TAdminDAO adminDAO;
	private TCatelogDAO catelogDAO;
	private TGoodsDAO goodsDAO;
	private TYuangongDAO yuangongDAO;
	public TAdminDAO getAdminDAO()
	{
		return adminDAO;
	}
	public void setAdminDAO(TAdminDAO adminDAO)
	{
		this.adminDAO = adminDAO;
	}
	public TCatelogDAO getCatelogDAO()
	{
		return catelogDAO;
	}
	public void setCatelogDAO(TCatelogDAO catelogDAO)
	{
		this.catelogDAO = catelogDAO;
	}
	public TGoodsDAO getGoodsDAO()
	{
		return goodsDAO;
	}
	public void setGoodsDAO(TGoodsDAO goodsDAO)
	{
		this.goodsDAO = goodsDAO;
	}
	public TYuangongDAO getYuangongDAO()
	{
		return yuangongDAO;
	}
	public void setYuangongDAO(TYuangongDAO yuangongDAO)
	{
		this.yuangongDAO = yuangongDAO;
	}
	public String login(String userName,String userPw,int userType)
	{
		System.out.println("userType"+userType);
		try
		{
			Thread.sleep(700);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String result="no";
		
		if(userType==0)//系统管理员登录
		{
			String sql="from TAdmin where userName=? and userPw=?";
			Object[] con={userName,userPw};
			List adminList=adminDAO.getHibernateTemplate().find(sql,con);
			if(adminList.size()==0)
			{
				 result="no";
			}
			else
			{
				 WebContext ctx = WebContextFactory.get(); 
				 HttpSession session=ctx.getSession(); 
				 TAdmin admin=(TAdmin)adminList.get(0);
				 session.setAttribute("userType", 0);
	             session.setAttribute("admin", admin);
	             result="yes";
			}
		}
		if(userType==1)
		{
			String sql = "from TYuangong where del='no' and quanxian='caozuoyuan' and loginname=? and loginpw=?";
			Object[] con={userName,userPw};
			List yuangongList=yuangongDAO.getHibernateTemplate().find(sql,con);
			if(yuangongList.size()==0)
			{
				 result="no";
			}
			else
			{
				 WebContext ctx = WebContextFactory.get(); 
				 HttpSession session=ctx.getSession(); 
				 TYuangong yuangong=(TYuangong)yuangongList.get(0);
				 session.setAttribute("userType", 1);
	             session.setAttribute("yuangong", yuangong);
	             result="yes";
			}
		}
		if(userType==2)
		{
			
		}
		return result;
	}

    public String adminPwEdit(String userPwNew)
    {
		System.out.println("DDDD");
    	try 
		{
			Thread.sleep(700);
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebContext ctx = WebContextFactory.get(); 
		HttpSession session=ctx.getSession(); 
		 
		TAdmin admin=(TAdmin)session.getAttribute("admin");
		admin.setUserPw(userPwNew);
		
		adminDAO.getHibernateTemplate().update(admin);
		session.setAttribute("admin", admin);
		
		return "yes";
    }
    
    
    public List catelogAll()
    {
    	String sql = "from TCatelog where del='no'";
		List catelogList=catelogDAO.getHibernateTemplate().find(sql);
		return catelogList;
    }
	
    
    public List goodsAll(int catelog_id)
    {
    	String sql = "from TGoods where del='no' and catelog_id="+catelog_id;
		List goodsList=goodsDAO.getHibernateTemplate().find(sql);
		return goodsList;
    }
    
}
