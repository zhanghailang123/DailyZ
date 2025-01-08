package designpattern.builder;

/**
 * @description:建造者模式
 * @author: zhanghailang
 * @date: 2022/1/18 11:31
 */
public class BuilderDemo {

    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal meal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal :");
        meal.showItems();
        System.out.println("Total Cost :" + meal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("Non Veg Meal :");
        nonVegMeal.showItems();
        System.out.println("Total Cost :" + nonVegMeal.getCost());

        System.out.println(50.1f + 3.6f);

        //build yourself
        ThreadLocal<String> local = new ThreadLocal<>();
    }
}