package com.ddd.service.boxer;

import com.ddd.entity.Boxer;
import com.ddd.service.IService;

public interface IBoxerService extends IService<Boxer, String> {

    Boxer[] getAll();

    Boxer readByName(String name);

    boolean deleteByName(String name);

}
