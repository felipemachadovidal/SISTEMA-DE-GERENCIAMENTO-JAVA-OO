package pacote;

import java.util.ArrayList;

class Funcionario extends Usuarios {
	private ArrayList<ReclamacaoServico> reclamacoesServicos;

	public Funcionario(String nome, String endereco, String contato) {
		super(nome, endereco, contato);
		this.reclamacoesServicos = new ArrayList<>();
	}

	public void registrarOcorrencia(String descricao) {
		ReclamacaoServicoImpl reclamacaoServico = new ReclamacaoServicoImpl(descricao);
		reclamacoesServicos.add(reclamacaoServico);
		System.out.println("Ocorrência registrada com sucesso!");
	}

	private static class ReclamacaoServicoImpl implements ReclamacaoServico {
		private String descricao;
		private boolean resolvida;

		public ReclamacaoServicoImpl(String descricao) {
			this.descricao = descricao;
			this.resolvida = false;
		}

		@Override
		public String getDescricao() {
			return descricao;
		}

		@Override
		public boolean isResolvida() {
			return resolvida;
		}

		@Override
		public void resolver() {
			this.resolvida = true;
		}
	}
}
