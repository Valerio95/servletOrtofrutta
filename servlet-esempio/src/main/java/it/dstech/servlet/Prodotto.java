package it.dstech.servlet;

public class Prodotto {
	
	private String nome;
    private int quantità;
    
	public Prodotto(String nome, int quantità) {
		this.nome = nome;
		this.quantità = quantità;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantità() {
		return quantità;
	}
	public void setQuantità(int quantità) {
		this.quantità = quantità;
	}
	@Override
	public String toString() {
		return "Prodotto [nome=" + nome + ", quantità=" + quantità + "]";
	}
    
}
