package Week3;

import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        // Create a new HashSet
        Set<String> planeSet = new HashSet<>();

        // Add elements to the set
        planeSet.add("Cessna");
        planeSet.add("Beechcraft");
        planeSet.add("Piper");

        System.out.println("\nOriginal Set: " + planeSet);

        // Add a new element
        boolean isAdded = planeSet.add("Cirrus");
        System.out.println("\nIs 'Cirrus' added? " + isAdded);

        // Add a duplicate element
        isAdded = planeSet.add("Cessna");
        System.out.println("\nIs 'Cessna' added? " + isAdded);

        // Print the updated set
        // New element will be added, duplicate will not
        System.out.println("\nUpdated Set: " + planeSet + "\n");
    }
}