package com.ddd.service.boxer.impl;

import com.ddd.entity.Boxer;
import com.ddd.repository.boxer.IBoxerRepo;
import com.ddd.repository.boxer.impl.RepoBoxer;
import com.ddd.service.boxer.IBoxerService;
import org.springframework.stereotype.Service;

@Service 
public class ServiceBoxer implements IBoxerService {

    private static IBoxerService service = null;

    IBoxerRepo boxerRepo = null;

    // constructor
    private ServiceBoxer(){
        this.boxerRepo = RepoBoxer.getRepo();
    }

    // service singleton
    public static IBoxerService getService(){
        if(service == null){
            service = new ServiceBoxer();
        }
        return service;
    }


    @Override
    public Boxer[] getAll() {
        return boxerRepo.getBoxers();
    }


    @Override
    public Boxer create(Boxer boxer) {
        return boxerRepo.create(boxer);
    }

    @Override
    public Boxer read(String name) {
        return boxerRepo.read(name);
    }

    @Override
    public Boxer readByName(String name) {
        return boxerRepo.readByName(name);
    }

    @Override
    public Boxer update(Boxer boxer) {
        return boxerRepo.update(boxer);
    }

    @Override
    public boolean delete(String id) {
        return boxerRepo.delete(id);
    }

    @Override
    public boolean deleteByName(String name) {
        return boxerRepo.deleteByName(name);
    }

}
