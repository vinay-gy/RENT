package models;

import java.util.List;

import javax.persistence.*;

import com.avaje.ebean.Ebean;

import play.db.ebean.Model;

@Entity
@SuppressWarnings({"serial"})
public class Locality extends Model {

	@Id
	public int id;
	
	@OneToOne
	public City city;
	
	public String locality;
	
	public static Model.Finder<Long,Locality> find = new Model.Finder<Long,Locality>(Long.class, Locality.class);
	
	public static List<Locality> vehiclesList() {
		List<Locality> list = Ebean.find(Locality.class).findList();
		return list;
	}
	
	
}
