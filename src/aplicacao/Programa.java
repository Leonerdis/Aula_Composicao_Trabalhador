package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Departamento;
import entidades.Empregado;
import entidades.contratoHora;
import entidades.enums.nivelTrabalhador;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Entre com o nome do departamento: ");
		String nomeDepartamento = sc.nextLine();
		System.out.println("Entre com os dados do empregado:");
		System.out.print("Nome: ");
		String nomeFuncionario = sc.nextLine();
		System.out.print("Nível: ");
		String nivelFuncionario = sc.nextLine();
		System.out.print("Salario Base: ");
		Double salarioBase = sc.nextDouble();
		
		Empregado empregado = new Empregado(nomeFuncionario, nivelTrabalhador.valueOf(nivelFuncionario), salarioBase, new Departamento(nomeDepartamento));
		
		System.out.print("Quantos contratos o funcionário tem? ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Entre com os dados do # " + i + " contrato:");
			System.out.print("Data (DD/MM/YYYY)");
			Date dataContrato = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valorPorHora = sc.nextDouble();
			System.out.print("Duração(horas): ");
			int horas = sc.nextInt();
			contratoHora contrato = new contratoHora(dataContrato, valorPorHora, horas);
			Empregado.addContrato(contrato);
		}
			System.out.println();
			System.out.print("Entre com o mês e ano para calcular o pagamento(MM/YYYY): ");
			String mesEAno = sc.next();
			int mes = Integer.parseInt(mesEAno.substring(0, 2));
			int ano = Integer.parseInt(mesEAno.substring(3));
			System.out.println("Nome: " + Empregado.getNome());
			System.out.println("Departamento: " + Empregado.getDepartamento());
			System.out.println("Ordenado para " + mesEAno + ": " + String.format("%.2f", Empregado.calculaRecebimento(ano, mes)));
		sc.close();

	}

}
