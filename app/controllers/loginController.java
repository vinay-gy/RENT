package controllers;

import static play.data.Form.form;

import java.util.List;

import buscinessLogics.LoginLogic;
import models.Customer;
import play.api.mvc.Session;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class loginController extends Controller {

	public static Result login(String message) {
		return ok(views.html.login.render(message));
	}
	
	public static Result signUp() {
		return ok(views.html.signup.render());
	}

	
	public static Result save() {
		LoginLogic saveDetails=new LoginLogic();
		saveDetails.save();
		
		return ok();
	}
	
	public static Result authenticate() {
		try {
			Form<Customer> loginForm = form(Customer.class).bindFromRequest();
	        String username = loginForm.data().get("email");
	        String password = LoginLogic.encryptAES(loginForm.data().get("password"));
	        System.out.println(password);
	        List<Customer> data = Customer.authenticate(username, password);
	        if (data.size() == 0) {
		    	
	        	System.out.println("------------------------------");
	        	return ok("Invalid");
			    }else{
			        System.out.println("------------------------------2"+loginForm);
		        	session("re_login_user", data.get(0).id+"");
		        	session("re_user", data.get(0).name);
					return ok("Success");
			    }
		}catch(Exception e) {
			return ok("Invalid");
		}
		
	}
	
	
	 
	 public static Result encryptAES(String password) {
	    	String privateKey = "1234567891012153";
	    	return ok(play.api.libs.Crypto.encryptAES(password, privateKey));
	    }
	    
	    public static Result decryptAES(String password) {
	    	String privateKey = "1234567891012153";
	    	return ok(play.api.libs.Crypto.decryptAES(password, privateKey));
	    }
	    
	public static Result logout() {
		session().clear();
		return ok(views.html.dashboard.render());
	}
}