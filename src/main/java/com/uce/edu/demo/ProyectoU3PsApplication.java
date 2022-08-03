package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3PsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3PsApplication.class, args);
	}

	private static Logger logJava = Logger.getLogger(ProyectoU3PsApplication.class);

	@Autowired
	private IHotelService hotelService;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		List<Hotel> listaHoteles = this.hotelService.buscarHotelInnerJoin("Familiar");
	
		for(Hotel item : listaHoteles) {
			logJava.info(item + item.getNombre() + " " +item.getDireccion());
		}
		
		//LEFT
		List<Hotel> listaHotelesLeft = this.hotelService.buscarHotelOuterJoinLeft("Familiar");
		
		for(Hotel item : listaHotelesLeft) {
			logJava.info(item + item.getNombre() + " " +item.getDireccion());
		}
		
		
		//RIGHT
		List<Hotel> listaHotelesRight = this.hotelService.buscarHotelOuterJoinRight("Matrimonial");
		
		for(Hotel item : listaHotelesRight) {
			logJava.info(item + item.getNombre() + " " +item.getDireccion());
		}
		
		
		// LEFT
		List<Hotel> listaHotelesLeft2 = this.hotelService.buscarHotelOuterJoinLeft();
		for (Hotel h : listaHotelesLeft2) {
			logJava.info("Hotel2: " + h.getNombre() + " " + h.getDireccion());
		}
	
	}

}
