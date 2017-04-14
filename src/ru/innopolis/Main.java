package ru.innopolis;

import ru.innopolis.conf.DB;

public class Main {

    public static void main(String[] args) {

        DB db = new DB();

        db.initConnection();

        db.get();

    }
}