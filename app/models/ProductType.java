package models;


import java.util.List;

import javax.persistence.*;

import com.avaje.ebean.Ebean;

import play.db.ebean.Model;

@Entity
@SuppressWarnings("serial")
public class ProductType extends Model {

	@Id
	public int id;
	
	public String productType;
	
	@OneToOne
	public SubCategories subCategory;
	
	public Boolean isMapped;
	
	public String route;
	
	public String isActive;
	
	public String isDeleted;
	
	public static Model.Finder<Long,ProductType> find = new Model.Finder<Long,ProductType>(Long.class, ProductType.class);
	
	public static List<ProductType> productTypeList() {
		List<ProductType> product = Ebean.find(ProductType.class).findList();
		return product;
	}
	
	public static List<ProductType> productTypeList(String subCategoryId) {
		List<ProductType> list = ProductType.find.where().eq("subCategory.id", subCategoryId).eq("isDeleted","0").eq("isActive","1").findList();
		return list;
	}
}
