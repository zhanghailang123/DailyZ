package zhilian.z1215;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2021/12/15 18:27
 */
public class DeepStuThreadLocal {

    private String a = "";
    public static void main(String[] args) {
        DeepStuThreadLocal test = new DeepStuThreadLocal();

        //First q
        //What's supplier
        ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> {
            if (1 == 1) {
                return test.getString();
            }
            return null;
        });

    }
    //被讨厌的勇气
    //courage to be hated
    //冷静 努力 专注 集中 冷静努力专注集中 专注 努力 集中
    //作用
    //Thread function 引用类型 静态内部类 ThreadLocalMap 内存泄漏问题  解决Hash冲突--》开放定址法
    //应用实例
    //升级版ThreadLocal FastThreadLocal

    //被讨厌的勇气
    //专注
    //KeepT
    //温和而坚定的人
    //Dont lie to yourself
    //热爱 love
    //勇敢去面对 不要逃避 要想着如何解决 发脾气解决不了问题
    //做一个心思纯粹的人
    //持续地关注自我意识和情绪
    //持续地关注自我意识和情绪 自我监视 抓住自己最轻微细节的情绪
    //职业规划 生命中有哪些是对我重要的事情
    private String getString(){
        return "test";
    }


    public void setA(String a){
        this.a = a;
    }
}