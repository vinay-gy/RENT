package controllers;

import java.io.PrintWriter;
import java.io.StringWriter;
import static play.libs.Json.toJson;
import models.Customer;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;

public class CustomerController extends Controller {

	public static Result customerInfo(String customerId) {
		final play.Logger.ALogger log = Logger.of("customerlog");
		Customer details = new Customer();
		try {
			 details = Customer.find.where().eq("id", customerId).findUnique();
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
		return ok(toJson(details));
	}
	
	public static Result validateEmail(String email) {
		final play.Logger.ALogger log = Logger.of("customerlog");
		String result = "";
		try {
			Customer data = Customer.find.where().eq("email", email).findUnique();
			if(data != null) {
				result = "duplicated";
			}else {
				result = "ok";
			}
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
		return ok(result);
	}
	
	public static Result validateMobile(String mobile) {
		final play.Logger.ALogger log = Logger.of("customerlog");
		String result = "";
		try {
			Customer data = Customer.find.where().eq("mobile", mobile).findUnique();
			if(data != null) {
				result = "duplicated";
			}else {
				result = "ok";
			}
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
		return ok(result);
	}
}
