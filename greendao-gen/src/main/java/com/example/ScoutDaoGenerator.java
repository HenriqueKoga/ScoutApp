package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

public class ScoutDaoGenerator {

    private static final String PACKAGE = "scoutapp.com.br.scoutapp.model";

    public static void main(String[] args) {
        Schema schema = new Schema(3, PACKAGE);
        schema.enableKeepSectionsByDefault();

        addTables(schema);

        try {
            new DaoGenerator().generateAll(schema, "./app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addTables(final Schema schema) {
        Entity athlete = addAthlete(schema);
        Entity championship = addChampionship(schema);
        Entity user = addUser(schema);
        Entity gameUser = addGameUser(schema);
        Entity gameOpponent = addGameOpponent(schema);

        Property athleteId = championship.addLongProperty("athleteId").notNull().getProperty();
        championship.addToOne(athlete, athleteId);

        Property gameUserId = championship.addLongProperty("gameUserId").notNull().getProperty();
        championship.addToOne(gameUser, gameUserId);

        Property gameOpponentId = championship.addLongProperty("gameOpponentId").notNull().getProperty();
        championship.addToOne(gameOpponent, gameOpponentId);
    }

    private static Entity addUser(Schema schema) {
        Entity user = schema.addEntity("User");
        user.addIdProperty().primaryKey().autoincrement();
        user.addStringProperty("name");
        user.addIntProperty("age");
        user.addStringProperty("user");
        user.addStringProperty("password");

        user.implementsSerializable();

        return user;
    }

    private static Entity addAthlete(final Schema schema) {
        Entity athlete = schema.addEntity("Athlete");
        athlete.addIdProperty().primaryKey().autoincrement();
        athlete.addStringProperty("name");
        athlete.addIntProperty("age");
        athlete.addStringProperty("category");

        //Clube pode ser uma tabela com foreign key
        athlete.addStringProperty("club");

        athlete.addIntProperty("hand");
        athlete.addIntProperty("style");
        athlete.addStringProperty("obs");

        athlete.implementsSerializable();

        return athlete;
    }

    private static Entity addChampionship(final Schema schema){
        Entity championship = schema.addEntity("Championship");
        championship.addIdProperty().primaryKey().autoincrement();
        championship.addStringProperty("champName");
//        championship.addDateProperty("date");
        championship.addStringProperty("state");
        championship.addStringProperty("city");

        championship.implementsSerializable();

        return championship;
    }

    private static Entity addGameOpponent(Schema schema) {
        Entity gameOpponent = schema.addEntity("GameOpponent");
        gameOpponent.addIdProperty().primaryKey().autoincrement();

        gameOpponent.addIntProperty("service");
        gameOpponent.addIntProperty("reception");
        gameOpponent.addIntProperty("forehand");
        gameOpponent.addIntProperty("backhand");
        gameOpponent.addIntProperty("smash");
        gameOpponent.addIntProperty("slice");
        gameOpponent.addIntProperty("block");
        gameOpponent.addIntProperty("flick");
        gameOpponent.addIntProperty("lob");

        gameOpponent.addIntProperty("total");

        //service spec
        gameOpponent.addIntProperty("serviceLeftLongCrossed");
        gameOpponent.addIntProperty("serviceLeftLongParallel");
        gameOpponent.addIntProperty("serviceLeftShortCrossed");
        gameOpponent.addIntProperty("serviceLeftShortParallel");
        gameOpponent.addIntProperty("serviceMiddleLongCrossed");
        gameOpponent.addIntProperty("serviceMiddleLongParallel");
        gameOpponent.addIntProperty("serviceMiddleShortCrossed");
        gameOpponent.addIntProperty("serviceMiddleShortParallel");
        gameOpponent.addIntProperty("serviceRightLongCrossed");
        gameOpponent.addIntProperty("serviceRightLongParallel");
        gameOpponent.addIntProperty("serviceRightShortCrossed");
        gameOpponent.addIntProperty("serviceRightShortParallel");

        //reception spec
        gameOpponent.addIntProperty("receptionLeftLongCrossed");
        gameOpponent.addIntProperty("receptionLeftLongParallel");
        gameOpponent.addIntProperty("receptionLeftShortCrossed");
        gameOpponent.addIntProperty("receptionLeftShortParallel");
        gameOpponent.addIntProperty("receptionMiddleLongCrossed");
        gameOpponent.addIntProperty("receptionMiddleLongParallel");
        gameOpponent.addIntProperty("receptionMiddleShortCrossed");
        gameOpponent.addIntProperty("receptionMiddleShortParallel");
        gameOpponent.addIntProperty("receptionRightLongCrossed");
        gameOpponent.addIntProperty("receptionRightLongParallel");
        gameOpponent.addIntProperty("receptionRightShortCrossed");
        gameOpponent.addIntProperty("receptionRightShortParallel");

        //forehand spec
        gameOpponent.addIntProperty("forehandLeftLongCrossed");
        gameOpponent.addIntProperty("forehandLeftLongParallel");
        gameOpponent.addIntProperty("forehandLeftShortCrossed");
        gameOpponent.addIntProperty("forehandLeftShortParallel");
        gameOpponent.addIntProperty("forehandMiddleLongCrossed");
        gameOpponent.addIntProperty("forehandMiddleLongParallel");
        gameOpponent.addIntProperty("forehandMiddleShortCrossed");
        gameOpponent.addIntProperty("forehandMiddleShortParallel");
        gameOpponent.addIntProperty("forehandRightLongCrossed");
        gameOpponent.addIntProperty("forehandRightLongParallel");
        gameOpponent.addIntProperty("forehandRightShortCrossed");
        gameOpponent.addIntProperty("forehandRightShortParallel");

        //backhand spec
        gameOpponent.addIntProperty("backhandLeftLongCrossed");
        gameOpponent.addIntProperty("backhandLeftLongParallel");
        gameOpponent.addIntProperty("backhandLeftShortCrossed");
        gameOpponent.addIntProperty("backhandLeftShortParallel");
        gameOpponent.addIntProperty("backhandMiddleLongCrossed");
        gameOpponent.addIntProperty("backhandMiddleLongParallel");
        gameOpponent.addIntProperty("backhandMiddleShortCrossed");
        gameOpponent.addIntProperty("backhandMiddleShortParallel");
        gameOpponent.addIntProperty("backhandRightLongCrossed");
        gameOpponent.addIntProperty("backhandRightLongParallel");
        gameOpponent.addIntProperty("backhandRightShortCrossed");
        gameOpponent.addIntProperty("backhandRightShortParallel");

        //smash spec
        gameOpponent.addIntProperty("smashLeftLongCrossed");
        gameOpponent.addIntProperty("smashLeftLongParallel");
        gameOpponent.addIntProperty("smashLeftShortCrossed");
        gameOpponent.addIntProperty("smashLeftShortParallel");
        gameOpponent.addIntProperty("smashMiddleLongCrossed");
        gameOpponent.addIntProperty("smashMiddleLongParallel");
        gameOpponent.addIntProperty("smashMiddleShortCrossed");
        gameOpponent.addIntProperty("smashMiddleShortParallel");
        gameOpponent.addIntProperty("smashRightLongCrossed");
        gameOpponent.addIntProperty("smashRightLongParallel");
        gameOpponent.addIntProperty("smashRightShortCrossed");
        gameOpponent.addIntProperty("smashRightShortParallel");

        //slice spec
        gameOpponent.addIntProperty("sliceLeftLongCrossed");
        gameOpponent.addIntProperty("sliceLeftLongParallel");
        gameOpponent.addIntProperty("sliceLeftShortCrossed");
        gameOpponent.addIntProperty("sliceLeftShortParallel");
        gameOpponent.addIntProperty("sliceMiddleLongCrossed");
        gameOpponent.addIntProperty("sliceMiddleLongParallel");
        gameOpponent.addIntProperty("sliceMiddleShortCrossed");
        gameOpponent.addIntProperty("sliceMiddleShortParallel");
        gameOpponent.addIntProperty("sliceRightLongCrossed");
        gameOpponent.addIntProperty("sliceRightLongParallel");
        gameOpponent.addIntProperty("sliceRightShortCrossed");
        gameOpponent.addIntProperty("sliceRightShortParallel");

        //block spec
        gameOpponent.addIntProperty("blockLeftLongCrossed");
        gameOpponent.addIntProperty("blockLeftLongParallel");
        gameOpponent.addIntProperty("blockLeftShortCrossed");
        gameOpponent.addIntProperty("blockLeftShortParallel");
        gameOpponent.addIntProperty("blockMiddleLongCrossed");
        gameOpponent.addIntProperty("blockMiddleLongParallel");
        gameOpponent.addIntProperty("blockMiddleShortCrossed");
        gameOpponent.addIntProperty("blockMiddleShortParallel");
        gameOpponent.addIntProperty("blockRightLongCrossed");
        gameOpponent.addIntProperty("blockRightLongParallel");
        gameOpponent.addIntProperty("blockRightShortCrossed");
        gameOpponent.addIntProperty("blockRightShortParallel");

        //flick spec
        gameOpponent.addIntProperty("flickLeftLongCrossed");
        gameOpponent.addIntProperty("flickLeftLongParallel");
        gameOpponent.addIntProperty("flickLeftShortCrossed");
        gameOpponent.addIntProperty("flickLeftShortParallel");
        gameOpponent.addIntProperty("flickMiddleLongCrossed");
        gameOpponent.addIntProperty("flickMiddleLongParallel");
        gameOpponent.addIntProperty("flickMiddleShortCrossed");
        gameOpponent.addIntProperty("flickMiddleShortParallel");
        gameOpponent.addIntProperty("flickRightLongCrossed");
        gameOpponent.addIntProperty("flickRightLongParallel");
        gameOpponent.addIntProperty("flickRightShortCrossed");
        gameOpponent.addIntProperty("flickRightShortParallel");

        //lob spec
        gameOpponent.addIntProperty("lobLeftLongCrossed");
        gameOpponent.addIntProperty("lobLeftLongParallel");
        gameOpponent.addIntProperty("lobLeftShortCrossed");
        gameOpponent.addIntProperty("lobLeftShortParallel");
        gameOpponent.addIntProperty("lobMiddleLongCrossed");
        gameOpponent.addIntProperty("lobMiddleLongParallel");
        gameOpponent.addIntProperty("lobMiddleShortCrossed");
        gameOpponent.addIntProperty("lobMiddleShortParallel");
        gameOpponent.addIntProperty("lobRightLongCrossed");
        gameOpponent.addIntProperty("lobRightLongParallel");
        gameOpponent.addIntProperty("lobRightShortCrossed");
        gameOpponent.addIntProperty("lobRightShortParallel");

        gameOpponent.implementsSerializable();

        return gameOpponent;
    }

    private static Entity addGameUser(Schema schema) {
        Entity gameUser = schema.addEntity("GameUser");
        gameUser.addIdProperty().primaryKey().autoincrement();

        gameUser.addIntProperty("service");
        gameUser.addIntProperty("reception");
        gameUser.addIntProperty("forehand");
        gameUser.addIntProperty("backhand");
        gameUser.addIntProperty("smash");
        gameUser.addIntProperty("slice");
        gameUser.addIntProperty("block");
        gameUser.addIntProperty("flick");
        gameUser.addIntProperty("lob");

        gameUser.addIntProperty("total");

        //service spec
        gameUser.addIntProperty("serviceLeftLongCrossed");
        gameUser.addIntProperty("serviceLeftLongParallel");
        gameUser.addIntProperty("serviceLeftShortCrossed");
        gameUser.addIntProperty("serviceLeftShortParallel");
        gameUser.addIntProperty("serviceMiddleLongCrossed");
        gameUser.addIntProperty("serviceMiddleLongParallel");
        gameUser.addIntProperty("serviceMiddleShortCrossed");
        gameUser.addIntProperty("serviceMiddleShortParallel");
        gameUser.addIntProperty("serviceRightLongCrossed");
        gameUser.addIntProperty("serviceRightLongParallel");
        gameUser.addIntProperty("serviceRightShortCrossed");
        gameUser.addIntProperty("serviceRightShortParallel");

        //reception spec
        gameUser.addIntProperty("receptionLeftLongCrossed");
        gameUser.addIntProperty("receptionLeftLongParallel");
        gameUser.addIntProperty("receptionLeftShortCrossed");
        gameUser.addIntProperty("receptionLeftShortParallel");
        gameUser.addIntProperty("receptionMiddleLongCrossed");
        gameUser.addIntProperty("receptionMiddleLongParallel");
        gameUser.addIntProperty("receptionMiddleShortCrossed");
        gameUser.addIntProperty("receptionMiddleShortParallel");
        gameUser.addIntProperty("receptionRightLongCrossed");
        gameUser.addIntProperty("receptionRightLongParallel");
        gameUser.addIntProperty("receptionRightShortCrossed");
        gameUser.addIntProperty("receptionRightShortParallel");

        //forehand spec
        gameUser.addIntProperty("forehandLeftLongCrossed");
        gameUser.addIntProperty("forehandLeftLongParallel");
        gameUser.addIntProperty("forehandLeftShortCrossed");
        gameUser.addIntProperty("forehandLeftShortParallel");
        gameUser.addIntProperty("forehandMiddleLongCrossed");
        gameUser.addIntProperty("forehandMiddleLongParallel");
        gameUser.addIntProperty("forehandMiddleShortCrossed");
        gameUser.addIntProperty("forehandMiddleShortParallel");
        gameUser.addIntProperty("forehandRightLongCrossed");
        gameUser.addIntProperty("forehandRightLongParallel");
        gameUser.addIntProperty("forehandRightShortCrossed");
        gameUser.addIntProperty("forehandRightShortParallel");

        //backhand spec
        gameUser.addIntProperty("backhandLeftLongCrossed");
        gameUser.addIntProperty("backhandLeftLongParallel");
        gameUser.addIntProperty("backhandLeftShortCrossed");
        gameUser.addIntProperty("backhandLeftShortParallel");
        gameUser.addIntProperty("backhandMiddleLongCrossed");
        gameUser.addIntProperty("backhandMiddleLongParallel");
        gameUser.addIntProperty("backhandMiddleShortCrossed");
        gameUser.addIntProperty("backhandMiddleShortParallel");
        gameUser.addIntProperty("backhandRightLongCrossed");
        gameUser.addIntProperty("backhandRightLongParallel");
        gameUser.addIntProperty("backhandRightShortCrossed");
        gameUser.addIntProperty("backhandRightShortParallel");

        //smash spec
        gameUser.addIntProperty("smashLeftLongCrossed");
        gameUser.addIntProperty("smashLeftLongParallel");
        gameUser.addIntProperty("smashLeftShortCrossed");
        gameUser.addIntProperty("smashLeftShortParallel");
        gameUser.addIntProperty("smashMiddleLongCrossed");
        gameUser.addIntProperty("smashMiddleLongParallel");
        gameUser.addIntProperty("smashMiddleShortCrossed");
        gameUser.addIntProperty("smashMiddleShortParallel");
        gameUser.addIntProperty("smashRightLongCrossed");
        gameUser.addIntProperty("smashRightLongParallel");
        gameUser.addIntProperty("smashRightShortCrossed");
        gameUser.addIntProperty("smashRightShortParallel");

        //slice spec
        gameUser.addIntProperty("sliceLeftLongCrossed");
        gameUser.addIntProperty("sliceLeftLongParallel");
        gameUser.addIntProperty("sliceLeftShortCrossed");
        gameUser.addIntProperty("sliceLeftShortParallel");
        gameUser.addIntProperty("sliceMiddleLongCrossed");
        gameUser.addIntProperty("sliceMiddleLongParallel");
        gameUser.addIntProperty("sliceMiddleShortCrossed");
        gameUser.addIntProperty("sliceMiddleShortParallel");
        gameUser.addIntProperty("sliceRightLongCrossed");
        gameUser.addIntProperty("sliceRightLongParallel");
        gameUser.addIntProperty("sliceRightShortCrossed");
        gameUser.addIntProperty("sliceRightShortParallel");

        //block spec
        gameUser.addIntProperty("blockLeftLongCrossed");
        gameUser.addIntProperty("blockLeftLongParallel");
        gameUser.addIntProperty("blockLeftShortCrossed");
        gameUser.addIntProperty("blockLeftShortParallel");
        gameUser.addIntProperty("blockMiddleLongCrossed");
        gameUser.addIntProperty("blockMiddleLongParallel");
        gameUser.addIntProperty("blockMiddleShortCrossed");
        gameUser.addIntProperty("blockMiddleShortParallel");
        gameUser.addIntProperty("blockRightLongCrossed");
        gameUser.addIntProperty("blockRightLongParallel");
        gameUser.addIntProperty("blockRightShortCrossed");
        gameUser.addIntProperty("blockRightShortParallel");

        //flick spec
        gameUser.addIntProperty("flickLeftLongCrossed");
        gameUser.addIntProperty("flickLeftLongParallel");
        gameUser.addIntProperty("flickLeftShortCrossed");
        gameUser.addIntProperty("flickLeftShortParallel");
        gameUser.addIntProperty("flickMiddleLongCrossed");
        gameUser.addIntProperty("flickMiddleLongParallel");
        gameUser.addIntProperty("flickMiddleShortCrossed");
        gameUser.addIntProperty("flickMiddleShortParallel");
        gameUser.addIntProperty("flickRightLongCrossed");
        gameUser.addIntProperty("flickRightLongParallel");
        gameUser.addIntProperty("flickRightShortCrossed");
        gameUser.addIntProperty("flickRightShortParallel");

        //lob spec
        gameUser.addIntProperty("lobLeftLongCrossed");
        gameUser.addIntProperty("lobLeftLongParallel");
        gameUser.addIntProperty("lobLeftShortCrossed");
        gameUser.addIntProperty("lobLeftShortParallel");
        gameUser.addIntProperty("lobMiddleLongCrossed");
        gameUser.addIntProperty("lobMiddleLongParallel");
        gameUser.addIntProperty("lobMiddleShortCrossed");
        gameUser.addIntProperty("lobMiddleShortParallel");
        gameUser.addIntProperty("lobRightLongCrossed");
        gameUser.addIntProperty("lobRightLongParallel");
        gameUser.addIntProperty("lobRightShortCrossed");
        gameUser.addIntProperty("lobRightShortParallel");

        gameUser.implementsSerializable();

        return gameUser;
    }
}
