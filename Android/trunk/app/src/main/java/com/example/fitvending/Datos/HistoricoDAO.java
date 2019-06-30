package com.example.fitvending.Datos;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.fitvending.entidades.Historico;
import com.example.fitvending.entidades.Usuario;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HistoricoDAO {
    private static final String TABLE_NAME = "historico";
    private static final String NOMBRE = "nombreUsuario";
    private static final String LOGRO = "logro";
    private static final String CALORIAS = "calorias";
    private static final String FECHAHORA = "fechahora";
    private static final String ID = "ID";

    public static final String CREATE_USUARIO_TABLE = "CREATE TABLE " + TABLE_NAME +
            " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NOMBRE +
            " TEXT, " + LOGRO + " TEXT, " +  CALORIAS + " DOUBLE, " + FECHAHORA + " STRING )";

    public static final String DELETE_HISTORICO_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public boolean registrarHistorico(DBHandler dbHandler, Historico historico) {
        SQLiteDatabase database = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();
        long id = -1;

        values.put(NOMBRE, historico.getNombreUsuario());
        values.put(LOGRO, historico.getLogro());
        values.put(CALORIAS, historico.getCalorias());
        values.put(FECHAHORA, getCurrentDateTime());

        id = database.insert(TABLE_NAME, null, values);
        if (id >= 0) {

            database.close();
            return true;
        }
        database.close();
        return false;
    }

    private String getCurrentDateTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ssZ ");
        String strDate =  mdformat.format(calendar.getTime());
        return strDate;
    }
}
