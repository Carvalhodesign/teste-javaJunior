package com.desafiojava.teste.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desafiojava.teste.entity.Pessoa;
import com.desafiojava.teste.service.PessoasService;

@RestController
@RequestMapping("/pessoas")
public class PessoasController {
	@Autowired
	private PessoasService pessoasService;
	
	
	@GetMapping("/listar-pessoas")
	public ResponseEntity<List<Pessoa>> listarPessoas() {
		List<Pessoa> pessoas = pessoasService.listarPessoas();
		return ResponseEntity.ok(pessoas);
	}
	
	@PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa create(@RequestBody Pessoa pessoa) throws Exception {
	     return pessoasService.criar(pessoa);
    }
	
	

}
