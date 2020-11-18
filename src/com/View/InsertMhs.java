package com.View;

import com.Controller.Controller;
import com.Model.Jurusan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InsertMhs implements ActionListener {

    JFrame frame =  new JFrame("Insert Mahasiswa");
    JPanel panel = new JPanel(new GridLayout(8,1,5,5));

    JLabel lblTitle = new JLabel("Insert Insert Mahasiswa");

    JLabel lblNama = new JLabel("Nama : ");
    JTextField namaMhs = new JTextField();

    JLabel lblAngakatan = new JLabel("Angkatan : ");
    JTextField angkatanMhs = new JTextField();

    JLabel lblJurusan = new JLabel("Jurusan : ");
    JComboBox pilihJurusan;

    JButton btnSubmit = new JButton("Submit");
    JButton btnBack = new JButton("Back");

    public InsertMhs() {

        ArrayList<Jurusan> listJurusan = new ArrayList<>();
        listJurusan = Controller.getJurusan();
        String[] jurusan = new String[listJurusan.size()];

        for (int i = 0; i < listJurusan.size(); i++) {
            jurusan[i] = listJurusan.get(i).getKode();
        }
        JComboBox pilihJurusan = new JComboBox(jurusan);

        btnSubmit.setActionCommand("Submit");
        btnSubmit.addActionListener(this);

        btnBack.setActionCommand("Back");
        btnBack.addActionListener(this);

        panel.add(lblTitle);
        panel.add(lblNama);
        panel.add(namaMhs);
        panel.add(lblAngakatan);
        panel.add(angkatanMhs);
        panel.add(lblJurusan);
        panel.add(pilihJurusan);
        panel.add(btnSubmit);
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
            case "Submit":
                String stringJurusan = String.valueOf(pilihJurusan.getSelectedItem());
                Controller.insertMahasiswa(namaMhs.getText(), Integer.parseInt(angkatanMhs.getText()), stringJurusan);
                new MainMenu();
                frame.dispose();
                break;
            case "Back":
                new MainMenu();
                frame.dispose();
            default:
//                throw new IllegalStateException("Unexpected value: " + command);
        }
    }
}
