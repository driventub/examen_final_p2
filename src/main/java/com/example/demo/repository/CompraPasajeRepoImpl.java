package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.CompraPasaje;

@Repository
@Transactional
public class CompraPasajeRepoImpl implements ICompraPasajeRepo{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(CompraPasaje compra) {
		this.entityManager.persist(compra);
	}
	
}
