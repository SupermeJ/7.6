package com.model;

/**
 * TRukuMingxi generated by MyEclipse Persistence Tools
 */

public class TRukuMingxi implements java.io.Serializable
{

	// Fields

	private Integer id;

	private Integer ruku_id;

	private Integer goods_id;

	private Integer shuliang;

	private String beizhu;
	
	private String goods_name;

	// Constructors

	/** default constructor */
	public TRukuMingxi()
	{
	}


	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}


	public Integer getGoods_id()
	{
		return goods_id;
	}


	public void setGoods_id(Integer goods_id)
	{
		this.goods_id = goods_id;
	}


	public Integer getRuku_id()
	{
		return ruku_id;
	}


	public String getGoods_name()
	{
		return goods_name;
	}


	public void setGoods_name(String goods_name)
	{
		this.goods_name = goods_name;
	}


	public void setRuku_id(Integer ruku_id)
	{
		this.ruku_id = ruku_id;
	}


	public Integer getShuliang()
	{
		return this.shuliang;
	}

	public void setShuliang(Integer shuliang)
	{
		this.shuliang = shuliang;
	}

	public String getBeizhu()
	{
		return this.beizhu;
	}

	public void setBeizhu(String beizhu)
	{
		this.beizhu = beizhu;
	}

}