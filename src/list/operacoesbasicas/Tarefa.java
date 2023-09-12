/**
 * @author ronaldo neto
 */
package list.operacoesbasicas;

/**
 * Representa uma tarefa com uma descrição.
 */
public class Tarefa {

	/**
	 * Atributo.
	 */
	private String descricao;

	/**
	 * Obtém a descrição da tarefa.
	 * 
	 * @return A descrição da tarefa.
	 */
	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * Cria uma nova instância de Tarefa com a descrição especificada.
	 * 
	 * @param descricao A descrição a ser atribuída á tarefa.
	 */
	public Tarefa(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return descricao ;
	}
	
	

}
