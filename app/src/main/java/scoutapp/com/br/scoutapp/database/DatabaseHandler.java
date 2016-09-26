package scoutapp.com.br.scoutapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import scoutapp.com.br.scoutapp.model.AthleteDao;
import scoutapp.com.br.scoutapp.model.ChampionshipDao;
import scoutapp.com.br.scoutapp.model.DaoMaster;
import scoutapp.com.br.scoutapp.model.DaoSession;
import scoutapp.com.br.scoutapp.model.UserDao;

public class DatabaseHandler extends DaoMaster.DevOpenHelper {
    private static final String DATABASE_NAME = "scout-db";
    private static DatabaseHandler sharedInstance = null;
    private static DaoMaster daoMaster = null;
    private static DaoSession daoSession = null;
    private Context mContext;

    private DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
        mContext = context;
        daoMaster = new DaoMaster(this.getReadableDatabase());
        daoSession = daoMaster.newSession();
    }

    public static DatabaseHandler getSharedInstance(Context context) {
        if (sharedInstance == null) {
            sharedInstance = new DatabaseHandler(context, DATABASE_NAME, null);
        }
        return sharedInstance;
    }

    public AthleteDao getAthleteDao(){
        return daoSession.getAthleteDao();
    }

    public UserDao getUserDao(){
        return daoSession.getUserDao();
    }

    public ChampionshipDao getChampionshipDao(){
        return daoSession.getChampionshipDao();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        DaoMaster.dropAllTables(db, true);
        DaoMaster.createAllTables(db, true);
    }
}