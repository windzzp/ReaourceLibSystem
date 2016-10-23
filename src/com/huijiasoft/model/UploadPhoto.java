package com.huijiasoft.model;

import java.util.List;

import com.huijiasoft.model.base.BaseUploadPhoto;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class UploadPhoto extends BaseUploadPhoto<UploadPhoto> {
	public static final UploadPhoto dao = new UploadPhoto();
	
	public List<UploadPhoto> getPhotoListByUserId(int user_id){
		String sql = "select * from upload_photo where user_id = ?";
		return dao.find(sql,user_id);
	}
	
	
}