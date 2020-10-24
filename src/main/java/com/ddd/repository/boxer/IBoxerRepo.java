package com.ddd.repository.boxer;

import com.ddd.entity.Boxer;
import com.ddd.repository.IRepository;

public interface IBoxerRepo extends IRepository<Boxer, String> {
    Boxer[] getBoxers();

    Boxer readByName(String name);

    boolean deleteByName(String name);

}
