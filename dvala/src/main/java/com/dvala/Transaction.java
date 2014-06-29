/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dvala;

import java.math.BigDecimal;
import java.util.UUID;

/**
 *
 * @author Valera
 */
public class Transaction {
    private final UUID id;
    Expense expense;
    private BigDecimal amount;
    Transaction(Expense expense, BigDecimal amount) {
        id = UUID.randomUUID();
        this.expense = expense;
        this.amount = amount;
    }
}
