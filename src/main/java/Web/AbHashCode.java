package Web;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: hashcode 的一些 写法 why技术的
 * @author: zhanghailang
 * @date: 2020/11/19 0019 22:06
 */
public class AbHashCode {
    static class HaomeInfo{
        private String homeAdrr;
        private String carName;

        public HaomeInfo(String homeAdrr, String carName) {
            this.homeAdrr = homeAdrr;
            this.carName = carName;
        }

        public String getHomeAdrr() {
            return homeAdrr;
        }

        public void setHomeAdrr(String homeAdrr) {
            this.homeAdrr = homeAdrr;
        }

        public String getCarName() {
            return carName;
        }

        public void setCarName(String carName) {
            this.carName = carName;
        }

        @Override
        public String toString() {
            return "homeaddr:" + this.getHomeAdrr() +", carName :" + this.getCarName();
        }
    }
   static class StuInfo{
        private String name;
        private Integer age;

        public StuInfo(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

       public String getName() {
           return name;
       }

       public void setName(String name) {
           this.name = name;
       }

       public Integer getAge() {
           return age;
       }

       public void setAge(Integer age) {
           this.age = age;
       }

       @Override
       public String toString() {
           return "name:" + this.getName() + ",age:" + this.getAge();
       }
   }

    private static Map<StuInfo,HaomeInfo> hashMap = new HashMap<>();
    static {
        StuInfo stuInfo = new StuInfo("zy",23);
        HaomeInfo haomeInfo = new HaomeInfo("潘家园","建工");
        hashMap.put(stuInfo,haomeInfo);
    }


    private static void update(String name,Integer age,String homeAddr,String carName){
        StuInfo stuInfo = new StuInfo(name,age);
        HaomeInfo haomeInfo = hashMap.get(stuInfo);
        if(haomeInfo == null){
            hashMap.put(stuInfo,new HaomeInfo(homeAddr,carName));
        }
    }

    public static void main(String[] args) {
        update("zy",23,"双井","天桥");
        for(Map.Entry<StuInfo,HaomeInfo> entry : hashMap.entrySet()){
            System.out.println(entry.getKey()+"-"+entry.getValue());
        }
    }
}