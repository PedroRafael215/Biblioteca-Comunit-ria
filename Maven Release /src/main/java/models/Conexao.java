/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import com.mycompany.av2maven.UserAdmTela;
import models.Administradores;
import models.Livros;
import com.sun.tools.javac.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author pedro
 * Essa classe possui metodos que se conectam ao banco de dados e realiza validações importantes para a aplicação.
 */
public class Conexao {
    
   public static ArrayList<Administradores> administradores = new ArrayList<Administradores>();
   public static ArrayList<Livros> livros = new ArrayList<Livros>();
   public static ArrayList<Membros> membros = new ArrayList<Membros>();
   
   public static ArrayList<Emprestimos> emprestimos = new ArrayList<Emprestimos>();
   public static ArrayList<Integer> diasEmprestimo = new ArrayList<Integer>();
   public static ArrayList<EmprestimosAtrasados> emprestimosAtrasados = new ArrayList<EmprestimosAtrasados>();
   public static ArrayList<EmprestimosAtrasados> listaDevedores = new ArrayList<EmprestimosAtrasados>();
   public static ArrayList<Devolucoes> devolucoes = new ArrayList<Devolucoes>();
    
   /**
    * Conexão ao banco de dados
    * @return
    * @throws SQLException 
    */
public static Connection Conectar() throws SQLException{
        String URL_SERVIDOR = "jdbc:sqlite::resource:Biblioteca.db";
                //"jdbc:sqlite::resource:Biblioteca.db";
                //"jdbc:sqlite:C:\\Users\\pedro\\Documents\\NetBeansProjects\\AV2Maven\\src\\main\\java\\com\\mycompany\\av2maven\\Biblioteca.db";
        
        try{
        Connection conn = DriverManager.getConnection(URL_SERVIDOR);
            System.out.println("Conexão bem sucedida");
            return conn;
    }catch(Exception e){
        e.printStackTrace();
            System.out.println("Erro ao conectar ao banco de dados");
            return null;
    }
        
        
    }
/**
 * Fecha a conexão com o banco de dados
 * @param conn 
 */    
public static void Desconectar(Connection conn){
        
        try {
            conn.close();
            System.out.println("Desconectando...");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }


/**
 * Importa informações do banco de dados de todas as devoluções  na interface
 */
public static void ImportarDevolucoes(){
    
    
    String sql = "SELECT * FROM Devolucoes";
                 try {
                      Connection conn = Conectar();
                      
                      PreparedStatement DevolucoesStatement = conn.prepareStatement(sql);
                      ResultSet res = DevolucoesStatement.executeQuery();
                      
                      while(res.next()){
                          Devolucoes a = new Devolucoes();
                          
                          a.setId(res.getInt(1));
                          a.setMembro(res.getString(2));
                          a.setLivro(res.getString(3));
                          a.setData_devolucao(res.getString(4));
                          devolucoes.add(a);
                          
                      }
                      
                      DevolucoesStatement.close();
                      Desconectar(conn);
                      
                      
                      
                 } catch (SQLException ex) {
                     Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
             }
    
    
    
}

/**
 * Verifica se há algum emprestimo em atraso no banco de dados. Se houver, importa informações do banco de dados
 */
public static void ImportarANDSetarEmprestimosAtrasados(/*Emprestimos e*/){
    //String dataPrevistaDevolucao = e.getData_devolucao();
    LocalDate dataAtual = LocalDate.now();
    for(int i = 0; i < emprestimos.size(); i++){
        
        String dataDev = dataFormatoCerto(emprestimos.get(i).getData_devolucao());
        LocalDate dataDevParsed = LocalDate.parse(dataDev);
        
        if(dataAtual.isAfter(dataDevParsed)){
            Period atraso = dataDevParsed.until(dataAtual);
            int diasAtraso = atraso.getDays();
            
            //import data below to EmprestimosAtrasados Object, and them, add to its ArrayList
            int id = emprestimos.get(i).getId();
            String id_usuario = emprestimos.get(i).getId_usuario();
            String id_livro = emprestimos.get(i).getId_livro();
            String data_pedido = emprestimos.get(i).getData_pedido();
            String data_devolucao = emprestimos.get(i).getData_devolucao();
            int dias_atraso = diasAtraso;
            
            EmprestimosAtrasados a = new EmprestimosAtrasados();
            a.setId(id);
            a.setId_usuario(id_usuario);
            a.setId_livro(id_livro);
            a.setData_pedido(data_pedido);
            a.setData_devolucao(data_devolucao);
            a.setDias_atraso(dias_atraso);
            emprestimosAtrasados.add(a);
        }
    
    
    }
    
    
    
} 

/**
 * Importa os Emprestimos registrados no banco de dados 
 */
public static void importarEmprestimos(){
    
    String sql = "SELECT E.id, M.nome, L.titulo, E.data_pedido, E.data_devolucao FROM Membros AS M, Livros AS L, Emprestimos AS E WHERE M.id = E.id_usuario AND L.id = E.id_livro";
                //emprestimos.clear();  
                try {
                      Connection conn = Conectar();
                      
                      PreparedStatement emprestimosStatement = conn.prepareStatement(sql);
                      ResultSet res = emprestimosStatement.executeQuery();
                      
                      while(res.next()){
                          Emprestimos a = new Emprestimos();
                          
                          a.setId(res.getInt(1));
                          a.setId_usuario(res.getString(2));
                          a.setId_livro(res.getString(3));
                          a.setData_pedido(res.getString(4));
                          a.setData_devolucao(res.getString(5));
                          
                          emprestimos.add(a);
                          
                      }
                      
                      emprestimosStatement.close();
                      Desconectar(conn);
                      
                      
                      
                 } catch (SQLException ex) {
                     Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
             }
    
                if(emprestimosAtrasados.isEmpty()){
                    ImportarANDSetarEmprestimosAtrasados();
                }
    
    
}

/**
 * Deleta um emprestimo realizado no banco de dados
 * @param e 
 */
public static void deletarEmprestimo(Emprestimos e){
    
    int id = e.getId(); 
    String membro = e.getId_usuario();
    String livro = e.getId_livro(); 
    String data_devolucao = e.getData_devolucao();
    String DELETAR = "DELETE FROM Emprestimos WHERE id=?";
    
    try{
        Connection conn = Conectar();
        PreparedStatement del = conn.prepareStatement(DELETAR);
        del.setInt(1, id);
        int res = del.executeUpdate();
        
        if(res > 0 ){
            System.out.println("Deletado com sucesso o emprestimo abatido");
        }
        
        
        
    }catch(SQLException w){
        w.printStackTrace();
        System.err.println("Não foi possivel deletar Emprestimo");
    }
    
}
/**
 * Importa os livros registrados no banco de dados para o programa
 */
public static void ImportarLivros(){

              String sql = "SELECT  L.id, L.titulo, L.autor, L.ano FROM Livros AS L ";// AS L, Situacao AS S WHERE L.id_situacao = S.id
                 try {
                      Connection conn = Conectar();
                      
                      PreparedStatement livrosStatement = conn.prepareStatement(sql);
                      ResultSet res = livrosStatement.executeQuery();
                      
                      while(res.next()){
                          Livros a = new Livros();
                          
                          a.setId(res.getInt(1));
                          a.setTitulo(res.getString(2));
                          a.setAutor(res.getString(3));
                          a.setAno(res.getString(4));
                          //a.setSituacao(res.getString(5));
                          
                          livros.add(a);
                          
                      }
                      
                      livrosStatement.close();
                      Desconectar(conn);
                      
                      
                      
                 } catch (SQLException ex) {
                     Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
             }
}

/**
 * Importa os administradores do banco de dados para o programa. Usado para verificar o login.
 */
public static void ImportarAdministradores(){
           
            String sql = "SELECT * FROM Administradores";
                 try {
                      Connection conn = Conectar();
                      
                      PreparedStatement AdministradoresStatement = conn.prepareStatement(sql);
                      ResultSet res = AdministradoresStatement.executeQuery();
                      
                      while(res.next()){
                          Administradores a = new Administradores();
                          
                          a.setId(res.getInt(1));
                          a.setLogin(res.getString(2));
                          a.setSenha(res.getString(3));
                          administradores.add(a);
                          
                      }
                      
                      AdministradoresStatement.close();
                      Desconectar(conn);
                      
                      
                      
                 } catch (SQLException ex) {
                     Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
             }
           
           
           
       }


/**
 * Importa a lista de membros da biblioteca registrada no banco de dados
 */
public static void ImportarMembros(){
    
    
    String sql = "SELECT * FROM Membros";
                 try {
                      Connection conn = Conectar();
                      
                      PreparedStatement MembrosStatement = conn.prepareStatement(sql);
                      ResultSet res = MembrosStatement.executeQuery();
                      
                      while(res.next()){
                          Membros a = new Membros();
                          
                          a.setId(res.getInt(1));
                          a.setNome(res.getString(2));
                          a.setRua(res.getString(3));
                          a.setBairro(res.getString(4));
                          a.setCidade(res.getString(5));
                          a.setCpf(res.getString(6));
                          a.setRg(res.getString(7));
                          a.setEmail(res.getString(8));
                          membros.add(a);
                          //Id, Nome, Rua, Bairro, Cidade, CPF, RG, Email
                      }
                      
                      MembrosStatement.close();
                      Desconectar(conn);
                      
                      
                      
                 } catch (SQLException ex) {
                     Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
             }
    
    
}

/**
 * Importa do banco de dados os dias de emprestimo. se >0.. representa os dias de atraso
 */
public static void importarDiasEmprestimo() {
        
        if(!diasEmprestimo.isEmpty()){
        diasEmprestimo.clear();
        }
        String sql = "SELECT dias FROM DiasEmprestimo WHERE id = 1";
                 try {
                      Connection conn = Conectar();
                      
                      PreparedStatement DiasEmprestimoStatement = conn.prepareStatement(sql);
                      ResultSet res = DiasEmprestimoStatement.executeQuery();
                      
                      while(res.next()){
                          
                          diasEmprestimo.add( res.getInt(1));
                          System.out.println("DiasImportados");
                          
                      }
                      
                      DiasEmprestimoStatement.close();
                      Desconectar(conn);
                      
                      
                      
                 } catch (SQLException ex) {
                     Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
             }
        
    }
/**
 * Importante método que retorna corretamente o formato de data usado para o cálculo de dadas. 
 * Assim sendo possivel saber 
 * os dias de atraso de um emprestimo.
 * @param in data no formato "mm/dd/yyyy"
 * @return 
 */
public static String dataFormatoCerto(String in) {
		
		SimpleDateFormat formatoErrado = new SimpleDateFormat("mm/dd/yyyy");
		SimpleDateFormat formatoCerto = new SimpleDateFormat( "yyyy-dd-mm"  /*"mm-dd-yyyy"*/);
		
		String dataSaida = "";
		
		try {
			Date date = formatoErrado.parse(in);
			dataSaida = formatoCerto.format(date);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataSaida;
	}


/**
 * Metodo que realiza a validação do login ao sistema
 * @param a Login
 * @param b Senha
 * @return 
 */
public static boolean checkLogin(String a, String b){
    
    for(int i = 0; i < Conexao.administradores.size(); i++){
        
        if(Conexao.administradores.get(i).getLogin().equals(a) && Conexao.administradores.get(i).getSenha().equals(b) ){
            return true;
            
        
        
    }
    
       return false;
    
    
}
       return false;



}



/**
 * Importa a lista de membros devedores. Devedores são membros que atrasam 5 dias ou mais.
 * Ficando assim impedidos de realizar qualquer outro emprestimo
 */
public static void ImportarDevedores(){
    
    for(int i = 0; i < emprestimosAtrasados.size(); i++){
        
        if(emprestimosAtrasados.get(i).getDias_atraso()>=5){
            
            listaDevedores.add(emprestimosAtrasados.get(i));
        }else{
            return;
        }
   
    
    
    
     }
    
}

}

