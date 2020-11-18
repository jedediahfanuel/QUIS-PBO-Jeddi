package com.View;

import com.Controller.Controller;
import com.Model.Jurusan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShowJrs  implements ActionListener {

    JFrame frame =  new JFrame("Show Jurusan");
    JPanel panel = new JPanel(new GridLayout());

    JTable tabelJurusan;
    String[] columnNames = {"Kode Jurusan", "Nama Jurusan"};

    JButton btnBack = new JButton("Back");

    public ShowJrs() {

        // Get from database
        ArrayList<Jurusan> listJurusan = new ArrayList<>();
        listJurusan = Controller.getJurusan();
        String[][] data = new String[listJurusan.size()][2];
        // Add data to tabel

        for (int i = 0; i < listJurusan.size(); i++) {
            data [i][0] = listJurusan.get(i).getKode();
            data [i][1] = listJurusan.get(i).getNama();
        }

        tabelJurusan = new JTable(data, columnNames);

        JScrollPane sp = new JScrollPane(tabelJurusan);
        panel.add(sp);

        btnBack.setActionCommand("Back");
        btnBack.addActionListener(this);

        panel.add(btnBack);

        frame.setSize(1280,720);
        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Back":
                new MainMenu();
                frame.dispose();
            default:
//                throw new IllegalStateException("Unexpected value: " + command);
        }
    }
}
