package entities;

public class Company extends TaxPayer{
    private byte numberOfEmployees;

    public Company() {
        super();
    }

    public Company(String name, Double anualIncome, byte numberOfEmployees) {
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public byte getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(byte numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public double tax() {
        return 0;
    }
}
