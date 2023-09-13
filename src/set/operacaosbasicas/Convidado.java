package set.operacaosbasicas;

import java.util.Objects;

public class Convidado {
	private String nome;
	private int codigoConvite;

	public Convidado() {
	};

	public Convidado(String nome, int codigo) {
		this.nome = nome;
		this.codigoConvite = codigo;
	}

	public String getNome() {
		return nome;
	}

	public int getCodigoConvite() {
		return codigoConvite;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoConvite, nome);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Convidado convidado))
			return false;
		return getCodigoConvite() == convidado.getCodigoConvite();
	}

	@Override
	public String toString() {
		return "Nome: " + nome + " Código: " + codigoConvite + "";
	}

}
