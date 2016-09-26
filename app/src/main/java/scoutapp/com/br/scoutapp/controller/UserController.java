package scoutapp.com.br.scoutapp.controller;

import android.content.Context;

import java.util.List;

import de.greenrobot.dao.query.QueryBuilder;
import scoutapp.com.br.scoutapp.database.DatabaseHandler;
import scoutapp.com.br.scoutapp.model.User;
import scoutapp.com.br.scoutapp.model.UserDao;

/**
 * Created by HenriqueKoga on 23/09/16.
 */
public class UserController {
    private final UserDao mDAO;
    private final Context mContext;

    public UserController(Context context) {
        mContext = context;
        mDAO = DatabaseHandler.getSharedInstance(mContext).getUserDao();
    }

    public void insertOrReplaceAthlete(User user) {
        mDAO.insertOrReplace(user);
    }

    public List<User> getAllUser(User user) {
        QueryBuilder<User> query = mDAO.queryBuilder();
        return query.where(UserDao.Properties.Id.notEq(user.getId())).list();
    }

    public void removeAthlete(User user) {
        mDAO.delete(user);
    }

    public void cleanDB(){
        mDAO.deleteAll();
    }
}

