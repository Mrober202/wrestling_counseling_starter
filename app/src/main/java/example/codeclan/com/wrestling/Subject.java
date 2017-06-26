package example.codeclan.com.wrestling;

import java.sql.ResultSet;

import db.SqlRunner;

/**
 * Created by michaelrobertson on 26/06/2017.
 */

public class Subject {

    private String name;
    private String description;
    private int councelor_id;
    private int id;

    public Subject(String name, String description, int councelor_id) {
        this.name = name;
        this.description = description;
        this.councelor_id = councelor_id;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCouncelor_id() {
        return councelor_id;
    }

    public void save() {
        String sql = String.format("INSERT INTO subjects (name, description, councelor_id) " +
                "VALUES ('%s', '%s', %d);", this.name, this.description, this.councelor_id);
        this.id = SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static void all() {
        String sql = "SELECT * FROM subjects;";
        ResultSet rs = SqlRunner.executeQuery(sql);
        try {
            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                int councelor_id = rs.getInt("counselor_id");

                System.out.println("Name: " + name);
                System.out.println("Description: " + description);
                System.out.println("Counselor id: " + councelor_id);
                System.out.println();
            }
        } catch (Exception ex) {
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }
    }

    public static void deleteAll() {
        String sql = "DELETE FROM subjects;";
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static void getCouselorDetails() {
        String sql = String.format
                ("SELECT councelors.first_name, counselors.nick_name, counselors.last_name, " +
                        "counselors.telephone, counselors.email, counselors.member_since " +
                        "FROM counselors JOIN subjects ON counselors.id = subjects.councelor_id " +
                        "WHERE subjects.id = %d;", this.id);
        ResultSet rs = SqlRunner.executeQuery(sql);
        try {
            while (rs.next()) {
                String first_name = rs.getString("first_name");
                String nick_name = rs.getString("nick_name");
                String last_name = rs.getString("last_name");
                String telephone = rs.getString("telephone");
                String email = rs.getString("email");
                String member_since = rs.getString("member_since");

                System.out.println("First Name: " + first_name);
                System.out.println("Nick Name: " + nick_name);
                System.out.println("Last Name: " + last_name);
                System.out.println("Telephone: " + telephone);
                System.out.println("Email Address: " + email);
                System.out.println("Member Since: " + member_since);
            }
        } catch (Exception ex){
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }
    }
}
