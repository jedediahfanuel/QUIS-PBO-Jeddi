package com.Controller;

import com.Model.Jurusan;
import com.Model.Mahasiswa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Controller {

    public Controller() {
    }

    static DatabaseHandler conn = new DatabaseHandler();

    public static ArrayList<Jurusan> getJurusan() {
        ArrayList<Jurusan> listJurusan = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM Jurusan";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Jurusan j = new Jurusan();
                j.setKode(rs.getString("kode"));
                j.setNama(rs.getString("nama"));
                listJurusan.add(j);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listJurusan;
    }

    // INSERT
    public static boolean insertJurusan(String kode, String nama) {
        conn.connect();
        String query = "INSERT INTO Jurusan VALUES(?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, kode);
            stmt.setString(2, nama);
            stmt.executeUpdate();
            return (true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return (false);
        }
    }

    public static boolean insertMahasiswa(String nama, int angkatan,String jurusan) {
        conn.connect();
        String query = "INSERT INTO Mahasiswa VALUES(?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, nama);
            stmt.setInt(2, angkatan);
            stmt.setString(1, jurusan);
            stmt.executeUpdate();
            return (true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return (false);
        }
    }

    public static ArrayList<Mahasiswa> getMahasiswa() {
        ArrayList<Mahasiswa> listMahasiswa = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM Mahasiswa";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Mahasiswa m = new Mahasiswa();
                m.setNama(rs.getString("nama"));
                m.setAngkatan(rs.getInt("angkatan"));
                m.setNama(rs.getString("kodeJurusan"));
                listMahasiswa.add(m);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listMahasiswa;
    }

//    // UPDATE
//    public static boolean updateNama(String Nama, int Umur) {
//        conn.connect();
//        String query = "UPDATE temp SET " +
//                "Nama='" + Nama + "', " +
//                "TempatLahir='" + Umur + "', " +
//                " WHERE Nama='" + Nama + "'";
//        try {
//            Statement stmt = conn.con.createStatement();
//            stmt.executeUpdate(query);
//            return (true);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            return (false);
//        }
//    }

    // DELETE
    public static boolean deleteNama(String Nama) {
        conn.connect();

        String query = "DELETE FROM temp WHERE Nama='" + Nama + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return (false);
        }
    }

}
