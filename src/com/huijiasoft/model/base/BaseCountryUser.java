package com.huijiasoft.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseCountryUser<M extends BaseCountryUser<M>> extends Model<M> implements IBean {

	public void setCountryId(java.lang.Integer countryId) {
		set("country_id", countryId);
	}

	public java.lang.Integer getCountryId() {
		return get("country_id");
	}

	public void setCountryname(java.lang.String countryname) {
		set("countryname", countryname);
	}

	public java.lang.String getCountryname() {
		return get("countryname");
	}

	public void setCountrypassword(java.lang.String countrypassword) {
		set("countrypassword", countrypassword);
	}

	public java.lang.String getCountrypassword() {
		return get("countrypassword");
	}

	public void setAreaId(java.lang.Integer areaId) {
		set("area_id", areaId);
	}

	public java.lang.Integer getAreaId() {
		return get("area_id");
	}

	public void setJibie(java.lang.String jibie) {
		set("jibie", jibie);
	}

	public java.lang.String getJibie() {
		return get("jibie");
	}

}