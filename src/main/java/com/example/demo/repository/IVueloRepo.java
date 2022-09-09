package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.repository.modelo.Vuelo;

public interface IVueloRepo {
	public List<Vuelo> buscarVuelos(String origen, String destino, LocalDateTime fechaVuelo);
	public Vuelo buscarNumero(String numero);
	public void actualizar(Vuelo v);
}
