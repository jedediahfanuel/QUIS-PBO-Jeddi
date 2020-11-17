package com.View;

import com.Controller.Controller;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Controller controller = new Controller();
        ArrayList<String> lsNama = controller.getNama();

        for (String nama :
                lsNama) {
            System.out.println("Nama : " + nama);
        }

    }
}
