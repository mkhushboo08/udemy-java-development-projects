/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentprofile;

import connectivity.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Dell
 */
public class AddAction {

    public boolean add(StudentProfile sp) {
        boolean check = false;

        try {
            Connection con = DB.getCon();
            String query = "INSERT INTO profile(name, domain, address) VALUE(?,?,?)";

            PreparedStatement p = con.prepareStatement(query);
            p.setString(1, sp.getName());
            p.setString(2, sp.getDomain());
            p.setString(3, sp.getAddress());
            p.executeUpdate();
            check = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return check;
    }

    public void display() {
        try {
            Connection con = DB.getCon();
            String query = "select * from profile";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);

            while (rs.next()) {

                System.out.println(
                        "ID      -> " + rs.getInt(1) + "\n"
                        + "Name    -> " + rs.getString(2) + "\n"
                        + "Domain  -> " + rs.getString(3) + "\n"
                        + "Address -> " + rs.getString(4)
                );
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public boolean displayById(int id) {
        boolean check = false;
        try {
            Connection con = DB.getCon();
            String query = "select * from profile where id =" + id;
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);

            while (rs.next()) {
                System.out.println(
                        "ID      -> " + rs.getInt(1) + "\n"
                        + "Name    -> " + rs.getString(2) + "\n"
                        + "Domain  -> " + rs.getString(3) + "\n"
                        + "Address -> " + rs.getString(4)
                );
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
            check = true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return check;
    }

    public boolean delete(int del) {
        boolean check = false;
        try {
            Connection con = DB.getCon();
            String query = "delete from profile where id =" + del;
            PreparedStatement p = con.prepareStatement(query);
            p.executeUpdate();
            check = true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return check;
    }

    public boolean update(int idd, String newData, int se, StudentProfile spp) {
        boolean check = false;
        try {
            if (se == 1) {
                Connection con = DB.getCon();
                String query = "update profile set domain=?  where id=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, newData);
                ps.setInt(2, idd);
                ps.executeUpdate();

                check = true;
            } else if (se == 2) {
                Connection con = DB.getCon();
                String query = "update profile set address=?  where id=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, newData);
                ps.setInt(2, idd);
                ps.executeUpdate();

                check = true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return check;
    }

}
