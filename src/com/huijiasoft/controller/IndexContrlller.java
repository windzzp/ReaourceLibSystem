package com.huijiasoft.controller;



import com.huijiasoft.model.User;
import com.huijiasoft.service.IndexService;
import com.huijiasoft.utils.DateUtils;
import com.huijiasoft.utils.MD5;
import com.huijiasoft.validate.RegistValidator;
import com.jfinal.aop.Before;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.ext.kit.SessionIdKit;

/**
 * @author pangPython
 *	前端控制器
 */

public class IndexContrlller extends Controller {
	
	//进入首页
	
	@ActionKey("/")
	public void index(){
			setAttr("system", IndexService.getSysConfig());
			render("index.html");	
	}
	
	
	public void loginpage(){
		setAttr("system", IndexService.getSysConfig());
		render("login.html");
	}
	
	//前台登录方法
	public void login(){
		//如果请求参数cookie中可以获取到当前登录用户
		//先移除其登录信息
		String cuser = getCookie("cuser");
		
		if(cuser!=null){
			removeSessionAttr(cuser);
		}
		
		String uname = getPara("uname");
		String sql = "select * from user where uname = ? limit 1";
		
		//验证码结果
		boolean result = validateCaptcha("verifycode");
		
		User user = User.usermodel.findFirst(sql,uname);
		if(user!=null && result){
			String pwd = MD5.GetMD5Code(getPara("password")+user.getRegDate());
			
			if(user.getPwd().equals(pwd)){
				
				//生成唯一标识
				String sessionId = SessionIdKit.me().generate(getRequest());
				//设置服务器端session
				setSessionAttr(sessionId, user);
				//设置用户端cookie
				setCookie("cuser", sessionId, 600);
				redirect("/user");
				
			}else{
				
				redirect("loginpage");
				
			}
			
		}else{
			
			redirect("loginpage");
		}
		
		
	}
	
	//注册
	
	public void register(){
		render("regist.html");
	}
	
	
	@ActionKey("regist")
	@Before(RegistValidator.class)
	public void regist(){
		//使用工具包把当前时间转换成unix时间戳再转换成string类型
		//注册时间，并作为用户密码md5加密的salt
		String reg_date = DateUtils.unixTimestampToDate(DateUtils.dateToUnixTimestamp(DateUtils.getNowTime()));
		
		//使用jfinal标识生成工具生成随机数作为密码的盐
		
		String pwd = MD5.GetMD5Code(getPara("user.pwd")+reg_date);
		
		System.out.println(pwd+"md5 密码：！");
		
		User user = this.getModel(User.class);
		
		user.setRegDate(reg_date);
		user.setPwd(pwd);
		user.save();
		//getModel(User.class).save();
		renderText("注册成功!");
	}
	
	
}
