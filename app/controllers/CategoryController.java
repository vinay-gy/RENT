package controllers;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import static play.libs.Json.toJson;
import buscinessLogics.CategoryLogic;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;

@SuppressWarnings({ "unused", "rawtypes" })
public class CategoryController extends Controller {

	public static Result categoryList() {
		final play.Logger.ALogger log = Logger.of("categorylog");
		List categoryList = new ArrayList();
		try {
			log.info("Inside CategoryController - categoryList() started");
			categoryList = CategoryLogic.categoryList();
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
		
		return ok(toJson(categoryList));
	}
	
	public static Result subCategoryList(String categoryId) {
		final play.Logger.ALogger log = Logger.of("categorylog");
		List data = new ArrayList();
		try {
			log.info("Inside CategoryController - categoryList() started");
			data = CategoryLogic.subCategoryList(categoryId);
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
		
		return ok(toJson(data));
	}
}
