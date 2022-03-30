/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetotestefelipedesktop.views;


import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import projetotestefelipedesktop.controllers.ControllerUsuario;
import projetotestefelipedesktop.models.beans.Usuario;

/**
 *
 * @author User
 */
public class ManterUsuario {
    
    public static void menu() throws SQLException, ClassNotFoundException {
        String txtMenu = " 0 - Sair"
                       + "\n 1 - Inserir"
                       + "\n 2 - Alterar"
                       + "\n 3 - Excluir"
                       + "\n 4 - Buscar"
                       + "\n 5 - Listar";

        int ops = Integer.parseInt(JOptionPane.showInputDialog(txtMenu));
        switch(ops) {
            case 0:
                int sair = JOptionPane.showConfirmDialog(null,"Deseja Sair");
                if(sair > 0) {
                    menu();
                    break;
                }
            case 1:
                inserir();
                break;
            case 2:
                alterar();
                break;
            case 3:
                excluir();
                break;
            case 4:
                buscar();
                break;
            case 5:
                listar();
                break;
            default:
                JOptionPane.showMessageDialog(null,"Opcao invalida");
                menu();
                break;
        }
    }
    
    
    public static boolean valida() throws SQLException, ClassNotFoundException {
        String login = JOptionPane.showInputDialog("Entre com o Login");
        String senha = JOptionPane.showInputDialog("Entre com o Senha");
        Usuario usuEntrada = new Usuario(login,senha);
        ControllerUsuario contUsu = new ControllerUsuario();
        return contUsu.valida(usuEntrada);
    }

    private static void inserir() throws SQLException, ClassNotFoundException {
        String login = JOptionPane.showInputDialog("Entre com o Login");
        String senha = JOptionPane.showInputDialog("Entre com o Senha");
        String status = JOptionPane.showInputDialog("Entre com o Status");
        String tipo = JOptionPane.showInputDialog("Entre com o Tipo");
        Usuario uEntrada = new Usuario(login,senha,status, tipo);
        ControllerUsuario contU = new ControllerUsuario();
        Usuario uSaida = contU.inserir(uEntrada);
        JOptionPane.showMessageDialog(null, uSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Entre com o Id"));
        String login = JOptionPane.showInputDialog("Entre com o Login");
        String senha = JOptionPane.showInputDialog("Entre com o Senha");
        String status = JOptionPane.showInputDialog("Entre com o Status");
        String tipo = JOptionPane.showInputDialog("Entre com o Tipo");
        Usuario uEntrada = new Usuario(id,login,senha,status, tipo);
        ControllerUsuario contU = new ControllerUsuario();
        Usuario uSaida = contU.alterar(uEntrada);
        JOptionPane.showMessageDialog(null, uSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Entre com o Id"));
        Usuario uEntrada = new Usuario(id);
        ControllerUsuario contU = new ControllerUsuario();
        Usuario uSaida = contU.excluir(uEntrada);
        JOptionPane.showMessageDialog(null, uSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Entre com o Id"));
        Usuario uEntrada = new Usuario(id);
        ControllerUsuario contU = new ControllerUsuario();
        Usuario uSaida = contU.buscar(uEntrada);
        JOptionPane.showMessageDialog(null, uSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String login = JOptionPane.showInputDialog("Entre com o Login");
        Usuario uEntrada = new Usuario(login);
        ControllerUsuario contU = new ControllerUsuario();
        List<Usuario> listaUsuSaida = contU.listar(uEntrada);
        listaUsuSaida.forEach((uSaida) -> {
            JOptionPane.showMessageDialog(null, uSaida.toString());
        });
    }
    
}
