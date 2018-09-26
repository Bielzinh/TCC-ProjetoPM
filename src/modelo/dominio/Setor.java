package modelo.dominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tab_setores")
public class Setor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SETOR")
	@SequenceGenerator(name = "SETOR", allocationSize = 1, sequenceName = "SEQ_SETOR")
	private Integer id;
	private String nomeSetor;
	private Integer ala;
	private String status;
	
	
	@OneToMany(mappedBy = "setor", fetch = FetchType.LAZY)
	private List<Policial> policiais;
	
	
	@OneToMany(mappedBy = "setor", fetch = FetchType.LAZY)
	private List<Chamado> chamados;
	



	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}

	public List<Policial> getPoliciais() {
		return policiais;
	}

	public void setPoliciais(List<Policial> policiais) {
		this.policiais = policiais;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeSetor() {
		return nomeSetor;
	}

	public void setNomeSetor(String nomeSetor) {
		this.nomeSetor = nomeSetor;
	}

	public Integer getAla() {
		return ala;
	}

	public void setAla(Integer ala) {
		this.ala = ala;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Setor [id=" + id + ", nomeSetor=" + nomeSetor + ", ala=" + ala + ", status=" + status + ", policiais="
				+ policiais + "]";
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
		Setor other = (Setor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	

}
