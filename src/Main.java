import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static String[] hotelGuests;
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);

        System.out.println("Welcome to Capsule-Capsule!");
        printDivider(20);

        System.out.print("Enter the number of capsules: ");
        int capNum = Integer.parseInt(user.nextLine());

        hotelGuests = new String[capNum];
        Arrays.fill(hotelGuests, "[unoccupied]");
        System.out.println("There are " + capNum + " unoccupied capsules ready to be booked.");

        while (true) {
            printGuestMenu();
            getUserResponseGuestMenu();
        }
    }
    public static void printDivider(int dividerNumber) {
        for (int i = 0; i < dividerNumber; i++) {
            System.out.print("=");
        }
        System.out.println();
    }
    public static void printGuestMenu() {
        System.out.println("Guest Menu");
        printDivider(10);
        System.out.println("1. Check in");
        System.out.println("2. Check out");
        System.out.println("3. View Guests");
        System.out.println("4. Exit");
    }
    public static String getGuestName() {
        Scanner user = new Scanner(System.in);
        System.out.print("Guest Name: ");
        return user.nextLine();
    }
    public static int getCapsuleNumber() {
        Scanner user = new Scanner(System.in);
        System.out.print("Capsule #[1-" + hotelGuests.length + "]: ");
        return Integer.parseInt(user.nextLine());
    }
    public static void getUserResponseGuestMenu() {
        System.out.print("Chose [1-4]: ");
        Scanner user = new Scanner(System.in);

        switch (Integer.parseInt(user.nextLine())) {
            case 1:
                checkIn();
                break;
            case 2:
                checkOut();
                break;
            case 3:
                viewGuests(getCapsuleNumber());
                break;
            case 4:
                systemExit();
            default:
                System.out.println("Please enter a number 1-4.");
                printGuestMenu();
        }
    }
    public static void checkIn() {
        int cap = getCapsuleNumber();
        String guest = getGuestName();
        if (!hotelGuests[cap].equals("[unoccupied]")) {
            System.out.println("ERROR: Capsule #" + cap + " is already occupied!");
        } else {
            hotelGuests[cap] = guest;
        }
    }
    public static void checkOut() {
        int cap = getCapsuleNumber();
        if (hotelGuests[cap].equals("[unoccupied]")) {
            hotelGuests[cap] = "[unoccupied]";
            System.out.println("Capsule #" + cap + " is now [unoccupied].");
        } else {
            System.out.println("ERROR: Capsule #" + cap + " is already [unoccupied]!");
        }
    }
    public static void viewGuests(int index) {
        if (index < 11) {
            for (int i = 0; i < 11; i++) {
                System.out.println(i+1 + ": " + hotelGuests[i]);
            }
        } else if (index > hotelGuests.length-11) {
            int j = -11, counter = hotelGuests.length+j;
            for (int i = hotelGuests.length-1; i > hotelGuests.length-12; i--) {
                System.out.println(hotelGuests.length+j+1 + ": " + hotelGuests[counter]);
                counter++; j++;
            }
        } else {
            for (int i = index-5; i < index+11; i++) {
                System.out.println(i+1 + ": " + hotelGuests[i]);
            }
        }
    }
    public static void systemExit() {
        System.out.println("Goodbye!");
        System.exit(0);
    }

}