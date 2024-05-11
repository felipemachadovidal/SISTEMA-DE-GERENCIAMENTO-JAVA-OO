package pacote;

import java.util.ArrayList;

class Morador extends Usuarios {
	private int numeroApartamento;
	private ArrayList<ReclamacaoServico> reclamacoes;

	public Morador(String nome, String endereco, String contato, int numeroApartamento) {
		super(nome, endereco, contato);
		this.numeroApartamento = numeroApartamento;
		this.reclamacoes = new ArrayList<>();
	}
	

	@Override
	public String toString() {
		return "Morador [numeroApartamento=" + numeroApartamento + ", reclamacoes=" + reclamacoes + "]";
	}


	public int getNumeroApartamento() {
		return numeroApartamento;
	}

	public void registrarReclamacao(String descricao) {
		ReclamacaoServicoImpl reclamacaoServico = new ReclamacaoServicoImpl(descricao, numeroApartamento);
		reclamacoes.add(reclamacaoServico);
		System.out.println("Reclamação registrada com sucesso!");
	}

	public void registrarDebito(String descricao, double valor, ArrayList<Debito> debitos) {
		DebitoImpl debito = new DebitoImpl(descricao, valor);
		debitos.add(debito);
		System.out.println("Débito registrado com sucesso!");
	}

	public void visualizarComunicados(ArrayList<String> comunicados) {
		System.out.println("Comunicados:");
		for (String comunicado : comunicados) {
			System.out.println(comunicado);
		}
	}

	private static class ReclamacaoServicoImpl implements ReclamacaoServico {
		private String descricao;
		private int numeroApartamento;

		public ReclamacaoServicoImpl(String descricao, int numeroApartamento) {
			this.descricao = descricao;
			this.numeroApartamento = numeroApartamento;
		}

		@Override
		public String getDescricao() {
			return descricao;
		}

		@Override
		public boolean isResolvida() {
			return false;
		}

		@Override
		public void resolver() {
		}
	}

	private static class DebitoImpl implements Debito {
		private String descricao;
		private double valor;

		public DebitoImpl(String descricao, double valor) {
			this.descricao = descricao;
			this.valor = valor;
		}

		@Override
		public String getDescricao() {
			return descricao;
		}

		@Override
		public double getValor() {
			return valor;
		}
	}
}
