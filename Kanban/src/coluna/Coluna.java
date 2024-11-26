package coluna;

import java.util.ArrayList;
import java.util.List;

import kanban.Util.Cores;
import tarefa.Tarefa;

public class Coluna {
	Tarefa tarefaRemover;

	private List<Tarefa> listaTarefa = new ArrayList<Tarefa>();

	public Coluna() {

	}

	public List<Tarefa> getListaTarefa() {
		return listaTarefa;
	}

	public void setListaTarefa(List<Tarefa> listaTarefa) {
		this.listaTarefa = listaTarefa;
	}

	public void adicionarTarefa(Tarefa tarefa) {

		listaTarefa.add(tarefa);

	}

	public void removerTarefa(int id) {
		int contador = 0;

		for (Tarefa tarefa : listaTarefa) {
			if (tarefa.getId() == id) {
				tarefaRemover = tarefa;
				contador = 1;
			}
		}
		listaTarefa.remove(tarefaRemover);
		if (contador == 1) {

		} else {
			System.out.println("TAREFA NÃO ENCONTRADA!");
		}
	}

	public boolean checarId(int id) {
		for (Tarefa tarefa : listaTarefa) {
			if (tarefa.getId() == id) {
				return true;
			}
		}
		return false;
	}

	public Tarefa retornaTarefa(int id) {
		for (Tarefa tarefa : listaTarefa) {
			if (tarefa.getId() == id) {
				return tarefa;
			}
		}
		return null;
	}

	public void moverTarefa(int id, Coluna origem, Coluna destino) {
		var listaOrigem = origem;
		var listaDestino = destino;
		if (this.retornaTarefa(id) != null) {
			listaDestino.adicionarTarefa(this.retornaTarefa(id));
			listaOrigem.removerTarefa(id);
			System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT +"\nTarefa Movida!");

		}

	}

	public boolean tarefaContains(int id) {
		for (Tarefa tarefa : listaTarefa) {
			if (tarefa.getId() == id) {
				return true;
			}
		}
		return false;
	}

	public void mostrarColuna() {

		if (listaTarefa.isEmpty()) {
			System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "        Sem tarefas por aqui!       ");
		} else {
			for (Tarefa tarefa : listaTarefa) {
				tarefa.visualizar();
			}
		}
	}

	public boolean checarColuna() {
		if (listaTarefa.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}
