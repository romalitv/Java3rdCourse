package com.backend.PowerTool;

public class MobilePowerTool extends PowerTool {
    public MobilePowerTool(int power, double electromagneticRadiation, int durability) {
        super(power, electromagneticRadiation, durability);
    }

    public boolean isMobile() {
        return true;
    }
}

