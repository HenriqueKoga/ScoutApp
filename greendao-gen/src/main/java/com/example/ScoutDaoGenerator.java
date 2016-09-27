package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

public class ScoutDaoGenerator {

    private static final String PACKAGE = "scoutapp.com.br.scoutapp.model";

    public static void main(String[] args) {
        Schema schema = new Schema(4, PACKAGE);
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
        championship.addDateProperty("date");
        championship.addStringProperty("state");
        championship.addStringProperty("city");

        championship.implementsSerializable();

        return championship;
    }

    private static Entity addGameOpponent(Schema schema) {
        Entity gameOpponent = schema.addEntity("GameOpponent");
        gameOpponent.addIdProperty().primaryKey().autoincrement();
        gameOpponent.addIntProperty("service").notNull();
        gameOpponent.addIntProperty("reception").notNull();
        gameOpponent.addIntProperty("forehand").notNull();
        gameOpponent.addIntProperty("backhand").notNull();
        gameOpponent.addIntProperty("smash").notNull();
        gameOpponent.addIntProperty("slice").notNull();
        gameOpponent.addIntProperty("block").notNull();
        gameOpponent.addIntProperty("flick").notNull();
        gameOpponent.addIntProperty("lob").notNull();

        gameOpponent.addIntProperty("total").notNull();

        //service spec
        gameOpponent.addIntProperty("serviceLeftLongCrossed").notNull();
        gameOpponent.addIntProperty("serviceLeftLongParallel").notNull();
        gameOpponent.addIntProperty("serviceLeftShortCrossed").notNull();
        gameOpponent.addIntProperty("serviceLeftShortParallel").notNull();
        gameOpponent.addIntProperty("serviceMiddleLongCrossed").notNull();
        gameOpponent.addIntProperty("serviceMiddleLongParallel").notNull();
        gameOpponent.addIntProperty("serviceMiddleShortCrossed").notNull();
        gameOpponent.addIntProperty("serviceMiddleShortParallel").notNull();
        gameOpponent.addIntProperty("serviceRightLongCrossed").notNull();
        gameOpponent.addIntProperty("serviceRightLongParallel").notNull();
        gameOpponent.addIntProperty("serviceRightShortCrossed").notNull();
        gameOpponent.addIntProperty("serviceRightShortParallel").notNull();

        //reception spec
        gameOpponent.addIntProperty("receptionLeftLongCrossed").notNull();
        gameOpponent.addIntProperty("receptionLeftLongParallel").notNull();
        gameOpponent.addIntProperty("receptionLeftShortCrossed").notNull();
        gameOpponent.addIntProperty("receptionLeftShortParallel").notNull();
        gameOpponent.addIntProperty("receptionMiddleLongCrossed").notNull();
        gameOpponent.addIntProperty("receptionMiddleLongParallel").notNull();
        gameOpponent.addIntProperty("receptionMiddleShortCrossed").notNull();
        gameOpponent.addIntProperty("receptionMiddleShortParallel").notNull();
        gameOpponent.addIntProperty("receptionRightLongCrossed").notNull();
        gameOpponent.addIntProperty("receptionRightLongParallel").notNull();
        gameOpponent.addIntProperty("receptionRightShortCrossed").notNull();
        gameOpponent.addIntProperty("receptionRightShortParallel").notNull();

        //forehand spec
        gameOpponent.addIntProperty("forehandLeftLongCrossed").notNull();
        gameOpponent.addIntProperty("forehandLeftLongParallel").notNull();
        gameOpponent.addIntProperty("forehandLeftShortCrossed").notNull();
        gameOpponent.addIntProperty("forehandLeftShortParallel").notNull();
        gameOpponent.addIntProperty("forehandMiddleLongCrossed").notNull();
        gameOpponent.addIntProperty("forehandMiddleLongParallel").notNull();
        gameOpponent.addIntProperty("forehandMiddleShortCrossed").notNull();
        gameOpponent.addIntProperty("forehandMiddleShortParallel").notNull();
        gameOpponent.addIntProperty("forehandRightLongCrossed").notNull();
        gameOpponent.addIntProperty("forehandRightLongParallel").notNull();
        gameOpponent.addIntProperty("forehandRightShortCrossed").notNull();
        gameOpponent.addIntProperty("forehandRightShortParallel").notNull();

        //backhand spec
        gameOpponent.addIntProperty("backhandLeftLongCrossed").notNull();
        gameOpponent.addIntProperty("backhandLeftLongParallel").notNull();
        gameOpponent.addIntProperty("backhandLeftShortCrossed").notNull();
        gameOpponent.addIntProperty("backhandLeftShortParallel").notNull();
        gameOpponent.addIntProperty("backhandMiddleLongCrossed").notNull();
        gameOpponent.addIntProperty("backhandMiddleLongParallel").notNull();
        gameOpponent.addIntProperty("backhandMiddleShortCrossed").notNull();
        gameOpponent.addIntProperty("backhandMiddleShortParallel").notNull();
        gameOpponent.addIntProperty("backhandRightLongCrossed").notNull();
        gameOpponent.addIntProperty("backhandRightLongParallel").notNull();
        gameOpponent.addIntProperty("backhandRightShortCrossed").notNull();
        gameOpponent.addIntProperty("backhandRightShortParallel").notNull();

        //smash spec
        gameOpponent.addIntProperty("smashLeftLongCrossed").notNull();
        gameOpponent.addIntProperty("smashLeftLongParallel").notNull();
        gameOpponent.addIntProperty("smashLeftShortCrossed").notNull();
        gameOpponent.addIntProperty("smashLeftShortParallel").notNull();
        gameOpponent.addIntProperty("smashMiddleLongCrossed").notNull();
        gameOpponent.addIntProperty("smashMiddleLongParallel").notNull();
        gameOpponent.addIntProperty("smashMiddleShortCrossed").notNull();
        gameOpponent.addIntProperty("smashMiddleShortParallel").notNull();
        gameOpponent.addIntProperty("smashRightLongCrossed").notNull();
        gameOpponent.addIntProperty("smashRightLongParallel").notNull();
        gameOpponent.addIntProperty("smashRightShortCrossed").notNull();
        gameOpponent.addIntProperty("smashRightShortParallel").notNull();

        //slice spec
        gameOpponent.addIntProperty("sliceLeftLongCrossed").notNull();
        gameOpponent.addIntProperty("sliceLeftLongParallel").notNull();
        gameOpponent.addIntProperty("sliceLeftShortCrossed").notNull();
        gameOpponent.addIntProperty("sliceLeftShortParallel").notNull();
        gameOpponent.addIntProperty("sliceMiddleLongCrossed").notNull();
        gameOpponent.addIntProperty("sliceMiddleLongParallel").notNull();
        gameOpponent.addIntProperty("sliceMiddleShortCrossed").notNull();
        gameOpponent.addIntProperty("sliceMiddleShortParallel").notNull();
        gameOpponent.addIntProperty("sliceRightLongCrossed").notNull();
        gameOpponent.addIntProperty("sliceRightLongParallel").notNull();
        gameOpponent.addIntProperty("sliceRightShortCrossed").notNull();
        gameOpponent.addIntProperty("sliceRightShortParallel").notNull();

        //block spec
        gameOpponent.addIntProperty("blockLeftLongCrossed").notNull();
        gameOpponent.addIntProperty("blockLeftLongParallel").notNull();
        gameOpponent.addIntProperty("blockLeftShortCrossed").notNull();
        gameOpponent.addIntProperty("blockLeftShortParallel").notNull();
        gameOpponent.addIntProperty("blockMiddleLongCrossed").notNull();
        gameOpponent.addIntProperty("blockMiddleLongParallel").notNull();
        gameOpponent.addIntProperty("blockMiddleShortCrossed").notNull();
        gameOpponent.addIntProperty("blockMiddleShortParallel").notNull();
        gameOpponent.addIntProperty("blockRightLongCrossed").notNull();
        gameOpponent.addIntProperty("blockRightLongParallel").notNull();
        gameOpponent.addIntProperty("blockRightShortCrossed").notNull();
        gameOpponent.addIntProperty("blockRightShortParallel").notNull();

        //flick spec
        gameOpponent.addIntProperty("flickLeftLongCrossed").notNull();
        gameOpponent.addIntProperty("flickLeftLongParallel").notNull();
        gameOpponent.addIntProperty("flickLeftShortCrossed").notNull();
        gameOpponent.addIntProperty("flickLeftShortParallel").notNull();
        gameOpponent.addIntProperty("flickMiddleLongCrossed").notNull();
        gameOpponent.addIntProperty("flickMiddleLongParallel").notNull();
        gameOpponent.addIntProperty("flickMiddleShortCrossed").notNull();
        gameOpponent.addIntProperty("flickMiddleShortParallel").notNull();
        gameOpponent.addIntProperty("flickRightLongCrossed").notNull();
        gameOpponent.addIntProperty("flickRightLongParallel").notNull();
        gameOpponent.addIntProperty("flickRightShortCrossed").notNull();
        gameOpponent.addIntProperty("flickRightShortParallel").notNull();

        //lob spec
        gameOpponent.addIntProperty("lobLeftLongCrossed").notNull();
        gameOpponent.addIntProperty("lobLeftLongParallel").notNull();
        gameOpponent.addIntProperty("lobLeftShortCrossed").notNull();
        gameOpponent.addIntProperty("lobLeftShortParallel").notNull();
        gameOpponent.addIntProperty("lobMiddleLongCrossed").notNull();
        gameOpponent.addIntProperty("lobMiddleLongParallel").notNull();
        gameOpponent.addIntProperty("lobMiddleShortCrossed").notNull();
        gameOpponent.addIntProperty("lobMiddleShortParallel").notNull();
        gameOpponent.addIntProperty("lobRightLongCrossed").notNull();
        gameOpponent.addIntProperty("lobRightLongParallel").notNull();
        gameOpponent.addIntProperty("lobRightShortCrossed").notNull();
        gameOpponent.addIntProperty("lobRightShortParallel").notNull();

        gameOpponent.implementsSerializable();

        return gameOpponent;
    }

    private static Entity addGameUser(Schema schema) {
        Entity gameUser = schema.addEntity("GameUser");
        gameUser.addIdProperty().primaryKey().autoincrement();

        gameUser.addIntProperty("service").notNull();
        gameUser.addIntProperty("reception").notNull();
        gameUser.addIntProperty("forehand").notNull();
        gameUser.addIntProperty("backhand").notNull();
        gameUser.addIntProperty("smash").notNull();
        gameUser.addIntProperty("slice").notNull();
        gameUser.addIntProperty("block").notNull();
        gameUser.addIntProperty("flick").notNull();
        gameUser.addIntProperty("lob").notNull();

        gameUser.addIntProperty("total").notNull();

        //service spec
        gameUser.addIntProperty("serviceLeftLongCrossed").notNull();
        gameUser.addIntProperty("serviceLeftLongParallel").notNull();
        gameUser.addIntProperty("serviceLeftShortCrossed").notNull();
        gameUser.addIntProperty("serviceLeftShortParallel").notNull();
        gameUser.addIntProperty("serviceMiddleLongCrossed").notNull();
        gameUser.addIntProperty("serviceMiddleLongParallel").notNull();
        gameUser.addIntProperty("serviceMiddleShortCrossed").notNull();
        gameUser.addIntProperty("serviceMiddleShortParallel").notNull();
        gameUser.addIntProperty("serviceRightLongCrossed").notNull();
        gameUser.addIntProperty("serviceRightLongParallel").notNull();
        gameUser.addIntProperty("serviceRightShortCrossed").notNull();
        gameUser.addIntProperty("serviceRightShortParallel").notNull();

        //reception spec
        gameUser.addIntProperty("receptionLeftLongCrossed").notNull();
        gameUser.addIntProperty("receptionLeftLongParallel").notNull();
        gameUser.addIntProperty("receptionLeftShortCrossed").notNull();
        gameUser.addIntProperty("receptionLeftShortParallel").notNull();
        gameUser.addIntProperty("receptionMiddleLongCrossed").notNull();
        gameUser.addIntProperty("receptionMiddleLongParallel").notNull();
        gameUser.addIntProperty("receptionMiddleShortCrossed").notNull();
        gameUser.addIntProperty("receptionMiddleShortParallel").notNull();
        gameUser.addIntProperty("receptionRightLongCrossed").notNull();
        gameUser.addIntProperty("receptionRightLongParallel").notNull();
        gameUser.addIntProperty("receptionRightShortCrossed").notNull();
        gameUser.addIntProperty("receptionRightShortParallel").notNull();

        //forehand spec
        gameUser.addIntProperty("forehandLeftLongCrossed").notNull();
        gameUser.addIntProperty("forehandLeftLongParallel").notNull();
        gameUser.addIntProperty("forehandLeftShortCrossed").notNull();
        gameUser.addIntProperty("forehandLeftShortParallel").notNull();
        gameUser.addIntProperty("forehandMiddleLongCrossed").notNull();
        gameUser.addIntProperty("forehandMiddleLongParallel").notNull();
        gameUser.addIntProperty("forehandMiddleShortCrossed").notNull();
        gameUser.addIntProperty("forehandMiddleShortParallel").notNull();
        gameUser.addIntProperty("forehandRightLongCrossed").notNull();
        gameUser.addIntProperty("forehandRightLongParallel").notNull();
        gameUser.addIntProperty("forehandRightShortCrossed").notNull();
        gameUser.addIntProperty("forehandRightShortParallel").notNull();

        //backhand spec
        gameUser.addIntProperty("backhandLeftLongCrossed").notNull();
        gameUser.addIntProperty("backhandLeftLongParallel").notNull();
        gameUser.addIntProperty("backhandLeftShortCrossed").notNull();
        gameUser.addIntProperty("backhandLeftShortParallel").notNull();
        gameUser.addIntProperty("backhandMiddleLongCrossed").notNull();
        gameUser.addIntProperty("backhandMiddleLongParallel").notNull();
        gameUser.addIntProperty("backhandMiddleShortCrossed").notNull();
        gameUser.addIntProperty("backhandMiddleShortParallel").notNull();
        gameUser.addIntProperty("backhandRightLongCrossed").notNull();
        gameUser.addIntProperty("backhandRightLongParallel").notNull();
        gameUser.addIntProperty("backhandRightShortCrossed").notNull();
        gameUser.addIntProperty("backhandRightShortParallel").notNull();

        //smash spec
        gameUser.addIntProperty("smashLeftLongCrossed").notNull();
        gameUser.addIntProperty("smashLeftLongParallel").notNull();
        gameUser.addIntProperty("smashLeftShortCrossed").notNull();
        gameUser.addIntProperty("smashLeftShortParallel").notNull();
        gameUser.addIntProperty("smashMiddleLongCrossed").notNull();
        gameUser.addIntProperty("smashMiddleLongParallel").notNull();
        gameUser.addIntProperty("smashMiddleShortCrossed").notNull();
        gameUser.addIntProperty("smashMiddleShortParallel").notNull();
        gameUser.addIntProperty("smashRightLongCrossed").notNull();
        gameUser.addIntProperty("smashRightLongParallel").notNull();
        gameUser.addIntProperty("smashRightShortCrossed").notNull();
        gameUser.addIntProperty("smashRightShortParallel").notNull();

        //slice spec
        gameUser.addIntProperty("sliceLeftLongCrossed").notNull();
        gameUser.addIntProperty("sliceLeftLongParallel").notNull();
        gameUser.addIntProperty("sliceLeftShortCrossed").notNull();
        gameUser.addIntProperty("sliceLeftShortParallel").notNull();
        gameUser.addIntProperty("sliceMiddleLongCrossed").notNull();
        gameUser.addIntProperty("sliceMiddleLongParallel").notNull();
        gameUser.addIntProperty("sliceMiddleShortCrossed").notNull();
        gameUser.addIntProperty("sliceMiddleShortParallel").notNull();
        gameUser.addIntProperty("sliceRightLongCrossed").notNull();
        gameUser.addIntProperty("sliceRightLongParallel").notNull();
        gameUser.addIntProperty("sliceRightShortCrossed").notNull();
        gameUser.addIntProperty("sliceRightShortParallel").notNull();

        //block spec
        gameUser.addIntProperty("blockLeftLongCrossed").notNull();
        gameUser.addIntProperty("blockLeftLongParallel").notNull();
        gameUser.addIntProperty("blockLeftShortCrossed").notNull();
        gameUser.addIntProperty("blockLeftShortParallel").notNull();
        gameUser.addIntProperty("blockMiddleLongCrossed").notNull();
        gameUser.addIntProperty("blockMiddleLongParallel").notNull();
        gameUser.addIntProperty("blockMiddleShortCrossed").notNull();
        gameUser.addIntProperty("blockMiddleShortParallel").notNull();
        gameUser.addIntProperty("blockRightLongCrossed").notNull();
        gameUser.addIntProperty("blockRightLongParallel").notNull();
        gameUser.addIntProperty("blockRightShortCrossed").notNull();
        gameUser.addIntProperty("blockRightShortParallel").notNull();

        //flick spec
        gameUser.addIntProperty("flickLeftLongCrossed").notNull();
        gameUser.addIntProperty("flickLeftLongParallel").notNull();
        gameUser.addIntProperty("flickLeftShortCrossed").notNull();
        gameUser.addIntProperty("flickLeftShortParallel").notNull();
        gameUser.addIntProperty("flickMiddleLongCrossed").notNull();
        gameUser.addIntProperty("flickMiddleLongParallel").notNull();
        gameUser.addIntProperty("flickMiddleShortCrossed").notNull();
        gameUser.addIntProperty("flickMiddleShortParallel").notNull();
        gameUser.addIntProperty("flickRightLongCrossed").notNull();
        gameUser.addIntProperty("flickRightLongParallel").notNull();
        gameUser.addIntProperty("flickRightShortCrossed").notNull();
        gameUser.addIntProperty("flickRightShortParallel").notNull();

        //lob spec
        gameUser.addIntProperty("lobLeftLongCrossed").notNull();
        gameUser.addIntProperty("lobLeftLongParallel").notNull();
        gameUser.addIntProperty("lobLeftShortCrossed").notNull();
        gameUser.addIntProperty("lobLeftShortParallel").notNull();
        gameUser.addIntProperty("lobMiddleLongCrossed").notNull();
        gameUser.addIntProperty("lobMiddleLongParallel").notNull();
        gameUser.addIntProperty("lobMiddleShortCrossed").notNull();
        gameUser.addIntProperty("lobMiddleShortParallel").notNull();
        gameUser.addIntProperty("lobRightLongCrossed").notNull();
        gameUser.addIntProperty("lobRightLongParallel").notNull();
        gameUser.addIntProperty("lobRightShortCrossed").notNull();
        gameUser.addIntProperty("lobRightShortParallel").notNull();

        gameUser.implementsSerializable();

        return gameUser;
    }
}
