package models;


import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

import com.avaje.ebean.Ebean;

import play.db.ebean.Model;

@Entity
@SuppressWarnings("serial")
public class Customer extends Model {

	@Id
	public int id;
	
	@OneToOne
	public CustomerType customerType;
	
	public String loginId;
	
	public String password;
	
	public String name;
	
	public String dob;
	
	public String email;
	
	public String mobile;
	
	public String state;
	
	public String city;
	
	public String locality;
	
	public String pincode;
	
	public String address;
	
	public Timestamp joinDate;
	
	public Boolean isActive;
	
	public Boolean isDeleted;
	
	public String ratings;
	
	public static Model.Finder<Long,Customer> find = new Model.Finder<Long,Customer>(Long.class, Customer.class);
	
	public static List<Customer> categoryList() {
		List<Customer> Customer = Ebean.find(Customer.class).findList();
		return Customer;
	}
	
	public static List<Customer> authenticate(String Id, String pass){
		  
	     List<Customer> users = find.where().eq("email", Id).eq("password", pass).findList();
	     return users;
	    }
}
