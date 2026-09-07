/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package studentprofile;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class StudentProfile {

    private int id;
    private String name;
    private String domain;
    private String address;

    public StudentProfile() {
    }

    public StudentProfile(int id, String name, String domain, String address) {
        this.id = id;
        this.name = name;
        this.domain = domain;
        this.address = address;
    }

    public StudentProfile(String name, String domain, String address) {
        this.name = name;
        this.domain = domain;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "Student ID ->  " + id + "\n"
                + "Student Name ->  " + name + "\n"
                + "Student Domain ->  " + domain + "\n"
                + "Student Address ->  " + address + "\n";
    }

    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("The Student Profile Portal");

        while (true) {
            System.out.println(
                    """       
            Press 1 for Adding Profile 
                               
            Press 2 for Displaying Profile 
                               
            Press 3 for Displaying Profile with ID
                               
            Press 4 for Deleting Profile 
                    
            Press 5 for Updating Profile
                    
            Press 6 for Exiting the portal
            """);

            int i = scan.nextInt();
            AddAction aa = new AddAction();

            switch (i) {
                case 1 -> {
                    System.out.println("Please provide input : ");
                    System.out.println("Add Profile");
                    System.out.println("Enter Name: ");
                    String name = scan.next();
                    System.out.println("Enter Domain: ");
                    String domain = scan.next();
                    scan.nextLine();
                    System.out.println("Enter Address: ");
                    String address = scan.nextLine();

                    StudentProfile sp = new StudentProfile(name, domain, address);
                    boolean valid = aa.add(sp);
                    if (valid) {
                        System.out.println("** Profile Added **");
                    } else {
                        System.out.println("** Something happened. Check again. **");
                    }
                }
                case 2 -> {
                    System.out.println("Display all profiles ");
                    aa.display();
                }
                case 3 -> {
                    System.out.println("Display by ID");
                    int inp = scan.nextInt();
                    boolean validId = aa.displayById(inp);
                    if (!validId) {
                        System.out.println("** Profile with is ID not available **");
                    }
                }
                case 4 -> {
                    System.out.println("Delete Profile");
                    System.out.println("Enter ID to delete ->  ");
                    int del = scan.nextInt();

                    boolean validId = aa.delete(del);
                    if (validId) {
                        System.out.println("** Deleted Successfully **");
                    } else {
                        System.out.println("** Some problem occurred. Check again. **");
                    }
                }
                case 5 -> {
                    System.out.println("Update");

                    System.out.println("""
                                       Press 1 to update domain 
                                       Press 2 to update address
                                       """);
                    int se = scan.nextInt();

                    if (se == 1) {
                        System.out.println("Enter ID ");
                        int idd = scan.nextInt();
                        System.out.println("Enter new domain ");
                        String ddomain = scan.next();
                        StudentProfile spp = new StudentProfile();
                        spp.setDomain(ddomain);
                        boolean up = aa.update(idd, ddomain, se, spp);
                        if (up) {
                            System.out.println("** Domain updated successfully **");
                        } else {
                            System.out.println("Something problem occurred.");
                        }

                    } else if (se == 2) {
                        System.out.println("Enter ID ");
                        int idd = scan.nextInt();
                        System.out.println("Enter new address ");
                        String addr = scan.next();
                        StudentProfile spp = new StudentProfile();
                        spp.setDomain(addr);
                        boolean up = aa.update(idd, addr, se, spp);
                        if (up) {
                            System.out.println("** Address updated successfully **");
                        } else {
                            System.out.println("Something problem occurred.");
                        }
                    }else{
                        System.out.println("** Invalid Choice **");
                    }
                }
                case 6 -> {
                    System.out.println("Exit");
                    System.exit(0);
                }
                default ->
                    System.out.println("Invalid ");
            }

        }
    }
}
