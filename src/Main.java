import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = " ";
        String lastName = " ";
        int dateOfBirth = 0;
        int  yearStart = 0;

            try {
                System.out.println("Атынызды жазыныз:");
                name = scanner.nextLine();

                if (name.matches(".*\\d.*")) {
                    throw new InputMismatchException("Адамдын аты сандан турбайт");

                }

                System.out.println("Фамилиянызды жазыныз: ");
                lastName = scanner.nextLine();
                if (lastName.matches(".*\\d.*")) {
                    throw new InputMismatchException("Адамдын фамилиясы сан болбойт");

                }
                System.out.println("Туулган жылынызды жазыныз: ");
                dateOfBirth = scanner.nextInt();

                if (!String.valueOf(dateOfBirth).matches(".*\\d.*")) {
                    throw new InputMismatchException("dateOfBirth  тамга болбойт");
                }
                if (dateOfBirth > LocalDate.now().getYear()) {
                    throw new InputMismatchException("dateOfBirth 2024жылдан чон болбойт ");
                }
                System.out.println("Жумушка кирген жылынызды жазыныз: ");
                yearStart = scanner.nextInt();

                if (yearStart < dateOfBirth || yearStart > LocalDate.now().getYear()) {
                    throw new InputMismatchException("Жумушка кирген жылыныз " + (dateOfBirth + 18) + " жылдан кичине же 2024жылдан чон болбойт");
                }
                int age = LocalDate.now().getYear() - dateOfBirth;

                int experience = LocalDate.now().getYear() - yearStart;
                if (dateOfBirth+18> yearStart) {
                    throw new MyException("Иштегенге болбойт");
                }
                Person person = new Person(name, lastName, dateOfBirth, yearStart);
                System.out.println(person);

                System.out.println("Age: " + age);
                System.out.println("Experience: " + experience);
            }
            catch (MyException e) {
                System.out.println(e.getMessage());
            }catch (Exception e) {
                System.err.println(e.getMessage());

        }

    }
}