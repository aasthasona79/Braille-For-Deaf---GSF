package com.example.aasthasona.gsf;

/**
 * Created by aasthasona on 13-04-2015.
 */
public class VARIABLES {
    private String WORDS;
    private String cell1;
    private String cell2;
    private String cell3;
    private String cell4;


    public VARIABLES(String words,String cell1,String cell2,String cell3,String cell4){
        this.WORDS=words;
        this.cell1=cell1;
        this.cell2=cell2;
        this.cell3=cell3;
        this.cell4=cell4;
    }
    public String getwords(){
        return this.WORDS;
    }

    public String getcell1(){
        return this.cell1;

    }
    public String getCell2(){
        return this.cell2;

    }
    public String getCell3(){
        return this.cell3;
    }
    public String getCell4(){
        return this.cell4;
    }

}
