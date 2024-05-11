package pacote;

import java.util.ArrayList;
import java.util.Scanner;

class Administrador extends Usuarios implements Menu {
	private ArrayList<Morador> moradores;
	private ArrayList<Funcionario> funcionarios;
	private ArrayList<Debito> debitos;

	public Administrador(String nome, String endereco, String contato) {
		super(nome, endereco, contato);
		this.moradores = new ArrayList<>();
		this.funcionarios = new ArrayList<>();
		this.debitos = new ArrayList<>();
	}

	@Override
	public void cadastrarUsuario() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nCadastro de Novo Usuário:");
		System.out.print("Nome: ");
		String nome = scanner.nextLine();
		System.out.print("Endereço: ");
		String endereco = scanner.nextLine();
		System.out.print("Contato: ");
		String contato = scanner.nextLine();
		System.out.print("Tipo (Morador/Funcionário): ");
		String tipo = scanner.nextLine();

		if (tipo.equalsIgnoreCase("Morador")) {
			System.out.print("Número do Apartamento: ");
			int numeroApartamento = scanner.nextInt();
			moradores.add(new Morador(nome, endereco, contato, numeroApartamento));
		} else if (tipo.equalsIgnoreCase("Funcionário")) {
			funcionarios.add(new Funcionario(nome, endereco, contato));
		} else {
			System.out.println("Tipo de usuário inválido.");
		}
	}

	@Override
	public void registrarDebito() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nRegistrar Débito:");
		System.out.print("Descrição: ");
		String descricao = scanner.nextLine();
		System.out.print("Valor: ");
		double valor = scanner.nextDouble();
		debitos.add(new DebitoImpl(descricao, valor));
	}

	@Override
	public void visualizarDebitos() {
		System.out.println("\nDébitos Registrados:");
		for (Debito debito : debitos) {
			System.out.println("Descrição: " + debito.getDescricao() + ", Valor: " + debito.getValor());
		}
	}

	@Override
	public void calcularValorPagoPorMorador() {
		System.out.println("\nCálculo do Valor a Ser Pago por Morador:");
		for (Morador morador : moradores) {
			double totalDebitosMorador = 0;
			for (Debito debito : debitos) {
				if (debito instanceof DebitoImpl) {
					DebitoImpl debitoMorador = (DebitoImpl) debito;
					if (debitoMorador.getDescricao().contains(Integer.toString(morador.getNumeroApartamento()))) {
						totalDebitosMorador += debitoMorador.getValor();
					}
				}
			}
			System.out.println("Morador: " + morador.getNome() + ", Apartamento: " + morador.getNumeroApartamento()
					+ ", Total a Pagar: " + totalDebitosMorador);
		}
	}

	private static class DebitoImpl implements Debito {
		private String descricao;
		private double valor;

		public DebitoImpl(String descricao, double valor) {
			this.descricao = descricao;
			this.valor = valor;
		}

		public String getDescricao() {
			return descricao;
		}

		public double getValor() {
			return valor;
		}
	}
}