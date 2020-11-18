package com.View;

import com.Controller.Controller;
import com.Model.Jurusan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JurusanView implements ActionListener {
    JFrame frame =  new JFrame("Show Mahasiswa");
    JPanel panel = new JPanel(new GridLayout(5, 1, 5, 5));

    JTable tabelJurusan;
    String[] columnNames = {"Nama Mahasiswa", "Angkatan", "Jurusan"};

    JLabel lblJurusan = new JLabel("Jurusan : ");
    static JComboBox pilihJurusan;

    JButton btnSubmit = new JButton("Submit");
    JButton btnBack = new JButton("Back");

    public JurusanView() {
        btnBack.setActionCommand("Back");
        btnBack.addActionListener(this);

        ArrayList<Jurusan> listJurusan = new ArrayList<>();
        listJurusan = Controller.getJurusan();
        String[] jurusan = new String[listJurusan.size()];

        for (int i = 0; i < listJurusan.size(); i++) {
            jurusan[i] = listJurusan.get(i).getKode();
        }
        JComboBox pilihJurusan = new JComboBox(jurusan);

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
//                new ShowMhs(stringJurusan);
                frame.dispose();
            case "Back":
                new MainMenu();
                frame.dispose();
            default:
//                throw new IllegalStateException("Unexpected value: " + command);
        }
    }
}
