package com.View;

import com.Controller.Controller;
import com.Model.Jurusan;
import com.Model.Mahasiswa;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShowMhs {

    JFrame frame =  new JFrame("Show Mahasiswa");
    JPanel panel = new JPanel(new GridLayout());

    JTable tabelJurusan;
    String[] columnNames = {"Nama Mahasiswa", "Angkatan", "Jurusan"};

    JButton btnBack = new JButton("Back");

    public ShowMhs() {

        // Get from database
        ArrayList<Mahasiswa> listMhs = new ArrayList<>();
        listMhs = Controller.getMahasiswa();
        String[][] data = new String[listMhs.size()][3];
        // Add data to tabel

        for (int i = 0; i < listMhs.size(); i++) {
            data [i][1] = listMhs.get(i).getNama();
//            data [i][0] = listMhs.get(i).getAngkatan();
            data [i][2] = listMhs.get(i).getKodeJurusan();
        }

        tabelJurusan = new JTable(data, columnNames);

        JScrollPane sp = new JScrollPane(tabelJurusan);
        panel.add(sp);



    }

}
