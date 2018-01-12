package models;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

import com.avaje.ebean.Ebean;

import play.db.ebean.Model;

@Entity
@SuppressWarnings("serial")
public class Product extends Model {

	@Id
	public int id;
	
	public String title;
	
	@Column(length=1000)
	public String description;
	
	@OneToOne
	public ProductType productType;
	
	@OneToOne
	public Categories categories;
	
	@OneToOne
	public SubCategories subCategories;
	
	@OneToOne
	public Customer customer;
	
	public String email;
	
	public String mobile;
	
	public String address;
	
	public State state;
	
	public City city;
	
	public Locality locality;
	
	public String duration;
	
	@Column(precision=12, scale=2)
	public BigDecimal  price;
	
	@Column(precision=12, scale=2)
	public BigDecimal  deposit;
	
	public Boolean isDepositOptional;
	
	public Boolean isNegotiable;
	
	public Boolean isRefundable;
	
	public Timestamp postedDate;

	public String imagePath;
	
	public String videoPath;
	
	public String views;
	
	public String likes;
	
	public Boolean isActive;
	
	public Boolean isAvailable;
	
	public Boolean isHidden;
	
	public Boolean isDeleted;
	
	public String searchKey;
	
	public static Model.Finder<Long,Product> find = new Model.Finder<Long,Product>(Long.class, Product.class);
	
	public static List<Product> productList() {
		List<Product> product = Ebean.find(Product.class).findList();
		return product;
	}
	
	public static List<Product> productList(String pid) {
		List<Product> product = Ebean.find(Product.class).where().eq("id", pid).findList();
		return product;
	}
	
	public static List<Product> getRealEstateDetails(String productId) {
		List<Product> list = Product.find.where().eq("categories.id", productId).eq("isDeleted","0").eq("isActive","1").findList();
		return list;
	}
}
