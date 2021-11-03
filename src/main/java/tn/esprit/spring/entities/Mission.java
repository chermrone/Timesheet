package tn.esprit.spring.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Mission implements Serializable {

	private static final long serialVersionUID = -5369734855993305723L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "this field is required")
    @Size(min = 3,message="Enter a valid name ! at least 3 caracters ! ")
	@Size(max=12,message="Enter a valid name ! at max 20 caracters !")
	private String name;
	private String description;
	private Date dateDébut;
	private int Durée ; 
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Departement departement;
	
	@OneToMany(mappedBy="mission",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private  List<Timesheet> timesheets;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "idEmploye", insertable=false, updatable=false)

	private Employe employe;
	
	
	
	
	
	
	
	public Mission() {
		super();
	}


	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public List<Timesheet> getTimesheets() {
		return timesheets;
	}

	public void setTimesheets(List<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}

	public Date getDateDébut() {
		return dateDébut;
	}

	public void setDateDébut(Date dateDébut) {
		this.dateDébut = dateDébut;
	}

	public int getDurée() {
		return Durée;
	}

	public void setDurée(int durée) {
		Durée = durée;
	}




	public Mission(int id, String name, String description, Date dateDébut, int durée, Departement departement,
			List<Timesheet> timesheets) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.dateDébut = dateDébut;
		Durée = durée;
		this.departement = departement;
		this.timesheets = timesheets;
	}
	
	public Mission( String name, String description, Date dateDébut, int durée, Departement departement,
			List<Timesheet> timesheets) {
		super();
		this.name = name;
		this.description = description;
		this.dateDébut = dateDébut;
		Durée = durée;
		this.departement = departement;
		this.timesheets = timesheets;
	}

}
