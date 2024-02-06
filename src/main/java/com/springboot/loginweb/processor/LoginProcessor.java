package com.springboot.loginweb.processor;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Data
@RequestScope
@Component
public class LoginProcessor {
    private String username;
    private String password;

    public boolean login(String username, String password){
        this.password=password;
        this.username=username;
        if("asher".equals(username)&&"pass".equals(password)){
            return true;
        }
        else
            return false;
    }
}
