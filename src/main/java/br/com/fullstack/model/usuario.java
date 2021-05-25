package br.com.fullstack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_USUARIO")
public class usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nome", length=50)
	private String nome;
	
	@Column(name="senha", length=20)
	private String senha;
	
	@Column(name="email", length=70)
	private String email;
	
	@Column(name="foto", length=100)
	private String foto;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public usuario(int id, String nome, String senha, String email, String foto) {
		super();
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.foto = foto;
	}
	public usuario() {
		super();
	}
	@Override
	public String toString() {
		return "usuario [id=" + id + ", nome=" + nome + ", senha=" + senha + ", email=" + email + ", foto=" + foto
				+ "]";
	}
	
	
	

}
