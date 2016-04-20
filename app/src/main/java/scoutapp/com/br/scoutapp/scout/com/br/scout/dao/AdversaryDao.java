package scoutapp.com.br.scoutapp.scout.com.br.scout.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import scoutapp.com.br.scoutapp.scout.com.br.scout.modelo.Adversary;

/**
 * Created by HenriqueKoga on 20/04/16.
 */
public class AdversaryDao extends SQLiteOpenHelper{

    public AdversaryDao(Context context) {
        super(context, "Scout", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Adversaries (id INTEGER PRIMARY KEY, name TEXT NOT NULL, category TEXT, genre TEXT, club TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Alunos;";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insert(Adversary adversary) {
        SQLiteDatabase db = getWritableDatabase();

        //map - chave e valor
        ContentValues dados = dataAdversary(adversary);

        db.insert("Adversary", null, dados);
    }

    @NonNull
    private ContentValues dataAdversary(Adversary adversary) {
        ContentValues dados = new ContentValues();
        dados.put("name", adversary.getName());
        dados.put("category", adversary.getCategory());
        dados.put("genre", adversary.getGenre());
        dados.put("club", adversary.getClub());
        return dados;
    }

    public List<Adversary> buscarAlunos() {
        String sql = "SELECT * FROM Adversary;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        List<Adversary> adversaries = new ArrayList<Adversary>();

        while (c.moveToNext()){
            Adversary adversary = new Adversary();
            adversary.setId(c.getLong(c.getColumnIndex("id")));
            adversary.setName(c.getString(c.getColumnIndex("name")));
            adversary.setCategory(c.getString(c.getColumnIndex("category")));
            adversary.setGenre(c.getString(c.getColumnIndex("genre")));
            adversary.setClub(c.getString(c.getColumnIndex("club")));
            adversaries.add(adversary);
        }
        c.close();

        return adversaries;
    }

    public void deleta(Adversary adversary) {

        SQLiteDatabase db = getWritableDatabase();

        String [] params = {adversary.getId().toString()};
        db.delete("Adversaries", "id = ?", params);
    }

    public void altera(Adversary adversary) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = dataAdversary(adversary);

        String [] params = {adversary.getId().toString()};
        db.update("Adversaries", dados, "id = ?", params);
    }
}

