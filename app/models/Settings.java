package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.avaje.ebean.Page;

import play.db.ebean.Model;

@Entity
@Table(name="settings")
public class Settings extends Model{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	public Long settingsid;

	@Column(name="KeyName", length=256)
	public String keyname;
	
	@Column(name="Keyvalue", length=500)
	public String keyvalue;

	@Column(name="Visible", nullable=false)
	public Boolean visible;
	
	public static Finder<Long,Settings> find = new Finder<Long,Settings>(Long.class, Settings.class); 
	
	public static Page<Settings> page(int page, int pageSize, String sortBy, String order, String filter) {
        return 
            find.where()
                .ilike("keyname", "%"+filter+"%")
                .eq("visible", 1)
                .orderBy(sortBy + " " + order)
                .findPagingList(pageSize)
                .setFetchAhead(false)
                .getPage(page);
    }
	
	public static List<Settings> details(Long Id){
	    List<Settings> updatedetails = find.where().eq("settingsid", Id).findList();
	    return updatedetails;
    }
}