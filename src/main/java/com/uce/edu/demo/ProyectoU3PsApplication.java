package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.Ciudadano;
import com.uce.edu.demo.repository.modelo.Cliente;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.service.ICiudadanoService;
import com.uce.edu.demo.service.ICompraService;
import com.uce.edu.demo.service.IFacturaService;
import com.uce.edu.demo.service.IProductoService;

@SpringBootApplication
public class ProyectoU3PsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3PsApplication.class, args);
	}

	private static Logger logJava = Logger.getLogger(ProyectoU3PsApplication.class);

	@Autowired
	private IProductoService iProductoService;
	
	@Autowired
	private ICiudadanoService iCiudadanoService;
	
	@Autowired
	private IProductoRepository iProductoRepository;
	
	@Autowired
	private ICompraService iCompraService;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub



	}

}
