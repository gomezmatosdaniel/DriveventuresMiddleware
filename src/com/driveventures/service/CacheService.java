package com.driveventures.service;

import java.io.IOException;
import java.net.InetSocketAddress;

// Import the AWS-provided library with Auto Discovery support 
import net.spy.memcached.MemcachedClient;  

public interface CacheService {

    public static void main(String[] args) throws IOException {
            
        String configEndpoint = "driveventures-memcached.l5t19l.cfg.euw3.cache.amazonaws.com 11211";
				 
        Integer clusterPort = 11211;

        MemcachedClient client = new MemcachedClient(
                                 new InetSocketAddress(configEndpoint, 
                                                       clusterPort));       
        // The client will connect to the other cache nodes automatically.

        // Store a data item for an hour.
        // The client will decide which cache host will store this item. 
        client.set("theKey", 3600, "This is the data value"); 
    }
    
}