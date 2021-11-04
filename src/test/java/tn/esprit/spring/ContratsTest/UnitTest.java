package tn.esprit.spring.ContratsTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.entities.TimesheetPK;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.TimesheetRepository;
import tn.esprit.spring.services.IContratService;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService;
import tn.esprit.spring.services.IMissionService;
import tn.esprit.spring.services.ITimesheetService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitTest {
	@Autowired
	IContratService cs;
	@Autowired
	IEmployeService es;
	@Autowired
	ITimesheetService iTimesheetService;
	@Autowired
	IEntrepriseService entrepriseService;
	@Autowired
	IMissionService ms;
	

	@MockBean
	private ContratRepository cr;
	@MockBean
	private EmployeRepository er;
	@MockBean
	private TimesheetRepository tsr;
	@MockBean
	private MissionRepository mr;
	@MockBean
	private DepartementRepository dr;
	@MockBean
	private EntrepriseRepository entr;

	private static final Logger l = LogManager.getLogger(UnitTest.class);

	//@Test(timeout = 2000)
	public void getAllTest() {
		l.info("entring to test getAllContrats");
		Contrat c1 = new Contrat();
		c1.setDateDebut(new Date());
		c1.setSalaire(11);
		c1.setTypeContrat("CDD");

		Contrat c2 = new Contrat();
		c2.setDateDebut(new Date());
		c2.setSalaire(12);
		c2.setTypeContrat("CDI");

		Contrat c3 = new Contrat();
		c3.setDateDebut(new Date());
		c3.setSalaire(13);
		c3.setTypeContrat("SIVP");

		when(cr.findAll()).thenReturn(Stream.of(c1, c2, c3).collect(Collectors.toList()));
		assertEquals(3, cs.getAll().size());
	}
	
	//@Test
	public void findByIdTest() {
		Contrat c1 = new Contrat();
		c1.setReference(100);
		c1.setDateDebut(new Date());
		c1.setSalaire(11);
		c1.setTypeContrat("CDD");
		when(cr.findById(100)).thenReturn(Optional.of(c1));
		assertEquals(c1, cs.findContratById(100));
	}

	//@Test(timeout = 2000)
	public void addandDeleteContratTest() {

		/********** without mock ***********/
		/*
		 * c.setDateDebut(new Date()); c.setSalaire(1000); c.setTypeContrat("CDI"); long
		 * nombreDeContrats = cs.nombreDeContrats();
		 * l.info("nombre initiale des contrats = " + nombreDeContrats); int addedid =
		 * cs.ajouterContrat(c); l.info("ajout avec succés de tontrat: " + addedid);
		 * assertEquals(nombreDeContrats + 1, cs.nombreDeContrats());
		 * l.info("test add success"); cs.deleteContratById(addedid);
		 * l.info("delete contrat: " + addedid); assertEquals(nombreDeContrats,
		 * cs.nombreDeContrats()); l.info("test delete success");
		 */

		/********** with mock ***********/
		Contrat c = new Contrat();
		c.setReference(24);
		c.setDateDebut(new Date());
		c.setSalaire(1000);
		c.setTypeContrat("CDI");

		when(cr.save(c)).thenReturn(c);
		l.info("affichage c: " + c);
		assertEquals(c.getReference(), cs.ajouterContrat(c));
		l.info("test add contrat success");
	}

	//@Test(timeout = 2000)
	public void affectEmplToContrat() {

		Contrat c = new Contrat();
		c.setReference(250);
		c.setDateDebut(new Date());
		c.setSalaire(100);
		c.setTypeContrat("CDD");
		when(cr.findById(250)).thenReturn(Optional.of(c));
		List<Employe> allEmloyes = es.getAllEmployes();
		c = es.affecterContratAEmploye(c.getReference(), allEmloyes.get(0).getId());
		assertEquals(c.getEmploye().getId(), cs.getById(c.getReference()).getEmploye().getId());
	}
	
	
		//@Test
		public void testAjouterTimesheet() {
			Employe emp=new Employe("Issaoui", "Wissem","wissem@gmail.com",true,Role.ADMINISTRATEUR);
			when(er.save(emp)).thenReturn(emp);
			l.info("test add contrat success");
			es.ajouterEmploye(emp);
			TimesheetPK tspk=new TimesheetPK();
			tspk.setIdEmploye(5);
			tspk.setIdMission(5);
			tspk.setDateDebut(new Date());
			tspk.setDateFin(new Date());
			Timesheet ts=new Timesheet();
			ts.setTimesheetPK(tspk);
			ts.setValide(true);
			when(tsr.save(ts)).thenReturn(ts);
			l.info("affichage ts: " + ts);
			assertEquals((ts).getTimesheetPK(), iTimesheetService.addTimeSheet(tspk,ts));
			l.info("timesheet ajouté avec succès");
		}
		//@Test
		public void testGetAllEmployeByMission(){
			
			int x = iTimesheetService.getAllEmployeByMission(6).size();
			assertThat(x).isEqualTo(3);
			l.info("test add contrat success");
		}
		
		//@Test
		public void findMissionByIdTest() {
			Mission mission = new Mission();
			mission.setId(20);
			mission.setDescription("comptable chez une société IT");
			mission.setName("comptable out sourcing");
			when(mr.findById(20)).thenReturn(Optional.of(mission));
			assertEquals(mission, ms.findMissionById(20));}
		//@Test
		public void getAllMissionsTest() {
			l.info(" Testing getAllMissions");
			Mission mission1=new Mission();
			mission1.setId(100);
			mission1.setDescription("externe");
			mission1.setName("marketing");
			Mission mission2= new Mission();
			mission2.setId(101);
			mission2.setDescription("externe");
			mission2.setName("RH");
			when(mr.findAll()).thenReturn(Stream.of(mission1,mission2).collect(Collectors.toList()));
		assertEquals(2,ms.getAll().size());
		}
		//@Test
		public void addMissionTest() {
		Mission mission = new Mission();
		mission.setId(11);
		mission.setDescription("externe");
mission.setName("marketing");

		when(mr.save(mission)).thenReturn(mission);
		l.info("la mission est: " + mission);
		assertEquals(mission.getId(), ms.ajouterMission(mission));
		l.info("mission has been added successfully");}
		/*@Test 
		public void testValiderTimesheet() {
			Entreprise entreprise=new Entreprise();
			entreprise.setId(10);
			entreprise.setName("Vermeg");
			entreprise.setRaisonSocial("IT");
			Employe employee=new Employe();
			employee.setId(10);
			employee.setRole(Role.CHEF_DEPARTEMENT);
			employee.setNom("Wissal");
			employee.setPrenom("Aouissaoui");
			employee.setActif(true);
			employee.setEmail("wissal@gmail.com");
			Employe employee2=new Employe();
			employee2.setId(11);
			employee2.setRole(Role.INGENIEUR);
			employee2.setNom("Wissem");
			employee2.setPrenom("Aouissaoui");
			employee2.setActif(true);
			employee2.setEmail("wissem@gmail.com");
			
			Departement dept=new Departement();
			dept.setId(10);
			dept.setName("Comptabilité");
			List<Departement> departementList= new ArrayList<>();
			departementList.add(dept);
			Mission mission=new Mission();
			mission.setId(10);
			mission.setName("comptabilité");
			mission.setDescription("durée de 6mois");
			mission.setDepartement(dept);
			Timesheet timesheet = new Timesheet();
			List<Timesheet> timesheetList= new ArrayList<>();
			entreprise.setDepartements(departementList);
			//entrepriseService.affecterDepartementAEntreprise(10, 10);
			//List<Departement> departementList= new ArrayList<>();
			employee.setDepartements(departementList);
			employee2.setDepartements(departementList);
			timesheet.setEmploye(employee2);
			timesheet.setMission(mission);
			timesheetList.add(timesheet);
			TimesheetPK tspk = new TimesheetPK();
			tspk.setIdMission(10);
			tspk.setDateDebut(new Date());
			tspk.setDateFin(new Date());
			tspk.setIdEmploye(11);
			timesheet.setTimesheetPK(tspk);
			employee2.setTimesheets(timesheetList);
			es.ajouterEmploye(employee);
			es.ajouterEmploye(employee2);
			entrepriseService.ajouterEntreprise(entreprise);
			iTimesheetService.ajouterMission(mission);
		entrepriseService.ajouterDepartement(dept);
		;
			when(er.save(employee)).thenReturn(employee);
			when(entr.save(entreprise)).thenReturn(entreprise);
			when(mr.save(mission)).thenReturn(mission);
			when(dr.save(dept)).thenReturn(dept);
			when(er.save(employee2)).thenReturn(employee2);
			when(tsr.save(timesheet)).thenReturn(timesheet);
			iTimesheetService.validerTimesheet(10, 10, new Date(), new Date(), 11);
			when(tsr.findBytimesheetPK(tspk)).thenReturn(timesheet);
			l.info("added");
			assertTrue(iTimesheetService.validerTimesheet(10, 10, new Date(), new Date(), 11));
	}*/
		@Test
		public void findTimesheetByPKTest() {
			Timesheet ts = new Timesheet();
			TimesheetPK tspk=new TimesheetPK(10, 10, new Date(), new Date());
			ts.setTimesheetPK(tspk);
		when(tsr.findBytimesheetPK(tspk)).thenReturn(ts);
			assertEquals(ts, iTimesheetService.findTimesheetByTimesheetPK(tspk));}
}
