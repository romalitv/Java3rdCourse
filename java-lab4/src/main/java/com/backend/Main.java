package com.backend;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();

        Cosmetics firstCosmetic =  new Cosmetics("Brand1", "Type1", 15.99, 5, "Women");
        Cosmetics secondCosmetic =new Cosmetics("Brand2", "Type2", 25.99, 8, "Men");
        Cosmetics thirdCosmetic =new Cosmetics("Brand3", "Type3", 12.99, 10, "Women");
        Cosmetics forthCosmetic =new Cosmetics("Brand4", "Type4", 18.99, 15, "Men");

        storage.addCosmetics(firstCosmetic);
        storage.addCosmetics(secondCosmetic);
        storage.addCosmetics(thirdCosmetic);
        storage.addCosmetics(forthCosmetic);

        storage.printQuantityDescent();

        storage.printPriceAscend();

        Usage.usageGender(storage.getQuantityDescendingSorted(), "Women");
        Usage.usageGender(storage.getQuantityDescendingSorted(), "Men");
        System.out.println("\n");

        Usage.buying(storage.getQuantityDescendingSorted(), "Brand1", "Type1", 3);
        System.out.println("\n");

        Usage.buying(storage.getQuantityDescendingSorted(), "Brand1", "Type1", 3);
        System.out.println("\n");

        Usage.buying(storage.getQuantityDescendingSorted(), "Brand2", "Type2", 10);

    }
}