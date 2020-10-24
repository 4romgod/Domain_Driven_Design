package com.ddd.repository.boxer.impl;

import com.ddd.entity.Boxer;
import com.ddd.repository.boxer.IBoxerRepo;

import java.util.HashSet;
import java.util.Set;

public class RepoBoxer implements IBoxerRepo {

    private static RepoBoxer repo = null;

    Set<Boxer> boxerDB = new HashSet<>();

    // Repository Singleton
    public static RepoBoxer getRepo(){
        if(repo == null){
            repo = new RepoBoxer();
        }
        return repo;
    }

    @Override
    public Boxer create(Boxer boxer) {
        this.boxerDB.add(boxer);
        return boxer;
    }

    @Override
    public Boxer read(String id) {
        for(Boxer boxer : this.boxerDB){
            if(boxer.getId().equalsIgnoreCase(id)){
                return boxer;
            }
        }
        return null;
    }

    @Override
    public Boxer readByName(String name) {
        for(Boxer boxer : this.boxerDB){
            if(boxer.getName().equalsIgnoreCase(name)){
                return boxer;
            }
        }
        return null;
    }

    @Override
    public Boxer update(Boxer boxer) {
        boolean deleted = delete(boxer.getId());

        if(deleted){
            this.boxerDB.add(boxer);
            return boxer;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        int size = boxerDB.size();

        Boxer boxer = read(id);
        this.boxerDB.remove(boxer);

        return (this.boxerDB.size() == size -1);
    }



    @Override
    public boolean deleteByName(String name) {
        int size = boxerDB.size();

        Boxer boxer = readByName(name);
        this.boxerDB.remove(boxer);

        return (this.boxerDB.size() == size -1);
    }

    @Override
    public Boxer[] getBoxers() {
        int size = this.boxerDB.size();

        Boxer[] list = new Boxer[size];

        int index = 0;
        for (Boxer boxer : this.boxerDB){
            list[index] = boxer;
            index++;
        }
        return list;
    }


}
