package com.View;

import com.Controller.Controller;
import com.Model.Jurusan;
import com.Model.Mahasiswa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShowMhs implements ActionListener {

    JFrame frame =  new JFrame("Show Mahasiswa");
    JPanel panel = new JPanel(new GridLayout());

    JTable tabelJurusan;
    String[] columnNames = {"Nama Mahasiswa", "Angkatan", "Jurusan"};

//    JLabel lblJurusan = new JLabel("Jurusan : ");
//    static JComboBox pilihJurusan;

    JButton btnSubmit = new JButton("Submit");
    JButton btnBack = new JButton("Back");

//    public ShowMhs(String stringJurusan) {
//
//        btnBack.setActionCommand("Back");
//        btnBack.addActionListener(this);
//
//        ArrayList<Jurusan> listJurusan = new ArrayList<>();
//        listJurusan = Controller.getJurusan();
//        String[] jurusan = new String[listJurusan.size()];
//
//        for (int i = 0; i < listJurusan.size(); i++) {
//            jurusan[i] = listJurusan.get(i).getKode();
//        }
//        JComboBox pilihJurusan = new JComboBox(jurusan);
//
//        panel.add(lblJurusan);
//        panel.add(pilihJurusan);
//        panel.add(btnSubmit);
//        panel.add(btnBack);
//
//        frame.setSize(1280,720);
//        frame.add(panel);
//        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        frame.setVisible(true);
//    }

    public ShowMhs() {

        // Get from database
        ArrayList<Mahasiswa> listMhs = new ArrayList<>();
        listMhs = Controller.getMahasiswa();
        String[][] data = new String[listMhs.size()][3];

        // Add data to tabel
        for (int i = 0; i < listMhs.size(); i++) {
            data [i][0] = listMhs.get(i).getNama();
            data [i][1] = String.valueOf(listMhs.get(i).getAngkatan());
            data [i][2] = listMhs.get(i).getKodeJurusan();
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
//            case "Submit":
//                String stringJurusan = String.valueOf(pilihJurusan.getSelectedItem());
//                new ShowMhs(stringJurusan);
//                frame.dispose();
            case "Back":
                new MainMenu();
                frame.dispose();
            default:
//                throw new IllegalStateException("Unexpected value: " + command);
        }
    }
}
