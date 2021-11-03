package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Mission;

@Repository
public interface MissionRepository extends CrudRepository<Mission, Integer> {
	@Query("select m from Mission m where m.name=:MissionName")
	Mission findByName(@Param("MissionName") String MissionName);
	
	List<Mission> findAll() ;
	
	@Query("select name from Mission")
	List<String> MissionsNames();
	
	@Query("SELECT count(*) FROM Mission")
    int nbreMission();
	
	
    @Query("Select "
			+ "DISTINCT m from Mission m "
			+ "join m.departement deps "
			+ "where deps=:dep")
     List<Mission> getAllMissionByDepartment(@Param("dep") Departement DEPAR);
    
    
	
	
	

}
