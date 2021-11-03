package tn.esprit.spring.services;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Mission;



public interface IMissionService {
	
	void addMission(Mission mission);
	void DeleteById(@PathVariable("id") int id) ;
	void updateMission(Mission mission) ;
	Mission findByName(@Param("missionName") String MissionName);
	List<Mission> findAll() ;
	List<String> MissionsNames();
    Long nbreMission();
    List<Mission> getAllMissionsByDepartment(@Param("dep") Departement DEPAR);
    
	
	
	
	

}
