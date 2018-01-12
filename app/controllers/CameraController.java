package controllers;

import static play.data.Form.form;
import static play.libs.Json.toJson;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import buscinessLogics.ProductLogic;
import models.Cameras;


import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;


public class CameraController extends Controller {
public static Result create()
{final play.Logger.ALogger log = Logger.of("productlog");
try {
	log.info("Inside ComputersController - create() started");
		Form<Cameras> model= form(Cameras.class);
		return ok(views.html.createCameras.render(model));
	}catch(Exception e) {
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
		log.error(errors.toString());
		e.printStackTrace();
	}
	return notFound();
}
public static Result save()
{
	final play.Logger.ALogger log = Logger.of("productlog");
	try {
		Form<Cameras> data=form(Cameras.class).bindFromRequest();
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

public static Result cameraDetails(String productId) {
	final play.Logger.ALogger log = Logger.of("productlog");
	try {
		log.info("Inside ComputersController - computerDetails() started");
		session("re_login_user", "1");
		
		return ok(views.html.cameraDetails.render(productId));
	}catch(Exception e) {
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
		log.error(errors.toString());
		e.printStackTrace();
	}
	return notFound();
}

public static Result getCameraDetails(String productId) {
	final play.Logger.ALogger log = Logger.of("");
	List data = new ArrayList();
	try {
		
		data = ProductLogic.getCameraList(productId);
		
	}catch(Exception e) {
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
		log.error(errors.toString());
		e.printStackTrace();
	}
	
	return ok(toJson(data));
}
}
