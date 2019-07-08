package com.arquitecturajava.aplicacion.dao;

import java.util.List;

import com.arquitecturajava.aplicacion.bo.Categoria;

public interface CategoriaDAO {

	public abstract List<Categoria> buscarTodos();

	public abstract void insertar(Categoria categoria);

	public abstract Categoria buscarPorClave(int id);

}
