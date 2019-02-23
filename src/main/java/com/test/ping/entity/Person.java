package com.test.ping.entity;

import javax.json.Json;
import javax.json.JsonObject;

public class Person {


    private int id;
    private String name;
    private String email;
    private String phone;

    public Person(){};

    public Person(int id, String name, String email, String phone)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Person(JsonObject input){
        id = input.getInt("id");
        name = input.getString("name");
        email = input.getString("email");
        phone = input.getString("phone");
    }

    public JsonObject toJson(){
        return Json.createObjectBuilder().add("id", id)
                .add("name", name)
                .add("email", email)
                .add("phone", phone).build();
    }

    @Override
    public String toString() {
        return "id: " + id + " name: " + name + " email: " + email + " phone: " + phone;
    }
}

