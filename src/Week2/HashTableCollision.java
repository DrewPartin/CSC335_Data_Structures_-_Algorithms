package Week2;
import java.util.Random;

public class HashTableCollision {

    public static void main(String[] args) {
        int tableSize = 31;
        int[] linearTable = new int[tableSize];
        int[] quadraticTable = new int[tableSize];

        int[] randomIntegers = generateRandomIntegers(20, 0, 100);

        System.out.println("List of Integers to Insert: ");
        for (int num : randomIntegers) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        int linearCollisions = insertWithLinearProbing(randomIntegers, linearTable);
        int quadraticCollisions = insertWithQuadraticProbing(randomIntegers, quadraticTable);

        System.out.println("\nHash Table with Linear Probing:");
        displayHashTable(linearTable);

        System.out.println("\nHash Table with Quadratic Probing:");
        displayHashTable(quadraticTable);

        System.out.println("\nNumber of Collisions with Linear Probing: " + linearCollisions);
        System.out.println("\nNumber of Collisions with Quadratic Probing: " + quadraticCollisions + "\n");

        int[] separateChainingTable = new int[10];
        int[] linearProbingTable = new int[10];
        int[] quadraticProbingTable = new int[10];
        int[] doubleHashingTable = new int[10];

        int[] numbers = {4371, 1323, 6173, 4199, 4344, 9679, 1989};

        System.out.println("List of Integers to Insert: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        int separateChainingCollisions = insertWithSeparateChaining(numbers, separateChainingTable);
        int linearProbingCollisions = insertWithLinearProbing(numbers, linearProbingTable);
        int quadraticProbingCollisions = insertWithQuadraticProbing(numbers, quadraticProbingTable);
        int doubleHashingCollisions = insertWithDoubleHashing(numbers, doubleHashingTable);

        System.out.println("\nHash Table with Separate Chaining:");
        displayHashTable(separateChainingTable);

        System.out.println("\nHash Table with Linear Probing:");
        displayHashTable(linearProbingTable);

        System.out.println("\nHash Table with Quadratic Probing:");
        displayHashTable(quadraticProbingTable);

        System.out.println("\nHash Table with Double Hashing:");
        displayHashTable(doubleHashingTable);

        System.out.println("\nNumber of Collisions with Separate Chaining: " + separateChainingCollisions);
        System.out.println("\nNumber of Collisions with Linear Probing: " + linearProbingCollisions);
        System.out.println("\nNumber of Collisions with Quadratic Probing: " + quadraticProbingCollisions);
        System.out.println("\nNumber of Collisions with Double Hashing: " + doubleHashingCollisions + "\n");
    }

    private static int insertWithSeparateChaining(int[] values, int[] table) {
        int collisions = 0;
        for (int value : values) {
            int index = value % table.length;
            if (table[index] != 0) {
                collisions++;
            }
            table[index] = value;
        }
        return collisions;
    }

    private static int insertWithDoubleHashing(int[] values, int[] table) {
        int collisions = 0;
        for (int value : values) {
            int index = value % table.length;
            int step = 7 - (value % 7);
            while (table[index] != 0) {
                collisions++;
                index = (index + step) % table.length; // Double hashing
            }
            table[index] = value;
        }
        return collisions;
    }

    private static int[] generateRandomIntegers(int count, int min, int max) {
        Random random = new Random();
        int[] randomIntegers = new int[count];
        for (int i = 0; i < count; i++) {
            randomIntegers[i] = random.nextInt(max - min + 1) + min;
        }
        return randomIntegers;
    }

    private static int insertWithLinearProbing(int[] values, int[] table) {
        int collisions = 0;
        for (int value : values) {
            int index = value % table.length;
            while (table[index] != 0) {
                collisions++;
                index = (index + 1) % table.length; // Linear probing
            }
            table[index] = value;
        }
        return collisions;
    }

    private static int insertWithQuadraticProbing(int[] values, int[] table) {
        int collisions = 0;
        for (int value : values) {
            int index = value % table.length;
            int step = 1;
            while (table[index] != 0) {
                collisions++;
                index = (index + step * step) % table.length; // Quadratic probing
                step++;
            }
            table[index] = value;
        }
        return collisions;
    }

    private static void displayHashTable(int[] table) {
        for (int i = 0; i < table.length; i++) {
            System.out.print(table[i] + " ");
        }
        System.out.println();
    }
}
