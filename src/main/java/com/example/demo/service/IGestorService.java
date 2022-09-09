package com.example.demo.service;

import com.example.demo.repository.modelo.Vuelo;

public interface IGestorService {
	public void reservarPasajeros(Integer cantidadAsientos, String cedulaCliente, Vuelo vuelo);
}
