package controllers;
import static play.libs.Json.toJson;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import static play.data.Form.*;
import buscinessLogics.CategoryLogic;
import buscinessLogics.ProductLogic;
import models.Customer;
import models.Product;
import models.ProductType;
import models.RealEstateCommercial;
import models.RealEstateResidential;
import models.Settings;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;

@SuppressWarnings({ "unused", "rawtypes" })
public class RealEstateController extends Controller{
	
	public static Result createResidential() {
		final play.Logger.ALogger log = Logger.of("productlog");
		try {
			log.info("Inside ProductLogic - createResidential() started");
			session("re_login_user", "1");
			Form<RealEstateResidential> model = form(RealEstateResidential.class);
			return ok(views.html.createRealEstate.render(model));
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
		return notFound();
	}
	
	public static Result saveRealEstateResidential() {
		final play.Logger.ALogger log = Logger.of("productlog");
		try {
			log.info("Inside ProductLogic - saveRealEstateResidential() started");
			Form<RealEstateResidential> data = form(RealEstateResidential.class).bindFromRequest();
			if(data.hasErrors()) {
				log.error("The City form has errors");
	        }
	        data.get().save();
			return ok("success");
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
		return notFound();
	}
	public static Result createCommercial() {
		final play.Logger.ALogger log = Logger.of("productlog");
		try {
			log.info("Inside ProductLogic - createCommercial() started");
			session("re_login_user", "1");
			Form<RealEstateCommercial> model = form(RealEstateCommercial.class);
			return ok(views.html.createRealEstateCommercial.render(model));
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
		return notFound();
	}
	
	public static Result saveRealEstateCommercial() {
		final play.Logger.ALogger log = Logger.of("productlog");
		try {
			log.info("Inside ProductLogic - saveRealEstateCommercial() started");
			Form<RealEstateCommercial> data = form(RealEstateCommercial.class).bindFromRequest();
			System.out.println(data);
			if(data.hasErrors()) {
				log.error("The City form has errors");
				return ok("Failure");
	        }
	        data.get().save();
			return ok("success");
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
		return notFound();
	}
	
	public static Result getRealEstate() {
		return ok(views.html.getRealEstateDetails.render());
	}
	
	public static Result productDetails(String productId) {
		return ok(views.html.productDetails.render(productId));
	}
	
	public static Result getRealEstateDetails(String productId) {
		final play.Logger.ALogger log = Logger.of("");
		List data = new ArrayList();
		try {
			
			data = ProductLogic.getRealEstateDetails(productId);
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
		
		return ok(toJson(data));
	}
	
	public static Result getproductDetails(String productId) {
		final play.Logger.ALogger log = Logger.of("");
		List data = new ArrayList();
		try {
			
			data = ProductLogic.getProductDetails(productId);
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
		
		return ok(toJson(data));
	}
	
	public static Result commercialDetails(String productId) {
		final play.Logger.ALogger log = Logger.of("productlog");
		try {
			log.info("Inside ComputersController - computerDetails() started");
			session("re_login_user", "1");
			
			return ok(views.html.commercialDetails.render(productId));
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			log.error(errors.toString());
			e.printStackTrace();
		}
		return notFound();
	}
	
	public static Result getcommercialDetails(String productId) {
		final play.Logger.ALogger log = Logger.of("");
		List data = new ArrayList();
		try {
			
			data = ProductLogic.getCommercialList(productId);
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			log.error(errors.toString());
			e.printStackTrace();
		}
		
		return ok(toJson(data));
	}
	
}
