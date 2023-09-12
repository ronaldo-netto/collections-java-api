/**
 * @author ronaldo neto
 */
package list.OperacoesBasicas;

public class Item {

	/**
	 * Atributos da classe item
	 */
	private String nome;
	private double preco;
	private int quantidade;

	/**
	 *
	 * @param nome  O nome do item a ser adicionado
	 * @param preco O preco do item a ser adicionado
	 * @param quant A quantidade do item a ser adicionado
	 */
	public Item(String nome, double preco, int quantidade) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

	public int getQuant() {
		return quantidade;
	}

	/**
	 * Sobrescrevendo o método toString da classe Item
	 */
	@Override
	public String toString() {
		return "Item{" + "nome='" + nome + '\'' + ", preco=" + preco + ", quant=" + quantidade + '}';
	}
}
