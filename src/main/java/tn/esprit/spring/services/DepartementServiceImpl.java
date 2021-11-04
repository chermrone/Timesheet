package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;

@Service
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
		Optional<Departement> d=dr.findById(departementId);
		if (d.isPresent()) {
			Departement dept=d.get();
		dr.delete(dept);}
		
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