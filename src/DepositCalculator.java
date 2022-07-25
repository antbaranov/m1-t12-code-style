import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return exponentiation(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return exponentiation(amount + amount * yearRate * depositPeriod, 2);
    }

    double exponentiation(double value, int degree) {
        double scale = Math.pow(10, degree);
        return Math.round(value * scale) / scale;
    }

    void calculation() {
        int period;
        int action;
        final double YEAR_RATE = 0.06;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double income = 0;

        if (action == 1) {
            income = calculateSimplePercent(amount, YEAR_RATE, period);
        } else if (action == 2) {
            income = calculateComplexPercent(amount, YEAR_RATE, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + income);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculation();
    }
}
