/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc2.model;

import java.util.Objects;

/**
 *
 * @author jeffc
 */
public class Selection {
    private Long selection;

    public Long getSelection() {
        return selection;
    }

    public void setSelection(Long selection) {
        this.selection = selection;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.selection);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Selection other = (Selection) obj;
        if (!Objects.equals(this.selection, other.selection)) {
            return false;
        }
        return true;
    }
    
}
