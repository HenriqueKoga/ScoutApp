package scoutapp.com.br.scoutapp.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import scoutapp.com.br.scoutapp.modelo.Atleta;
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
     * Athlete table mehtods
     */

    public void insertAthlete(Atleta atleta) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValues(atleta);
        db.insert("atleta", null, dados);
    }

    public List<Atleta> searchAthlete() {
        String sql = "SELECT * FROM atleta;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        List<Atleta> atletas = new ArrayList<Atleta>();
        while (c.moveToNext()) {
            Atleta atleta = new Atleta();
            atleta.setId(c.getLong(c.getColumnIndex("_id_atleta")));
            atleta.setNome(c.getString(c.getColumnIndex("nome")));
            atleta.setIdade(c.getString(c.getColumnIndex("idade")));
            atleta.setCategoria(c.getString(c.getColumnIndex("categoria")));
            atleta.setClube(c.getString(c.getColumnIndex("clube")));
            atleta.setMao(c.getInt(c.getColumnIndex("mao")));
            atleta.setEstilo(c.getInt(c.getColumnIndex("estilo")));
            atleta.setObs(c.getString(c.getColumnIndex("obs")));

            atletas.add(atleta);
        }
        c.close();

        return atletas;
    }

    public void deleteAthlete(Atleta atleta) {
        SQLiteDatabase db = getWritableDatabase();

        String [] params = {atleta.getId().toString()};
        db.delete("atleta", "_id_atleta = ?", params);
    }

    public void updateAthlete(Atleta atleta) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = getContentValues(atleta);
        String[] params = {atleta.getId().toString()};
        db.update("atleta", dados, "_id_atleta = ?", params);
    }

    @NonNull
    private ContentValues getContentValues(Atleta atleta) {
        ContentValues dados = new ContentValues();
        dados.put("nome", atleta.getNome());
        dados.put("idade", atleta.getIdade());
        dados.put("categoria", atleta.getCategoria());
        dados.put("clube", atleta.getClube());
        dados.put("mao", atleta.getMao());
        dados.put("estilo", atleta.getEstilo());
        dados.put("obs", atleta.getObs());
        return dados;
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
