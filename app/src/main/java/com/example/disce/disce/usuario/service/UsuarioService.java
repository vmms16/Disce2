package com.example.disce.disce.usuario.service;

import android.content.Context;

import com.example.disce.disce.usuario.dao.UsuarioDAO;
import com.example.disce.disce.usuario.dominio.UsuarioDominio;

/**
 * Created by Vinicius on 12/07/2016.
 */
public class UsuarioService {
    private UsuarioDAO usuarioDAO;
    private UsuarioDominio usuario;

    public  UsuarioService(Context context){
        usuarioDAO = new UsuarioDAO(context);
        usuario= new UsuarioDominio();
    }

    public void cadastrar(String nome, String login, String pass) throws Exception {

        usuario= usuarioDAO.getUsuario(login);

        if(usuario!=null){
            throw new Exception("Usuario ja cadastrado");
        }else{

            usuario= new UsuarioDominio();
            usuario.setNome(nome);
            usuario.setPass(pass);
            usuario.setLogin(login);

            long idUsuario= usuarioDAO.inserir(usuario);


        }

    }


    public UsuarioDominio login(String login, String pass) throws Exception {

        UsuarioDominio usuario= usuarioDAO.getUsuario(login, pass);

        if(usuario==null){
            throw new Exception("Login ou senha invalidos");

        }else{
            return usuario;
        }


    }




}
