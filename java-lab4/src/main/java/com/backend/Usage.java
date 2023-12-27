package com.backend;

import java.util.List;

public class Usage {

    public static void usageGender(List<Cosmetics> cosmeticsList, String requestedGender) {

        System.out.println("Список доступної косметики для " + requestedGender + ":");

        for (Cosmetics cosmetics : cosmeticsList) {
            if (cosmetics.getGender().equalsIgnoreCase(requestedGender)) {
                System.out.println(cosmetics.getBrand() + " " + cosmetics.getProductType());
            }
        }
    }

    public static void buying(List<Cosmetics> cosmeticsList, String brand, String productType, int requestedQuantity) {
        boolean brandNotFound = true;

        for (Cosmetics cosmetics : cosmeticsList) {
            if (cosmetics.getBrand().equalsIgnoreCase(brand) && cosmetics.getProductType().equalsIgnoreCase(productType)) {
                brandNotFound = false;

                int availableQuantity = cosmetics.getQuantity();

                if (requestedQuantity > availableQuantity) {
                    System.out.println("На жаль, в наявності є тільки " + availableQuantity + " одиниць товару.");
                    System.out.println("Будь ласка, введіть іншу кількість:");
                } else {
                    cosmetics.quantity -= requestedQuantity;
                    System.out.println("Ваша покупка виконана. Залишилось " + cosmetics.getQuantity() + " одиниць товару.");
                }
                break;
            }
        }

        if (brandNotFound) {
            System.out.println("Товар не знайдено.");
        }
    }
}


