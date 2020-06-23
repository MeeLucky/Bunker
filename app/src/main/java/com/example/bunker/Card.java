package com.example.bunker;

import java.io.Serializable;

public class Card implements Serializable {
    //карточка с характеристиками
    public final int childfreeAge = 50;
    public boolean[] mask = new boolean[11];
    /*mask open/close of characteristics
    * 0) gender and age
    * 1) is childfree
    * 2) profession
    * 3) health
    * 4) phobia
    * 5) character
    * 6) hobby
    * 7) info
    * 8) baggage
    * 9) skill1
    *10) skill2
    * */
    private boolean isAlive = true;

    private int id;
    private boolean gender; //true - male, false - female
    private int age;
    private String profession;
    private String phobia;
    private String character;
    private String health;
    private String baggage;
    private String hobby;
    private String info;
    private boolean childfree;

    private String skill1;
    private String skill2;

    public Card(int id, boolean gender, int age, String profession, String phobia,
                String character, String health, String baggage, String hobby,
                String info, boolean childfree, String skill1, String skill2) {

        this.id = id;
        this.gender = gender;
        this.age = age;
        this.profession = profession;
        this.phobia = phobia;
        this.character = character;
        this.health = health;
        this.baggage = baggage;
        this.hobby = hobby;
        this.info = info;
        this.childfree = childfree;
        this.skill1 = skill1;
        this.skill2 = skill2;

        if(!gender) {
            if(age >= childfreeAge)
                this.childfree = true;
        }
    }

    public void setAlive() {
        isAlive = !isAlive;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setPhobia(String phobia) {
        this.phobia = phobia;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public void setBaggage(String baggage) {
        this.baggage = baggage;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public boolean isAlive() { return isAlive; }
    public boolean getGender() { return gender; }
    public boolean getChildfree() { return childfree; }
    public int getId() { return id; }
    public int getAge() { return age; }
    public String getProfession() { return profession; }
    public String getPhobia() { return phobia; }
    public String getCharacter() { return character; }
    public String getHealth() { return health; }
    public String getBaggage() { return baggage; }
    public String getHobby() { return hobby; }
    public String getInfo() { return info; }
    public String getSkill1() { return skill1; }
    public String getSkill2() { return skill2; }
}
