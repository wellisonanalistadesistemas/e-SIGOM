package com.dao;

import com.dto.DtoRetornoPaginado;
import com.dto.DtoServicoPesquisa;
import com.model.Servico;

public interface ServicoDao {

	public DtoRetornoPaginado<Servico> listAll(Integer pagina, DtoServicoPesquisa dto);

	void persist(Servico servico);

	boolean deletar(Integer id);

	Servico getObj(Integer id);

	void merge(Servico users);

}