package buscinessLogics;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import play.mvc.Result.*;
import models.Customer;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;

import static play.data.Form.*;
public class LoginLogic {

	public static void create() {
		final play.Logger.ALogger log = Logger.of("productlog");
		try {
			log.info("Inside ProductLogic - create() started");
			
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
	}
	
	public static void save() {
		final play.Logger.ALogger log = Logger.of("productlog");
		try {
			log.info("Inside ProductLogic - save() started");
			Form<Customer> saveDetails = form(Customer.class).bindFromRequest();
			System.out.println(saveDetails);
			saveDetails.get().loginId = saveDetails.get().email;
			saveDetails.get().password = encryptAES(saveDetails.get().password);
			saveDetails.get().save();
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
	}
	
	 public static String encryptAES(String password) {
	    	String privateKey = "1234567891012153";
	    	return play.api.libs.Crypto.encryptAES(password, privateKey);
	    }
	
	public static void edit() {
		final play.Logger.ALogger log = Logger.of("productlog");
		try {
			log.info("Inside ProductLogic - edit() started");
			
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
	}
	
	public static void update() {
		final play.Logger.ALogger log = Logger.of("productlog");
		try {
			log.info("Inside ProductLogic - update() started");
			
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
	}
	
	public static void productList() {
		final play.Logger.ALogger log = Logger.of("productlog");
		try {
			log.info("Inside ProductLogic - productList() started");
			
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
	}
	
	public static void searchProduct() {
		final play.Logger.ALogger log = Logger.of("productlog");
		try {
			log.info("Inside ProductLogic - searchProduct() started");
			
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
	}
	
	public static void subProductCreate() {
		final play.Logger.ALogger log = Logger.of("productlog");
		try {
			log.info("Inside ProductLogic - subProductcreate() started");
			
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
	}
	
	public static void subProductSave() {
		final play.Logger.ALogger log = Logger.of("productlog");
		try {
			log.info("Inside ProductLogic - subProductsave() started");
			
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
	}
	
	public static void subProductEdit() {
		final play.Logger.ALogger log = Logger.of("productlog");
		try {
			log.info("Inside ProductLogic - subProductedit() started");
			
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
	}
	
	public static void subProductUpdate() {
		final play.Logger.ALogger log = Logger.of("productlog");
		try {
			log.info("Inside ProductLogic - subProductupdate() started");
			
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
	}
	
	public static void subProductList() {
		final play.Logger.ALogger log = Logger.of("productlog");
		try {
			log.info("Inside ProductLogic - subproductList() started");
			
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
	}
	
	public static void searchSubProduct() {
		final play.Logger.ALogger log = Logger.of("productlog");
		try {
			log.info("Inside ProductLogic - searchSubProduct() started");
			
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
	}
}

