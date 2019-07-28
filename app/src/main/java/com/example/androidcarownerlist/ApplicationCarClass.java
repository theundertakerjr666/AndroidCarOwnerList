package com.example.androidcarownerlist;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationCarClass extends Application {

    public static ArrayList<Car> cars;

    @Override
    public void onCreate() {
        super.onCreate();

        cars = new ArrayList<Car>();
        cars.add(new Car("Courcheval_Manta", "Manta", "Styker", "0102334455"));
        cars.add(new Car("Phaedra_Palomino", "Palomino", "Jokeri", "02055667788"));
        cars.add(new Car("Picard_phirana", "Phirana", "Jackie", "01022334455"));
        cars.add(new Car("Phaedra_Palomino", "Palomino", "Johnny", "02024364788"));
        cars.add(new Car("Picard_phirana", "Phirana", "Louie", "088453433"));
    }
}
