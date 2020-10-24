package com.ddd.repository.boxer.impl;

import com.ddd.entity.Boxer;
import com.ddd.factory.BoxerFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoxerRepoTest {

    RepoBoxer repoBoxer;

    @Before
    public void a_setup(){
        repoBoxer = RepoBoxer.getRepo();
    }

    @Test
    public void b_create() {
        System.out.println("CREATE");
        Boxer floyd = BoxerFactory.createBoxer("Floyd Mayweather", 50, 0);
        Boxer terence = BoxerFactory.createBoxer("Terence Crawford", 40,0);
        Boxer loma = BoxerFactory.createBoxer("Vasyl Lomachenko", 14, 1);

        System.out.println(repoBoxer.create(loma).toString());
        System.out.println(repoBoxer.create(floyd).toString());
        System.out.println(repoBoxer.create(terence).toString());

        System.out.println("");
    }

    @Test
    public void c_read() {
        System.out.println("READ");

        Boxer boxer = repoBoxer.readByName("Vasyl lomachenko");

        Assert.assertTrue(boxer instanceof Boxer);

        System.out.println(boxer.toString());
        System.out.println("");
    }

    @Test
    public void d_update() {
        System.out.println("UPDATE");

        Boxer read = repoBoxer.readByName("Vasyl lomachenko");
        Boxer boxer = new Boxer.Builder().copy(read).setLosses(2).build();

        repoBoxer.update(boxer);

        System.out.println(repoBoxer.readByName("Vasyl lomachenko").toString());
        System.out.println("");
    }

    @Test
    public void e_delete() {
        System.out.println("DELETE");

        boolean deleted = repoBoxer.deleteByName("floyd mayweather");
        System.out.println("DELETED: " + deleted);

        Assert.assertTrue(deleted);

        System.out.println("");
    }

    @Test
    public void f_getBoxers() {
        System.out.println("GET ALL");

        Boxer[] list = repoBoxer.getBoxers();

        System.out.println(java.util.Arrays.toString(list));
        System.out.println("");
    }

}

