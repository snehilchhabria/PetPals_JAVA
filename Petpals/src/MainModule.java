

import entity.*;
import dao.ShelterDAO;
import exception.InvalidPetAgeException;
import exception.InsufficientFundsException;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class MainModule {
    public static void main(String[] args) {
        PetShelter shelter = new PetShelter();

        Scanner scanner = new Scanner(System.in);
        ShelterDAO shelterDAO = new ShelterDAO();

        try {
            // Menu-driven application
            System.out.println("1. Add Pet");
            System.out.println("2. List Available Pets");
            System.out.println("3. Record Donation");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Pet Name:");
                    String name = scanner.next();
                    System.out.println("Enter Pet Age:");
                    int age = scanner.nextInt();
                    System.out.println("Enter Pet Breed:");
                    String breed = scanner.next();
                    Pet pet = new Pet(name, age, breed);
                    shelter.addPet(pet);
                    shelterDAO.addPet(pet);
                    break;

                case 2:
                    shelterDAO.getAvailablePets().forEach(System.out::println);
                    break;

                case 3:
                    System.out.println("Enter Donor Name:");
                    String donorName = scanner.next();
                    System.out.println("Enter Donation Amount:");
                    double amount = scanner.nextDouble();
                    if (amount < 10) {
                        throw new InsufficientFundsException("Minimum donation amount is $10.");
                    }
                    System.out.println("Enter Donation Type (cash/item):");
                    String donationType = scanner.next();

                    if ("cash".equalsIgnoreCase(donationType)) {
                        CashDonation cashDonation = new CashDonation(donorName, amount, LocalDate.now());
                        cashDonation.recordDonation();
                    } else if ("item".equalsIgnoreCase(donationType)) {
                        System.out.println("Enter Item Type:");
                        String itemType = scanner.next();
                        ItemDonation itemDonation = new ItemDonation(donorName, amount, itemType);
                        itemDonation.recordDonation();
                    } else {
                        System.out.println("Invalid donation type.");
                    }
                    break;

                default:
                    System.out.println("Invalid option");
                    break;
            }
        } catch (SQLException | InvalidPetAgeException | InsufficientFundsException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
