package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.avaje.ebean.Ebean;

import play.db.ebean.Model;

@Entity
@SuppressWarnings({"serial"})
public class Computers extends Model {

	@Id 
	public int id;
	
	public String brand ;
	
	public String model ;
	
	@OneToOne 
	public Product product;
	
	public String ram;
	
	public String hardDisk;
	
	public String processor;
	
	public Boolean anyDamages;
	
	public String damageDetails;
	
	@Column(length=1000)
	public String discription;
	
	public Boolean picAndDrop;
	
	public Boolean accessories;
	
	public static Model.Finder<Long,Computers> find = new Model.Finder<Long,Computers>(Long.class, Computers.class);
	
	public static List<Computers> vehiclesList() {
		List<Computers> list = Ebean.find(Computers.class).findList();
		return list;
	}
	
	public static List<Computers> getCompterDetails(String productId) {
		List<Computers> list = Computers.find.where().eq("product.id", productId).findList();
		return list;
	}
	
}
