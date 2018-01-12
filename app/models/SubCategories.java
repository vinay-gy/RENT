package models;

import java.util.List;

import javax.persistence.*;

import com.avaje.ebean.Ebean;

import play.db.ebean.Model;

@Entity
@SuppressWarnings({ "serial", "unused" })
public class SubCategories extends Model {

	@Id
	public int id;
	
	public String subCategory;
	
	@OneToOne
	@Column(name="category_id")
	public Categories category;
	
	public Boolean isDeleted;
	
	public Boolean isActive;
	
	public static Model.Finder<Long,SubCategories> find = new Model.Finder<Long,SubCategories>(Long.class, SubCategories.class);
	
	public static List<SubCategories> subCategoryList() {
		List<SubCategories> list = SubCategories.find.where().eq("isDeleted","0").eq("isActive","1").findList();
		return list;
	}
	
	public static List<SubCategories> subCategoryList(String categoryId) {
		List<SubCategories> list = SubCategories.find.where().eq("category.id", categoryId).eq("isDeleted","0").eq("isActive","1").findList();
		return list;
	}
}
