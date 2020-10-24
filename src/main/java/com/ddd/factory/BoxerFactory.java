package com.ddd.factory;

import com.ddd.entity.Boxer;
import com.ddd.util.GenerateID;

public class BoxerFactory {

    public static Boxer createBoxer(String name, int wins, int losses){
        String id = GenerateID.generateId();

        Boxer boxer = new Boxer.Builder()
                .setId(id)
                .setName(name)
                .setWins(wins)
                .setLosses(losses)
                .build();

        return boxer;
    }

}
