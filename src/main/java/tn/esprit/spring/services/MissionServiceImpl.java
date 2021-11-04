package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.MissionRepository;

@Service
public class MissionServiceImpl implements IMissionService {

	@Autowired
	MissionRepository mr;
	@Override
	public List<Mission> getAll() {
		return (List<Mission>) mr.findAll();
	}

	@Override
	public int ajouterMission(Mission mission) {
		mr.save(mission);
		return mission.getId();
	}

	@Override
	public void deleteMissionById(int missionId) {
		Optional<Mission> m=mr.findById(missionId);
		if (m.isPresent()) {
			Mission mission=m.get();
		mr.delete(mission);}
		
		}
		

	@Override
	public long nombreDeMissions() {
		return mr.count();
	}

	@Override
	public Mission findMissionById(int id) {
		return mr.findById(id).orElse(null);
	}

}
