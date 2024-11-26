package tarefa;

import kanban.Util.Cores;

public class Tarefa {
	private int id;
	private String nome;
	private String descricao;

	public Tarefa(int id, String nome, String decricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = decricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDecricao() {
		return descricao;
	}

	public void setDecricao(String decricao) {
		this.descricao = decricao;
	}

	public void visualizar() {

		System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_YELLOW_BOLD_BRIGHT + "ID: "
				+ Cores.TEXT_WHITE_BOLD_BRIGHT + this.getId());
		System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "Nome: " + Cores.TEXT_WHITE_BOLD_BRIGHT + this.getNome());
		System.out.println(
				Cores.TEXT_YELLOW_BOLD_BRIGHT + "Descrição: " + Cores.TEXT_WHITE_BOLD_BRIGHT + this.getDecricao());

	}

}
