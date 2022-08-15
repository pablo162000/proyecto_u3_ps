package com.uce.edu.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import com.uce.edu.demo.repository.HotelRepositoryImpl;
import com.uce.edu.demo.repository.modelo.Habitacion;
import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;

@SpringBootTest
class ProyectoU3PsApplicationTests {

	@Autowired
	private HotelRepositoryImpl hotelRepositoryImpl;

	@Autowired
	private IHotelService hotelService;

	@Test
	@Order(1)
	@Transactional
	@Rollback(true)
	public void testInsertarHotel() {

		Hotel hotel1 = new Hotel();
		hotel1.setDireccion("Eloy Alfaro");
		hotel1.setNombre("Marriot");
		List<Habitacion> lista1 = new ArrayList<>();
		Habitacion habitacion1 = new Habitacion();
		habitacion1.setNumero("101");
		habitacion1.setPiso("5");
		habitacion1.setTipo("Familiar");
		habitacion1.setHotel(hotel1);
		lista1.add(habitacion1);

		hotel1.setHabitaciones(lista1);

		this.hotelService.insertarHotel(hotel1);
		assertNotNull(hotelService.buscarHotel(hotel1.getId()));
	}

	@Test
	@Order(2)
	public void testBuscarHotelOuterJoinRight() {
		List<Hotel> listaHoteles = hotelRepositoryImpl.buscarHotelOuterJoinRight();
		assertThat(listaHoteles).asList();

	}

}
