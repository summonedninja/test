import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class TestAuto {
    public static void main(String[] args) throws IOException {
        String param1 = "\\d{2}\\.\\d{2}\\.\\d{4}";
        String param2 = "\\d{2}\\.\\d{2}\\.\\d{4}";
        String par3 = "\\d{1}\\.\\d{2}\\.\\d{4}";
        String par4 = "\\d{1,2}\\.\\d{1}\\.\\d{4}";
        String par5 = "\\d{1}\\.\\d{1}\\.\\d{4}";
        String path = "C:/Users/DmitryCyber24/Desktop/tg/CALENDAR_1.1.exe";

        Scanner scanner = new Scanner(System.in);
        String enteredPath = "";
        do {
            System.out.println("Введите путь ");
            enteredPath = scanner.nextLine();
        } while (!enteredPath.equals(path));
        {
            System.out.println("Верно");
        }
        Path exePath = Paths.get(enteredPath);


        ProcessBuilder processBuilder = new ProcessBuilder("python", exePath.toAbsolutePath().toString(), param1, param2);
        Process process = processBuilder.start();

        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }


        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.println("Введите начальную дату в формате d.m.y (01.01.2010):");
            String inpitOne = scanner.nextLine();
            System.out.println("Введите конечную дату в формате d.m.y (01.01.2018):");
            String inputSecond = scanner.nextLine();

            if (inpitOne.matches(param1) && inputSecond.matches(param2)) {
                isValidInput = true;
                param1 = inpitOne;
                param2 = inputSecond;
            } else if (inpitOne.matches(par3) || inputSecond.matches(par3)) {
                System.out.println("Введенные значения неверные. Попробуйте еще раз");
            } else if (inpitOne.matches(par4) || inputSecond.matches(par4)) {
                System.out.println("Введенные значения неверные. Попробуйте еще раз");
            } else if (inpitOne.matches(par5) || inputSecond.matches(par5)) {
                System.out.println("Введенные значения неверные. Попробуйте еще раз");
            } else if (inpitOne.matches(par3) || inputSecond.matches(par4)) {
                System.out.println("Введенные значения неверные. Попробуйте еще раз");
            } else if (inpitOne.matches(par4) || inputSecond.matches(par3)) {
                System.out.println("Введенные значения неверные. Попробуйте еще раз");
            } else if (inpitOne.matches(par3) || inputSecond.matches(par5)) {
                System.out.println("Введенные значения неверные. Попробуйте еще раз");
            } else {
                System.out.println("Введите заного ");
            }
        }

        processBuilder = new ProcessBuilder("python", exePath.toAbsolutePath().toString(), param1, param2);
        process = processBuilder.start();

        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}





