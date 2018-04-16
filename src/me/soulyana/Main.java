package me.soulyana;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scan = new Scanner(System.in);
        Book aBook = new Book();
        Book selectedBook = new Book();
        String toBorrow;
        String toReturn;
        ArrayList<Book> library = new ArrayList<Book>();
        int menuSelection = 1;
        boolean scrollMenu = true;

        do {
          printMenu();
            try {
                menuSelection = scan.nextInt();
            }catch (InputMismatchException e) {
                //System.err.println("InputMisMatchException: " + e.getMessage());
                System.out.println("Incorrect selection. Please enter 1 - 5 only.");
            }
            scan.nextLine();

            switch (menuSelection) {
                case 1:
                    System.out.println("These are all the books in the library");
                    for(Book eachBook : library) {
                        if(eachBook.isBorrowed() == true) {
                            System.out.println(eachBook.getTitle() + " is borrowed");
                        } else {
                            System.out.println(eachBook.getTitle() + " is available");
                        }
                    }
                    break;
                case 2:
                    aBook = new Book();
                    System.out.println("Enter a title");
                    aBook.setTitle(scan.nextLine());
                    /*System.out.println("Enter author name");
                    aBook.setAuthor(scan.nextLine());
                    System.out.println("Enter year of publication");
                    aBook.setYearPub(scan.nextInt());
                    scan.nextLine();
                    System.out.println("Enter ISBN number");
                    aBook.setISBN(scan.nextLine());*/
                    library.add(aBook);
                    break;
                case 3:
                    System.out.println("These are the available books");
                    for (Book eachAvailableBk : library) {
                        if (eachAvailableBk.isBorrowed()==false) {
                            System.out.println(eachAvailableBk.getTitle());
                        }
                    }
                        System.out.println("Enter title of book you want to borrow");
                        toBorrow = scan.nextLine();
                    for (Book eachBook: library) {
                        if (eachBook.getTitle().equalsIgnoreCase(toBorrow)) {
                            selectedBook = eachBook;
                        }
                    }
                    selectedBook.setBorrowed(true);
                    //Use Sets when using databases; Arraylist automatically updates without having to remove
                    //library.set(library.indexOf(selectedBook), selectedBook);
                    break;
                case 4:
                    System.out.println("Enter the title of the book you want to return");
                    toReturn = scan.nextLine();
                    for (Book eachBook: library) {
                        if(eachBook.getTitle().equalsIgnoreCase(toReturn)) {
                            selectedBook = eachBook;
                        }
                    }
                    selectedBook.setBorrowed(false);
                    break;
                case 5:
                    scrollMenu = false;
                    break;
                default:
                    System.out.println("Incorrect selection. Please select between 1 -5. Try again.");
                    break;
            }
        } while (scrollMenu);
    }
    private static void printMenu() {
        System.out.println("1. List all books");
        System.out.println("2. Add a book");
        System.out.println("3. Borrow a book");
        System.out.println("4. Return a book");
        System.out.println("5. Exit menu selection");
        System.out.println("Enter menu selection");
    }
}
