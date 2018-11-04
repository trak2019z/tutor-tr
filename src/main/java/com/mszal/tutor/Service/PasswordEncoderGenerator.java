package com.mszal.tutor.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Mateusz on 2018-11-04.
 */
public class PasswordEncoderGenerator {
    public static String encode(String password1) {
        String hashedPassword="";
        int i = 0;
        while (i < 10) {

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            hashedPassword = passwordEncoder.encode(password1);
            i++;
        }
        return hashedPassword;
    }
}
