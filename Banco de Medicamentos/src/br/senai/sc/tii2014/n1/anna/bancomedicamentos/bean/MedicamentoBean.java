package br.senai.sc.tii2014.n1.anna.bancomedicamentos.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.senai.sc.tii2014.n1.anna.bancomedicamentos.model.MedicamentoRn;
import br.senai.sc.tii2014.n1.anna.bancomedicamentos.model.entity.Medicamento;

@ManagedBean
public class MedicamentoBean {
	
	private List<Medicamento> medicamentos;
	private Medicamento medicamento;
	private MedicamentoRn rn;
	
	@PostConstruct
	public void init(){
		rn = new MedicamentoRn();
		medicamento = new Medicamento();
	}
	
	public List<Medicamento> getMedicamentos(){
		if(medicamentos == null){
			medicamentos = rn.listar();
		}
		return medicamentos;
	}
	
	public void setMedicamentos(List<Medicamento> medicamentos){
		this.medicamentos = medicamentos;		
	}
	
	
	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}


	
	public String salvar(){
		try {
			rn.salvar(medicamento);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		} 
		return "listarMedicamentos";
	}
	
	public String editar(String idParam){
		Long id = Long.parseLong(idParam);
		medicamento = rn.buscarPorId(id);
		return "cadastroMedicamentos";
	}
	
	public String excluir(String idParam){
		Long id = Long.parseLong(idParam);
		try {
			rn.excluir(id);
			medicamentos = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
}
