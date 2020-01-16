package com.eshore.project.springbootdemo.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lixinxin
 * @since 2020-01-03
 */
public class Car  implements Serializable  {

    private static final long serialVersionUID = 1L;
    private String id;
    private String carName;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Car(String carName) {
        this.carName = carName;
    }
}
