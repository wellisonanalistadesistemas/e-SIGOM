package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dto.DtoOrdemServicoPesquisa;
import dto.DtoRetornoPaginado;

import services.OrdemServicoService;

@Controller
@RequestMapping("/home/ordem-servicos")
@SessionAttributes("roles")

public class OrdemServicoController {

	@Autowired
	OrdemServicoService _ordemServicoService;

	@RequestMapping(method = { RequestMethod.GET })
	public ModelAndView lista(ModelMap model) {
		return new ModelAndView("ordem-servico/index");
	}
	
	@RequestMapping(value = "/pagination/{pagina}", method = { RequestMethod.POST })
	public @ResponseBody DtoRetornoPaginado<DtoOrdemServicoPesquisa> paginated(@PathVariable("pagina") Integer pagina,
			@RequestBody DtoOrdemServicoPesquisa dto) throws IllegalAccessException {
		return _ordemServicoService.listAll(pagina, dto);
	}
	/*
	@RequestMapping(value = "/cadastrar", method = { RequestMethod.GET })
	public ModelAndView insert(ModelMap model) {
		model.addAttribute("obj", new Servico());
		return new ModelAndView("OrdemServico/cadastrar");
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/getPesquisaPeca/{nome}", method = { RequestMethod.GET })
	public @ResponseBody DtoListaPeca getPecas(@PathVariable("nome") String nome, RedirectAttributes r) {

		DtoListaPeca retorno = _ordemServicoService.getPesquisaPeca(nome);

		if (retorno != null) {
			return retorno;
		}
		return null;
	}

	@RequestMapping(value = "/getPesquisaServico/{nome}", method = { RequestMethod.GET })
	public @ResponseBody DtoListaPeca getServicos(@PathVariable("nome") String nome, RedirectAttributes r) {

		DtoListaPeca retorno = _ordemServicoService.getPesquisaServico(nome);

		if (retorno != null) {
			return retorno;
		}
		return null;
	}

	@RequestMapping(value = "/getCliente/{cpf}", method = { RequestMethod.GET })
	public @ResponseBody Cliente getCliente(@PathVariable("cpf") String cpf) {

		Cliente retorno = _ordemServicoService.getCliente(cpf);

		if (retorno != null) {
			return retorno;
		}
		return null;
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody Serializable saveOrdemServico(@RequestParam Object dto) {

		return _ordemServicoService.salvarOrdemServico(dto);

	}*/

}
