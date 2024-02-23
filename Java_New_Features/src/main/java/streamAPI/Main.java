package main.java.streamAPI;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("1", 100.0, LocalDate.of(2024, 2, 20), "Groceries"),
                new Transaction("2", 200.0, LocalDate.of(2024, 2, 21), "Dining"),
                new Transaction("3", 300.0, LocalDate.of(2024, 2, 22), "Entertainment"),
                new Transaction("4", 400.0, LocalDate.of(2024, 2, 22), "Groceries"),
                new Transaction("5", 500.0, LocalDate.of(2024, 2, 23), "Shopping")
        );

        // Filter transactions for a specific category
        List<Transaction> groceryTransactions = transactions.stream()
                .filter(transaction -> transaction.getCategory().equals("Groceries")).toList();
        System.out.println("Grocery Transactions: ");
        groceryTransactions.forEach(System.out::println);

        // Map transactions to their amounts
        List<Double> transactionAmounts = transactions.stream()
                .map(Transaction::getAmount).toList();
        System.out.println("Transaction Amounts: ");
        transactionAmounts.forEach(System.out::println);

        // Calculate the total amount of transactions
        double totalAmount = transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
        System.out.println("Total Amount: " + totalAmount);

        // Calculate the average transaction amount
        double averageAmount = transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .average()
                .orElse(0);
        System.out.println("Average Amount: " + averageAmount);

        // Sort transactions based on their dates
        List<Transaction> sortedTransactions = transactions.stream()
                .sorted((t1, t2) -> t1.getDate().compareTo(t2.getDate())).toList();
        System.out.println("Sorted Transactions: ");
        sortedTransactions.forEach(System.out::println);

        // Group transactions by category
        Map<String, List<Transaction>> transactionsByCategory = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getCategory));
        System.out.println("Transactions Grouped by Category: ");
        transactionsByCategory.forEach((category, transactionList) -> {
            System.out.println("Category: " + category);
            transactionList.forEach(System.out::println);
        });
    }
}
