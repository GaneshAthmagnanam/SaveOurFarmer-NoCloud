package com.yaalis.savefarmer.savefarmer.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class FarmerDatabase {

	@PersistenceContext	
	private EntityManager entityManager;
	
	public void getFarmerDetails(){
		List<?> list =(List<?>) entityManager.createQuery("SELECT id FROM farmer_details").getResultList();
		if(!list.isEmpty()) {
			System.out.println("Finally###########"+list.get(0));
		}
		else{
			System.out.println("Failed###########");
		}
	}
}