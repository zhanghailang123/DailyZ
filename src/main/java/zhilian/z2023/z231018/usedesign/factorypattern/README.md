工厂模式

如何将实例化具体类的代码从应用中抽离，或者封装起来，使它们不会干扰应用的其他部分？

改造前，使用``new`` 的方式来实例化对象

````java
public Pizza orderPizza(String type) {
    Pizza pizza;
    
    if (type.euals("cheese")) {
        pizza = new CheesePizza();    
    } else if (type.equals("clam")) {
        pizza = new ClamsPizza();    
    } else if (type.equals("veggie")) {
        pizza = new VeggiePizza();
    }
    
    return pizza;
}

````

我们设计一个简单工厂来替代new的方式````SimplePizzaFactory````







````java
public class SimplePizzaFactory {
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        
        if(type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("clam")) {
            pizza = new ClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        }
        
        return pizza;
    }
}
````

问题：有类似静态方法工厂的方式，有何区别

> 静态方法无需实例化对象进行创建，但是不能通过继承来改变创建方法的行为
> 
> 无法进行多态处理
> 
> 难以继承和重写
> 
> 



### 依赖倒置原则
毋庸置疑的，代码里减少对具体类的依赖是件好事，`依赖倒置原则`正是基于此指导代码的设计
> 要依赖抽象，不要依赖具体类

听起来像：我们应当针对接口编程，不针对实现编程。

实际还是有区别的，关键是理解抽象，这个原则更强调`抽象`。

想要遵循依赖倒置原则，工厂方法并非是唯一的技巧，但却是极具代表意义的其中之一。



### 工厂模式和抽象工厂模式