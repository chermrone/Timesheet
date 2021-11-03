package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.MissionRepository;

@Service
public class MissionServiceImpl implements IMissionService {
	
	@Autowired
	MissionRepository mrepo;
	@Autowired
	DepartementRepository depRepo;

	@Override
	public void addMission(Mission mission) {
		mrepo.save(mission);
		
	}

	@Override
	public void DeleteById(int id) {
		mrepo.deleteById(id);
	}
	
	public void DeleteAll() {
		mrepo.deleteAll();		
	}
	

	@Override
	public void updateMission(Mission mission) {
		mrepo.save(mission);		
	}

	@Override
	public Mission findByName(String MissionName) {

		return mrepo.findByName(MissionName);
	}

	@Override
	public List<Mission> findAll() {
		return mrepo.findAll();}

	@Override
	public List<String> MissionsNames() {
		List<String> missions = mrepo.MissionsNames();
		return missions;
		
	}

	@Override
	public Long nbreMission() {
		
		return  mrepo.count();
	}

	@Override
	public List<Mission> getAllMissionsByDepartment(Departement DEPAR) {
		
		
		return mrepo.getAllMissionByDepartment(DEPAR);
	}

}
