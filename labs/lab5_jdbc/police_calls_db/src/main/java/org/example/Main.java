package org.example;

import dao.*;
import entity.*;

import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Starting the system...\n");

        AddressDAO addressDAO = new AddressDAO();
        OfficerDAO officerDAO = new OfficerDAO();
        CrewDAO crewDAO = new CrewDAO();
        CrewMemberDAO crewMemberDAO = new CrewMemberDAO();
        CallDAO callDAO = new CallDAO();
        ReportDAO reportDAO = new ReportDAO();
        UserDAO userDAO = new UserDAO();

        try {


            System.out.println("Total addresses: " + addressDAO.getAllAddresses().size());
            System.out.println("Total officers: " + officerDAO.getAllOfficers().size());
            System.out.println("Total crews: " + crewDAO.getAllCrews().size());
            System.out.println("Total crew members: " + crewMemberDAO.getAllCrewMembers().size());
            System.out.println("Total calls: " + callDAO.getAllCalls().size());
            System.out.println("Total reports: " + reportDAO.getAllReports().size());

            System.out.println("-----------------------------------\n");


            System.out.println("Searching officers with 'Майкл':");
            List<Officer> officers = officerDAO.searchByName("Майкл");
            for (Officer o : officers) {
                System.out.println(o.getFullName());
            }

            System.out.println("\nSearching addresses with 'Test':");
            List<Address> addresses = addressDAO.searchByStreet("Test");
            for (Address a : addresses) {
                System.out.println(a.getStreet());
            }

            System.out.println("-----------------------------------\n");


            boolean login = userDAO.login("admin", "12345");
            System.out.println("Login test: " + (login ? "SUCCESS" : "FAILED"));

            System.out.println("-----------------------------------\n");


            System.out.println("CRUD TEST (Calls)");


            Call newCall = new Call(
                    0,
                    "Test Caller",
                    LocalDateTime.now(),
                    1,
                    "Test description"
            );
            callDAO.addCall(newCall);
            System.out.println("Call added");


            List<Call> calls = callDAO.getAllCalls();
            Call found = null;

            for (Call c : calls) {
                if (c.getCallerName().equals("Test Caller")) {
                    found = c;
                    System.out.println("Call found, ID: " + c.getCallId());
                    break;
                }
            }


            if (found != null) {
                found.setDescription("Updated description");
                callDAO.updateCall(found);
                System.out.println("Call updated");


                callDAO.deleteCall(found.getCallId());
                System.out.println("Call deleted");
            }

            System.out.println("-----------------------------------\n");


            System.out.println("Metadata (officers table):");

            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM officers");
            ResultSet rs = ps.executeQuery();

            ResultSetMetaData meta = rs.getMetaData();
            int columnCount = meta.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                System.out.println(
                        meta.getColumnName(i) + " - " +
                                meta.getColumnTypeName(i)
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}