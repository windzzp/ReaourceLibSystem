package com.huijiasoft.model;

import java.util.List;

import com.huijiasoft.model.base.BaseUploads;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class Uploads extends BaseUploads<Uploads> {
	public static final Uploads dao = new Uploads();
	
	
	public List<Uploads> getAllMediaById(String string){
		String sql = "select * from uploads where user_id = ?";
		return dao.find(sql,string);
	}
}
