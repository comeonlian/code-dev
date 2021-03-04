package com.leolian.data.structure.list.doube;

/**
 * @author Lian
 * @description:
 * @date 2020/10/17 16:37
 */
public class HeroNodeDouble {
    public int no;
    public String name;
    public String nickname;
    public HeroNodeDouble next;
    public HeroNodeDouble pre;

    public HeroNodeDouble(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNodeDouble{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

}
