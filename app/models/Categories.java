package models;

import java.util.List;

import javax.persistence.*;
import play.db.ebean.Model;

@Entity
@SuppressWarnings({"serial"})
public class Categories extends Model {

	@Id
	public int id;
	
	public String category;
	
	public Boolean isDeleted;
	
	public Boolean isActive;
	
	public static Model.Finder<Long,Categories> find = new Model.Finder<Long,Categories>(Long.class, Categories.class);
	
	public static List<Categories> categoryList() {
		List<Categories> categories = Categories.find.where().eq("isDeleted","0").eq("isActive","1").findList();
		return categories;
	}
	
}
