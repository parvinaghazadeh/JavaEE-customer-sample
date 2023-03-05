package com.tosan.customer_sample.soap;

import javax.ejb.Local;

@Local
public interface HelloLocal {
    String sayHello();
}
