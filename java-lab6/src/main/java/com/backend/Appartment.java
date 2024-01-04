package com.backend;

import com.backend.PowerTool.PowerTool;

import java.util.ArrayList;
import java.util.List;

public class Appartment {
    private PowerTool[] appliances;
    private int numberOfAppliances;

    public Appartment(int capacity) {
        this.appliances = new PowerTool[capacity];
        this.numberOfAppliances = 0;
    }

    public void addAppliance(PowerTool appliance) {
        if (numberOfAppliances < appliances.length) {
            appliances[numberOfAppliances++] = appliance;
        }
    }

    public void sortByPower() {
        for (int i = 0; i < numberOfAppliances - 1; i++) {
            for (int j = 0; j < numberOfAppliances - i - 1; j++) {
                if (appliances[j].getPower() > appliances[j + 1].getPower()) {
                    // Поміняти місцями елементи, якщо потрібно
                    PowerTool temp = appliances[j];
                    appliances[j] = appliances[j + 1];
                    appliances[j + 1] = temp;
                }
            }
        }
    }

    public List<PowerTool> findAppliancesByRadiationRange(double minRadiation, double maxRadiation) {
        List<PowerTool> result = new ArrayList<>();
        for (int i = 0; i < numberOfAppliances; i++) {
            double radiation = appliances[i].getElectromagneticRadiation();
            if (radiation >= minRadiation && radiation <= maxRadiation) {
                result.add(appliances[i]);
            }
        }
        return result;
    }

    public boolean hasMobileDevice() {
        for (int i = 0; i < numberOfAppliances; i++) {
            if (appliances[i].isMobile()) {
                return true;
            }
        }
        return false;
    }
}