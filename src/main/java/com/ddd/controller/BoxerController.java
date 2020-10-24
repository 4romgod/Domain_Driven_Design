package com.ddd.controller;

import com.ddd.entity.Boxer;
import com.ddd.factory.BoxerFactory;
import com.ddd.service.boxer.IBoxerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/boxer")
public class BoxerController {

    @Autowired
    private IBoxerService service;

    //@RequestMapping(value = "/create", method = RequestMethod.POST)
    @PostMapping("/create")
    public Boxer create(@RequestBody Boxer boxer){
        Boxer newBoxer = BoxerFactory.createBoxer(boxer.getName(), boxer.getWins(), boxer.getLosses());
        return service.create(newBoxer);
    }


    @GetMapping("/read/{name}")
    public Boxer readByName(@PathVariable String name){
        return service.readByName(name);
    }


    @GetMapping("/getBoxers")
    public Boxer[] getAll(){
        return service.getAll();
    }


    @PutMapping("/update")
    public Boxer update(@RequestBody Boxer boxer){
        return service.update(boxer);
    }


    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return service.delete(id);
    }


}
