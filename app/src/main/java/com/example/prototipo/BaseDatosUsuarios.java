package com.example.prototipo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatosUsuarios extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String BD_NOMBRE = "Usuarios";
    public static final String TABLA_USUARIOS = "Tabla de usuarios";
    public static final String CLAVE_PRIMARIA_EMAIL = "email";
    public static final String CONTRASENA = "Contraseña";
    public static final String TELEFONO = "Telefono";

    public BaseDatosUsuarios(Context context) {
        super(context, BD_NOMBRE, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        String CrearBD = "CREATE TABLE " + "Usuarios" + "("
                + CLAVE_PRIMARIA_EMAIL + " TEXT PRIMARY KEY," + CONTRASENA + " TEXT,"
                + TELEFONO + " TEXT" + ")";
        bd.execSQL(CrearBD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int i, int i1) {
        bd.execSQL("DROP TABLE IF EXISTS " + TABLA_USUARIOS );
        onCreate(bd);
    }

    // Para añadir un nuevo usuario
    public void anadirUsuario(Usuarios usuario) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CLAVE_PRIMARIA_EMAIL, usuario.getEmail()); // email
        values.put(TELEFONO, usuario.getTelefono()); // telefono

        db.insert(TABLA_USUARIOS, null, values);

        db.close();
    }

    // Para comprobar un usuario
    Usuarios getUsuario(String email) {
        SQLiteDatabase bd = this.getReadableDatabase();

        Cursor cursor = bd.query(TABLA_USUARIOS, new String[] {CLAVE_PRIMARIA_EMAIL,
                        CONTRASENA, TELEFONO }, CLAVE_PRIMARIA_EMAIL + "=?",
                new String[] { email }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Usuarios usuario = new Usuarios(cursor.getString(0), cursor.getString(1), cursor.getString(2));
        bd.close();
        // return usuario
        return usuario;
    }


}
