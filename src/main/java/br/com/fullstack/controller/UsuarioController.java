package br.com.fullstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fullstack.dao.usuarioDAO;
import br.com.fullstack.model.usuario;

@RestController // para que a classe responda as requisiçoes HTTP
@CrossOrigin("*") // permite para que a controller receba requisiçoes externas (fora do server)
public class UsuarioController {

	@Autowired // transfere para Spring boot a responsabilidade sobre este objeto
	private usuarioDAO dao;



	//Get => método para açoes simples, retorno para grande conjunto de dados .
	//Get SEMPRE os dados sao passados pela "rota", por meio de variaveis 
	//@PathVariable


	@PostMapping("/login")
	public ResponseEntity<usuario> logar(@RequestBody usuario usuario){
		usuario resposta = dao.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());

		if (resposta==null) {
			return ResponseEntity.status(404).build();

		}
		resposta.setSenha("");
		return ResponseEntity.ok(resposta);

	}

	//Post => métodos para açoes onde os dados sao enviados dentro do pacote (envelope)
	//Post SEMPRE tera no Body (corpo) o conjunto de dados (JSON)
	//@RequestBody => que recupera o objeto.

	@PostMapping("/novousuario")
	public ResponseEntity<usuario> add(@RequestBody usuario usuario) {
		try {
			dao.save(usuario);
			return ResponseEntity.ok(usuario);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}

	}
	
	@PostMapping("/pornome")
	public ResponseEntity<List<usuario>> getUserName(@RequestBody usuario usuario){
		List<usuario> lista = dao.findByNomeLike("%" + usuario.getNome() + "%");
		if (lista.size()==0) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
	}


	@GetMapping("/usuario/nome")
	public ResponseEntity<List<usuario>> getUserbyNome(@PathVariable String var){
		List<usuario> resposta = dao.findByNomeLike(var);
		if (resposta == null) {
			return ResponseEntity.status(404).build();
		} 
		return ResponseEntity.ok(resposta);

	}

	//@GetMapping("/usuario/{var}")
	//public ResponseEntity<usuario> getUser(@PathVariable int var){
		//usuario resposta = dao.findById(var).orElse(null);
		//if (resposta==null) {
			//return ResponseEntity.status(404).build();
		//}
		//return ResponseEntity.ok(resposta);

	//}

	@GetMapping("/usuarios")
	public ResponseEntity<List<usuario>> getAll(){
		List<usuario> lista = (List<usuario>) dao.findAll();
		if (lista.size()==0) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
	}
	
	




}
