package com.doit.net.model;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Author：Libin on 2020/12/29 15:41
 * Email：1993911441@qq.com
 * Describe：
 */
@Table(name = "city")
public class DBCity {
    @Column(name = "id", isId = true)
    private int id;

    @Column(name = "number")
    private String number;

    @Column(name = "city")
    private String city;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DBCity(String number, String city) {
        this.number = number;
        this.city = city;
    }

    public DBCity() {
    }

    @Override
    public String toString() {
        return "DBCity{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
