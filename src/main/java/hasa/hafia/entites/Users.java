package hasa.hafia.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Users implements Serializable {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		private String nom;
		private String prenom;
		private String email;
		private String password;
		private int etat;
		
		
		@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
		@JoinTable(name = "user_roles",
				joinColumns = {@JoinColumn(name="idU",nullable = false,updatable=false)},
				inverseJoinColumns = {@JoinColumn(name="idR",nullable = false,updatable=false)})
		private List<Roles> roles = new ArrayList<Roles>();

		public Users() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Users(int id, String nom, String prenom, String email, String password, int etat,
				List<Roles> roles) {
			super();
			this.id = id;
			this.nom = nom;
			this.prenom = prenom;
			this.email = email;
			this.password = password;
			this.etat = etat;
		
			this.roles = roles;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public int getEtat() {
			return etat;
		}

		public void setEtat(int etat) {
			this.etat = etat;
		}

		

		public List<Roles> getRoles() {
			return roles;
		}

		public void setRoles(List<Roles> roles) {
			this.roles = roles;
		}
		
		
	

}
