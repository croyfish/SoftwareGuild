/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine2.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author jeffc
 */
public class Machine {
    
    private static final Integer COLS = 8;
    private static final Integer ROWS = 8;
    private Slot[][] machineSlots = new Slot[COLS][ROWS];
    private boolean inService;
    private Money machineMoney;
    private LocalDate installationDate;
    private LocalDateTime lastRestock;

    public Machine(LocalDate installation) {
        this.installationDate = installation;
    }
    
    public Integer getCOLS() {
        return COLS;
    }
    
    public Integer getROWS() {
        return ROWS;
    }
    
    public long getMachineAge() {
        Period p = installationDate.until(LocalDate.now());
        return p.getYears();
    }
    
    public long getTimeSinceLastRestock () {
        long hours = lastRestock.until(LocalDateTime.now(), ChronoUnit.HOURS);
        return hours;
    }
    
    public Slot[][] getMachineSlots() {
        return machineSlots;
    }

    public void setMachineSlots(Slot[][] machineSlots) {
        this.machineSlots = machineSlots;
    }

    public boolean isInService() {
        return inService;
    }

    public void setInService(boolean inService) {
        this.inService = inService;
    }

    public Money getMachineMoney() {
        return machineMoney;
    }

    public void setMachineMoney(Money machineMoney) {
        this.machineMoney = machineMoney;
    }

    public LocalDate getMachineInstallation() {
        return installationDate;
    }

    public void setMachineInstallation(LocalDate installationDate) {
        this.installationDate = installationDate;
    }

    public LocalDateTime getLastRestock() {
        return lastRestock;
    }

    public void setLastRestock(LocalDateTime lastRestock) {
        this.lastRestock = lastRestock;
    }
    
}
