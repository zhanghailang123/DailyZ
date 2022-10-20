package com.zhanghl.first.z220207;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/9/13 9:01
 */
public class JITTest {

    public static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
//        Runnable runnable = () -> {
//          for (long i = 0; i < 1000000000; i ++) {
//            num.addAndGet(1);
//          }
//            System.out.println(Thread.currentThread().getName() + "，执行结束");
//        };
//
//        Thread t1 = new Thread(runnable);
//        Thread t2 = new Thread(runnable);
//
//        t1.start();
//        t2.start();
//
//        Thread.sleep(1000);
//
//        System.out.println("num = " + num);
        String param = "40653971 ,\n" +
                "19962    ,\n" +
                "12047159 ,\n" +
                "26666    ,\n" +
                "67588652 ,\n" +
                "34227171 ,\n" +
                "22372391 ,\n" +
                "86235936 ,\n" +
                "40481883 ,\n" +
                "13599073 ,\n" +
                "29870551 ,\n" +
                "19346172 ,\n" +
                "14575607 ,\n" +
                "64368082 ,\n" +
                "20053362 ,\n" +
                "54261112 ,\n" +
                "165      ,\n" +
                "81663939 ,\n" +
                "12097019 ,\n" +
                "12017432 ,\n" +
                "13656    ,\n" +
                "12014360 ,\n" +
                "34157123 ,\n" +
                "15271641 ,\n" +
                "48371052 ,\n" +
                "45310492 ,\n" +
                "63972278 ,\n" +
                "44424    ,\n" +
                "64104502 ,\n" +
                "12074085 ,\n" +
                "19989111 ,\n" +
                "87767835 ,\n" +
                "15569531 ,\n" +
                "32776983 ,\n" +
                "37377981 ,\n" +
                "12074736 ,\n" +
                "41368    ,\n" +
                "5588     ,\n" +
                "55666453 ,\n" +
                "85280998 ,\n" +
                "13098070 ,\n" +
                "125102623,\n" +
                "40583998 ,\n" +
                "37687352 ,\n" +
                "13350825 ,\n" +
                "36154    ,\n" +
                "20146    ,\n" +
                "67723702 ,\n" +
                "13624309 ,\n" +
                "13295    ,\n" +
                "30639171 ,\n" +
                "12054395 ,\n" +
                "14450192 ,\n" +
                "46009771 ,\n" +
                "14693248 ,\n" +
                "12014670 ,\n" +
                "83098159 ,\n" +
                "12088703 ,\n" +
                "13871843 ,\n" +
                "18403932 ,\n" +
                "19292131 ,\n" +
                "16167851 ,\n" +
                "46921751 ,\n" +
                "45868042 ,\n" +
                "19543511 ,\n" +
                "12108439 ,\n" +
                "29683248 ,\n" +
                "12084926 ,\n" +
                "12081771 ,\n" +
                "84659121 ,\n" +
                "46771761 ,\n" +
                "63216213 ,\n" +
                "2364     ,\n" +
                "12283    ,\n" +
                "30421738 ,\n" +
                "20123431 ,\n" +
                "13319697 ,\n" +
                "27198863 ,\n" +
                "60817862 ,\n" +
                "12000236 ,\n" +
                "13960501 ,\n" +
                "12091662 ,\n" +
                "12091627 ,\n" +
                "40688258 ,\n" +
                "19397782 ,\n" +
                "15714332 ,\n" +
                "29454788 ,\n" +
                "126892546,\n" +
                "5876     ,\n" +
                "20047581 ,\n" +
                "55869    ,\n" +
                "44013752 ,\n" +
                "12014642 ,\n" +
                "12035798 ,\n" +
                "13273    ,\n" +
                "20140181 ,\n" +
                "13708303 ,\n" +
                "13509886 ,\n" +
                "34898381 ,\n" +
                "29261092 ,\n" +
                "66274922 ,\n" +
                "84498681 ,\n" +
                "34307878 ,\n" +
                "81735818 ,\n" +
                "37134808 ,\n" +
                "27971733 ,\n" +
                "13053126 ,\n" +
                "22451302 ,\n" +
                "32415222 ,\n" +
                "43663281 ,\n" +
                "61462    ,\n" +
                "12007229 ,\n" +
                "13195500 ,\n" +
                "67332852 ,\n" +
                "13650805 ,\n" +
                "29905141 ,\n" +
                "28290991 ,\n" +
                "15342441 ,\n" +
                "14710111 ,\n" +
                "13206743 ,\n" +
                "38065531 ,\n" +
                "18321852 ,\n" +
                "19053721 ,\n" +
                "127278458,\n" +
                "43608683 ,\n" +
                "124229531,\n" +
                "14597663 ,\n" +
                "66689802 ,\n" +
                "39530292 ,\n" +
                "40269331 ,\n" +
                "88835903 ,\n" +
                "14099860 ,\n" +
                "13616750 ,\n" +
                "13315589 ,\n" +
                "77549759 ,\n" +
                "34280008 ,\n" +
                "57702832 ,\n" +
                "57642662 ,\n" +
                "48946752 ,\n" +
                "14607789 ,\n" +
                "27333501 ,\n" +
                "41706063 ,\n" +
                "14671873 ,\n" +
                "135404879,\n" +
                "20218082 ,\n" +
                "54877852 ,\n" +
                "12018867 ,\n" +
                "14388504 ,\n" +
                "40779842 ,\n" +
                "14359254 ,\n" +
                "19246741 ,\n" +
                "30731578 ,\n" +
                "18972322 ,\n" +
                "61197802 ,\n" +
                "86732823 ,\n" +
                "16274491 ,\n" +
                "40852228 ,\n" +
                "129000281,\n" +
                "132103980,\n" +
                "128818092,\n" +
                "14462466 ,\n" +
                "12098831 ,\n" +
                "126937615,\n" +
                "43817762 ,\n" +
                "58207062 ,\n" +
                "62944593 ,\n" +
                "60580    ,\n" +
                "19866492 ,\n" +
                "13091689 ,\n" +
                "46988441 ,\n" +
                "24511731 ,\n" +
                "12096653 ,\n" +
                "139120446,\n" +
                "24936581 ,\n" +
                "82335673 ,\n" +
                "42787988 ,\n" +
                "26337113 ,\n" +
                "13203828 ,\n" +
                "33700343 ,\n" +
                "43791302 ,\n" +
                "126727752,\n" +
                "42245341 ,\n" +
                "41863072 ,\n" +
                "67094182 ,\n" +
                "18931841 ,\n" +
                "20073778 ,\n" +
                "26976263 ,\n" +
                "121982500,\n" +
                "124651900,\n" +
                "64019733 ,\n" +
                "24391511 ,\n" +
                "39180271 ,\n" +
                "53819742 ,\n" +
                "86737775 ,\n" +
                "40780742 ,\n" +
                "37171868 ,\n" +
                "50580362 ,\n" +
                "57918342 ,\n" +
                "28457108 ,\n" +
                "123883422,\n" +
                "141270366,\n" +
                "40845281 ,\n" +
                "15170871 ,\n" +
                "44181752 ,\n" +
                "39367721 ,\n" +
                "48619952 ,\n" +
                "44425281 ,\n" +
                "64017158 ,\n" +
                "39707893 ,\n" +
                "131833442,\n" +
                "38985273 ,\n" +
                "131937575,\n" +
                "12104669 ,\n" +
                "38651702 ,\n" +
                "53520752 ,\n" +
                "128576322,\n" +
                "14113349 ,\n" +
                "67011642 ,\n" +
                "24152663 ,\n" +
                "37798258 ,\n" +
                "31585182 ,\n" +
                "64781    ,\n" +
                "13184545 ,\n" +
                "14113318 ,\n" +
                "68282292 ,\n" +
                "12035641 ,\n" +
                "14420162 ,\n" +
                "27514513 ,\n" +
                "63056452 ,\n" +
                "27401961 ,\n" +
                "121087034,\n" +
                "14522849 ,\n" +
                "126638424,\n" +
                "57211638 ,\n" +
                "44365752 ,\n" +
                "14297179 ,\n" +
                "27917103 ,\n" +
                "55288968 ,\n" +
                "38992022 ,\n" +
                "44369631 ,\n" +
                "27918083 ,\n" +
                "13218957 ,\n" +
                "13452147 ,\n" +
                "13890175 ,\n" +
                "16461541 ,\n" +
                "84825320 ,\n" +
                "14666625 ,\n" +
                "13913134 ,\n" +
                "14913601 ,\n" +
                "40856151 ,\n" +
                "39546423 ,\n" +
                "49786582 ,\n" +
                "35052    ,\n" +
                "124253144,\n" +
                "61157933 ,\n" +
                "89151208 ,\n" +
                "33933481 ,\n" +
                "17224031 ,\n" +
                "47902502 ,\n" +
                "130848588,\n" +
                "53132    ,\n" +
                "62280362 ,\n" +
                "15408241 ,\n" +
                "12076611 ,\n" +
                "13331943 ,\n" +
                "33757751 ,\n" +
                "20590811 ,\n" +
                "13847197 ,\n" +
                "28743818 ,\n" +
                "12095785 ,\n" +
                "63944332 ,\n" +
                "54243642 ,\n" +
                "55193542 ,\n" +
                "74541229 ,\n" +
                "89260667 ,\n" +
                "18093611 ,\n" +
                "20066071 ,\n" +
                "26846841 ,\n" +
                "13189426 ,\n" +
                "26470851 ,\n" +
                "84225774 ,\n" +
                "13321677 ,\n" +
                "65879952 ,\n" +
                "28286823 ,\n" +
                "123656046,\n" +
                "41822351 ,\n" +
                "28289358 ,\n" +
                "17459472 \n";
        List<Long> companyIds = Arrays.stream(param.split(",")).map(String::trim).map(Long::parseLong).collect(Collectors.toList());
        System.out.println(companyIds);
    }
}