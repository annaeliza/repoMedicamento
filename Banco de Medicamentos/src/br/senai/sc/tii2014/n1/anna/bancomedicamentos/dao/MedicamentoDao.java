package br.senai.sc.tii2014.n1.anna.bancomedicamentos.dao;

import java.sql.PreparedStatement;

import br.senai.sc.tii2014.n1.anna.bancomedicamentos.model.entity.Medicamento;

public class MedicamentoDao extends Dao{
	
	private final String INSERT = "INSERT INTO medicamentos (nome, dosagem, intervalo, duracao) values (?, ?, ?, ?)";
	private final String UPDATE = "UPDATE medicamentos SET nome=?, dosagem=?, intervalo=?, duracao=? WHERE id=?";
	private final String DELETE = "DELETE FROM medicamentos WHERE id=?";
	private final String SELECT = "SELECT * FROM medicamentos";
	private final String SELECT_ID = "SELECT * FROM medicamentos WHERE id=?";
	
	public void salvar(Medicamento medicamento) throws Exception{
		if(medicamento.getId() == 0){
			inserir(medicamento);
		} else {
			//alterar(medicamento);
		}
		
	}

	private void inserir(Medicamento medicamento) throws Exception {
		try {
			PreparedStatement ps = getConnection().prepareStatement(INSERT);
			ps.setString(1, medicamento.getNome());
			ps.setString(2, medicamento.getDosagem());
			ps.setString(3, medicamento.getIntervalo());
			ps.setString(4, medicamento.getDuracao());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao tentar cadastrar seu medicamento.");
		}
	}

}
