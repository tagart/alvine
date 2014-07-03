/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dvala;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Dvala {
    @RequestMapping(value = "/expense_")
    public String expense(@RequestParam(value="name",required=true) String name) {
        return new Expense(name).getName();
    }
}
