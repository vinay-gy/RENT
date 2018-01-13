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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import static play.data.Form.*;
import buscinessLogics.CategoryLogic;
import buscinessLogics.ProductLogic;
import models.Customer;
import models.Product;
import models.ProductType;
import models.RealEstateResidential;
import models.Settings;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;

@SuppressWarnings({ "unused", "rawtypes" })
public class ProductController extends Controller {

	public static Result getAdDetails(String categoryId) {
		return ok(views.html.adDetails.render(categoryId));
	}
	
	public static Result productTypeList(String subCatId) {
		final play.Logger.ALogger log = Logger.of("productlog");
		List data = new ArrayList();
		try {
			log.info("Inside ProductController - productTypeList() started");
			data = ProductLogic.productList(subCatId);
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
		
		return ok(toJson(data));
	}
	
	public static Result create() {
		final play.Logger.ALogger log = Logger.of("productlog");
		try {
			if((session("re_login_user") == null)){
				return ok(views.html.login.render(""));
			}
			log.info("Inside ProductLogic - create() started");
			session("re_login_user", "1");
			Form<Product> model = form(Product.class);
			return ok(views.html.createAd.render(model));
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
		long productId = 0;
		
		try {
			log.info("Inside ProductController - createProduct() started");
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date=new Date();
			String IMAGE_PATH = Settings.find.where().eq("KeyName", "AD_IMAGE_PATH").findUnique().keyvalue;
			String AD_IMAGE_PATH = "";
	        DynamicForm formData = Form.form().bindFromRequest();
			
			play.mvc.Http.MultipartFormData body = request().body().asMultipartFormData();
	        List<FilePart> files = body.getFiles();
	        
	        Form<Product> data = form(Product.class).bindFromRequest();
	    	data.get().isActive = true;
	    	data.get().isDeleted = false;
	    	data.get().isAvailable = true;
	    	data.get().isHidden = false;
	    	data.get().postedDate = new java.sql.Timestamp(date.getTime());
	    	data.get().views = "0";
	    	data.get().likes = "0";
	    	data.get().imagePath = "";
	    	long cid = Long.parseLong(session("re_login_user"));
	    	data.get().customer = Customer.find.byId(cid);
	    	System.out.println(data.toString());
//	        Boolean result = false;
	        long result = ProductLogic.save(data);
	        if(result != 0) {
	        	int i = 1;
		        for(FilePart e:files) {
		        	File image = e.getFile();
		        	if(image!=null){
				        File destination = new File(IMAGE_PATH, "pid"+result);
				        if(!destination.exists()){
				        	destination.mkdir();
				        }
				        String ary[] = e.getFilename().split("\\.");
				        String format = ary[ary.length-1];
				        AD_IMAGE_PATH = destination.getPath();
				        System.out.println(AD_IMAGE_PATH);
				        
				        destination = new File(destination.getPath(), "image"+i+"."+format);
				        if(destination.exists()){
				        	destination.delete();
				        }
				  	  	FileUtils.moveFile(image, destination);
				        System.out.println(destination.getPath());
				  	  	i++;
		        		}
		        }
	        	Product p = Product.find.byId(result);
	        	p.imagePath = AD_IMAGE_PATH;
	        	p.update();
	        	productId = result;
	        	flash("success", "Ad has been created");
	        	log.info("The Product has been created by the user: " +session("re_login_user") + ". Created Time is : " + dateFormat.format(date));
	        }else {
	        	flash("Failure", "Ad creation failed");
	        	log.info("Ad creation failed");
	        }
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
		
		return ok(String.valueOf(productId));
	}
	
	public static Result saveRealEstateResidential() {
		final play.Logger.ALogger log = Logger.of("productlog");
		try {
			log.info("Inside ProductLogic - createRealEstate() started");
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
	public static Result getProductForm(String productID) {
		final play.Logger.ALogger log = Logger.of("productlog");
		try {
			log.info("Inside ProductLogic - createRealEstate() started");
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
	
	public static Result successPage(String pid) {
		final play.Logger.ALogger log = Logger.of("productlog");
		try {
			log.info("Inside ProductLogic - successPage() started");
			return ok(views.html.successPage.render(pid));
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
		return notFound();
	}
	
	public static Result productDetails(String pid) {
		final play.Logger.ALogger log = Logger.of("categorylog");
		List data = new ArrayList();
		try {
			log.info("Inside ProductController - productDetails() started");
			data = Product.productList(pid);
			Product p = (Product)data.get(0);
			String imagePath = p.imagePath;
			imagePath.replace("\\", "/").replace("public", "/assets");
			File path = new File(imagePath);
			List images = new ArrayList();
		    File [] files = path.listFiles();
		    for (int i = 0; i < files.length; i++){
		        if (files[i].isFile()){ //this line weeds out other directories/folders
		        	images.add(((files)[i]+"").replace("\\", "/").replace("public", "/assets"));
		        }
		    }
		    Map map = new HashMap();
		    map.put("images", images);
		    data.add(map);
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
		
		return ok(toJson(data));
	}
	
	public static Result adImages(String imagePath) {
		final play.Logger.ALogger log = Logger.of("categorylog");
		List data = new ArrayList();
		try {
			File path = new File(imagePath);
		
		    File [] files = path.listFiles();
		    for (int i = 0; i < files.length; i++){
		        if (files[i].isFile()){ //this line weeds out other directories/folders
		            System.out.println(files[i]);
		        }
		    }
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			log.error(errors.toString());
			e.printStackTrace();
		}
		
		return ok(toJson(data));
	}
}

