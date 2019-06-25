package com.example.fitvending;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.fitvending.Datos.DBHandler;
import com.example.fitvending.Datos.UsuarioDAO;


public class MainInicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        DBHandler dbhandler = new DBHandler(this);
        Intent activityIntent ;
        /*SQLiteDatabase db = dbhandler.getReadableDatabase();


        Cursor c = db.rawQuery(" SELECT nombreUsuario,conectado FROM usuario WHERE conectado='1'",null);
        if(c.moveToFirst())
        {
            do {
                String user= c.getString(0);
                Integer conec = c.getInt(1);
                if(conec == 1)
                {
                    activityIntent = new Intent(this, MainActivity.class);
                    break;
                }
            } while(c.moveToNext());

        }
       else
        {
            activityIntent = new Intent(this, LoginActivity.class);
        }
*/
        activityIntent = new Intent(this, LoginActivity.class);
        startActivity(activityIntent);
        finish();
    }
}
