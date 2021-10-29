package tn.esprit.spring.services;

import java.util.List;


import tn.esprit.spring.entities.Mission;

public interface IMissionService {
	public List<Mission> getAll();
	public int ajouterMission(Mission mission);
	public void deleteMissionById(int missionId);
	public long nombreDeMissions();
	public Mission findMissionById(int id);

}
