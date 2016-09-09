package entity;

import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name = "pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idpessoa")
	private Integer idpessoa;
	
	@Column(name="nome", length=35, nullable=false)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="datanascimento", nullable=false)
	private Date datanascimento;
	
	
	public Pessoa() {
	}


	public Integer getIdpessoa() {
		return idpessoa;
	}


	public void setIdpessoa(Integer idpessoa) {
		this.idpessoa = idpessoa;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Date getDatanascimento() {
		return datanascimento;
	}


	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}
	
	
	
}
