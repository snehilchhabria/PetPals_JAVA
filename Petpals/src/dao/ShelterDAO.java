package dao;
import entity.Pet;
import util.DBConnUtil;
import exception.InvalidPetAgeException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException; // Import IOException

public class ShelterDAO {

    public List<Pet> getAvailablePets() throws SQLException {
        List<Pet> pets = new ArrayList<>();
        
        Connection conn = null;
        try {
            // Try to establish a connection and catch IOException if it occurs
            conn = DBConnUtil.getConnection();
        } catch (IOException e) {
            System.err.println("Error: Could not load database connection string. " + e.getMessage());
            return pets; // Return an empty list if there's an error
        }

        String query = "SELECT * FROM pets";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            try {
                Pet pet = new Pet(rs.getString("name"), rs.getInt("age"), rs.getString("breed"));
                pets.add(pet);
            } catch (InvalidPetAgeException e) {
                System.err.println("Error: Invalid pet age found in database. " + e.getMessage());
            }
        }

        conn.close();
        return pets;
    }

    public void addPet(Pet pet) throws SQLException {
        Connection conn = null;
        try {
            conn = DBConnUtil.getConnection();
        } catch (IOException e) {
            System.err.println("Error: Could not load database connection string. " + e.getMessage());
            return; // Exit method if connection couldn't be established
        }

        String query = "INSERT INTO pets (name, age, breed) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, pet.getName());
        pstmt.setInt(2, pet.getAge());
        pstmt.setString(3, pet.getBreed());
        pstmt.executeUpdate();
        conn.close();
    }
}
