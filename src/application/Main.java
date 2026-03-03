package application;

import java.util.List;
import java.util.Scanner;

import dao.AlunoDAO;
import model.Aluno;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		AlunoDAO dao = new AlunoDAO();
		
		while (true) {
			System.out.println("--------------------------");
			System.out.println("Bem vindo ao menu da academia, o que deseja?");
			System.out.println("1 - Cadastrar aluno");
			System.out.println("2 - Listar alunos");
			System.out.println("3 - Buscar alunos pelo cpf");
			System.out.println("4 - Atualizar plano da academia");
			System.out.println("5 - Deletar");
			System.out.println("0 - Sair");
			System.out.println("Escolha uma das opções acima: ");
			
			int op = sc.nextInt();
			sc.nextLine();
			
			switch (op) {
			case 1:
				System.out.print("Nome: ");
				String nome = sc.nextLine();
				System.out.print("CPF: ");
				String cpf = sc.nextLine();
				System.out.print("Idade");
				int idade = sc.nextInt();
				System.out.print("Plano");
				String plano = sc.nextLine();
				System.out.print("Mensalidade");
				double mensalidade = sc.nextDouble();
				
				dao.inserirAluno(new Aluno(nome, cpf, idade, plano, mensalidade));
				break;
			case 2:
				List<Aluno> alunos = dao.listar();
				alunos.forEach(a -> System.out.println(a.getNome() + " - " + a.getPlano()));
				break;
				
				
			case 3:
				System.out.print("CPF: ");
				String buscaCPF = sc.nextLine();
				Aluno aluno = dao.buscarAlunoPorCpf(buscaCPF);
				
				if(aluno != null) {
					System.out.println(aluno.getNome());
				} 
				else {
					System.out.println("Aluno não encontrado.");
				}
				break;
				
			case 4: 
				System.out.print("Digite o cpf: ");
				String cpfUpdate = sc.nextLine();
				System.out.print("Novo plano: ");
				String novoPlano = sc.nextLine();
				dao.atualizarPlano(cpfUpdate, novoPlano);
				break;
			case 5:
				System.out.print("Digite o cpf: " );
				String cpfDelete = sc.nextLine();
				dao.deletar(cpfDelete);
				break;
			}
			sc.close();
		}
		
	}

}
