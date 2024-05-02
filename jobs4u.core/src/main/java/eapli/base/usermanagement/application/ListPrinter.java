package eapli.base.usermanagement.application;

import eapli.base.Application;
import java.util.Collection;

public class ListPrinter<T> {
    private final String message;
    protected final Collection<T> collection;
    private String color;



    public ListPrinter(String message, Collection<T> collection, String color) {
        this.message = message;
        this.collection = collection;
        this.color = color;
    }
//    public ListPrinter(String color) {
//        this.color = color;
//    }

    public ListPrinter(String message, Collection<T> collection) {
        this.message = message;
        this.collection = collection;
    }



    /**
     * Show the list with numbers
     */
    public void printNumeratedList() {
        System.out.printf("%s\n\n", message);

        int index = 1;
        for (T item : collection) {
            System.out.println(getValue() + index + getValue() + " - " + item);
            index++;
        }
        System.out.println();
    }
    public String getValue() {
        if (Application.settings().isOperativeSystemLinux()) {
            return color;
        } else {
            return "";
        }
    }


    /**
     * Shows the list
     */
    public void showList() {
        System.out.printf("%s\n\n", message);

        for (T item : collection) {
            if (Application.settings().isOperativeSystemLinux())
                System.out.printf("• %s\n", item);
            else
                System.out.printf("- %s\n", item);
        }
        System.out.println();
    }


    public boolean isEmpty() {
        return collection.isEmpty();
    }
}
