package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import play.db.ebean.Model;
@Entity
public class Cameras extends Model {
	@Id
	public int id;
	
	public String brand;
	public String model;
	public String age;
	public boolean anyDamages;
	public boolean additional;
	public boolean pickUpDrop;
	public boolean anyAccessories;
	@OneToOne
	public ProductType product;
	@Column(length=500)
	public String description;
	
	public static Model.Finder<Long,Cameras> find = new Model.Finder<Long,Cameras>(Long.class, Cameras.class);
	
	public static List<Cameras> getCameraDetails(String productId) {
		List<Cameras> list = Cameras.find.where().eq("product.id", productId).findList();
		return list;
	}

 }
