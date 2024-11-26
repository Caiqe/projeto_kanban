package testeKanban;

import java.util.InputMismatchException;
import java.util.Scanner;

import coluna.Coluna;
import kanban.Util.Cores;
import tarefa.Tarefa;

public class TesteKanban {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Coluna toDo = new Coluna();
		Coluna doing = new Coluna();
		Coluna done = new Coluna();
		int opcao = -1, id, destino, coluna;

		do {
			try {
				System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_CYAN_BOLD_BRIGHT + "\n");
				System.out.println(" +-----------SpeedProject-----------+ ");
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + " |                                  | ");
				System.out.println(" |     [1] - Adicionar Tarefa       | ");
				System.out.println(" |     [2] - Remover Tarefa         | ");
				System.out.println(" |     [3] - Mover Tarefa           | ");
				System.out.println(" |     [4] - Mostrar Quadro         | ");
				System.out.println(" |                                  | ");
				System.out.println(" |     " + Cores.TEXT_RED_BOLD_BRIGHT + "[0] - Sair" + Cores.TEXT_WHITE_BOLD_BRIGHT
						+ "                   | ");
				System.out.println(" |                                  | ");
				System.out.println(Cores.TEXT_CYAN_BOLD_BRIGHT + " +----------------------------------+ ");
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "          Escolha uma opção:          ");
				opcao = sc.nextInt();

				switch (opcao) {
				case 1 -> {
					System.out.println(Cores.TEXT_CYAN_BOLD_BRIGHT + "+-------- Adicionar Tarefa --------+");
					do {
						System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "Informe um ID para a tarefa:        ");
						id = sc.nextInt();
					} while (toDo.checarId(id));
					sc.nextLine();
					System.out.println("Informe um nome para Tarefa: ");
					String nome = sc.nextLine();
					System.out.println("Qual a descrição da Tarefa?");
					String descricao = sc.nextLine();
					toDo.adicionarTarefa(new Tarefa(id, nome, descricao));
					System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + "TAREFA ADICIONADA A COLUNA 'To Do'!");
				}
				case 2 -> {
					if (toDo.checarColuna() && doing.checarColuna() && done.checarColuna()) {
						System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "NENHUMA TAREFA EXISTENTE!");
					} else {
						System.out.println(Cores.TEXT_CYAN_BOLD_BRIGHT + "+-------- Remover Tarefa --------+");
						System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "Informe o ID da Tarefa:           ");
						id = sc.nextInt();
						do {
							System.out.println("Informe a lista onde está a Tarefa:          ");
							System.out.println(" [1] - ToDo                                  ");
							System.out.println(" [2] - Doing                                 ");
							System.out.println(" [3] - Done                                  ");
							System.out.println("                                             ");
							coluna = sc.nextInt();
						} while (coluna < 1 || coluna > 3);
						switch (coluna) {
						case 1 -> {
							if (toDo.tarefaContains(id)) {
								toDo.removerTarefa(id);
								System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + "TAREFA REMOVIDA!");
							} else {
								System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "Tarefa não encontrada!");
							}
						}
						case 2 -> {
							if (doing.tarefaContains(id)) {
								doing.removerTarefa(id);
								System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + "TAREFA REMOVIDA!");
							} else {
								System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "Tarefa não encontrada!");
							}
						}
						case 3 -> {
							if (done.tarefaContains(id)) {
								done.removerTarefa(id);
							} else {
								System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "Tarefa não encontrada!");
							}
						}
						default -> {
							System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "Opção inválida!");
						}
						}
					}
				}
				case 3 -> {
					if (toDo.checarColuna() && doing.checarColuna() && done.checarColuna()) {
						System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "NENHUMA TAREFA EXISTENTE!");
					} else {
						System.out.println(Cores.TEXT_CYAN_BOLD_BRIGHT + "+-------- Mover Tarefa --------+");
						System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "Informe o ID da Tarefa: ");
						id = sc.nextInt();
						System.out.println("Informe a lista de origem da Tarefa:         ");
						System.out.println(" [1] - ToDo                                  ");
						System.out.println(" [2] - Doing                                 ");
						System.out.println(" [3] - Done                                  ");
						System.out.println("                                             ");
						coluna = sc.nextInt();

						switch (coluna) {
						case 1 -> {
							if (toDo.tarefaContains(id)) {
								do {
									System.out.println("Informe a lista de destino da Tarefa:        ");
									System.out.println(" [1] - Doing                                 ");
									System.out.println(" [2] - Done                                  ");
									System.out.println("                                             ");
									destino = sc.nextInt();
								} while (destino < 1 || destino > 2);
								sc.nextLine();

								switch (destino) {
								case 1 -> toDo.moverTarefa(id, toDo, doing);
								case 2 -> toDo.moverTarefa(id, toDo, done);
								default -> System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "Opção inválida!");
								}

							} else {
								System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "Tarefa não encontrada!");
							}
						}

						case 2 -> {
							if (doing.tarefaContains(id)) {
								do {
									System.out.println("Informe a lista de destino da Tarefa:        ");
									System.out.println(" [1] - To Do                                 ");
									System.out.println(" [2] - Done                                  ");
									System.out.println("                                             ");
									destino = sc.nextInt();
								} while (destino < 1 || destino > 2);
								switch (destino) {
								case 1 -> doing.moverTarefa(id, doing, toDo);
								case 2 -> doing.moverTarefa(id, doing, done);
								default -> System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "Opção inválida!");
								}

							} else {
								System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "Tarefa não encontrada!");
							}
						}
						case 3 -> {
							if (done.tarefaContains(id)) {
								do {
									System.out.println("Informe a lista de destino da Tarefa:        ");
									System.out.println(" [1] - To Do                                 ");
									System.out.println(" [2] - Doing                                 ");
									System.out.println("                                             ");
									destino = sc.nextInt();
								} while (destino < 1 || destino > 2);
								switch (destino) {
								case 1 -> done.moverTarefa(id, done, toDo);
								case 2 -> done.moverTarefa(id, done, doing);
								}

							} else {
								System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "Tarefa não encontrada!");
							}
						}
						default -> {
							System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "Opção inválida!");
						}
						}
					}
				}
				case 4 -> {
					System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "\n+------------ Quadro: -------------+");
					System.out.println("                                    ");
					System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_CYAN_BOLD_BRIGHT
							+ "+------------- To Do: -------------+");
					toDo.mostrarColuna();
					System.out.println(Cores.TEXT_CYAN_BOLD_BRIGHT + "\n+------------- Doing: -------------+");
					doing.mostrarColuna();
					System.out.println(Cores.TEXT_CYAN_BOLD_BRIGHT + "\n+------------- Done: --------------+");
					done.mostrarColuna();

				}
				}
			} catch (InputMismatchException e) {
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "Informe um valor válido!");
				sc.nextLine();
			}

		} while (opcao != 0);
		sobre();

		sc.close();
	}

	public static void sobre() {
		System.out.println(Cores.TEXT_CYAN_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
				+ "                                                ");
		System.out.println(" SpeedProject - Mais Agilidade para sua vida!   ");
		System.out.println("                                                ");
		System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + " Projeto desenvolvido por: Caique Gomes         ");
		System.out.println("                           Isak Amorim          ");
		System.out.println("                           Henrique Neves       ");
		System.out.println("                                                ");
		System.out.println("       Fundação Salvador Arena - CEFSA          ");
		System.out.println("                                                ");
	}

}
