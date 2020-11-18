package com.View;

import com.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertJrs implements ActionListener {

    JFrame frame =  new JFrame("Insert Jurusan");
    JPanel panel = new JPanel(new GridLayout(7,1,5,5));

    JLabel lblTitle = new JLabel("Insert Jurusan");

    JLabel lblKode = new JLabel("Kode : ");
    JTextField kodeJurusan = new JTextField();

    JLabel lblNama = new JLabel("Nama : ");
    JTextField namaJurusan = new JTextField();

    JButton btnSubmit = new JButton("Submit");
    JButton btnBack = new JButton("Back");

    public InsertJrs() {

        btnSubmit.setActionCommand("Submit");
        btnSubmit.addActionListener(this);

        btnBack.setActionCommand("Back");
        btnBack.addActionListener(this);

        panel.add(lblTitle);
        panel.add(lblKode);
        panel.add(kodeJurusan);
        panel.add(lblNama);
        panel.add(namaJurusan);
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
                Controller.insertJurusan(kodeJurusan.getText(), namaJurusan.getText());
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
