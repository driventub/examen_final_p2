package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.CompraPasaje;
import com.example.demo.repository.modelo.Vuelo;
import com.example.demo.service.IGestorService;
import com.example.demo.service.IVueloService;

@Controller
@RequestMapping("/vuelos")
public class VueloController {
	
	@Autowired
	private IGestorService gestorService;
	
	@Autowired
	private IVueloService vueloService;
	
	@GetMapping("/buscarVuelos")
	public String buscarVuelos(Vuelo vuelo) {
		return "vuelos_buscar";
	}
	
	@GetMapping("/buscar")
	public String buscar(Vuelo vuelo, Model modelo) {
		
		List<Vuelo> lista = this.vueloService.buscarVuelos(vuelo.getOrigen(),vuelo.getDestino(), vuelo.getFechaVuelo());
		modelo.addAttribute("vuelos", lista);
		
		return "vuelos_mostrar";
	}
	
	@GetMapping("/buscarNumero")
	public String buscarNumero(Vuelo vuelo) {
		return "vuelos_buscar_numero";
	}
	
	@GetMapping("/reservarPasaje")
	public String reservarPasaje(CompraPasaje vuelo, Model modelo) {
		
		Vuelo vBuscado = this.vueloService.buscarNumero(vuelo.getNumero());
		modelo.addAttribute(vBuscado);
		
		return "reservar";
	}
	
	@PostMapping("/reservar")
	public String reservar(CompraPasaje compraPasaje) {
		this.gestorService.reservarPasajeros(compraPasaje.getCantidadAsientosComprados(), compraPasaje.getCliente().getCedula(), null);
		
		
		return "listo";
	}
}
