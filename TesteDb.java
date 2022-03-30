/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetotestefelipedesktop.utils;


/**
 *
 * @author User
 */
public class TesteDb {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println(Conexao.statusConection());
        Conexao.getConnection();
        System.out.println(Conexao.statusConection());
        Conexao.FecharConexao();
        System.out.println(Conexao.statusConection());

    }

    
}
