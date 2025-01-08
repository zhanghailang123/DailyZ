package designpattern.builder;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/1/18 11:27
 */
public class MealBuilder {

    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pesi());
        return meal;
    }
}