package com.test.ping.boundary;

import java.util.Date;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.test.ping.control.IdentityGenerator;
import com.test.ping.entity.Person;


@Path("ping")
public class PersonResource {

    @Inject
    IdentityGenerator idGenerator;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getPerson(){
        Person person = new Person(idGenerator.getId(), "John", "john@doe.com", "+1234567890");
        return person.toJson();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject addPerson(JsonObject input){
        Person person = new Person(input);
        System.out.println(person.toString());
        System.out.println(input.toString());

        return Json.createObjectBuilder().add("timestamp", new Date().toString()).add("status", "ok").build();
    }


}

