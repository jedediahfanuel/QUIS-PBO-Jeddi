package com.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Controller {

    static DatabaseHandler conn = new DatabaseHandler();

    // SELECT ALL from table dataKTP
//    public static ArrayList<KTP> getAllKTP() {
//        ArrayList<KTP> listKTP = new ArrayList<>();
//        conn.connect();
//        String query = "SELECT * FROM dataKTP";
//        try {
//            Statement stmt = conn.con.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                KTP ktp = new KTP();
//                ktp.setNIK(rs.getString("NIK"));
//                ktp.setNama(rs.getString("Nama"));
//                listKTP.add(ktp);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return (listKTP);
//    }

    public static ArrayList<String> getNama() {
        ArrayList<String> listNama = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM temp";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                listNama.add(rs.getString("Nama"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listNama;
    }

}
