package models;


import java.util.List;

import javax.persistence.*;

import com.avaje.ebean.Ebean;

import play.db.ebean.Model;

@Entity
@SuppressWarnings("serial")
public class RealEstateResidential extends Model {

	@Id
	public int id;
	
	@OneToOne
	public Product product;
	
	@Column(length=1000)
	public String description;
	
	public String squreFeets;
	
	public String floorNo;
	
	public String propertyAge;
	
	public String propertyType;
	
	public String foodType;
	
	public String toiletType;
	
	public String isFurnished;
	
	public String isParkingAvailable;
	
	public String waterSupply;
	
	public String balcony;
	
	public String powerBackup;
	
	public String security;
	
	public static Model.Finder<Long,RealEstateResidential> find = new Model.Finder<Long,RealEstateResidential>(Long.class, RealEstateResidential.class);
	
	public static List<RealEstateResidential> categoryList() {
		List<RealEstateResidential> list = Ebean.find(RealEstateResidential.class).findList();
		return list;
	}
	
	public static List<RealEstateResidential> getRealEstateResidentialDetails(String productId) {
		List<RealEstateResidential> list = RealEstateResidential.find.where().eq("product.id", productId).findList();
		return list;
	}
}
