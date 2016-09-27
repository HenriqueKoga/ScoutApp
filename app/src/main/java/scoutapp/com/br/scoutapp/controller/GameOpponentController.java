package scoutapp.com.br.scoutapp.controller;

import android.content.Context;

import java.util.List;

import de.greenrobot.dao.query.QueryBuilder;
import scoutapp.com.br.scoutapp.database.DatabaseHandler;
import scoutapp.com.br.scoutapp.model.GameOpponent;
import scoutapp.com.br.scoutapp.model.GameOpponentDao;

/**
 * Created by HenriqueKoga on 26/09/16.
 */
public class GameOpponentController {
    private final GameOpponentDao mDAO;
    private final Context mContext;

    public GameOpponentController(Context context) {
        mContext = context;
        mDAO = DatabaseHandler.getSharedInstance(mContext).getGameOpponentDao();
    }

    public void insertOrReplaceGameOpponent(GameOpponent gameOpponent) {
        mDAO.insertOrReplace(gameOpponent);
    }

    public List<GameOpponent> getAllGameOpponent() {
        QueryBuilder<GameOpponent> query = mDAO.queryBuilder();
        return query.list();
    }

    public GameOpponent getGameOpponentByPosition(int position) {
        QueryBuilder<GameOpponent> query = mDAO.queryBuilder();

        return query.list().get(position);
    }

    public void removeGameOpponent(GameOpponent gameOpponent) {
        mDAO.delete(gameOpponent);
    }

    public void cleanDB(){
        mDAO.deleteAll();
    }
}
