package com.example.bunker;

public class Card {
    //карточка с характеристиками
    public static int childfreeAge = 50;
    private int id;
    private boolean isAlive = true;

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
