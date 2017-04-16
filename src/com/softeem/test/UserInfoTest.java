package com.softeem.test;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

import com.softeem.matcher.RetryLimitHashedCredentialsMatcher;

public class UserInfoTest {
    public static void main(String[] args) {  
        String algorithmName = "MD5";  
        String password = "123456";  
        
        String salt2 = new SecureRandomNumberGenerator().nextBytes().toHex();  
        int hashIterations = 5;  
        SimpleHash hash = new SimpleHash(algorithmName, password,  
                salt2, hashIterations);  
        String encodedPassword = hash.toHex();  
        System.out.println(encodedPassword);  
        System.out.println(salt2);  
        
        
        
        
        
    }  
}
