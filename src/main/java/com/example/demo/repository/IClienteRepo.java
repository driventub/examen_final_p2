package com.example.demo.repository;

import com.example.demo.repository.modelo.Cliente;

public interface IClienteRepo {
	public Cliente buscarCedula(String cedula);
}
