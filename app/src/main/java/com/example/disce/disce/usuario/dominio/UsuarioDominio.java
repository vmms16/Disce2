package com.example.disce.disce.usuario.dominio;

/**
 * Created by Vinicius on 12/07/2016.
 */
public class UsuarioDominio {
    private String nome;
    private String login;
    private String pass;
    private long id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
