package models;

import java.util.List;

import javax.persistence.*;

import com.avaje.ebean.Ebean;

import play.db.ebean.Model;

@Entity
@SuppressWarnings({"serial"})
public class Vehicles extends Model {
	
	@Id
	public int id;
	
	public String brand;
	
	@OneToOne
	public Product product;
	
	@Column(length=1000)
	public String description;
	
	public String vehicleType;
	
	public String year;
	
	public String kmDriven;
	
	public String model;
	
	public Boolean isWithDriver;
	
	public Boolean saftyKit;

	public Boolean rcBook;
	
	public Boolean pickAndDrop;
	
	public Boolean helmet;
	
	public static Model.Finder<Long,Vehicles> find = new Model.Finder<Long,Vehicles>(Long.class, Vehicles.class);
	
	public static List<Vehicles> vehiclesList() {
		List<Vehicles> list = Ebean.find(Vehicles.class).findList();
		return list;
	}
	
	public static List<Vehicles> getVehicleDetails(String productId) {
		List<Vehicles> list = Vehicles.find.where().eq("product.id", productId).findList();
		return list;
	}
}
