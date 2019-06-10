package com.company.sgd.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author the_d
 */
public class Encoder {	
    public static void main(String args[]){
        System.out.println(Encoder.getEncodePassword("reach2106"));
        System.out.println(Encoder.getEncodePassword("luisrico23"));
        System.out.println(Encoder.getEncodePassword("jepp"));
        System.out.println(Encoder.getEncodePassword("chuwy"));
    }

    public static String getEncodePassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}