package modelo.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tab_historico")
public class Historico {
	@Id
	private Integer idHistorico;
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_HISTORICO")
@SequenceGenerator(name = "ID_HISTORICO", sequenceName = "SEQ_HISTORICO", allocationSize = 1)


@ManyToOne
@JoinColumn(name = "idMaterial")
private Materialbelico material;

@ManyToOne
@JoinColumn(name = "idPolicial")
private Policial policial;



private String endereco;
private String data;
private String hora;
private String latLon;

public Materialbelico getMaterial() {
	return material;
}
public void setMaterial(Materialbelico material) {
	this.material = material;
}
public Policial getPolicial() {
	return policial;
}
public void setPolicial(Policial policial) {
	this.policial = policial;
}
public String getEndereco() {
	return endereco;
}
public void setEndereco(String endereco) {
	this.endereco = endereco;
}
public String getData() {
	return data;
}
public void setData(String data) {
	this.data = data;
}


public Integer getIdHistorico() {
	return idHistorico;
}
public void setIdHistorico(Integer idHistorico) {
	this.idHistorico = idHistorico;
}
public String getHora() {
	return hora;
}
public void setHora(String hora) {
	this.hora = hora;
}
public String getLatLon() {
	return latLon;
}
public void setLatLon(String latLon) {
	this.latLon = latLon;
}
@Override
public String toString() {
	return "Historico [idHistorico=" + idHistorico + ", material=" + material + ", policial=" + policial + ", endereco="
			+ endereco + ", data=" + data + ", hora=" + hora + ", latLon=" + latLon + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((idHistorico == null) ? 0 : idHistorico.hashCode());
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
	Historico other = (Historico) obj;
	if (idHistorico == null) {
		if (other.idHistorico != null)
			return false;
	} else if (!idHistorico.equals(other.idHistorico))
		return false;
	return true;
}







}
