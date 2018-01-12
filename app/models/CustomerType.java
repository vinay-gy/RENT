package models;

import javax.persistence.*;

import play.db.ebean.Model;

@Entity
@SuppressWarnings("serial")
public class CustomerType extends Model {

	@Id
	public int id;
	
	public String customerType;
	
	public Boolean isDeleted;
	
	public Boolean isActive;
}
