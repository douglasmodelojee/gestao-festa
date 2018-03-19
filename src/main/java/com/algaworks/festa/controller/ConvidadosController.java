package com.algaworks.festa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.festa.model.Convidado;
import com.algaworks.festa.repository.Convidados;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
//@RequestMapping("/convidados")
public class ConvidadosController {

	@Autowired
	private Convidados convidados;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/convidados")
	public ModelAndView listar() {

		ModelAndView mv = new ModelAndView("ListaConvidados");
		mv.addObject(new Convidado());
		mv.addObject("convidados", convidados.findAll());
		return mv;
	}

	@PostMapping("/convidados/salvar")
	public String salvar(Convidado convidado) {
		this.convidados.save(convidado);
		return "redirect:/convidados";
	}
	
	@GetMapping("/convidado/delete/{id}")
	public String remove(@PathVariable Long id) {
		//log.debug("Excluido id=",id);
		this.convidados.delete(this.convidados.getOne(id));
		return "redirect:/convidados";
	}

}
