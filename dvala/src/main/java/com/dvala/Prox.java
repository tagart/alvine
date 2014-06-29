/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dvala;

import com.malin.Malin;
import javax.ejb.EJB;

/**
 *
 * @author Valera
 */
public class Prox {
    @EJB
    Malin malin;
    public Malin getCount() {
        return malin;
    }
    public Prox() {}
}
