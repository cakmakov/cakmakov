package com.example.taskmanager;


public class Ekle {

    private String ekleId;
    private String ekleCalisan;
    private String ekleGorev;

    public Ekle(){}

    public Ekle(String ekleId,String ekleCalisan,String ekleGorev){

        this.ekleId=ekleId;
        this.ekleCalisan=ekleCalisan;
        this.ekleGorev=ekleGorev;

    }

    public String getEkleId(){

        return ekleId;

    }

    public String getEkleCalisan(){

        return ekleCalisan;

    }

    public String getEkleGorev(){

        return ekleGorev;

    }

}
