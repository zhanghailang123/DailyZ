package designpattern.builder.interfacesz;

/**
 * @description: 不变的部分？
 * @author: zhanghailang
 * @date: 2022/1/18 10:40
 */
public interface Item {
    String name();
    Packing packing();
    float price();
}