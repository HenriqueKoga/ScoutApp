package scoutapp.com.br.scoutapp.controller;

import android.content.Context;

import java.util.List;

import de.greenrobot.dao.query.QueryBuilder;
import scoutapp.com.br.scoutapp.database.DatabaseHandler;
import scoutapp.com.br.scoutapp.model.Championship;
import scoutapp.com.br.scoutapp.model.ChampionshipDao;

/**
 * Created by HenriqueKoga on 03/07/16.
 */
public class ChampionshipController {
    private final ChampionshipDao mDAO;
    private final Context mContext;

    public ChampionshipController(Context context) {
        mContext = context;
        mDAO = DatabaseHandler.getSharedInstance(mContext).getChampionshipDao();
    }

    public void insertOrReplaceChamp(Championship championship) {
        mDAO.insertOrReplace(championship);
    }

    public List<Championship> getAllChamps() {
        QueryBuilder<Championship> query = mDAO.queryBuilder();
        return query.list();
    }

    public void removeChamp(Championship championship) {
        mDAO.delete(championship);
    }

//    public List<Championship> getChampByAthlete(int athleteId){
//        QueryBuilder<Championship> query = mDAO.queryBuilder();
//        return  query.where(ChampionshipDao.Properties.AthleteId.in(athleteId)).list();
//    }
}
