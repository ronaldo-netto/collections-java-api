package map.ordenacao;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Collections;
import map.ordenacao.Livro.ComparatorPorAutor;
import map.ordenacao.Livro.ComparatorPorPreco;

//import java.util.Comparator;

public class LivrariaOnline {

	private Map<String, Livro> livros;

	public LivrariaOnline() {
		this.livros = new LinkedHashMap<>();
	}

	public void adicionarLivro(String link, Livro livro) {
		this.livros.put(link, livro);
	}

	public void exibirLivros() {
		Set<Entry<String, Livro>> livross = this.livros.entrySet();
		if(!livros.isEmpty()) {
			for(Entry<String, Livro> li : livross) {
				String chave = li.getKey();
				Livro valor = li.getValue();

				System.out.println("{ Link: " + chave + " / Titulo: " + valor.getTitulo() + " / Autor: " + valor.getAutor() + " / Preço: " + valor.getPreco() + " }");
				System.out.println();
			}
		}
	}

	public void removerLivro(String titulo) {
		List<String> chavesRemover = new ArrayList<>();
		for (Map.Entry<String, Livro> entry : livros.entrySet()) {
			if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)) {
				chavesRemover.add(entry.getKey());
			}
		}
		for (String chave : chavesRemover) {
			livros.remove(chave);
		}
	}

	public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {
		List<Map.Entry<String, Livro>> livrosParaOrdenarPorPreco = new ArrayList<>(livros.entrySet());

		Collections.sort(livrosParaOrdenarPorPreco, new ComparatorPorPreco());

		Map<String, Livro> livrosOrdenadosPorPreco = new LinkedHashMap<>();

		for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorPreco) {
			livrosOrdenadosPorPreco.put(entry.getKey(), entry.getValue());
		}

		return livrosOrdenadosPorPreco;
	}


	public Map<String, Livro> exibirLivrosOrdenadosPorAutor() {
		List<Map.Entry<String, Livro>> livrosParaOrdenarPorAutor = new ArrayList<>(livros.entrySet());

		Collections.sort(livrosParaOrdenarPorAutor, new ComparatorPorAutor());

		Map<String, Livro> livrosOrdenadosPorAutor = new LinkedHashMap<>();

		for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorAutor) {
			livrosOrdenadosPorAutor.put(entry.getKey(), entry.getValue());
		}

		return livrosOrdenadosPorAutor;
	}

	public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
		Map<String, Livro> livrosPorAutor = new LinkedHashMap<>();
		for (Map.Entry<String, Livro> entry : livros.entrySet()) {
			Livro livro = entry.getValue();
			if (livro.getAutor().equalsIgnoreCase(autor)) {
				livrosPorAutor.put(entry.getKey(), livro);
			}
		}
		return livrosPorAutor;
	}



	public List<Livro> obterLivroMaisCaro() {
		List<Livro> livroMaisCaros = new ArrayList<>();
		double precoMaisAlto = Double.MIN_VALUE;

		if (!livros.isEmpty()) {
			for (Livro livro : livros.values()) {
				if (livro.getPreco() > precoMaisAlto) {
					precoMaisAlto = livro.getPreco();
				}
			}
		} else {
			System.out.println("A livraria está vazia!");
		}

		for (Map.Entry<String, Livro> entry : livros.entrySet()) {
			if (entry.getValue().getPreco() == precoMaisAlto) {
				Livro livroComPrecoMaisAlto = livros.get(entry.getKey());
				livroMaisCaros.add(livroComPrecoMaisAlto);
			}
		}
		return livroMaisCaros;
	}


	public List<Livro> obterLivroMaisBarato(){
		List<Livro> livroMaisBaratos = new ArrayList<>();
		double precoMaisBaixo = Double.MAX_VALUE;

		if(!livros.isEmpty()) {
			for(Livro livro: livros.values()) {
				if(livro.getPreco() < precoMaisBaixo) {
					precoMaisBaixo = livro.getPreco();
				}
			}
		}else {
			System.out.println("A livraria está vazia!");
		}

		for(Map.Entry<String, Livro> entry : livros.entrySet()) {
			if(entry.getValue().getPreco() == precoMaisBaixo) {
				Livro livroComPrecoMaisAlto = livros.get(entry.getKey());
				livroMaisBaratos.add(livroComPrecoMaisAlto);
			}
		}
		return livroMaisBaratos;
	}


	public static void main(String[] args) {
		LivrariaOnline livrariaOnline = new LivrariaOnline();
		// Adiciona os livros à livraria online
		livrariaOnline.adicionarLivro("https://amzn.to/3EclT8Z", new Livro("1984", "George Orwell", 50d));
		livrariaOnline.adicionarLivro("https://amzn.to/47Umiun", new Livro("A Revolução dos Bichos", "George Orwell", 7.05d));
		livrariaOnline.adicionarLivro("https://amzn.to/3L1FFI6", new Livro("Caixa de Pássaros - Bird Box: Não Abra os Olhos", "Josh Malerman", 19.99d));
		livrariaOnline.adicionarLivro("https://amzn.to/3OYb9jk", new Livro("Malorie", "Josh Malerman", 5d));
		livrariaOnline.adicionarLivro("https://amzn.to/45HQE1L", new Livro("E Não Sobrou Nenhum", "Agatha Christie", 50d));
		livrariaOnline.adicionarLivro("https://amzn.to/45u86q4", new Livro("Assassinato no Expresso do Oriente", "Agatha Christie", 5d));

		// Exibe todos os livros ordenados por preço
		System.out.println("Livros ordenados por preço: \n" + livrariaOnline.exibirLivrosOrdenadosPorPreco());

		//Exibe todos os livros ordenados por autor
		System.out.println("Livros ordenados por autor: \n" + livrariaOnline.exibirLivrosOrdenadosPorAutor());

		// Pesquisa livros por autor
		String autorPesquisa = "Josh Malerman";
		livrariaOnline.pesquisarLivrosPorAutor(autorPesquisa);

		// Obtém e exibe o livro mais caro
		System.out.println("Livro mais caro: " + livrariaOnline.obterLivroMaisCaro());

		// Obtém e exibe o livro mais barato
		System.out.println("Livro mais barato: " + livrariaOnline.obterLivroMaisBarato());

		// Remover um livro pelo título
		livrariaOnline.removerLivro("1984");
		System.out.println(livrariaOnline.livros);

	}

}
