/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dvala;

import java.util.UUID;

/**
 *
 * @author Valera
 */
class Expense {
    private final UUID id;
    private String name;
    Expense(String name) {
        id = UUID.randomUUID();
        this.name = name;
    }
}
