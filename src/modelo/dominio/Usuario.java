package modelo.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Usuario {

	public Usuario() {
		super();
	}
	
	private String 	login;
	
	
	private String nome;
	
	private String senha;
	
	@Id
	@GeneratedValue(generator = "USUARIO", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "USUARIO", allocationSize = 1, sequenceName = "SEQ_USUARIO")
	private Integer codigo;

	private String apelido;

	private String email;


	private String sexo;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	private Date nascimento;

	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	


	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	public boolean senhaCorreta(String senhaDigitada) {
		if (this.senha.equals(senhaDigitada))
			return true;
		else
			return false;
	}
	
	
	
	@Override
	public int hashCode() {
		if (this.codigo == null)
			return 0;

		return this.codigo.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.login;
	}

}