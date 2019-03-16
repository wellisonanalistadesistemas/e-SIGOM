package com.daoapi;

import java.util.List;

import com.dtos.DtoRetornoPaginado;
import com.entities.Cliente;
import com.dtos.DtoClientePesquisa;

public interface ClienteDao {

	public DtoRetornoPaginado<Cliente> list(Integer pagina, DtoClientePesquisa dto);

	public List<Cliente> lista();

	Cliente getObj(Integer id);

	boolean deletar(Integer id);

	void merge(Cliente users);

	void persist(Cliente users);
}