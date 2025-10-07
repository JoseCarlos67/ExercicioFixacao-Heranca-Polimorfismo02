package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        ByteArrayInputStream fakeInput = autofillingOfData();
        System.setIn(fakeInput);

        Scanner scanner = new Scanner(System.in);

        List<TaxPayer> taxPayerList = new ArrayList<>();
        registerTaxPayer(taxPayerList, scanner);

        scanner.close();
    }

    private static ByteArrayInputStream autofillingOfData() {
        String fakeInputString = """
                3
                i
                Alex
                50000.00
                2000.00
                c
                SoftTech
                40000.00
                25
                i
                Bob
                120000.00
                1000.00
                """;
        return new ByteArrayInputStream(fakeInputString.getBytes());
    }

    private static void registerTaxPayer(List<TaxPayer> taxPayerList, Scanner scanner) {
        System.out.print("Enter the number of tax payers: ");
        byte numberTaxPayers = scanner.nextByte();

        for (byte i = 1; i <= numberTaxPayers; i++) {
            System.out.println("Tax payer #" + i + " data:");

            System.out.print("Individual or companu (i/c)? ");
            char individualCompany = scanner.next().charAt(0);

            if (individualCompany == 'i'){
                System.out.print("Name: ");
                scanner.nextLine();
                String name = scanner.nextLine();

                System.out.print("Anual income: ");
                double anualIncome = scanner.nextDouble();

                System.out.print("Health expenditures: ");
                double healthExpenditures = scanner.nextDouble();

                taxPayerList.add(new Individual(name, anualIncome, healthExpenditures));
            } else {
                System.out.print("Name: ");
                scanner.nextLine();
                String name = scanner.nextLine();

                System.out.print("Anual income: ");
                double anualIncome = scanner.nextDouble();

                System.out.print("Number of employees: ");
                byte numberOfEmployees = scanner.nextByte();

                taxPayerList.add(new Company(name, anualIncome, numberOfEmployees));
            }
        }
    }
}
