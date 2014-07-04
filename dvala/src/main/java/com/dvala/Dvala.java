/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dvala;

import java.net.URL;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Dvala {
    //@Autowired
    //private RedisTemplate<String,String> template;
    @Resource(name="redisTemplate")
    private ListOperations<String,String> listOps;
    //public void addLink(String userId,URL url) {
    //    listOps.leftPush(userId, url.toExternalForm());
    //}
    @RequestMapping(value = "/expense_")
    public String expense(@RequestParam(value="name",required=true) String name) {
        listOps.leftPush("Hi", "Hello");
        return new Expense(name).getName();
    }
}
