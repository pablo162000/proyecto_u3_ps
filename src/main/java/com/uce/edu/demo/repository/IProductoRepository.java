package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Producto;

public interface IProductoRepository {
	
	public void insertarProducto(Producto producto) ;
	
	public Producto buscarProducto(String codigoBarras);
	
	public void actualizar(Producto producto);

	
	
		


}
