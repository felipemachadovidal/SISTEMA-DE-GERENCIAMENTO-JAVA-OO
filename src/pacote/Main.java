package pacote;

public class Main {
	public static void main(String[] args) {

		Morador morador1 = new Morador("João", "Rua A, 123", "123456789", 101);
		Morador morador2 = new Morador("Maria", "Rua B, 456", "987654321", 102);

		Funcionario funcionario = new Funcionario("Pedro", "Rua C, 789", "456123789");

		System.out.println("Informações dos Moradores:");
		System.out.println("Morador 1:");
		System.out.println("Nome: " + morador1.getNome());
		System.out.println("Endereço: " + morador1.getEndereco());
		System.out.println("Contato: " + morador1.getContato());
		System.out.println("Número do Apartamento: " + morador1.getNumeroApartamento());

		System.out.println("\nMorador 2:");
		System.out.println("Nome: " + morador2.getNome());
		System.out.println("Endereço: " + morador2.getEndereco());
		System.out.println("Contato: " + morador2.getContato());
		System.out.println("Número do Apartamento: " + morador2.getNumeroApartamento());

		System.out.println("\nInformações do Funcionário:");
		System.out.println("Nome: " + funcionario.getNome());
		System.out.println("Endereço: " + funcionario.getEndereco());
		System.out.println("Contato: " + funcionario.getContato());
	}
}
