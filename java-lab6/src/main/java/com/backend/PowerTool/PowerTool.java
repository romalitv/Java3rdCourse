package com.backend.PowerTool;

public class PowerTool {

    private int power;
    private double electromagneticRadiation;
    private int durability;

    public PowerTool(int power, double electromagneticRadiation, int durability) {
        this.power = power;
        this.electromagneticRadiation = electromagneticRadiation;
        this.durability = durability;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public double getElectromagneticRadiation() {
        return electromagneticRadiation;
    }

    public void setElectromagneticRadiation(double electromagneticRadiation) {
        this.electromagneticRadiation = electromagneticRadiation;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public boolean isMobile() {
        return false;
    }
}
