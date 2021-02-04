package Web;

/**
 * @description: 算法：将字符串中的空格替换为指定的字符串
 * @author: zhanghailang
 * @date: 2020/9/6 0006 23:34
 */
public class Solution {
    /*
    第一种方法常规方法。利用String.charAt(i)以及String.ValueOf(char).equals(" ")
     */
    public static String replaceString(StringBuffer str){
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++){
            char c = str.charAt(i);
            if (String.valueOf(c).equals(" ")){
                stringBuffer.append("阿言");
            }else{
                stringBuffer.append(c);
            }
        }
        return  stringBuffer.toString();
    }

    /**
     * 第二种方法，利用API替换掉所有空格，一行代码解决问题
     */
    public static String replaceSpace2(StringBuffer str){
        return str.toString().replaceAll("\\s","阿言");
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("zhang yan 可 真是个 憨憨");
        System.out.println(replaceString(stringBuffer));
        System.out.println(replaceSpace2(stringBuffer.append("言  yyy hhhh")));
    }
}