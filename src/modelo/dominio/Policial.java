package modelo.dominio;

import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

@Entity
@Table(name="tab_policiais")
public class Policial{
    
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_POLICIAL")
	@SequenceGenerator(name = "ID_POLICIAL", sequenceName = "SEQ_POLICIAL", allocationSize = 1)
	private Integer codigo;
	
	private String nomePolicial;
	
	private String sexo;
	
	private String cpf;
	
	private String rg;
	
	private String teste;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	private Date dataNascimento;
	
	private String telefone;
	
	private String email;
	
	private String ctps;
	
	private String estCivil;
	
	private String reservista;
	
    private String rua;
	
	private String numero;
	
	
	
	

	
	private String matricula;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_admissao")
	private Date dataAdmissao;
	
	private String cargo;
	
	private String estado = "";
	
	private String cidade = "";
	
	private String bairro = "";
	
	private String tipoLogradouro = "";
	
	private String logradouro = "";
	
	private String escala;

	private int resultado = 0;
	
	private Float salario;
	
	
	
	















	@Lob
	@Basic(fetch=FetchType.LAZY)
	private byte[] foto;
	

	
	@SuppressWarnings("rawtypes")
	public  Policial(String cep) {

		try {
			URL url = new URL(
					"http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep
							+ "&formato=xml");

			Document document = getDocumento(url);

			Element root = document.getRootElement();

			for (Iterator i = root.elementIterator(); i.hasNext();) {
				Element element = (Element) i.next();

				if (element.getQualifiedName().equals("uf"))
					setEstado(element.getText());

				if (element.getQualifiedName().equals("cidade"))
					setCidade(element.getText());

				if (element.getQualifiedName().equals("bairro"))
					setBairro(element.getText());

				if (element.getQualifiedName().equals("tipo_logradouro"))
					setTipoLogradouro(element.getText());

				if (element.getQualifiedName().equals("logradouro"))
					setLogradouro(element.getText());

				if (element.getQualifiedName().equals("resultado"))
					setResultado(Integer.parseInt(element.getText()));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	
	

	public Policial() {
		// TODO Auto-generated constructor stub
	}

	public Document getDocumento(URL url) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(url);

		return document;
	}
    
    
	
	










	public String getTeste() {
		return teste;
	}





	public void setTeste(String teste) {
		this.teste = teste;
	}














	@ManyToOne
	@JoinColumn(name = "id_setor_fk")
	private Setor setor;

	
	
	


	



	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNomePolicial() {
		return nomePolicial;
	}

	public void setNomePolicial(String nomePolicial) {
		this.nomePolicial = nomePolicial;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCtps() {
		return ctps;
	}

	public void setCtps(String ctps) {
		this.ctps = ctps;
	}

	public String getEstCivil() {
		return estCivil;
	}

	public void setEstCivil(String estCivil) {
		this.estCivil = estCivil;
	}

	public String getReservista() {
		return reservista;
	}

	public void setReservista(String reservista) {
		this.reservista = reservista;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}

	public Float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	

	public String getEscala() {
		return escala;
	}





	public void setEscala(String escala) {
		this.escala = escala;
	}





	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	@Override
	public String toString() {
		return "Policial [codigo=" + codigo + ", nomePolicial=" + nomePolicial + ", sexo=" + sexo + ", cpf=" + cpf
				+ ", rg=" + rg + ", dataNascimento=" + dataNascimento + ", telefone=" + telefone + ", email=" + email
				+ ", ctps=" + ctps + ", estCivil=" + estCivil + ", reservista=" + reservista + ", rua=" + rua
				+ ", numero=" + numero + ", matricula=" + matricula + ", dataAdmissao=" + dataAdmissao + ", cargo="
				+ cargo + ", estado=" + estado + ", cidade=" + cidade + ", bairro=" + bairro + ", tipoLogradouro="
				+ tipoLogradouro + ", logradouro=" + logradouro + ", resultado=" + resultado + ", salario=" + salario
				+ ", foto=" + Arrays.toString(foto) + ", escala=" + escala + ", setor=" + setor + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Policial other = (Policial) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}



	
	
}
