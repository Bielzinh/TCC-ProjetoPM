package modelo.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="tab_MaterialBelico")
public class Materialbelico {
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_MATERIALBELICO")
	@SequenceGenerator(name = "ID_MATERIALBELICO", sequenceName = "SEQ_MATERIABELICO", allocationSize = 1)
	private Integer id;

	@Column(unique=true)
	private String nm_serie;
	
	private String nm_sigma;
	private String marca;
	private String qtd;
    private String status;
    private String tipoMaterial;
	private String calibre;
	

	
	
	@OneToMany(mappedBy = "materialbelico", fetch = FetchType.LAZY)
	private List<Carga> cargas;
	

	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Carga> getCargas() {
		return cargas;
	}
	public void setCargas(List<Carga> cargas) {
		this.cargas = cargas;
	}
	public String getTipoMaterial() {
		return tipoMaterial;
	}
	public void setTipoMaterial(String tipoMaterial) {
		this.tipoMaterial = tipoMaterial;
	}
	public String getCalibre() {
		return calibre;
	}
	public void setCalibre(String calibre) {
		this.calibre = calibre;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNm_serie() {
		return nm_serie;
	}
	public void setNm_serie(String nm_serie) {
		this.nm_serie = nm_serie;
	}
	public String getNm_sigma() {
		return nm_sigma;
	}
	public void setNm_sigma(String nm_sigma) {
		this.nm_sigma = nm_sigma;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getQtd() {
		return qtd;
	}
	public void setQtd(String qtd) {
		this.qtd = qtd;
	}
	
	
	
	@Override
	public String toString() {
		return "Materialbelico [id=" + id + ", nm_serie=" + nm_serie + ", nm_sigma=" + nm_sigma + ", marca=" + marca
				+ ", qtd=" + qtd + ", tipoMaterial=" + tipoMaterial + ", calibre=" + calibre + ", cargas=" + cargas
				+ "]";
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
		Materialbelico other = (Materialbelico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
}
