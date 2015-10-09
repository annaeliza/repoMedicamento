package br.senai.sc.tii2014.n1.anna.bancomedicamentos.model;

import java.util.List;

import br.senai.sc.tii2014.n1.anna.bancomedicamentos.dao.MedicamentoDao;
import br.senai.sc.tii2014.n1.anna.bancomedicamentos.model.entity.Medicamento;


public class MedicamentoRn {
	
	private MedicamentoDao dao;
	
	public MedicamentoRn(){
		dao = new MedicamentoDao();		
	}
	
	public void salvar(Medicamento medicamento) throws Exception{
		if(medicamento.getNome().trim().isEmpty()){
			throw new Exception("O nome do medicamento � obrigat�rio.");
		}
		if (medicamento.getDosagem().trim().isEmpty()){
			throw new Exception("A dosagem do medicamento � obrigat�ria.");
		}
		if (medicamento.getIntervalo().trim().isEmpty()){
			throw new Exception("O intervalo do medicamento � obrigat�rio.");
		}
		if (medicamento.getDuracao().trim().isEmpty()){
			throw new Exception("A dura��o do medicamento � obrigat�ria.");
		}
		dao.salvar(medicamento);
	}
	
	public List<Medicamento> listar(){
		return dao.listarTodos();
	}

	public Medicamento buscarPorId(Long id){
		return dao.buscaPorId(id);
	}

}
