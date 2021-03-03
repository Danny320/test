package com.luodan.model;

/**
 * @author ：LD
 * @description：TODO
 * @date ：2021/2/9 19:55
 */
public class Section {
    public int sid;
    public String name;
    public Section() {
    }
    public Section(int sid,String name) {
        this.sid = sid;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Section{" +
                "name='" + name + '\'' +
                '}';
    }

}
