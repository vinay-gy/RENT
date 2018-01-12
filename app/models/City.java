package models;

import java.util.List;

import javax.persistence.*;

import com.avaje.ebean.Ebean;

import play.db.ebean.Model;

@Entity
@SuppressWarnings({"serial"})
public class City extends Model {

	@Id
	public int id;
	
	@OneToOne
	public State state;
	
	public String city;
	
	public static Model.Finder<Long,City> find = new Model.Finder<Long,City>(Long.class, City.class);
	
	public static List<City> vehiclesList() {
		List<City> list = Ebean.find(City.class).findList();
		return list;
	}
}
