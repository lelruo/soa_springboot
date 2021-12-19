package com.example.mydemo.pojo;

import org.springframework.context.annotation.Primary;

public class Experiment {

    public String userEmail;
    public int price;
    public int fixedCost;
    public int variableCost;
    public int bep;
    public String conclusion;

    public Experiment(String userEmail,int price,int fixedCost,int variableCost,int bep,String conclusion){
        this.userEmail=userEmail;
        this.price=price;
        this.fixedCost=fixedCost;
        this.variableCost=variableCost;
        this.bep=bep;
        this.conclusion=conclusion;
    }

//    public Integer getId() {
//        return id;
//    }
//    public void setId(Integer id) {
//        this.id = id;
//    }
//    public String getPurpose(){
//        return  purpose;
//    }
//    public void setPurpose(){ this.purpose=purpose;}
//    public String getProcess(){ return process;}
//    public void setProcess(){ this.process=process;}
//    public String getConclusion(){ return conclusion;}
//    public void setConclusion(){ this.conclusion=conclusion;}

}
