package tn.esprit.spring.services;

import java.util.List;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;

@Service
public class ContratServiceImpl implements IContratService {
	
	@Autowired ContratRepository cr;
	@Override
	public List<Contrat> getAll() {
		 
		return(List<Contrat>) cr.findAll();
	}
	
	@Override
	public int ajouterContrat(Contrat contrat) {
		 cr.save(contrat);
		 return contrat.getReference();
	}
	
	@Override
	public void deleteContratById(int contratId) {
	 
		 
		Contrat contratManagedEntity = cr.findById(contratId).orElse(null);
		if(contratManagedEntity!=null)
		{cr.delete(contratManagedEntity );}
	}

	@Override
	public Contrat getById(int id) {
	 
		return cr.findById(id).orElse(null);
	}

	@Override
	public long nombreDeContrats() {
		 
		return cr.count();
	}

}
