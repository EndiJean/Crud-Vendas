/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Funcionarios;
import br.com.projeto.view.FmrLogin;
import br.com.projeto.view.Frmmenu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Endi Jean
 */
public class FuncionariosDAO {

    private Connection con;

    public FuncionariosDAO() {

        this.con = new ConnectionFactory().getConnection();

    }
    
     public void cadastrarFuncionarios(Funcionarios obj) {
        try {

            String sql = "INSERT INTO tb_funcionarios (nome,rg,cpf,email,senha,cargo,nivel_acesso,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado) "
                    + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getUf());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro " + erro);

        }
    }
     
     public void alterarFuncionarios(Funcionarios obj) {

        try {

            String sql = "UPDATE tb_funcionarios SET nome = ?,rg = ?,cpf = ?"
                    + ",email = ?,senha = ?,cargo = ?,nivel_acesso = ?,"
                    + "telefone = ?,celular = ?,cep = ?,endereco = ?,numero = ?,"
                    + "complemento = ?,bairro = ?,cidade = ?,estado = ? WHERE id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());            
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getUf());
            stmt.setInt(17, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro " + erro);

        }

    }

    public void excluirFuncionarios(Funcionarios obj) {
        try {

            String sql = "DELETE FROM tb_funcionarios WHERE id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro " + erro);

        }

    }
     
     
     public List<Funcionarios> listarFuncionarios() {

        try {

            //Criar lista
            List<Funcionarios> lista = new ArrayList<>();

            String sql = ("SELECT * FROM tb_funcionarios");

            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionarios obj = new Funcionarios();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);

            }

            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro " + erro);
            return null;
        }

    }
     
     //metodo consultar Funcionarios por nome
    public Funcionarios consultaPorNome(String nome) {

        try {

            String sql = "SELECT * FROM tb_funcionarios WHERE nome = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            Funcionarios obj = new Funcionarios();

            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                 obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

            }

            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Funcionario não encontrado!");

            return null;

        }

    }
    //metodo buscar Funcionarios por nome - retorna uma lista

    public List<Funcionarios> listarFuncionarioPorNome(String nome) {

        try {

            //Criar lista
            List<Funcionarios> lista = new ArrayList<>();

            String sql = "SELECT * FROM tb_funcionarios WHERE nome LIKE ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionarios obj = new Funcionarios();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                 obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);

            }

            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro " + erro);
            return null;
        }

    }

    public List<Funcionarios> listarFuncionarioPorNome() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //Metodo efetua login
    
    public void efetuarLogin(String email, String senha){
        
        try {
        
            String sql = "SELECT * FROM tb_funcionarios WHERE email = ? and senha = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            
             ResultSet rs = stmt.executeQuery();
            
             if (rs.next()){
                 
                 if(rs.getString("nivel_acesso").equals("admin")){
                     JOptionPane.showMessageDialog(null, "Seja bem vindo ao sistema");                
                     Frmmenu tela = new Frmmenu();
                     tela.usuariologado = rs.getString("nome");
                     tela.setVisible(true);
                 }
                 
                 else if(rs.getString("nivel_acesso").equals("Usuário")){
                     JOptionPane.showMessageDialog(null, "Seja bem vindo ao sistema");                
                     Frmmenu tela = new Frmmenu();
                     tela.usuariologado = rs.getString("nome");
                    
                     tela.menu_posicao.setEnabled(false);
                     tela.menu_controlevendas.setEnabled(false);
                     
                     tela.setVisible(true);
                 }
                 
             } else {
                 JOptionPane.showMessageDialog(null, "Dados incorretos");                 
                 new FmrLogin().setVisible(true);

             }
             
            
        } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro: " + erro); 
        }
        
    }
    

}
