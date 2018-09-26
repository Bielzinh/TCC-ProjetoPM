package modelo.dominio;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name="tab_chamados")
public class Chamado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_CHAMADO")
	@SequenceGenerator(name = "ID_CHAMADO", sequenceName = "SEQ_CHAMADO", allocationSize = 1)
	private Integer id;
	private String descricao;
	private String matricula;
	private String status;
	@Temporal(TemporalType.DATE)
	private Date abertura;
	private String resumo;
	
	@ManyToOne
	@JoinColumn(name = "id_setor_fk")
	private Setor setor;
	
	
	
	
	
	
	
	public String getResumo() {
		return resumo;
	}


	public void setResumo(String resumo) {
		this.resumo = resumo;
	}


	


	public Date getAbertura() {
		return abertura;
	}


	public void setAbertura(Date abertura) {
		this.abertura = abertura;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public Setor getSetor() {
		return setor;
	}
	
	
	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
	
	



	@Override
	public String toString() {
		return "Chamado [id=" + id + ", descricao=" + descricao + ", matricula=" + matricula + ", status=" + status
				+ ", abertura=" + abertura + ", resumo=" + resumo + ", setor=" + setor + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chamado other = (Chamado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
