package com.model;

/**
 * TYuangong generated by MyEclipse Persistence Tools
 */

public class TYuangong implements java.io.Serializable
{

	// Fields

	private Integer id;
	private String name;
	private String sex;
	private String age;

	private String address;
	private String tel;
	private String quanxian;
	private String loginname;
	
	private String loginpw;
	private String del;

	// Constructors

	/** default constructor */
	public TYuangong()
	{
	}

	/** full constructor */
	public TYuangong(String name, String sex, String age, String address,
			String tel, String quanxian, String loginname, String loginpw,
			String del)
	{
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.address = address;
		this.tel = tel;
		this.quanxian = quanxian;
		this.loginname = loginname;
		this.loginpw = loginpw;
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

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSex()
	{
		return this.sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public String getAge()
	{
		return this.age;
	}

	public void setAge(String age)
	{
		this.age = age;
	}

	public String getAddress()
	{
		return this.address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getTel()
	{
		return this.tel;
	}

	public void setTel(String tel)
	{
		this.tel = tel;
	}

	public String getQuanxian()
	{
		return this.quanxian;
	}

	public void setQuanxian(String quanxian)
	{
		this.quanxian = quanxian;
	}

	public String getLoginname()
	{
		return this.loginname;
	}

	public void setLoginname(String loginname)
	{
		this.loginname = loginname;
	}

	public String getLoginpw()
	{
		return this.loginpw;
	}

	public void setLoginpw(String loginpw)
	{
		this.loginpw = loginpw;
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