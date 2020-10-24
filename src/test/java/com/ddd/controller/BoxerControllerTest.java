package com.ddd.controller;

import com.ddd.entity.Boxer;
import com.ddd.factory.BoxerFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoxerControllerTest {

    @Autowired
    private static RestTemplate restTemplate;

    private static final String baseURL = "http://localhost:8080/boxer/";

    private static Boxer floyd = BoxerFactory.createBoxer("Floyd Mayweather", 50, 0);
    private static Boxer terence = BoxerFactory.createBoxer("Terence Crawford", 40,0);
    private static Boxer loma = BoxerFactory.createBoxer("Vasyl Lomachenko", 14, 1);


    @Test
    public void a_create() {
        System.out.println("READ");

        String url = baseURL + "create";

        HttpEntity<Boxer> req = new HttpEntity(floyd, null);
        ResponseEntity<Boxer> res = restTemplate.exchange(url, HttpMethod.POST, req, Boxer.class);
        System.out.println(res);

        System.out.println("");
    }

    @Test
    public void b_getAll() {
        System.out.println("GET ALL");

        String url = baseURL + "getBoxers";


        System.out.println("");
    }

    @Test
    public void c_readByName() {
        System.out.println("READ BY NAME");

        String name = "Floyd Mayweather";
        String url = baseURL + "read/" + name;


        System.out.println("");
    }

    @Test
    public void d_update() {
        System.out.println("UPDATE");

        String url = baseURL + "update";
        Boxer newBoxer = new Boxer.Builder().copy(loma).setLosses(2).build();


        System.out.println("");
    }

    @Test
    public void e_delete() {
        System.out.println("DELETE");

        String id = "";
        String url = baseURL + "create/" + id;


        System.out.println("");
    }


}