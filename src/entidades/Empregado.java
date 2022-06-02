package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enums.nivelTrabalhador;

public class Empregado {
	private static String nome;
	private nivelTrabalhador level;
	private static Double salarioBase;
	private static Departamento departamento;
	private static List<contratoHora> contratos = new ArrayList<>() ;
	
	
	public Empregado() {
	}


	public Empregado(String nome, nivelTrabalhador level, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.level = level;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}


	public static String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public nivelTrabalhador getLevel() {
		return level;
	}


	public void setLevel(nivelTrabalhador level) {
		this.level = level;
	}


	public Double getSalarioBase() {
		return salarioBase;
	}


	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}


	public static Departamento getDepartamento() {
		return departamento;
	}


	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}


	public List<contratoHora> getContatos() {
		return contratos;
	}


	public static void addContrato(contratoHora contrato) {
		contratos.add(contrato);
	}
	
	public void removeContrato(contratoHora contrato) {
		contratos.remove(contrato);
	}
	
	public static double calculaRecebimento(int ano, int mes ) {
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance();
		for (contratoHora c : contratos) {
			cal.setTime(c.getData());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);		
			if(ano == c_ano && mes == c_mes ) {
				soma += c.valorTotal();
			}
		}
		return soma;
	}
	
	
}
