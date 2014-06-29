
package com.malin;

import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import redis.clients.jedis.Jedis;

/**
 *
 * @author Valera
 */
@Stateful
@LocalBean
public class Malin implements Serializable {

    private int count = 0;
    
    public int getCount() {
        count++;
        try {
        Jedis jedis = new Jedis("localhost");
        jedis.set("amount", String.valueOf(count)); }
        catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
    
}
