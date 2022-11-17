package com.example.kucharska;

import java.util.ArrayList;

public class RepozytoriumPrzepisow {
    public static final Przepis[] przepisy={
            new Przepis("mufinki",2,"mąka, cukier,mleko,kakao", R.drawable.mufinka),
            new Przepis("ptys",2,"mąka, cukier,mleko,smietana",R.drawable.ptys),
            new Przepis("lody",3,"cukier,mleko", R.drawable.lody),
            new Przepis("gofry",3,"mąka, cukier,mleko,kakao,jajko", R.drawable.gofry),
            new Przepis("chleb",4,"chleb,jajko",R.drawable.chleb),
    };
    public static ArrayList<Przepis> wybierzPrzepisy(int kategoria){
        ArrayList<Przepis> wybrane=new ArrayList<>();
        for (Przepis przepis:przepisy){
            if (przepis.getKategoria()==kategoria){
                wybrane.add(przepis);
            }
        }
        return wybrane;
    }
}
