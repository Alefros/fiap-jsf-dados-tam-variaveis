package bean;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.ProfissionalDAO;

import to.Profissional;

@ManagedBean
public class ProfissionalBean {

	private List<Profissional> profissionais;

	public List<Profissional> getProfissionais() {
		return profissionais;
	}

	public String retornarParaDatatable(){
		try{
			carregarColecao();
		}catch(SQLException e){
			return "erro";
		}
		return "datatable";
	}
	
	public String retornarParaRepeat(){
		try{
			carregarColecao();
		}catch(SQLException e){
			return "erro";
		}
		return "repeat";
	}
	
	private void carregarColecao() throws SQLException{
		ProfissionalDAO dao = new ProfissionalDAO();
		profissionais = dao.getAll();
	}
	
	
}
