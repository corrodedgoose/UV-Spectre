import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        int totalSteps = 100;

        // Print the static Header or Logo one time
//        printUV();
        printHeader();

        for (int i = 0; i <= totalSteps; i++) {
            printProgressBar(i, totalSteps);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
//        System.out.println("\nTask completed!");
//        System.out.flush();
        System.out.println(" ");
        printTail();
    }

    public static void printProgressBar(int current, int total) {
        int barLength = 50;
        double percentage = (double) current / total;
        int completedLength = (int) (percentage * barLength);

        StringBuilder sb = new StringBuilder();
        sb.append("\r[");

        for (int i = 0; i < barLength; i++) {
            if (i < completedLength) {
                sb.append("#");
            } else if (i == completedLength && current < total) {
                sb.append(">");
            } else {
                sb.append(" ");
            }
        }

        sb.append(String.format("] %d%% (%d/%d)", (int) (percentage * 100), current, total));

        // 2. Print ONLY the progress bar inline and flush
        System.out.print(sb.toString());
        System.out.flush();
    }

    public static void printUV(){
        String[] UV_LOGO = {
                "__/\\\\\\________/\\\\\\__/\\\\\\________/\\\\\\_        ",
                " _\\/\\\\\\_______\\/\\\\\\_\\/\\\\\\_______\\/\\\\\\_       ",
                "  _\\/\\\\\\_______\\/\\\\\\_\\//\\\\\\______/\\\\\\__      ",
                "   _\\/\\\\\\_______\\/\\\\\\__\\//\\\\\\____/\\\\\\___     ",
                "    _\\/\\\\\\_______\\/\\\\\\___\\//\\\\\\__/\\\\\\____    ",
                "     _\\/\\\\\\_______\\/\\\\\\____\\//\\\\\\/\\\\\\_____   ",
                "      _\\//\\\\\\______/\\\\\\______\\//\\\\\\\\\\______  ",
                "       __\\///\\\\\\\\\\\\\\\\\\/________\\//\\\\\\_______ ",
                "        ____\\/////////___________\\///________"
        };

        for(String logo : UV_LOGO){
            System.out.println(logo);
        }
    }

    public static void printHeader(){
        String[] HEADER = { "     ||======***==========***===*===========*====*====||",
                "     || ***-*\\\\\\********            *********///*-*** ||",
                "     || --------       -SYS7EM 3RR0R_   _-    ------- ||",
                "     || ***-*///********            *********\\\\\\*-*** ||",
                "     ||==**========*========***==========***===*======||"

        };

        for(String line : HEADER){
            System.out.println(line);
        }
    }

    public static void printTail(){
        String filePath = "src/resources/output.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            StringBuilder sb = new StringBuilder();
            for(String line : reader.readAllLines()){
//                System.out.println(line);
                for(Character c : line.toCharArray()){
                    System.out.print(c);
                    try{
                        Thread.sleep(50);
                    }catch(InterruptedException e){}
                }
                System.out.println("");
            }

//            System.out.print("Download Completed. Exiting Now . . .");
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
