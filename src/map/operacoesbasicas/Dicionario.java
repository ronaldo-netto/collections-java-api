package map.operacoesbasicas;

import java.util.Map;
import java.util.HashMap;

public class Dicionario {

	private Map<String, String> dicionarioMap;

	public Dicionario() {
		this.dicionarioMap = new HashMap<>();
	}

	public void adicionarPalavra(String palavra, String definicao) {
       this.dicionarioMap.put(palavra, definicao);
	}
	
	public void removerPalavra(String palavra) {
		String removerPalavra = null;
		
		if(!dicionarioMap.isEmpty()) {
			
		}
	}

}
