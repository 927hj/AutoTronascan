package com.tron.model;

import lombok.Data;

/**
 * ${params}
 *
 * @Author:tron
 * @Date:2019-08-23 14:20
 */
@Data
public class LoadTxInfoCase {
    private int id;
    private String knock;
    private int expected;

    public int getId(){
        return id;
    }
    public void setId(int id ){
        this.id = id;
    }

    public String getKnock(){
        return knock;
    }
    public void setKnock(String knock ){
        this.knock = knock;
    }
    public int getExpected(){
        return expected;
    }
    public void setKnock(int expected ){
        this.expected = expected;
    }

    public String toString(){
        return "knock"+knock+ "；expected="+expected;
    }
}
