package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

		logJava.info("INNER JOIN");
		List<Factura> listaFacturas = this.facturaService.buscarFacturaInnerJoin(10);
		for (Factura item : listaFacturas) {
			logJava.info("Numero: " + item.getNumero() + " " + "Fecha: " + item.getFecha());
		}

		logJava.info("INNER JOIN sin WHERE");
		List<Factura> listaFaturas2 = this.facturaService.buscarFacturaInnerJoin();
		for (Factura item : listaFaturas2) {
			logJava.info("Numero: " + item.getNumero() + " " + "Fecha: " + item.getFecha());
		}

		logJava.info("OUTER LEFT JOIN ");
		List<Factura> listaFaturas3 = this.facturaService.buscarFacturaOuterJoinLeft(10);

		for (Factura factura : listaFaturas3) {
			logJava.info("Numero: " + factura.getNumero() + " " + "Fecha: " + factura.getFecha());
		}

		logJava.info("OUTER LEFT JOIN sin WHERE");
		List<Factura> listaFactura4 = this.facturaService.buscarFacturaOuterJoinLeft();
		for (Factura factura : listaFactura4) {
			logJava.info("Numero: " + factura.getNumero() + " " + "Fecha: " + factura.getFecha());
		}

		logJava.info("OUTER RIGHT JOIN");
		List<Factura> listaFactura5 = this.facturaService.buscarFacturaOuterJoinRight(10);
		for (Factura factura : listaFactura5) {
			logJava.info("Numero: " + factura.getNumero() + " " + "Fecha: " + factura.getFecha());
		}

		logJava.info("OUTER RIGHT JOIN sin WHERE");
		List<Factura> listaFactura6 = this.facturaService.buscarFacturaOuterJoinRight();
		for (Factura factura : listaFactura6) {
			logJava.info("Numero: " + factura.getNumero() + " " + "Fecha: " + factura.getFecha());
		}

	}

}
