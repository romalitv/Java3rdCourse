package com.backend;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<Cosmetics> cosmeticsList;

    public Storage() {
        this.cosmeticsList = new ArrayList<>();
    }

    public void addCosmetics(Cosmetics cosmetics) {
        cosmeticsList.add(cosmetics);
    }

    public List<Cosmetics> getQuantityDescendingSorted() {
        List<Cosmetics> sortedList = new ArrayList<>(cosmeticsList);

        for (int i = 0; i < sortedList.size() - 1; i++) {
            for (int j = i + 1; j < sortedList.size(); j++) {
                if (sortedList.get(i).getQuantity() < sortedList.get(j).getQuantity()) {
                    Cosmetics temp = sortedList.get(i);
                    sortedList.set(i, sortedList.get(j));
                    sortedList.set(j, temp);
                }
            }
        }

        return sortedList;
    }

    public List<Cosmetics> getPriceAscendingSorted() {
        List<Cosmetics> sortedList = new ArrayList<>(cosmeticsList);

        for (int i = 0; i < sortedList.size() - 1; i++) {
            for (int j = i + 1; j < sortedList.size(); j++) {
                if (sortedList.get(i).getPrice() > sortedList.get(j).getPrice()) {
                    Cosmetics temp = sortedList.get(i);
                    sortedList.set(i, sortedList.get(j));
                    sortedList.set(j, temp);
                }
            }
        }

        return sortedList;
    }

    public void printPriceAscend() {
        List<Cosmetics> sortedList = getPriceAscendingSorted();

        System.out.println("Ціна за зростанням:");
        for (Cosmetics cosmetics : sortedList) {
            System.out.println("$" + cosmetics.getPrice() + " - " + cosmetics.getBrand() + " " + cosmetics.getProductType());
        }
    }

    public void printQuantityDescent() {
        List<Cosmetics> sortedList = getQuantityDescendingSorted();

        System.out.println("Кількість продукту за спаданням:");
        for (Cosmetics cosmetics : sortedList) {
            System.out.println(cosmetics.getQuantity() + " шт. - " + cosmetics.getBrand() + " " + cosmetics.getProductType());
        }
    }
}
