package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.Conexao;
import model.Aluno;

public class AlunoDAO {
	
	public void inserirAluno(Aluno aluno) throws Exception{
		String sql = "INSERT INTO Aluno (nome, cpf, idade, plano, mensalidade) VALUES (?, ?, ?, ?, ?)";
		
		try (Connection conn = Conexao.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setString(1, aluno.getNome());
			ps.setString(2, aluno.getCpf());
			ps.setInt(3, aluno.getIdade());
			ps.setString(4, aluno.getPlano());
			ps.setDouble(5, aluno.getMensalidade());
			
			ps.executeUpdate();
			System.out.println("Aluno Cadastrado com Sucesso!");
		} 
	}
	
	public List<Aluno> listar() throws Exception {
		List<Aluno> lista = new ArrayList<>();
		
		String sql = "SELECT * FROM alunos";
		
		try (Connection conn = Conexao.getConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			
			while (rs.next()) {
				Aluno aluno = new Aluno(
						rs.getString("nome"),
						rs.getString("cpf"),
						rs.getInt("idade"),
						rs.getString("plano"),
						rs.getDouble("mensalidade"));
				
				lista.add(aluno);
				
				}
			
		}
		return lista;
	}
	
	public Aluno buscarAlunoPorCpf(String cpf) throws Exception {
		String sql = "SELECT * FROM Alunos WHERE cpf = ?";
		
		try (Connection conn = Conexao.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setString(1, cpf);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				return new Aluno(
						rs.getString("nome"),
						rs.getString("cpf"),
						rs.getInt("idade"),
						rs.getString("plano"),
						rs.getDouble("mensalidade"));
				
			}
		}
		return null;
	}
	
	public void atualizarPlano(String cpf, String plano) throws Exception {
		String sql = "SELECT * FROM Alunos WHERE cpf = ? ";
		
		try (Connection conn = Conexao.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setString(1, cpf);
			ps.setString(2, plano);
			
			ps.executeUpdate();
			System.out.println("Plano atualizado com sucesso!");
			
		}
	}
	
	public void deletar(String cpf) throws Exception {
		String sql = "SELECT * FROM Alunos WHERE cpf = ?";
		
		try (Connection conn = Conexao.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setString(1, cpf);
			ps.executeUpdate();
			
		}
	}
}
