package com.example.fitvending.Datos;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.fitvending.entidades.Usuario;

public class UsuarioDAO {

    private static final String TABLE_NAME = "usuario";
    private static final String NOMBRE = "nombreUsuario";
    private static final String PASSWORD = "password";
    private static final String ALTURA = "altura";
    private static final String EDAD = "edad";
    private static final String PESO = "peso";
    private static final String SEXO = "sexo";
    private static final String MONEDAS = "monedas";
    private static final String CONECTADO= "conectado";

    public static final String CREATE_USUARIO_TABLE = "CREATE TABLE "+ TABLE_NAME +
            " (" + NOMBRE +
            " TEXT, " + PASSWORD +" TEXT, "+ ALTURA +" DOUBLE, " + EDAD + " INTEGER, " +
            PESO + " DOUBLE, " + SEXO + " TEXT, " + MONEDAS +
            " INTEGER," + CONECTADO + " INTEGER )";

    public static final String DELETE_USUARIO_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;

    public static boolean registrarUsuario(DBHandler dbHandler, Usuario user){


            SQLiteDatabase database = dbHandler.getWritableDatabase();
            ContentValues values = new ContentValues();
            long id = -1;

            values.put(NOMBRE, user.getNombreUsuario());
            values.put(PASSWORD, user.getPassword());
            values.put(ALTURA, user.getAltura());
            values.put(EDAD, user.getEdad());
            values.put(PESO, user.getPeso());
            values.put(SEXO, user.getSexo());
            values.put(MONEDAS, user.getMoneda());
            values.put(CONECTADO, user.getConectado());

            id = database.insert(TABLE_NAME, null, values);
            if (id >= 0) {
                Toast.makeText(dbHandler.getContext(), "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show();
                database.close();
                return true;
            }
            database.close();
            Toast.makeText(dbHandler.getContext(), "No se pudo registrar al usuario", Toast.LENGTH_SHORT).show();
            return false;
        }

    }
    /*
    public static  boolean actualizarUsuario(DBHandler dbHandler){
        SQLiteDatabase database = dbHandler.getWritableDatabase();
        String[] paramters = {event.getId().toString()};
        ContentValues values = new ContentValues();
        int error = database.update(TABLE_NAME,values,ID+"=?",paramters);
        if(error != 0){
            Toast.makeText(dbHandler.getContext(),"Usuario actualizado exitosamente",Toast.LENGTH_SHORT).show();
            database.close();
            return true;
        }
        database.close();
        Toast.makeText(dbHandler.getContext(),"No se pudo actualizar el usuario",Toast.LENGTH_SHORT).show();
        return false;
    }*/


