public class Main {
    public static void main(String[] args) {
        int totalSteps = 100;

        for (int i = 0; i <= totalSteps; i++) {
            printProgressBar(i, totalSteps);
            try {
                // Simulating some work
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("\nTask completed!");
    }

    public static void printProgressBar(int current, int total) {
        int barLength = 100; // Total width of the progress bar in characters
        double percentage = (double) current / total;
        int completedLength = (int) (percentage * barLength);

        StringBuilder sb = new StringBuilder();
        sb.append("\r["); // \r moves the cursor to the beginning of the line

        // Fill completed progress
        for (int i = 0; i < barLength; i++) {
            if (i < completedLength) {
                sb.append("#");
            } else if (i == completedLength && current < total) {
                sb.append(">"); // Optional arrowhead marker
            } else {
                sb.append(" ");
            }
        }

        sb.append(String.format("] %d%% (%d/%d)", (int) (percentage * 100), current, total));

        System.out.print(printUV());
        System.out.flush();
        // Print the string and flush the stream to make it instantly visible
        System.out.print(sb.toString());
        System.out.flush();
    }

    public static String printUV(){
        StringBuilder sb = new StringBuilder();
        final String[] UV_LOGO = {"__/\\\\\\________/\\\\\\__/\\\\\\________/\\\\\\_        ",
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
            sb.append(logo);
        }
        return sb.toString();
    }
}