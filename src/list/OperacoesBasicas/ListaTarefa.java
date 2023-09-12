/**
 * @author ronaldo neto
 */
package list.OperacoesBasicas;

import java.util.List;
import java.util.ArrayList;

public class ListaTarefa {
	/**
	 * Lista de tarefas que armazena as tarefas adicionadas.
	 */
	private List<Tarefa> tarefaList;

	/**
	 * Cria uma nova instância de ListaTarefa e inicializa a lista de tarefas como vazia.
	 */
	public ListaTarefa() {
		this.tarefaList = new ArrayList<>();
	}
	
	/**
	 * Adiciona uma nova tarefa à lista de tarefas.
	 * 
	 * @param descricao A descrição da nova tarefa a ser adicionada.
	 */
	public void adicionarTarefa(String descricao) {
		tarefaList.add(new Tarefa(descricao));
	}
   
	/**
	 * Remove todas as tarefas da lista que correspondem à descrição especificada.
	 * 
	 * @param descricao A descrição da tarefa a ser removida.
	 */
	public void removerTarefa(String descricao) {
		List<Tarefa> tarefasParaRemover = new ArrayList<>();
		for (Tarefa t : tarefaList) {
			if (t.getDescricao().equalsIgnoreCase(descricao)) {
				tarefasParaRemover.add(t);
			}
		}
		tarefaList.removeAll(tarefasParaRemover);
	}
    
	/**
	 * Obtém o número total de tarefas na lista.
	 * 
     * @return O número total de tarefas na lista
	 */
	public int obterNumeroTotalTarefas() {
		return tarefaList.size();
	}
    
	/**
	 * Exibe as descrições das tarefas na lista.
	 */
	public void obterDescricoesTarefas() {
		System.out.println(tarefaList);
	}
	
	
	/**
	 * 
	 * main
	 */
	public static void main(String[] args) {
		
		ListaTarefa listaTarefa = new ListaTarefa();
		
		System.out.println("Número total de elementos na lista: " + listaTarefa.obterNumeroTotalTarefas());
		
		listaTarefa.adicionarTarefa("Tarefa 1");
		listaTarefa.adicionarTarefa("Tarefa 1");
		listaTarefa.adicionarTarefa("Tarefa 2");
		
		System.out.println("Número total de elementos na lista: " + listaTarefa.obterNumeroTotalTarefas());
		
		listaTarefa.removerTarefa("tarefa 1");
		
		System.out.println("Número total de elementos na lista: " + listaTarefa.obterNumeroTotalTarefas());
		
		listaTarefa.obterDescricoesTarefas();
	}
}
