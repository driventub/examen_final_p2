package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Vuelo;

@Repository
@Transactional
public class VueloRepoImpl implements IVueloRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Vuelo> buscarVuelos(String origen, String destino, LocalDateTime fechaVuelo) {
		TypedQuery<Vuelo> myQuery = this.entityManager.createQuery(
				"SELECT v FROM Vuelo v JOIN Avion a WHERE v.origen = :origen AND v.destino = :destino AND v.fechaVuelo = :fechaVuelo",
				Vuelo.class).setParameter("fechaVuelo", fechaVuelo).setParameter("origen", origen)
				.setParameter("destino", destino);
		return myQuery.getResultList();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Vuelo buscarNumero(String numero) {
		TypedQuery<Vuelo> myQuery = this.entityManager
				.createQuery("SELECT v FROM Vuelo v WHERE v.numero = :numero AND v.estado = 'DIS'", Vuelo.class)
				.setParameter("numero", numero);

		return myQuery.getSingleResult();
	}

	@Override
	public void actualizar(Vuelo v) {
		this.entityManager.merge(v);
		
	}

}
