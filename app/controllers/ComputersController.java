package controllers;

import static play.data.Form.form;
import static play.libs.Json.toJson;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import buscinessLogics.ProductLogic;
import models.Computers;

import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class ComputersController extends Controller {
	public static Result create() {
		final play.Logger.ALogger log = Logger.of("productlog");
		try {
			log.info("Inside ComputersController - create() started");
			session("re_login_user", "1");
			Form<Computers> model = form(Computers.class);
			return ok(views.html.createComputers.render(model));
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
		return notFound();
	}
	
	public static Result save() {
		final play.Logger.ALogger log = Logger.of("productlog");
		try {
			log.info("Inside ComputersController - save() started");
			Form<Computers> data = form(Computers.class).bindFromRequest();
			if(data.hasErrors()) {
				log.error("The form has errors");
				return ok("failure");
	        }
			System.out.println(data);
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
	
	public static Result computerDetails(String productId) {
		final play.Logger.ALogger log = Logger.of("productlog");
		try {
			log.info("Inside ComputersController - computerDetails() started");
			session("re_login_user", "1");
			
			return ok(views.html.computerDetails.render(productId));
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
		return notFound();
	}
	
	public static Result getComputerDetails(String productId) {
		final play.Logger.ALogger log = Logger.of("");
		List data = new ArrayList();
		try {
			
			data = ProductLogic.getComputerList(productId);
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
		
		return ok(toJson(data));
	}
}
