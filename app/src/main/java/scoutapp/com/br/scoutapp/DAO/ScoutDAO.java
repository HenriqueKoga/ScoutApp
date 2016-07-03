package scoutapp.com.br.scoutapp.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import scoutapp.com.br.scoutapp.modelo.Campeonato;

/**
 * Created by HenriqueKoga on 22/04/16.
 */
public class ScoutDAO extends SQLiteOpenHelper {

    private static final String BANCO_DADOS = "Scout";
    private static int VERSAO = 5;

    public ScoutDAO(Context context) {
        super(context, BANCO_DADOS, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE atleta (_id_atleta INTEGER PRIMARY KEY, nome TEXT NOT NULL, " +
                "idade TEXT, categoria TEXT, clube TEXT, mao TEXT, estilo TEXT, obs TEXT);";
        db.execSQL(sql);
        String sqlChamp = "CREATE TABLE champ (_id INTEGER PRIMARY KEY, name TEXT NOT NULL, " +
                "date DATE, state TEXT, city TEXT, _id_atleta INTEGER, " +
                "FOREIGN KEY(_id_atleta) REFERENCES atleta(_id_atleta));";
        db.execSQL(sqlChamp);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS atleta";
        String sqlChamp = "DROP TABLE IF EXISTS champ";
        db.execSQL(sql);
        db.execSQL(sqlChamp);
        onCreate(db);
    }

    /**
     * Championship table mehtods
     */

    public void insertChamp(Campeonato campeonato) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValuesChamp(campeonato);
        db.insert("champ", null, dados);
    }

    public List<Campeonato> searchChamp() {
        String sql = "SELECT * FROM champ;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        List<Campeonato> campeonatos = new ArrayList<Campeonato>();
        while (c.moveToNext()) {
            Campeonato campeonato = new Campeonato();
            campeonato.setId(c.getLong(c.getColumnIndex("_id")));
            campeonato.setName(c.getString(c.getColumnIndex("name")));
            campeonato.setDate(c.getString(c.getColumnIndex("date")));
            campeonato.setState(c.getString(c.getColumnIndex("state")));
            campeonato.setCity(c.getString(c.getColumnIndex("city")));
            campeonato.setIdAtleta(c.getString(c.getColumnIndex("_id_atleta")));

            campeonatos.add(campeonato);
        }
        c.close();

        return campeonatos;
    }

    public void deleteChamp(Campeonato campeonato) {
        SQLiteDatabase db = getWritableDatabase();

        String [] params = {campeonato.getId().toString()};
        db.delete("champ", "_id = ?", params);
    }

    public void updateChamp(Campeonato campeonato) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = getContentValuesChamp(campeonato);
        String[] params = {campeonato.getId().toString()};
        db.update("champ", dados, "_id = ?", params);
    }

    @NonNull
    private ContentValues getContentValuesChamp(Campeonato campeonato) {
        ContentValues dados = new ContentValues();
        dados.put("name", campeonato.getName());
        dados.put("date", campeonato.getDate());
        dados.put("state", campeonato.getState());
        dados.put("city", campeonato.getCity());
        dados.put("_id_atleta", campeonato.getIdAtleta());
        return dados;
    }
}
