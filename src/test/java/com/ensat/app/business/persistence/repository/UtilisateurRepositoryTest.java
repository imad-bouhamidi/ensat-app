package com.ensat.app.business.persistence.repository;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ensat.app.business.persistence.entities.Utilisateur;
import com.ensat.app.business.persistence.repositories.RoleRepository;
import com.ensat.app.business.persistence.repositories.UtilisateurRepository;

@RunWith(JUnit4.class)
public class UtilisateurRepositoryTest {

	private static UtilisateurRepository utilisateurRepository;
	private static RoleRepository roleRepository;
	private static AbstractApplicationContext context;

	@BeforeClass
	public static void initHibernate() throws Exception {
		// service = new CourseServiceImpl(new CourseDaoJdbc());
		try {
			context = new ClassPathXmlApplicationContext("applicationContext-persistence.xml");
			utilisateurRepository = context.getBean(UtilisateurRepository.class);
			roleRepository = context.getBean(RoleRepository.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void testFindAllUtilisateurs() {
		try {
			long count = utilisateurRepository.count();
			System.out.println(count);
			Assert.assertEquals(2, count);
			Iterator<Utilisateur> iterateur = utilisateurRepository.findAll().iterator();
			while(iterateur.hasNext()) {
				Utilisateur u = iterateur.next();
				System.out.println("username = " + u.getNom());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	public void testModifierUtilisateur1() {
		try {
			Utilisateur u = utilisateurRepository.findOne(1l);
			Assert.assertNotNull(u);
			u.setNom("adminNomModified3");
//			Role role = new Role();
//			role.setId(12l);
//			role.setCode("ROLE_X");
//			role.setLibelle("Rôle x");
//			roleRepository.save(role);
//			System.out.println(role.getId());
//			u.getRoles().add(role);
			u.getRoles().remove(1);
			utilisateurRepository.save(u);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Test
	public void testFindUtilisateurByEmail() {
		Utilisateur u = utilisateurRepository.findByEmail("admin@ensat.com");
		Assert.assertNotNull(u);
		System.out.println(u.getLogin());
	}

}
