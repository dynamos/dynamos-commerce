package io.dynamos.entities;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

/**
 * Created by adelmo on 22/04/17.
 */
public class Manufacturer {

    @Id
    private String id;

    @NotNull
    private String name;

    @NotNull
    private String address;

    @NotNull
    private String telephone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
