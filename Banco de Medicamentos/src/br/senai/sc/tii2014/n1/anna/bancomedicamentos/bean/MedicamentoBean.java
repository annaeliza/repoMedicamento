package br.senai.sc.tii2014.n1.anna.bancomedicamentos.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.senai.sc.tii2014.n1.anna.bancomedicamentos.model.MedicamentoRn;
import br.senai.sc.tii2014.n1.anna.bancomedicamentos.model.entity.Medicamento;

@ManagedBean
public class MedicamentoBean {

	private Medicamento medicamento;
	private MedicamentoRn rn;
	
	
	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	@PostConstruct
	public void init(){
		rn = new MedicamentoRn();
		medicamento = new Medicamento();
		
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
	
}
