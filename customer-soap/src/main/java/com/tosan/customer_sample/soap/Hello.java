package com.tosan.customer_sample.soap;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class Hello implements HelloLocal{
    public String sayHello() {
        return " to Maven base JavaEE";
    }
}
