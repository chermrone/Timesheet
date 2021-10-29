package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Departement;

public interface IDepartmentService {
	public List<Departement> getAll();
	public int ajouterDepartement(Departement departement );
	public void deleteDepartementById(int missionId);
	public long nombreDeDepartements();
	public Departement findDepartementById(int id);
}
