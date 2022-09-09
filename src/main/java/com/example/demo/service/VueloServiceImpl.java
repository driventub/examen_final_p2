package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IVueloRepo;
import com.example.demo.repository.modelo.Vuelo;

@Service
public class VueloServiceImpl implements IVueloService{
	
	@Autowired
	private IVueloRepo vueloRepo;

	@Override
	public List<Vuelo> buscarVuelos(String origen, String destino, LocalDateTime fechaVuelo) {
		// TODO Auto-generated method stub
		return this.vueloRepo.buscarVuelos(origen, destino, fechaVuelo);
	}

	@Override
	public Vuelo buscarNumero(String numero) {
		// TODO Auto-generated method stub
		return this.vueloRepo.buscarNumero(numero);
	}

	@Override
	public void actualizar(Vuelo v) {
		this.vueloRepo.actualizar(v);
		
	}
}
