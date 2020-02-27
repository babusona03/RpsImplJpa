package com.miniclip.model;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
//import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;



@Transactional
@RequestScoped
@Named
public class RpsService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	EntityManager entityManager;
	
	public RpsService(){}
	
	public RpsData createRpsData(RpsData rpsData) {
		entityManager.persist(rpsData);
		return rpsData;
	}
	
	
	public List<RpsData> getAllRpsData(){
		return entityManager.createQuery("SELECT e from RpsData e",RpsData.class).getResultList();
	}	
	@PostConstruct	
	private void showPostConstrct() {
		System.out.println("After Construction.");
	}
	@PreDestroy
	private void showPreDestroy() {
		System.out.println("Before Ddestruction.");
	}	
	
	/*
	public RpsData createRpsData(String userChoice, String systemChoice, String winner){
		emf = Persistence.createEntityManagerFactory("RpsGame");
		em= emf.createEntityManager();
		rpsData= new RpsData();
		rpsData.setUserChoice(userChoice); 
		rpsData.setSystemChoice(systemChoice);
		rpsData.setWinner(winner);
		em.getTransaction().begin();
		em.persist(rpsData);
		em.flush();
		em.getTransaction().commit();
		em.close();
		emf.close();
		return rpsData;
	}
	
	public List<RpsData> readRpsData(){		
		emf = Persistence.createEntityManagerFactory("RpsGame");
		em = emf.createEntityManager();
		TypedQuery<RpsData> query = em.createQuery("SELECT e FROM RpsData e",RpsData.class);
		List<RpsData> rpsData = query.getResultList();
		em.close();
		emf.close();
		return rpsData;
	}*/	
}