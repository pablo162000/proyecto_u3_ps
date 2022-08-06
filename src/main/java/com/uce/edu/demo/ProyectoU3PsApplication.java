package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.repository.modelo.Habitacion;
import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IFacturaService;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3PsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3PsApplication.class, args);
	}

	private static Logger logJava = Logger.getLogger(ProyectoU3PsApplication.class);

	@Autowired
	private IHotelService hotelService;

	@Autowired
	private IFacturaService facturaService;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

//		List<Hotel> listaHoteles = this.hotelService.buscarHotelInnerJoin("Matrimonial");
//	
//		for(Hotel item : listaHoteles) {
//			logJava.info(item + item.getNombre() + " " +item.getDireccion());
//		}
//		
//		//LEFT
//		List<Hotel> listaHotelesLeft = this.hotelService.buscarHotelOuterJoinLeft("Matrimonial");
//		
//		for(Hotel item : listaHotelesLeft) {
//			logJava.info(item + item.getNombre() + " " +item.getDireccion());
//		}
//		
//		
//		//RIGHT
//		List<Hotel> listaHotelesRight = this.hotelService.buscarHotelOuterJoinRight("Matrimonial");
//		
//		for(Hotel item : listaHotelesRight) {
//			logJava.info(item + item.getNombre() + " " +item.getDireccion());
//		}
//		
//		
//		// LEFT
//		List<Hotel> listaHotelesLeft2 = this.hotelService.buscarHotelOuterJoinLeft();
//		for (Hotel h : listaHotelesLeft2) {
//			logJava.info("Hotel2: " + h.getNombre() + " " + h.getDireccion());
//		}

//		List<Factura> listaFacturas = this.facturaService.buscarFacturaInnerJoin(10);
//		for(Factura item:listaFacturas) {
//			logJava.info(item + item.getNumero()+item.getFecha());
//		}

		logJava.info("");

		List<Hotel> listaHoteles = this.hotelService.buscarHotelJoinWhere("Matrimonial");

		for (Hotel item : listaHoteles) {
			logJava.info("Hotel : " + "nombre: " + item.getNombre() + "direccion: " + item.getDireccion());
		}

		

		
		logJava.info("INNER JOIN EAGER/LAZY");
		List<Hotel> listaHoteles2 = this.hotelService.buscarHotelInnerJoin("Matrimonial");
		for (Hotel h : listaHoteles2) {
			logJava.info("Hotel2: " + h.getNombre() + " " + h.getDireccion());
			for (Habitacion ha : h.getHabitaciones()) {
				logJava.info("Habitacion2: " + ha);
			}

		}
		
		logJava.info("JOIN FETCH");
		List<Hotel> listaHoteles3 = this.hotelService.buscarHotelJoinFetch("Matrimonial");
		for (Hotel h : listaHoteles3) {
			logJava.info("Hotel3: " + h.getNombre() + " " + h.getDireccion());
			for (Habitacion ha : h.getHabitaciones()) {
				logJava.info("Habitacion3: " + ha);
			}

		}

	}

}
