package com.ddd.service.boxer.impl;

import com.ddd.entity.Boxer;
import com.ddd.factory.BoxerFactory;
import com.ddd.service.boxer.IBoxerService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServiceBoxerTest {

    IBoxerService service = ServiceBoxer.getService();

    private static Boxer floyd = BoxerFactory.createBoxer("Floyd Mayweather", 50, 0);
    private static Boxer terence = BoxerFactory.createBoxer("Terence Crawford", 40,0);
    private static Boxer loma = BoxerFactory.createBoxer("Vasyl Lomachenko", 14, 1);


    @Test
    public void a_create() {
        System.out.println("CREATE");

        System.out.println(service.create(floyd).toString());
        System.out.println(service.create(terence).toString());
        System.out.println(service.create(loma).toString());

        System.out.println("");
    }

    @Test
    public void b_read() {
        System.out.println("READ");

        Boxer read = service.readByName(loma.getName());
        System.out.println(read.toString());

        Assert.assertEquals(loma, read);
        System.out.println("");
    }

    @Test
    public void c_update() {
        System.out.println("UPDATE");

        Boxer newLoma = new Boxer
                .Builder()
                .copy(loma)
                .setLosses(2)
                .build();

        System.out.println(service.update(newLoma));
        System.out.println("");
    }

    @Test
    public void d_delete() {
        System.out.println("DELETE");

        boolean deleted = service.deleteByName(terence.getName());
        System.out.println("DELETED: " + deleted);

        System.out.println("");
    }

    @Test
    public void e_getAll() {
        System.out.println("GET ALL");

        Boxer[] all = service.getAll();

        for(Boxer boxer: all){
            System.out.println(boxer.toString());
        }

        System.out.println("");
    }

}