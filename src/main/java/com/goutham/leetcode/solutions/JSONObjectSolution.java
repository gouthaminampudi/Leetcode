package com.goutham.leetcode.solutions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.goutham.leetcode.utilities.Person;

public class JSONObjectSolution {
    


    public static void main(String[] args){

        ClassLoader cl =  ClassLoader.getSystemClassLoader() ;

        File jsonFile = new File(cl.getResource("persons.json").getFile());

        ObjectMapper om = new ObjectMapper();
        Person[] personArray = null;
      
        try {
            FileInputStream fi = new FileInputStream(jsonFile);
             personArray = om.readValue(fi, Person[].class);
            for(Person p: personArray){
                System.out.println(p.toString());
            }
        } catch (JsonParseException e) {
             e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Person newp = new Person("Goutham",14,"Male");

      /*  List<Person> pList = Arrays.asList(personArray);
        List<Person> arraylist = new ArrayList<Person>(pList);
        arraylist.add(newp);
        try {
            ObjectWriter writer = om.writer(new DefaultPrettyPrinter());
            writer.writeValue(new File(cl.getResource("persons.json").getFile()), arraylist);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }
}
