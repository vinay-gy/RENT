package buscinessLogics;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import models.Cameras;
import models.Computers;
import models.Product;
import models.ProductType;
import models.RealEstateCommercial;
import models.RealEstateResidential;
import models.SubCategories;
import models.Vehicles;
import play.Logger;
import play.data.Form;
@SuppressWarnings({ "unused", "rawtypes" })
public class ProductLogic {
	
	public static Long save(Form<Product> data) {
		final play.Logger.ALogger log = Logger.of("productlog");
		Long result;
		try {
			log.info("Inside ProductLogic - save() started");
			if(data.hasErrors()) {
				log.error("The City form has errors");
	            result = 0l;
	        }
	        data.get().save();
	       System.out.println( data.get().id);
	        result = (long) data.get().id;
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
    		result = 0l;
		}
		return result;
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
	
	public static List productList(String subCategory) {
		final play.Logger.ALogger log = Logger.of("productlog");
		List data = new ArrayList();
		try {
			log.info("Inside ProductLogic - productList() started");
			data = ProductType.productTypeList(subCategory);
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
		return data;
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
	
	public static List getRealEstateDetails(String productTypeId) {
		final play.Logger.ALogger log = Logger.of("productlog");
		List data = new ArrayList();
		try {
			log.info("Inside ProductLogic - productList() started");
			data = Product.getRealEstateDetails(productTypeId);
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
		return data;
	}
	
	public static List getProductDetails(String productId) {
		final play.Logger.ALogger log = Logger.of("productlog");
		List data = new ArrayList();
		try {
			log.info("Inside ProductLogic - productList() started");
			data = RealEstateResidential.getRealEstateResidentialDetails(productId);
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
		return data;
	}
	
	public static List getVechileList(String productId) {
		final play.Logger.ALogger log = Logger.of("productlog");
		List data = new ArrayList();
		try {
			log.info("Inside ProductLogic - getVechileList() started");
			data = Vehicles.getVehicleDetails(productId);
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
		return data;
	}
	
	public static List getComputerList(String productId) {
		final play.Logger.ALogger log = Logger.of("productlog");
		List data = new ArrayList();
		try {
			log.info("Inside ProductLogic - getComputerList() started");
			data = Computers.getCompterDetails(productId);
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
		return data;
	}
	
	public static List getCameraList(String productId) {
		final play.Logger.ALogger log = Logger.of("productlog");
		List data = new ArrayList();
		try {
			log.info("Inside ProductLogic - getCameraList() started");
			data = Cameras.getCameraDetails(productId);
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
		return data;
	}
	
	public static List getCommercialList(String productId) {
		final play.Logger.ALogger log = Logger.of("productlog");
		List data = new ArrayList();
		try {
			log.info("Inside ProductLogic - getCameraList() started");
			data = RealEstateCommercial.getCommercialDetails(productId);
			
		}catch(Exception e) {
			StringWriter errors = new StringWriter();
    		e.printStackTrace(new PrintWriter(errors));
    		log.error(errors.toString());
    		e.printStackTrace();
		}
		return data;
	}
}

