import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner = new Scanner(System.in);
    Operation op = new Operation();

    public void printMenu() {
        System.out.println("\n1. Add matrices\n" +
                "2. Multiply matrix by a constant\n" +
                "3. Multiply matrices\n" +
                "4. Transpose matrix\n" +
                "5. Calculate a determinant\n" +
                "6. Inverse matrix\n" +
                "0. Exit\n" +
                "Your choice:");
        int select = scanner.nextInt();
        selection(select);
    }

    public void selection(int select) {
        if (select == 1) {
            op.addMatrices();
            printMenu();
        } else if (select == 2) {
            op.multiplyConstant();
            printMenu();
        } else if (select == 3) {
            op.multiplyMatrices();
            printMenu();
        } else if (select == 4) {
            printTransposeMenu();
            printMenu();
        } else if (select == 5) {
            op.calculateDeterminant();
            printMenu();
        } else if (select == 6) {
            op.inverseMatrix();
            printMenu();
        }else if (select == 0) {
            System.exit(0);
        }
    }

    public void printTransposeMenu() {
        System.out.println("1. Main diagonal\n" +
                "2. Side diagonal\n" +
                "3. Vertical line\n" +
                "4. Horizontal line\n" +
                "Your choice:");
        int select = scanner.nextInt();
        if (select == 1) {
            op.mainDiagonal();
        } else if (select == 2) {
            op.sideDiagonal();
        } else if (select == 3) {
            op.vertical();
        } else if (select == 4) {
            op.horizontal();
        }
    }
}
