package com.model;

/**
 * TKehu generated by MyEclipse Persistence Tools
 */

public class TKehu implements java.io.Serializable
{

	// Fields

	private Integer id;

	private String mingcheng;

	private String dizhi;

	private String lianxiren;

	private String dianhua;

	private String youbian;

	private String chuanzhen;

	private String youxiang;

	private String kahuhang;

	private String zhanghao;

	private String type;

	private String del;

	// Constructors

	/** default constructor */
	public TKehu()
	{
	}

	/** full constructor */
	public TKehu(String mingcheng, String dizhi, String lianxiren,
			String dianhua, String youbian, String chuanzhen, String youxiang,
			String kahuhang, String zhanghao, String type, String del)
	{
		this.mingcheng = mingcheng;
		this.dizhi = dizhi;
		this.lianxiren = lianxiren;
		this.dianhua = dianhua;
		this.youbian = youbian;
		this.chuanzhen = chuanzhen;
		this.youxiang = youxiang;
		this.kahuhang = kahuhang;
		this.zhanghao = zhanghao;
		this.type = type;
		this.del = del;
	}

	// Property accessors

	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getMingcheng()
	{
		return this.mingcheng;
	}

	public void setMingcheng(String mingcheng)
	{
		this.mingcheng = mingcheng;
	}

	public String getDizhi()
	{
		return this.dizhi;
	}

	public void setDizhi(String dizhi)
	{
		this.dizhi = dizhi;
	}

	public String getLianxiren()
	{
		return this.lianxiren;
	}

	public void setLianxiren(String lianxiren)
	{
		this.lianxiren = lianxiren;
	}

	public String getDianhua()
	{
		return this.dianhua;
	}

	public void setDianhua(String dianhua)
	{
		this.dianhua = dianhua;
	}

	public String getYoubian()
	{
		return this.youbian;
	}

	public void setYoubian(String youbian)
	{
		this.youbian = youbian;
	}

	public String getChuanzhen()
	{
		return this.chuanzhen;
	}

	public void setChuanzhen(String chuanzhen)
	{
		this.chuanzhen = chuanzhen;
	}

	public String getYouxiang()
	{
		return this.youxiang;
	}

	public void setYouxiang(String youxiang)
	{
		this.youxiang = youxiang;
	}

	public String getKahuhang()
	{
		return this.kahuhang;
	}

	public void setKahuhang(String kahuhang)
	{
		this.kahuhang = kahuhang;
	}

	public String getZhanghao()
	{
		return this.zhanghao;
	}

	public void setZhanghao(String zhanghao)
	{
		this.zhanghao = zhanghao;
	}

	public String getType()
	{
		return this.type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getDel()
	{
		return this.del;
	}

	public void setDel(String del)
	{
		this.del = del;
	}

}