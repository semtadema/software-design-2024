package classes;

public class App {

    public final static void clearConsole() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } catch (final Exception e) {
            // Handle any exceptions.
        }
    }

    public static void loading() {
        // Total duration of the loading bar in milliseconds
        long duration = 1500;
        // Update interval for the loading bar in milliseconds
        long updateInterval = 100;
        // Number of updates during the duration
        int totalUpdates = (int) (duration / updateInterval);

        System.out.print("Loading: ");

        for (int i = 0; i <= totalUpdates; i++) {
            int progress = (int) ((double) i / totalUpdates * 100);

            // Print the progress bar
            System.out.print("[");

            for (int j = 0; j < 20; j++) {
                if (j <= progress / 5) {
                    System.out.print("=");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.print("] " + progress + "%");

            // Move the cursor back to overwrite the progress bar
            System.out.print("\r");

            try {
                Thread.sleep(updateInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getDefaultFilePath() {
        return "app/src/storage/main.json";
    }

    public static void main(String[] args) {
        try { 
            // try catch is only necessary because we are throwing an exception, if we
            // overload the constructor with default values, we can remove the try catch

            String filePath = getDefaultFilePath();

            // Check if any command-line arguments are provided
            if (args.length > 0) {
                // Iterate through the arguments and print them
                for (String arg : args) {
                    if (arg.startsWith("--file=")) {
                        // Extract the file path from the argument
                        filePath = arg.substring("--file=".length());
                        break; // Stop searching once the file argument is found
                    }
                }
            }

            new Game(filePath).play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
