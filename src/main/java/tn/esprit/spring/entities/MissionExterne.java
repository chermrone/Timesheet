package tn.esprit.spring.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class MissionExterne extends Mission {
	
	private static final long serialVersionUID = -3046278688391172322L;
	
	
	private String emailFacturation;
	
	
	private float tauxJournalierMoyen;

	
	public MissionExterne() {
		super();
	}


	public MissionExterne (int id, String name, String description, Date dateDébut, int durée, Departement departement,
	 String emailFacturation, float tauxJournalierMoyen) {
		super();
		this.emailFacturation = emailFacturation;
		this.tauxJournalierMoyen = tauxJournalierMoyen;
	}


	public String getEmailFacturation() {
		return emailFacturation;
	}


	public void setEmailFacturation(String emailFacturation) {
		this.emailFacturation = emailFacturation;
	}


	public float getTauxJournalierMoyen() {
		return tauxJournalierMoyen;
	}


	public void setTauxJournalierMoyen(float tauxJournalierMoyen) {
		this.tauxJournalierMoyen = tauxJournalierMoyen;
	}
	
	
	

}
