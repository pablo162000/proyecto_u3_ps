package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.DetalleFactura;
import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.service.IFacturaService;

@SpringBootApplication
public class ProyectoU3PsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3PsApplication.class, args);
	}

	private static Logger logJava = Logger.getLogger(ProyectoU3PsApplication.class);

	@Autowired
	private IFacturaService facturaService;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		

		logJava.info("JOIN WHERE");

		List<Factura> listaFactura7 = this.facturaService.buscarFacturaJoinWhere(10);
		for (Factura factura : listaFactura7) {
			logJava.info("Numero: " + factura.getNumero() + " " + "Fecha: " + factura.getFecha());
			for (DetalleFactura de : factura.getDetalles()) {
				logJava.info("Detealles: " + de);
			}

		}

		logJava.info("Fetch WHERE");
		
		List<Factura> listaFactura8 = this.facturaService.buscarFacturaJoinFetch(10);
		for (Factura factura : listaFactura8) {
			logJava.info("Numero: " + factura.getNumero() + " " + "Fecha: " + factura.getFecha());
			for (DetalleFactura de : factura.getDetalles()) {
				logJava.info("Detealles: " + de);
			}

		}

	}

}
