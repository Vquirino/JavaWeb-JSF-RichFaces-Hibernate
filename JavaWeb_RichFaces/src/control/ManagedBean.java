package control;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import persistence.PessoaDao;

import entity.Pessoa;

public class ManagedBean {
	
	private Pessoa pessoa; //Atributo para armazenar os campos de entrada de dados do formulario
	private List<Pessoa> dados; //Atributo para listar os registros de pessoa na DataTable
	
	public ManagedBean() {
		//Inicializar os atributos
		pessoa = new Pessoa();
		dados = new ArrayList<Pessoa>();
	}
	
	public void cadastrar(){
		FacesContext c = FacesContext.getCurrentInstance();
		FacesMessage m;
		
		try{
			new PessoaDao().salvar(pessoa);
			pessoa = new Pessoa();
			
			m = new FacesMessage("Pessoa cadastrada com sucesso!");
		}
		catch (Exception e) {
			m = new FacesMessage(e.getMessage());
		}
		
		c.addMessage("formulario", m);
		
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getDados() {
		
		try {
			
			//Limpar o conteúdo do atributo
			dados.clear();
			dados = new PessoaDao().consultar();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dados;
	}

	public void setDados(List<Pessoa> dados) {
		this.dados = dados;
	}
	
	

}
