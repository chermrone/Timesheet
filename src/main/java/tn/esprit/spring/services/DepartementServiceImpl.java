package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;

public class DepartementServiceImpl implements IDepartmentService{

	@Autowired
	DepartementRepository dr;
	@Override
	public List<Departement> getAll() {
		return (List<Departement>) dr.findAll();
	}

	@Override
	public int ajouterDepartement(Departement departement) {
		dr.save(departement);
		return departement.getId();
	}

	@Override
	public void deleteDepartementById(int departementId) {
		if (dr.findById(departementId).get()!=null) {
			Departement departement=dr.findById(departementId).get();
			dr.delete(departement);}
		
	}

	@Override
	public long nombreDeDepartements() {
		return dr.count();
	}

	@Override
	public Departement findDepartementById(int id) {
		return dr.findById(id).orElse(null);
	}

}
