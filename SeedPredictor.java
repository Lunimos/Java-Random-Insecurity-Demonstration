import java.util.Random;

public class SeedPredictor {
    public static void main(String[] args) {
        int[] knownNumbers = {6,14,13}; // arry of known numbers from guessing game
        
        long seed = predictSeed(knownNumbers); // predict seed from arry
        
        if (seed != -1) {
            System.out.println("Predicted seed: " + seed); // print seed
            printFirstNumbers(seed);
        } else {
            System.out.println("Seed not found!");
        }
    }
    
    public static long predictSeed(int[] knownNumbers) {
        // loop to find seed
        for (long seed = 0; seed <= Long.MAX_VALUE; seed++) {
            Random random = new Random(seed); 
            boolean seedFound = true; 
            
            // check the numbers
            for (int i = 0; i < knownNumbers.length; i++) {
                if (random.nextInt(21) != knownNumbers[i]) { 
                    seedFound = false;
                    break;
                }
            }
            
            // if seed found, return it
            if (seedFound) {
                return seed;
            }
        }
        
        // If no matching seed is found, return -1
        return -1;
    }
    
    public static void printFirstNumbers(long seed) {
        Random random = new Random(seed);
        System.out.println("First 10 numbers generated:");
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(21));
        }
    }
}
