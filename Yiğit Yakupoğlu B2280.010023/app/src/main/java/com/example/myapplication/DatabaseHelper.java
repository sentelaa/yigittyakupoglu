package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "YemekOnerisi.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "yemekler";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_KILO_AMACI = "kiloAmaci";
    private static final String COLUMN_MAKRO = "makro";
    private static final String COLUMN_ONERI = "oneri";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_KILO_AMACI + " TEXT, " +
                COLUMN_MAKRO + " TEXT, " +
                COLUMN_ONERI + " TEXT)";
        db.execSQL(createTable);

        // Örnek veriler ekleyelim
        db.execSQL("INSERT INTO " + TABLE_NAME + " (kiloAmaci, makro, oneri) VALUES " +
                "('kiloAl', 'protein', '350gr Tavuk veya 400gr Balık')," +
                "('kiloAl', 'karbonhidrat', '400gr Pirinç veya 200gr Fındık Ezmesi')," +
                "('kiloAl', 'yag', 'Zeytinyağlı Yemekler')," +
                "('kiloVer', 'protein', '200gr Tavuk veya 4 Haşlanmış Yumurta')," +
                "('kiloVer', 'karbonhidrat', '200gr Pirinç veya 100gr Yulaf')," +
                "('kiloVer', 'yag', '30gr Fındık veya 30gr Ceviz')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public String getYemekOnerisi(String kiloAmaci, String makro) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + COLUMN_ONERI + " FROM " + TABLE_NAME +
                " WHERE " + COLUMN_KILO_AMACI + " = ? AND " + COLUMN_MAKRO + " = ?", new String[]{kiloAmaci, makro});
        if (cursor.moveToFirst()) {
            String oneri = cursor.getString(0);
            cursor.close();
            return oneri;
        } else {
            cursor.close();
            return "Yemek önerisi bulunamadı.";
        }
    }
}

