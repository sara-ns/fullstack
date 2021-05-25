package br.com.fullstack.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.fullstack.model.Artista;
import br.com.fullstack.model.usuario;

public interface usuarioDAO extends CrudRepository<usuario, Integer>{
	
	//DAO é um Pattern - CRUD em uma classe
	//metodo = Gravar - Consultar - Excluir - Alterar
	
	//save(objeto) : void
	//findById(int) : objeto
	//findAll() : iterable
	// deleteById(int) : void
	// deleteAll()
	
	public List<usuario> findByNomeLike(String nome);
	public usuario findByEmailAndSenha(String email, String senha);
	
	
	
	
	
	

}
