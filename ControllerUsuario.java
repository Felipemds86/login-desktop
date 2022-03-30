/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetotestefelipedesktop.controllers;


import java.sql.SQLException;
import java.util.List;
import projetotestefelipedesktop.models.beans.Usuario;
import projetotestefelipedesktop.models.daos.DaoUsuario;

/**
 *
 * @author User
 */
public class ControllerUsuario {

    DaoUsuario daoUsu;
    
    public ControllerUsuario() throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario();
    }
    
    public boolean valida(Usuario usuEntrada) throws SQLException {
        boolean valida = false;
        Usuario usuSaida = daoUsu.valida(usuEntrada);
        if(usuEntrada.getLogin().equals(usuSaida.getLogin())) {
            if(usuEntrada.getSenha().equals(usuSaida.getSenha())) {
                valida = true;
            }
        }
        return valida;
    }

    public Usuario inserir(Usuario uEntrada) throws SQLException {
        Usuario usuSaida = daoUsu.inserir(uEntrada);
        return usuSaida;
    }

    public Usuario alterar(Usuario uEntrada) throws SQLException {
        Usuario usuSaida = daoUsu.alterar(uEntrada);
        return usuSaida;
    }

    public List<Usuario> listar(Usuario uEntrada) throws SQLException {
        List<Usuario> listaUsuSaida = daoUsu.listar(uEntrada);
        return listaUsuSaida;
    }

    public Usuario buscar(Usuario uEntrada) throws SQLException {
        Usuario usuSaida = daoUsu.buscar(uEntrada);
        return usuSaida;
    }

    public Usuario excluir(Usuario uEntrada) throws SQLException {
        Usuario usuSaida = daoUsu.excluir(uEntrada);
        return usuSaida;
    }
    
}
