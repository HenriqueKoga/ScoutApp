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

/**
 * Created by HenriqueKoga on 22/04/16.
 */
public class AtletaDAO extends SQLiteOpenHelper {

    public AtletaDAO(Context context) {
        super(context, "Atletas", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Atletas (id INTEGER PRIMARY KEY, nome TEXT NOT NULL, idade TEXT, categoria TEXT, clube TEXT, mao TEXT, estilo TEXT, obs TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Atletas";
        db.execSQL(sql);
        onCreate(db);

    }

    public void insere(Atleta atleta) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = getContentValues(atleta);

        db.insert("Atletas", null, dados);
    }

    public List<Atleta> buscaAtletas() {

        String sql = "SELECT * FROM Atletas;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        List<Atleta> atletas = new ArrayList<Atleta>();
        while (c.moveToNext()) {
            Atleta atleta = new Atleta();
            atleta.setId(c.getLong(c.getColumnIndex("id")));
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

    public void deleta(Atleta atleta) {
        SQLiteDatabase db = getWritableDatabase();

        String [] params = {atleta.getId().toString()};
        db.delete("Atletas", "id = ?", params);
    }

    public void altera(Atleta atleta) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = getContentValues(atleta);
        String[] params = {atleta.getId().toString()};
        db.update("Atletas", dados, "id = ?", params);
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
}
