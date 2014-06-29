/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dvala;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 *
 * @author Valera
 */
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
    public SecurityWebApplicationInitializer() {
        super(SecurityConfig.class);
    }    
}
