package com.example.demo.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IClienteRepo;
import com.example.demo.repository.ICompraPasajeRepo;
import com.example.demo.repository.IVueloRepo;
import com.example.demo.repository.modelo.Cliente;
import com.example.demo.repository.modelo.CompraPasaje;
import com.example.demo.repository.modelo.Vuelo;

@Service
public class GestorServiceImpl implements IGestorService{
	
	@Autowired
	private ICompraPasajeRepo compraRepo;
	
	@Autowired
	private IVueloRepo vueloRepo;
	
	@Autowired
	private IClienteRepo clienteRepo;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void reservarPasajeros(Integer cantidadAsientos, String cedulaCliente, Vuelo v) {
		CompraPasaje compraPasaje = new CompraPasaje();
		Vuelo vuelo = this.vueloRepo.buscarNumero(v.getNumero());
		Cliente cliente = this.clienteRepo.buscarCedula(cedulaCliente);
		
		
		compraPasaje.setNumero("AAA-111");
		compraPasaje.setCantidadAsientosComprados(cantidadAsientos);
		compraPasaje.setCliente(cliente);
		compraPasaje.setEstado("RES");
		compraPasaje.setFechaCompra(LocalDateTime.now());
		compraPasaje.setVuelo(vuelo);
		
		
		vuelo.setAsientosDisponibles(vuelo.getAsientosDisponibles() - cantidadAsientos);
		
		this.compraRepo.insertar(compraPasaje);
		this.vueloRepo.actualizar(v);
		
		
		
		
		
	}

}
