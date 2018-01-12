package models;

import java.util.List;

import javax.persistence.*;

import com.avaje.ebean.Ebean;

import play.db.ebean.Model;

@Entity
@SuppressWarnings({"serial"})
public class State extends Model {

	@Id
	public int id;
	
	public String state;
	
	public static Model.Finder<Long,State> find = new Model.Finder<Long,State>(Long.class, State.class);
	
	public static List<State> vehiclesList() {
		List<State> list = Ebean.find(State.class).findList();
		return list;
	}
}
