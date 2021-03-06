package com.prjcadcliente.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.prjcadcliente.dominio.Cliente;

/**
 * <b>CRUDCliente</b><br>
 * Essa classe p�rmite manipular as informa��es do cliente. Aqui voc�
 * encontrar� os seguintes comandos:
 * <ul>
 * 	<li>Cadastro</li>
 * <li>Pesquisar por nome e por id</li>
 * <li>Atualizar</li>
 * <li>Deletar</li>
 * </ul>
 * @author leandro.aopereira
 *
 */
public class CRUDCliente {
	
	private Connection con = null;
	private ResultSet rs = null;
	private PreparedStatement pst = null;
	
	public String cadastrar(Cliente cliente) {
		String msg = "";
		 
		// Cria��o dos Objetos para conexao com o banco de dados
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/clientedb","root","");
			
			String consulta = "INSERT INTO tbcliente(nome,email,telefone,idade)values()?,?,?,?)";
			
			pst = con.prepareStatement(consulta);
			
			pst.setString(1, cliente.getNome() );
			pst.setString(2, cliente.getEmail());
			pst.setString(3, cliente.getTelefone());
			pst.setInt(4, cliente.getIdade());
			
			int r = pst.executeUpdate();
			
			
			if(r > 0)
				msg = "Cadastro realizado com Sucesso!";
			else
				msg = "N�o foi Poss�vel Cadastrar!";
			
					
		}
		// catch mostra o erro
		catch(SQLException ex) {
			msg = "Erro ao tentar cadastrar:"+ex.getMessage();
			}
		catch(Exception e) {
			msg = "Erro Inesperado:"+e.getMessage();
		}
		finally {
			try{con.close();}catch(Exception e) {e.printStackTrace();}
		}
		
		return msg;
	
	
		
	}
	public String atualizar(Cliente cliente) {
		String msg = "";
		 
		// Cria��o dos Objetos para conexao com o banco de dados
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/clientedb","root","");
			
			// N�o se faz UPDATE sem WHERE
			String consulta = "UPDATE tbcliente SET nome=?,email=?,telefone=?,idade=? WHERE id=?";
			
			pst = con.prepareStatement(consulta);
			
			pst.setString(1, cliente.getNome() );
			pst.setString(2, cliente.getEmail());
			pst.setString(3, cliente.getTelefone());
			pst.setInt(4, cliente.getIdade());
			pst.setInt(5, cliente.getId());
			
			int r = pst.executeUpdate();
			
			
			if(r > 0)
				msg = " Atualizado com Sucesso!";
			else
				msg = "N�o foi Poss�vel Atualizar!";
			
					
		}
		// catch mostra o erro
		catch(SQLException ex) {
			msg = "Erro ao tentar atualizar:"+ex.getMessage();
			}
		catch(Exception e) {
			msg = "Erro Inesperado:"+e.getMessage();
		}
		finally {
			try{con.close();}catch(Exception e) {e.printStackTrace();}
		}
		
		return msg;
	
	}
	
	public String deletar(Cliente cliente) {
		String msg = "";
		 
		// Cria��o dos Objetos para conexao com o banco de dados
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/clientedb","root","");
			
			String consulta = "DELETE FROM tbcliente WHERE id=?";
			
			pst = con.prepareStatement(consulta);
			
			pst.setInt(1, cliente.getId() );
			
			
			int r = pst.executeUpdate();
			
			
			if(r > 0)
				msg = "Deletado com Sucesso!";
			else
				msg = "N�o foi Poss�vel Deletar!";
			
					
		}
		// catch mostra o erro
		catch(SQLException ex) {
			msg = "Erro ao tentar deletar:"+ex.getMessage();
			}
		catch(Exception e) {
			msg = "Erro Inesperado:"+e.getMessage();
		}
		finally {
			try{con.close();}catch(Exception e) {e.printStackTrace();}
		}
		
		return msg;
	
	}
	public List<Cliente> PesquisarPorNome(String Nome){
		return null;
	}
	
	public Cliente PesquisarPorId(int id){
		return null;
	}
	
	public List<Cliente> PesquisarTodos(){
		return null;
	}
	

}
