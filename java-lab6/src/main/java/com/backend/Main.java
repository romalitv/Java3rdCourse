package com.backend;

import com.backend.PowerTool.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Appartment apartment = new Appartment(7);


        Microwave microwave = new Microwave();
        Refrigerator refrigerator = new Refrigerator();
        Notebook notebook = new Notebook();
        StaticTelephone staticTelephone = new StaticTelephone();

        apartment.addAppliance(staticTelephone);
        apartment.addAppliance(notebook);
        apartment.addAppliance(refrigerator);
        apartment.addAppliance(microwave);

        apartment.addAppliance(new MobilePowerTool(200, 0.5, 10));
        apartment.addAppliance(new KitchenPowerTool(150, 0.8,8));
        apartment.addAppliance(new KitchenPowerTool(300, 0.4, 12));


        System.out.println("Appliances before sorting:");
        printAppliancesInfo(apartment);


        apartment.sortByPower();
        System.out.println("\nAppliances after sorting by power:");
        printAppliancesInfo(apartment);

        System.out.println("\nIs there any mobile device in the apartment? " + apartment.hasMobileDevice());

        List<PowerTool> appliancesInRange = apartment.findAppliancesByRadiationRange(0, 1);

        System.out.println("\nAppliances with radiation in range [0, 1]:");
        printAppliancesInRange(appliancesInRange);

    }

    private static void printAppliancesInRange(List<PowerTool> appliancesByRadiationRange) {
        for (PowerTool appliance : appliancesByRadiationRange) {
            System.out.println("Power: " + appliance.getPower() + ", Radiation: " +
                    appliance.getElectromagneticRadiation() + ", Durability: " +
                    appliance.getDurability() + ", Mobility: " + (appliance.isMobile() ? "Yes" : "No"));
        }
    }


    private static void printAppliancesInfo(Appartment apartment) {
        for (PowerTool appliance : apartment.findAppliancesByRadiationRange(0, 1)) {
            System.out.println("Power: " + appliance.getPower() + ", Radiation: " +
                    appliance.getElectromagneticRadiation() + ", Durability: " +
                    appliance.getDurability() + ", Mobility: " + (appliance.isMobile() ? "Yes" : "No"));
        }
    }
}