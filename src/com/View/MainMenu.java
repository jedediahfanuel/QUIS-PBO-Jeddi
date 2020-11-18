package com.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu implements ActionListener {

    JFrame frame =  new JFrame();
    JPanel panel = new JPanel(new GridLayout(4,1,5,5));

    JButton btnInsertJrs = new JButton("Insert Data Jurusan Baru");
    JButton btnShowJrs = new JButton("Show Semua Jurusan");
    JButton btnInsertMhs = new JButton("Insert Data Mahasiswa Baru");
    JButton btnShowMhs = new JButton("Show Mahasiswa per Jurusan");

    public MainMenu() {

        btnInsertJrs.setActionCommand("InsertJrs");
        btnInsertJrs.addActionListener(this);

        btnShowJrs.setActionCommand("ShowJrs");
        btnShowJrs.addActionListener(this);

        btnInsertMhs.setActionCommand("InsertMhs");
        btnInsertMhs.addActionListener(this);

        btnShowMhs.setActionCommand("ShowMhs");
        btnShowMhs.addActionListener(this);

        panel.add(btnInsertJrs);
        panel.add(btnShowJrs);
        panel.add(btnInsertMhs);
        panel.add(btnShowMhs);

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
            case "InsertJrs":
                new InsertJrs();
                frame.dispose();
                break;
            case "ShowJrs":
                new ShowJrs();
                frame.dispose();
                break;
            case "InsertMhs":
                new InsertMhs();
                frame.dispose();
                break;
            case "ShowMhs":
                new ShowMhs();
                frame.dispose();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }
}
