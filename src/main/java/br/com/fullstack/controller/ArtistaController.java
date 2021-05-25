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

import br.com.fullstack.dao.ArtistaDAO;
import br.com.fullstack.model.Artista;
import br.com.fullstack.model.usuario;

@RestController // para que a classe responda as requisiçoes HTTP
@CrossOrigin("*") // permite para que a controller receba requisiçoes externas (fora do server)
public class ArtistaController {
	
	@Autowired
	
	private ArtistaDAO dao;
	
	@GetMapping("/artistas")
	public ResponseEntity<List<Artista>> getAllArtistas(){
		
		List<Artista> lista = (List<Artista>) dao.findAll();
		if (lista.size() == 0 ) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/excluirartista")
	public ResponseEntity<Artista> dell(@RequestBody Artista artista) {
		try {
			dao.delete(artista);
			return ResponseEntity.ok(artista);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}

	}
	
	@PostMapping("/novoartista")
	public ResponseEntity<Artista> add(@RequestBody Artista artista) {
		try {
			dao.save(artista);
			return ResponseEntity.ok(artista);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}

	}
	
	@GetMapping("/artista/{var}")
	public ResponseEntity<Artista> getUser(@PathVariable int var){
		Artista resposta = dao.findById(var).orElse(null);
		if (resposta==null) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(resposta);

	}
	
	@GetMapping("/nacionalidade/{var}")
	public ResponseEntity<List<Artista>> getUser(@PathVariable String var){
		List<Artista> resposta = dao.findByNacionalidade(var);
		if (resposta==null) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(resposta);

	}

	

}
