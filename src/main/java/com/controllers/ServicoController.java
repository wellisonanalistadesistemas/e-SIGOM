package com.controllers;

import java.lang.reflect.InvocationTargetException;
import java.security.NoSuchAlgorithmException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.dtos.DtoRetornoPaginado;
import com.dtos.DtoServicoPesquisa;
import com.entities.Servico;
import com.servicesapi.ServicoService;

@Controller
@RequestMapping("/home/servicos")
@SessionAttributes("roles")

public class ServicoController {

	@Autowired
	ServicoService _servicoService;

	@RequestMapping(method = { RequestMethod.GET })
	public ModelAndView listarTodos() {
		return new ModelAndView("servico/consultar");
	}

	@RequestMapping(value = "/pagination/{pagina}", method = { RequestMethod.POST })
	public @ResponseBody DtoRetornoPaginado<Servico> paginated(@PathVariable("pagina") Integer pagina,
			@RequestBody DtoServicoPesquisa dto) {
		return _servicoService.listAll(pagina, dto);
	}/*

	@RequestMapping(value = "/cadastrar", method = { RequestMethod.GET })
	public ModelAndView insert(ModelMap model) {
		model.addAttribute("obj", new servico());
		return new ModelAndView("servico/cadastrar");
	}

	@RequestMapping(value = "/cadastrar", method = { RequestMethod.POST })
	public String insert(@ModelAttribute("obj") servico obj, RedirectAttributes ra, ModelMap model) throws Exception {
		_servicoService.salvar(obj);
		ra.addFlashAttribute("message", "Registro cadastrado com sucesso!");
		return "redirect:/home/servicos";
	}

	@RequestMapping(value = "/{cod}", method = { RequestMethod.GET })
	public ModelAndView editar(@PathVariable("cod") Integer cod, ModelMap model)
			throws NoSuchAlgorithmException, IllegalAccessException, InvocationTargetException {
		model.addAttribute("obj", _servicoService.getObj(cod));
		return new ModelAndView("servico/editar");
	}

	@RequestMapping(value = "/{cod}", method = { RequestMethod.POST })
	public String editar(@PathVariable("cod") Integer cod, @ModelAttribute("obj") servico objMerge,
			RedirectAttributes ra) throws Exception {
		objMerge.setId(cod);
		Boolean retorno = _servicoService.editar(objMerge);

		if (retorno) {
			ra.addFlashAttribute("message", "Registro editado com sucesso!");
			return "redirect:/home/servicos";
		}
		return null;
	}

	@RequestMapping(value = "/excluir/{cod}", method = { RequestMethod.POST })
	public @ResponseBody void excluir(@PathVariable("cod") Integer cod) {
		try {
			_servicoService.deletar(cod);
		} catch (Exception e) {
			return;
		}
	}



	@RequestMapping(value = "/detail/{cod}", method = { RequestMethod.GET })
	public @ResponseBody Object detalhes(@PathVariable("cod") Integer cod)
			throws IllegalAccessException, InvocationTargetException {

		Servico servico = (servico) _servicoService.getObj(cod);
		if (servico != null) {
			return servico;
		}
		System.out.println("Erro ao recuperar dados do servico!");
		return null;

	}*/
}
