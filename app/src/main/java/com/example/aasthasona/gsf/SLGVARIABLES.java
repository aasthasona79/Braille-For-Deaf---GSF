package com.example.aasthasona.gsf;

/**
 * Created by aasthasona on 27-04-2015.
 */
public class SLGVARIABLES {
    private String Word;
    private String Contraction;


    public SLGVARIABLES(String w, String co){
        this.Word = w;
        this.Contraction = co;

    }

    public String getwords(){

        return this.Word;
    }
    public String getContraction(){
        return  this.Contraction;
    }


}
