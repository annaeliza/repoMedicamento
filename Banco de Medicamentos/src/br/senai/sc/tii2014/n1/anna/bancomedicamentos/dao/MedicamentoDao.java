package br.senai.sc.tii2014.n1.anna.bancomedicamentos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
			alterar(medicamento);
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
	
	public List<Medicamento> listarTodos(){
		List<Medicamento> medicamentos = new ArrayList<Medicamento>();
		try {
			PreparedStatement ps = getConnection().prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				Medicamento medicamento = new Medicamento();
				medicamento.setNome(rs.getString("nome"));
				medicamento.setDosagem(rs.getString("dosagem"));
				medicamento.setIntervalo(rs.getString("intervalo"));
				medicamento.setDuracao(rs.getString("duracao"));
				medicamento.setId(rs.getLong("id"));
				medicamentos.add(medicamento);				
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao executar o select de medicamentos" + e);
		}
		return medicamentos;
	}
			
	public Medicamento buscaPorId(Long id){
		try {
			PreparedStatement ps = getConnection().prepareStatement(SELECT_ID);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				Medicamento medicamento = new Medicamento();
				medicamento.setNome(rs.getString("nome"));
				medicamento.setDosagem(rs.getString("dosagem"));
				medicamento.setIntervalo(rs.getString("intervalo"));
				medicamento.setDuracao(rs.getString("duracao"));
				medicamento.setId(rs.getLong("id"));
				return medicamento;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao executar o select de medicamentos." + e);
		}
		return null;
	}
	
	private void alterar(Medicamento medicamento){
		try {
			PreparedStatement ps = getConnection().prepareStatement(UPDATE);
			ps.setString(1, medicamento.getNome());
			ps.setString(2, medicamento.getDosagem());
			ps.setString(3, medicamento.getIntervalo());
			ps.setString(4, medicamento.getDuracao());
			ps.setLong(5, medicamento.getId());
			
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao executar o update" + e);
		}
	}

}
