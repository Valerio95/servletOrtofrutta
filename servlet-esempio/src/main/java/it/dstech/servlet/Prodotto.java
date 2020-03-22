package it.dstech.servlet;

public class Prodotto {
	
	private String nome;
    private int quantit�;
    
	public Prodotto(String nome, int quantit�) {
		this.nome = nome;
		this.quantit� = quantit�;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantit�() {
		return quantit�;
	}
	public void setQuantit�(int quantit�) {
		this.quantit� = quantit�;
	}
	@Override
	public String toString() {
		return "Prodotto [nome=" + nome + ", quantit�=" + quantit� + "]";
	}
    
}
