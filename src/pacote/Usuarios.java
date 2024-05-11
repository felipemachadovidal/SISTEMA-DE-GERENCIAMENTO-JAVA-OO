package pacote;

abstract class Usuarios {
    private String nome;
    private String endereco;
    private String contato;

    public Usuarios(String nome, String endereco, String contato) {
        this.nome = nome;
        this.endereco = endereco;
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getContato() {
        return contato;
    }
}