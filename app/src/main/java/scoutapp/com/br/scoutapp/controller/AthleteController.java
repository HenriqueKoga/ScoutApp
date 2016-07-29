package scoutapp.com.br.scoutapp.controller;

import android.content.Context;

import java.util.List;

import de.greenrobot.dao.query.QueryBuilder;
import scoutapp.com.br.scoutapp.database.DatabaseHandler;
import scoutapp.com.br.scoutapp.model.Athlete;
import scoutapp.com.br.scoutapp.model.AthleteDao;

public class AthleteController {

    private final AthleteDao mDAO;
    private final Context mContext;

    public AthleteController(Context context) {
        mContext = context;
        mDAO = DatabaseHandler.getSharedInstance(mContext).getAthleteDao();
    }

    public void insertOrReplaceAthlete(Athlete athlete) {
        mDAO.insertOrReplace(athlete);
    }

    public List<Athlete> getAllAthletes(Athlete user) {
        QueryBuilder<Athlete> query = mDAO.queryBuilder();
        return query.where(AthleteDao.Properties.Id.notEq(user.getId())).list();
    }

    public void removeAthlete(Athlete athlete) {
        mDAO.delete(athlete);
    }
}
