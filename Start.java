import UserInterface.UserInterface;
import Declaration.*;
import FileHandling.MoviesReader;
import Implementation.*;
import Implementation.Registration;
import java.util.Scanner;
import Booking.BookingSystem;

public class Start {
    public static int userIndex = 0;
    public static int adminIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Movie List Creation
        BookingSystem.movieArrayList.add(" The Shawshank Redemption");
        BookingSystem.movieArrayList.add(" The Godfather ");
        BookingSystem.movieArrayList.add(" The Godfather: Part II");
        BookingSystem.movieArrayList.add(" The Dark Knight");
        BookingSystem.movieArrayList.add(" 12 Angry Men");
        BookingSystem.movieArrayList.add(" Schindler's List");

        // Main Objects
        Admin adminObject[] = new Admin[10]; // Storage
        Admin functionCall = new Admin(); // Call functions
        User usersObject[] = new User[100]; // Storage

        // Default Admin
        Admin[] DefaultAdmin = new Admin[1];
        DefaultAdmin[0] = new Admin();
        DefaultAdmin[0].setUsername("admin");
        DefaultAdmin[0].setPassword("admin");
        functionCall.AddAdmins(DefaultAdmin[0]);

        usersObject[0] = new User();
        usersObject[0].setFullName("Muzahidul Islam");
        usersObject[0].setUsername("mu");
        usersObject[0].setMailAddress("Mu@gmail.com");
        usersObject[0].setMobile("01777777777");
        usersObject[0].setPassword("123");
        usersObject[0].setMovie("The Dark Knight");
        usersObject[0].setTiming("2| Afternoon: 3:00 PM");
        usersObject[0].setPrice("$20");

        usersObject[1] = new User();
        usersObject[1].setFullName("Samio Saif");
        usersObject[1].setUsername("saif");
        usersObject[1].setMailAddress("saif@gmail.com");
        usersObject[1].setMobile("01666666666");
        usersObject[1].setPassword("123");
        usersObject[1].setMovie("The Godfather");
        usersObject[1].setTiming("1| Morning: 9:00 AM");
        usersObject[1].setPrice("$10");

        usersObject[2] = new User();
        usersObject[2].setFullName("Zamiul Sadik Nahin");
        usersObject[2].setUsername("sadik");
        usersObject[2].setMailAddress("sadik@gmail.com");
        usersObject[2].setMobile("01555555555");
        usersObject[2].setPassword("123");
        usersObject[2].setMovie("Schindler's List");
        usersObject[2].setTiming("3| Evening: 6:00 PM");
        usersObject[2].setPrice("$5");


        // Adding PreDefined Information
        functionCall.AddUser(usersObject[0]);
        functionCall.AddUser(usersObject[1]);
        functionCall.AddUser(usersObject[2]);

        /////////////////////////////////////////////////////////////

        for (;;) {
            UserInterface.cls();
            UserInterface.Greetings();
            UserInterface.MainMenu(); // Main Menu Opened [Functional]
            String option = scanner.nextLine();
            if (option.equals("0")) // Select "0" To Exit The Application [Functional]
                break;

            if (option.equals("1")) { // Show Movie Ticket
                UserInterface.cls();
                MoviesReader obj4 = new MoviesReader();
                obj4.readFromFile();
                // Write Code From Here

            } else if (option.equals("2")) { // Select "1" To Login/Registration [Functional]
                UserInterface.cls();
                for (;;) {
                    UserInterface.cls();
                    UserInterface.LoginOrRegistrationMenu();// Login/Registration Opened [Functional]
                    option = scanner.nextLine();
                    if (option.equals("3")) { // Select "3" To Go back [Functional]
                        UserInterface.cls();
                        break;
                    }
                    if (option.equals("1")) { // Select "1" To Open Login Menu
                        for (;;) {
                            UserInterface.cls();
                            UserInterface.loginMenu(); // Login Menu Opened [Functional]
                            option = scanner.nextLine();
                            if (option.equals("3")) { // Go Back
                                UserInterface.cls();
                                break;
                            }
                            if (option.equals("2")) { // Select "2" To Access Employee Registration
                                if (Login.AdminLogin(functionCall)) { // Status: [Operational]
                                    Login.AdminInterface(functionCall); // Status: [Semi - Operational]
                                }
                            }
                            if (option.equals("1")) { // Select "1" To Access Customer Registration
                                if (Login.UserLogin(functionCall)) { // Status: [Operational]
                                    Login.UserInterface(functionCall); // Status: [Semi - Operational]
                                    // [Not Functional]

                                }
                            }
                        }
                    }
                    // Registration Starts
                    if (option.equals("2")) { // Open Registration Menu
                        for (;;) {
                            UserInterface.cls();
                            UserInterface.registrationMenu(); // Registration Menu Opened
                            option = scanner.nextLine();
                            if (option.equals("3")) {
                                break;
                            }
                            if (option.equals("2")) { // Access Employee Registration
                                adminObject[adminIndex] = new Admin();
                                Registration.AdminRegistration(adminObject[adminIndex], functionCall);
                                adminIndex++;
                            }
                            if (option.equals("1")) { // Access Registration
                                usersObject[userIndex] = new User();
                                Registration.UserRegistration(usersObject[userIndex], functionCall);
                                adminIndex++;
                            }

                        }
                    }
                    // Registration Ends
                }
            } else if (option.equals("3")) { // Book Movie Seat

                boolean trueOrFalse = BookingSystem.TicketBook(usersObject, functionCall);
                BookingSystem.movieArrayList.get(BookingSystem.movieIndex);
                System.out.println();
                if (trueOrFalse)
                    UserInterface.pause();

            } else if (option.equals("4")) { // About Us

                UserInterface.cls();
                UserInterface.AboutUs();
                UserInterface.pause();
            }

        }

    }
}
