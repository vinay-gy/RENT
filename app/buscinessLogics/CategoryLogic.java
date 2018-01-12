package buscinessLogics;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;
import static play.libs.Json.toJson;
import models.Categories;
import models.SubCategories;
import play.Logger;

@SuppressWarnings({ "unused", "rawtypes" })
public class CategoryLogic {

	public static void create() {
		final play.Logger.ALogger log = Logger.of("categorylog");
		try {
			log.info("Inside CategoryLogic - create() started");
			
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
	}
	
	public static void save() {
		final play.Logger.ALogger log = Logger.of("categorylog");
		try {
			log.info("Inside CategoryLogic - save() started");
			
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
	}
	
	public static void edit() {
		final play.Logger.ALogger log = Logger.of("categorylog");
		try {
			log.info("Inside CategoryLogic - edit() started");
			
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
	}
	
	public static void update() {
		final play.Logger.ALogger log = Logger.of("categorylog");
		try {
			log.info("Inside CategoryLogic - update() started");
			
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
	}
	
	
	public static List categoryList() {
		final play.Logger.ALogger log = Logger.of("categorylog");
		List categoryList = new ArrayList();
		try {
			log.info("Inside CategoryLogic - categoryList() started");
			categoryList = Categories.categoryList();
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
		return categoryList;
	}
	
	public static void searchCategory() {
		final play.Logger.ALogger log = Logger.of("categorylog");
		try {
			log.info("Inside CategoryLogic - searchCategory() started");
			
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
	}
	
	public static void subCategoryCreate() {
		final play.Logger.ALogger log = Logger.of("categorylog");
		try {
			log.info("Inside CategoryLogic - subCategorycreate() started");
			
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
	}
	
	public static void subCategorySave() {
		final play.Logger.ALogger log = Logger.of("categorylog");
		try {
			log.info("Inside CategoryLogic - subCategorysave() started");
			
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
	}
	
	public static void subCategoryEdit() {
		final play.Logger.ALogger log = Logger.of("categorylog");
		try {
			log.info("Inside CategoryLogic - subCategoryedit() started");
			
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
	}
	
	public static void subCategoryUpdate() {
		final play.Logger.ALogger log = Logger.of("categorylog");
		try {
			log.info("Inside CategoryLogic - subCategoryupdate() started");
			
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
	}
	
	public static List subCategoryList(String categoryId) {
		final play.Logger.ALogger log = Logger.of("categorylog");
		List data = new ArrayList();
		try {
			log.info("Inside CategoryLogic - subcategoryList() started");
			data = SubCategories.subCategoryList(categoryId);
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
		return data;
	}
	
	public static void searchSubCategory() {
		final play.Logger.ALogger log = Logger.of("categorylog");
		try {
			log.info("Inside CategoryLogic - searchSubCategory() started");
			
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
	}
}
