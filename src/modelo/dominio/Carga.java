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
@Table(name="tab_cargas")
public class Carga {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_CARGA")
	@SequenceGenerator(name = "ID_CARGA", sequenceName = "SEQ_CARGA", allocationSize = 1)
	private Integer id;
	private String dt_retirada;
	private String serie;
	private String mat;
	private String matricula;
	private String dt_devolucao;
	@ManyToOne
	@JoinColumn(name = "id_materialbelico_fk")
	private Materialbelico materialbelico;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

	
	
	public Materialbelico getMaterialbelico() {
		return materialbelico;
	}

	public void setMaterialbelico(Materialbelico materialbelico) {
		this.materialbelico = materialbelico;
	}
	
	


	public String getDt_devolucao() {
		return dt_devolucao;
	}

	public void setDt_devolucao(String dt_devolucao) {
		this.dt_devolucao = dt_devolucao;
	}

	public String getDt_retirada() {
		return dt_retirada;
	}

	public void setDt_retirada(String dt_retirada) {
		this.dt_retirada = dt_retirada;
	}
	
	


	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMat() {
		return mat;
	}

	public void setMat(String mat) {
		this.mat = mat;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
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
		Carga other = (Carga) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Carga [id=" + id + ", dt_retirada=" + dt_retirada + ", serie=" + serie + ", mat=" + mat + ", matricula="
				+ matricula + ", materialbelico=" + materialbelico + "]";
	}

	
	

	
	
	
	
}
