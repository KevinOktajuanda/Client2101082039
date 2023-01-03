/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kevin.client2101082039.service;

import com.kevin.client2101082039.model.Anggota;
import com.google.gson.Gson;
import java.util.List;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;


/**
 *
 * @author ASUS
 */
public class AnggotaService {
   private String url = "http://localhost:9012";
    
    public Anggota getAnggota(Long anggotaId){
        Anggota anggota = Unirest.get(url + "/anggota/"+anggotaId)
                .asObject(Anggota.class)
                .getBody();
        return anggota;
    }
    
    public Anggota saveAnggota(Anggota anggota){
        HttpResponse<JsonNode> response = Unirest.post(url + "/anggota/")
                .header("Content-Type", "application/json")
                .body(anggota)
                .asJson();
        Gson gson = new Gson();
        return gson.fromJson(response.getBody().toString(), Anggota.class);
    }
    
    public List <Anggota> getAllAnggota(){
        List <Anggota> anggotaList = Unirest.get(url + "/anggota/")
                .asObject(new GenericType<List<Anggota>>(){})
                .getBody();
        return anggotaList;
    }
    
    public Anggota updateAnggota(Anggota anggota){
        HttpResponse<JsonNode> response = Unirest.put(url + "/anggota/")
                .header("content-type","application/json")
                .body(anggota)
                .asJson();
        Gson gson = new Gson();
        Anggota a = gson.fromJson(response.getBody().toString(),Anggota.class);
        return a;
    }
    
    public void deleteAnggota(Long anggotaId){
        Unirest.delete(url + "/anggota/"+anggotaId).asEmpty();
    }
}