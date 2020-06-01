package hasa.hafia.entites;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Notification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String message;
	//@Temporal(javax.persistence.TemporalType.DATE)
	private Date datecreation;
	@Column
	private Boolean status;
	
	/*@ManyToMany (fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "notification")
	private List<Users> user = new ArrayList<Users>();*/


	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notification(int id, String message, Date datecreation, Boolean status, List<Users> user) {
		super();
		this.id = id;
		this.message = message;
		this.datecreation = datecreation;
		this.status = status;
		//this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDatecreation() {
		return datecreation;
	}

	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	/*public List<Users> getUser() {
		return user;
	}

	public void setUser(List<Users> user) {
		this.user = user;
	}*/


}
