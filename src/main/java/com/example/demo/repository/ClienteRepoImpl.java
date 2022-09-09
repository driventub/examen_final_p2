package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Cliente;
import com.example.demo.repository.modelo.Vuelo;

@Repository
@Transactional
public class ClienteRepoImpl implements IClienteRepo {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Cliente buscarCedula(String cedula) {
		TypedQuery<Cliente> myQuery = this.entityManager
				.createQuery("SELECT c FROM Cliente c WHERE c.cedula = :cedula ", Cliente.class)
				.setParameter("cedula", cedula);

		return myQuery.getSingleResult();
	}

}
