package com.desafiojava.teste.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiojava.teste.entity.Endereco;
import com.desafiojava.teste.entity.Pessoa;
import com.desafiojava.teste.repository.EnderecoRepository;
import com.desafiojava.teste.repository.PessoaRepository;

import jakarta.transaction.Transactional;

@Service
public class PessoasService {
	@Autowired
    private PessoaRepository pessoasRepository;
	
		
	 public List<Pessoa> listarPessoas() {
	        return pessoasRepository.findAll();
	    }
	 @Transactional
	 public Pessoa criar(Pessoa pessoa) throws Exception {
		List<Endereco> enderecosCriados = new ArrayList<>();
			
		    // validação e tratamento de exceções personalizadas
		    if (pessoa.getNome() == null || pessoa.getNome().trim().length() == 0) {
		        throw new Exception("Nome é obrigatório");
		    }
		    if (pessoa.getDataNascimento() == null) {
		        throw new Exception("Data de nascimento é obrigatória");
		    }
   
		    
		    if (pessoa.getEnderecos() == null || pessoa.getEnderecos().isEmpty()) {
		        throw new Exception("Ao menos um endereço é obrigatório");
		    }
		    for (Endereco endereco : pessoa.getEnderecos()) {
		        if (endereco.getLogradouro() == null || endereco.getLogradouro().trim().length() == 0) {
		            throw new Exception("Logradouro é obrigatório");
		        }
		        if (endereco.getCep() == null || endereco.getCep().trim().length() == 0) {
		            throw new Exception("CEP é obrigatório");
		        }
		        if (endereco.getNumero() == null || endereco.getNumero().trim().length() == 0) {
		            throw new Exception("Número é obrigatório");
		        }
		        if (endereco.getCidade() == null || endereco.getCidade().trim().length() == 0) {
		            throw new Exception("Cidade é obrigatória");
		        }
		        
		    }
		   /*
		    
		    Pessoa PessoaCriada = pessoasRepository.save(pessoa);
		    PessoaCriada.setEnderecos(enderecosCriados);
		    
		    for (Endereco endereco : pessoa.getEnderecos()) {
		    endereco.setIdPessoa(PessoaCriada);
		       PessoaCriada.getEnderecos().add(enderecoRepository.save(endereco));
		    }
		    
		     */
		    return pessoasRepository.save(pessoa);
		    
		}

		public Pessoa buscarPorId(Long id) {
		    return pessoasRepository.findById(id).orElse(null);
		}

		public Pessoa atualizar(Long id, Pessoa pessoa) throws Exception {
		    Pessoa pessoaSalva = buscarPorId(id);
		    if (pessoaSalva == null) {
		        throw new Exception("Pessoa não encontrada");
		    }
		    pessoaSalva.setNome(pessoa.getNome());
		    pessoaSalva.setDataNascimento(pessoa.getDataNascimento());
		    pessoaSalva.setEnderecos(pessoa.getEnderecos());
		    return pessoasRepository.save(pessoaSalva);
		}
		
		 public void deleteById(Long id) {
			 pessoasRepository.deleteById(id);
		    }

}
