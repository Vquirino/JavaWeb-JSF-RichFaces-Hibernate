package persistence;

import java.util.List;
import org.hibernate.*;
import entity.Pessoa;

public class PessoaDao {
	
	Session s;
	Transaction t;
	Query q;
	
	public void salvar(Pessoa p) throws Exception{	
		s = HibernateUtil.getInstance(); //obtar acesso ao banco de dados	
		t = s.beginTransaction(); //inicio da transção	
		s.save(p); //salvar o resgistro	
		t.commit();//confirmação da gravação
	}
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> consultar() throws Exception{
		s = HibernateUtil.getInstance();
		q = s.createQuery("from Pessoa order by idpessoa desc"); //HQL (Hibernate Query Language)
		return q.list();
	}

}
