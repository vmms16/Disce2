package com.example.disce.disce.usuario.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.disce.disce.infra.DatabaseHelper;
import com.example.disce.disce.usuario.dominio.UsuarioDominio;

/**
 * Created by Vinicius on 12/07/2016.
 */
public class UsuarioDAO {
    private DatabaseHelper helper;

    public UsuarioDAO(Context context){
        helper= new DatabaseHelper(context);
    }

    public UsuarioDominio getUsuario(String login){
        SQLiteDatabase db= helper.getReadableDatabase();

        String comando= "SELECT * FROM " + DatabaseHelper.TABLE_USER +
                " WHERE " + DatabaseHelper.COLUMN_LOGIN + " LIKE ?";

        String[] argumentos= {login};

        Cursor cursor = db.rawQuery(comando, argumentos);

        UsuarioDominio usuario= null;

        if(cursor.moveToNext()){

            String idColumn= DatabaseHelper.COLUMN_ID;
            String nomeColumn= DatabaseHelper.COLUMN_NOME;
            String loginColumn= DatabaseHelper.COLUMN_LOGIN;
            String passColumn= DatabaseHelper.COLUMN_PASS;

            int indexColumnId= cursor.getColumnIndex(idColumn);
            int indexColumnNome= cursor.getColumnIndex(nomeColumn);
            int indexColumnLogin= cursor.getColumnIndex(loginColumn);
            int indexColumnPass= cursor.getColumnIndex(passColumn);

            long id = cursor.getLong(indexColumnId);
            String nome=cursor.getString(indexColumnNome);
            String login1 =cursor.getString(indexColumnLogin);
            String pass =cursor.getString(indexColumnPass);

            usuario.setNome(nome);
            usuario.setPass(pass);
            usuario.setLogin(login1);
            usuario.setId(id);

        }

        cursor.close();
        db.close();

        return usuario;

    }

    public long inserir(UsuarioDominio usuario){
        SQLiteDatabase db= helper.getWritableDatabase();

        ContentValues values= new ContentValues();

        String nomeColumn= DatabaseHelper.COLUMN_NOME;
        String loginColumn= DatabaseHelper.COLUMN_LOGIN;
        String passColumn= DatabaseHelper.COLUMN_PASS;

        String nome=usuario.getNome();
        String login=usuario.getLogin();
        String pass= usuario.getPass();

        values.put(nomeColumn, nome);
        values.put(loginColumn,login);
        values.put(passColumn,pass);

        String table= DatabaseHelper.TABLE_USER;

        long id = db.insert(table, null, values);

        db.close();

        return id;




    }


    public UsuarioDominio getUsuario(String login, String pass){
        SQLiteDatabase db= helper.getReadableDatabase();

        String comando= "SELECT * FROM " + DatabaseHelper.TABLE_USER +
                " WHERE " + DatabaseHelper.COLUMN_LOGIN + " LIKE ? AND "+ DatabaseHelper.COLUMN_PASS + " LIKE ?";

        String[] argumentos= {login, pass};

        Cursor cursor = db.rawQuery(comando, argumentos);

        UsuarioDominio usuario= null;

        if(cursor.moveToNext()){

            String idColumn= DatabaseHelper.COLUMN_ID;
            String nomeColumn= DatabaseHelper.COLUMN_NOME;
            String loginColumn= DatabaseHelper.COLUMN_LOGIN;
            String passColumn= DatabaseHelper.COLUMN_PASS;

            int indexColumnId= cursor.getColumnIndex(idColumn);
            int indexColumnNome= cursor.getColumnIndex(nomeColumn);
            int indexColumnLogin= cursor.getColumnIndex(loginColumn);
            int indexColumnPass= cursor.getColumnIndex(passColumn);

            long id = cursor.getLong(indexColumnId);
            String nome=cursor.getString(indexColumnNome);
            String login1 =cursor.getString(indexColumnLogin);
            String pass1 =cursor.getString(indexColumnPass);

            usuario.setNome(nome);
            usuario.setPass(pass);
            usuario.setLogin(login1);
            usuario.setId(id);

        }

        cursor.close();
        db.close();

        return usuario;

    }
}

