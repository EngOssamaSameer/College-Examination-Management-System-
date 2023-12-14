/**
 *
 * @author Eng Ossama Samir
 */
package com.mycompany.examsite;

public abstract class user {
    //-id:int
    private String id;

    //-name:string
    private String name;

    //-password:string
    private String password;

    //-type:string
    private String type;


    //+setID()
    public void setID(String id){
        this.id = id;
    }

    //+getID()
    public String getID(){
        return this.id;
    }

    //+setPassword()
    public void setPassword(String password){
        this.password = password;
    }

    //+getName()
    public String getPassword(){
        return this.password;
    }
    //+setName()
    public void setType(String type){
        this.type = type;
    }

    //+getName()
    public String getType(){
        return this.type;
    }
    //+setName()
    public void setName(String name){
        this.name = name;
    }

    //+getName()
    public String getName(){
        return this.name;
    }
}
