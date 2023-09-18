package map.ordenacao;

public class Evento {

	private String nome;
	private String atracao;

	public Evento() {

	}

	public Evento(String nome, String atracao) {
		this.nome = nome;
		this.atracao = atracao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nomeEvento) {
		this.nome = nomeEvento;
	}

	public String getAtracao() {
		return atracao;
	}

	public void setAtracao(String nomeAtracao) {
		this.atracao = nomeAtracao;
	}

	@Override
	public String toString() {
		return "{ " + "Evento: " + this.nome + "Atração: " + this.atracao + " }";
	}

}
