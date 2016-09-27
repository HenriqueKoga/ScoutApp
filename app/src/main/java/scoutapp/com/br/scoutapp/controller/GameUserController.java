package scoutapp.com.br.scoutapp.controller;

import android.content.Context;

import java.util.List;

import de.greenrobot.dao.query.QueryBuilder;
import scoutapp.com.br.scoutapp.database.DatabaseHandler;
import scoutapp.com.br.scoutapp.model.GameUser;
import scoutapp.com.br.scoutapp.model.GameUserDao;

/**
 * Created by HenriqueKoga on 26/09/16.
 */
public class GameUserController {
    private final GameUserDao mDAO;
    private final Context mContext;

    public GameUserController(Context context) {
        mContext = context;
        mDAO = DatabaseHandler.getSharedInstance(mContext).getGameUserDao();
    }

    public void insertOrReplaceGameUser(GameUser gameUser) {
        mDAO.insertOrReplace(gameUser);
    }

    public List<GameUser> getAllGameUser() {
        QueryBuilder<GameUser> query = mDAO.queryBuilder();
        return query.list();
    }

    public GameUser getGameUserByPosition(int position) {
        QueryBuilder<GameUser> query = mDAO.queryBuilder();

        return query.list().get(position);
    }

    public void removeGameUser(GameUser gameUser) {
        mDAO.delete(gameUser);
    }

    public void cleanDB(){
        mDAO.deleteAll();
    }

}
