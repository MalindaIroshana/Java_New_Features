package main.java.streamAPI;

import java.time.LocalDate;

public class Transaction {
    private String id;
    private double amount;
    private LocalDate date;
    private String category;

    public Transaction(String id, double amount, LocalDate date, String category) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
