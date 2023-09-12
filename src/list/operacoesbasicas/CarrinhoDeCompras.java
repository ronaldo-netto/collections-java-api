/**
 * @author ronaldo neto
 */
package list.operacoesbasicas;

import java.util.List;
import java.util.ArrayList;

public class CarrinhoDeCompras {

	/**
	 * Lista de item no carrinho de compras
	 */
	private List<Item> itemList;

	/**
	 * Construtor vazio para inicializar a lista de itens do carrinho de compras.
	 */
	public CarrinhoDeCompras() {
		this.itemList = new ArrayList<>();
	}

	/**
	 * Cria um novo item e adiciona e o adiciona á lista de itens do carrinho
	 * 
	 * @param nome       O nome do item a ser adicionado
	 * @param preco      O preco do item a ser adicionado
	 * @param quantidade A quantidade do item a ser adicionado
	 */
	public void adicionarItem(String nome, double preco, int quantidade) {
		Item item = new Item(nome, preco, quantidade);
		this.itemList.add(item);
	}

	/**
	 * Usado para remover itens da lista
	 * 
	 * @param nome O nome do item que vai ser removido
	 */
	public void removerItem(String nome) {
		List<Item> itensParaRemover = new ArrayList<>();
		if (!itemList.isEmpty()) {
			for (Item i : itemList) {
				if (i.getNome().equalsIgnoreCase(nome)) {
					itensParaRemover.add(i);
				}
			}
			itemList.removeAll(itensParaRemover);
		} else {
			System.out.println("A lista está vazia!");
		}
	}

	/**
	 * 
	 * @return double valor total dos itens armazenados na lista
	 */
	public double calcularValorTotal() {
		double valorTotal = 0d;
		if (!itemList.isEmpty()) {
			for (Item item : itemList) {
				double valorItem = item.getPreco() * item.getQuant();
				valorTotal += valorItem; // valorTotal = valorTotal + valorItem;
			}
			return valorTotal;
		} else {
			throw new RuntimeException("A lista está vazia!");
		}
	}

	/**
	 * Exibi todos os itens da lista.
	 */
	public void exibirItens() {
		if (!itemList.isEmpty()) {
			System.out.println(this.itemList);
		} else {
			System.out.println("A lista está vazia!");
		}
	}

	/**
	 * Sobrescrevendo o método toString
	 */
	@Override
	public String toString() {
		return "CarrinhoDeCompras{" + "itens=" + itemList + '}';
	}

	public static void main(String[] args) {
		// Criando uma instância do carrinho de compras
		CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

		// Adicionando itens ao carrinho
		carrinhoDeCompras.adicionarItem("Lápis", 2d, 3);
		carrinhoDeCompras.adicionarItem("Lápis", 2d, 3);
		carrinhoDeCompras.adicionarItem("Caderno", 35d, 1);
		carrinhoDeCompras.adicionarItem("Borracha", 2d, 2);

		// Exibindo os itens no carrinho
		carrinhoDeCompras.exibirItens();

		// Removendo um item do carrinho
		carrinhoDeCompras.removerItem("Lápis");

		// Exibindo os itens atualizados no carrinho
		carrinhoDeCompras.exibirItens();

		// Calculando e exibindo o valor total da compra
		System.out.println("O valor total da compra é = " + carrinhoDeCompras.calcularValorTotal());
	}
}
