package EnglishArena;

import java.util.Scanner;

public class Runner {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        // Keep a single instance of EnglishArena for shared data
        System.out.println("Enter the Prep Time And Speak Time(sec) eg. 20 30 :");
        int prepTime = sc.nextInt();
        int  speakTime = sc.nextInt();
        
        System.out.println("Enter the Path of Names (Excel sheet) :");
        String namePath = sc.next();
        
        
        System.out.println("Enter the Path of Topics (Excel sheet) :");
        String topicPath = sc.next();
        
        //C:/Users/HP/Documents/names1.xlsx
//        C:/Users/HP/Documents/topics.xlsx
        System.out.println("\n");
        EnglishArena ea = new EnglishArena(prepTime, speakTime,namePath,topicPath );

        while (true) {
            System.out.print("Enter 0 to Start: ");
            int num = sc.nextInt();
            System.out.println();

            if (num == 0) {
                // Start a new thread instance using the same EnglishArena object
                startNewThread(ea);
                System.out.print("\n\n\n");
            } else {
                break;
            }
        }

        sc.close(); // Close the scanner to prevent resource leaks
    }

    // Encapsulate logic to restart the thread
    public static void startNewThread(EnglishArena ea) {
        // Create a new thread around the same EnglishArena instance
        Thread thread = new Thread(() -> ea.run());
        thread.start();

        try {
            thread.join();  // Main thread waits for the new thread to complete
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
