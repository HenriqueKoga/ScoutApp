package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class ScoutDaoGenerator {

    private static final String PACKAGE = "scoutapp.com.br.scoutapp.model";

    public static void main(String[] args) {
        Schema schema = new Schema(1, PACKAGE);
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
}
