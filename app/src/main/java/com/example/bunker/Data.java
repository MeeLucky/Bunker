package com.example.bunker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Data {
    //представляет данные для создания карт
    Random rand = new Random();



    private String generalStringGetter(String what) {
        String[] arr;
        ArrayList<Integer> history;
        switch (what){
            case "profession":
                arr = professions;
                history = professionsHistory;
                break;
            case "phobia":
                arr = phobias;
                history = phobiasHistory;
                break;
            case "character":
                arr = characters;
                history = charactersHistory;
                break;
            case "health":
                arr = healthiest;
                history = healthiestHistory;
                break;
            case "baggage":
                arr = baggage;
                history = baggageHistory;
                break;
            case "hobby":
                arr = hobbies;
                history = hobbiesHistory;
                break;
            case "info":
                arr = info;
                history = infoHistory;
                break;
            case "skill":
                arr = skills;
                history = skillsHistory;
                break;
            default:
                return "Data.ERROR 1";
        }

        if(history.size() == arr.length)
            return "Data.ERROR 2";

        while(true) {
            int n = rand.nextInt(arr.length);
            if(history.indexOf(n) == -1) {
                history.add(n);

                if(what.equals("health")) {
                    return arr[n] +" "+ (rand.nextInt(10) * 10) +"%";
                }
                return arr[n];
            }
        }
    }


    private String[] professions = new String[] {
            "слесарь",
            "химик",
            "биолг",
            "медик",
            "военный"
    };
    private ArrayList<Integer> professionsHistory = new ArrayList<>();
    public String getProfession() { return generalStringGetter("profession"); }

    private String[] phobias  = new String[] {
            "библиоФобия",
            "арахнофобия",
            "боязнь крыс",
            "боязнь числа 4",
            "пацифист"
    };
    private ArrayList<Integer> phobiasHistory = new ArrayList<>();
    public String getPhobia() { return generalStringGetter("phobia"); }

    private String[] characters = new String[] {
            "буйный",
            "токсик",
            "спокойный",
            "перфекционист",
            "заносчивый"
    };
    private ArrayList<Integer> charactersHistory = new ArrayList<>();
    public String getCharacter() { return generalStringGetter("character"); }

    private String[] healthiest = new String[] {
            "обычный человек",
            "крепкое телосложение",
            "ожирение",
            "туберкулёз",
            "слепой"
    };
    private ArrayList<Integer> healthiestHistory = new ArrayList<>();
    public String getHealth() { return generalStringGetter("health"); }

    private String[] baggage = new String[] {
            "набор инструментов",
            "ребёнок",
            "собкачка",
            "крыса",
            "книги"
    };
    private ArrayList<Integer> baggageHistory = new ArrayList<>();
    public String getBaggage() { return generalStringGetter("baggage"); }

    private String[] hobbies = new String[] {
            "готовка",
            "строительство",
            "садоводство",
            "брейкданс",
            "паркур"
    };
    private ArrayList<Integer> hobbiesHistory = new ArrayList<>();
    public String getHobby() { return generalStringGetter("hobby"); }

    private String[] info = new String[] {
            "знает 5 языков",
            "чемпион мира по стрельбе из лука",
            "резидент камеди клаб",
            "знает все стихи Бродского",
            "жил в семье фермеров"
    };
    private ArrayList<Integer> infoHistory = new ArrayList<>();
    public String getInfo() { return generalStringGetter("info"); }

    private String[] skills = new String[] {
            "обменять багаж с любым игроком",
            "излечить любого игрока",
            "сменить себе фобию",
            "сменить себе хобби",
            "сменить себе проффесию",
            "сменить себе багаж",
            "сменить проффесии всех игроков",
            "уменьшить бункер на 1",
            "увеличить бункер на 1",
            "прекратить разговоры и начать голосование"
    };

    private ArrayList<Integer> skillsHistory = new ArrayList<>();
    public String getSkill() { return generalStringGetter("skill"); }

    public boolean getСhildfree() {
        //30% шанс быть чаилдфри
        return rand.nextInt(100) < 30;
    }
}
