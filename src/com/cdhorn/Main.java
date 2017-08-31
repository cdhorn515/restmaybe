package com.cdhorn;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://swapi.co/api/people/1");
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
        String line = rd.readLine();
        System.out.println(line);
        ObjectMapper mapper = new ObjectMapper();
        StarWars starWars = mapper.readValue(line, StarWars.class);
        System.out.println(starWars);
        String name = starWars.getName();
        System.out.println(name);
        ArrayList<String> vehicles = starWars.getVehicles();
        System.out.println(vehicles);
        System.out.println(vehicles.get(0));

        System.out.println(mapper.writeValueAsString(starWars));
    }
}
