package com.zhanghl.first.z220207;


import cn.hutool.http.HttpUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Arrays;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/2/7 9:39
 */
@Service
public class TransactionalTest {

    @Transactional(rollbackFor = Exception.class)
    public void testTransactional() {
        System.out.println("start transactional test");
        throw new RuntimeException("test rollback");
    }

    public static void main(String[] args) {
        String urls = "https://storage-public.zhaopin.cn/innovation/gig/1671440030426143687/all_q_download_9207247bfb024ac897b957ab08874995.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671440029398195450/all_q_download_5c90ef10818d4a80ba5322a53c00e476.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671440028501959765/all_q_download_a3c734d54d12417288ac9a05e95a87f9.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671440027941690044/all_q_download_aea8b01c37944fbfa9d8c20f43271dfd.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671440026704913279/all_q_download_6af7c27ab113488cbf65596bcb775203.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671440024324590962/all_q_download_f8262809ccbe434d9400a8ea1796f580.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671440023351715916/all_q_download_ae660235700b4eed87a7f51071c7a0bf.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671440022343347138/all_q_download_2ec931e9241c49bb86fb0a4fa438ae3e.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671440021453521488/all_q_download_295b4a3ca42142c5a95216ddc20e5f11.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671440020843056508/all_q_download_557231794fc248159aa61cb80868de56.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671440019492442031/all_q_download_7e77df0b51d24271a1d5289efc27f06b.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671440016756876073/all_q_download_1e329ac6b22b4d7ab025a3da08c7d72d.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671440013064968083/all_q_download_8652e21c90ea4493b64f23b37ad05af0.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671440012366544105/all_q_download_53d8aab6d3d04d8da20afd581c20fada.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671440011462253009/all_q_download_599ed288c62c43ed8ea2e27224e9ab5b.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671440006318401201/all_q_download_1f4a1f397d544117ac8b76d3767bdf54.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671440005154048423/all_q_download_25a8b69a679e4916a11584eaf4b8ca0f.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671440004186734734/all_q_download_cbcd5fd2643a4273b2972e7be5ebc6d2.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671440003084151093/all_q_download_577d5e78a21e4f53b61feb6fcce11110.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671440001949308226/all_q_download_1f3af3c911d14a4bb77a69286f17f423.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671440000983078701/all_q_download_bfb8924503e84cdc84c51bfdc3542a44.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439999984817239/all_q_download_73c213b2dfcf4d4a97fa33cfc6257c7e.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439998927615125/all_q_download_3a26ba7c5c2a44f68c808321e9d1645a.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439997974771022/all_q_download_09b124af834d485ab6b13e368ea7ed83.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439997045831960/all_q_download_07d55dcbeae4454cba8fc4561ac9df33.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439995890491060/all_q_download_e50dc10681ab427f93e470e0b4e19c23.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439995010825604/all_q_download_d8910b4d9ec941a5959c48726da63901.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439994081778317/all_q_download_df31243519d54ba1bee8ff375fcdbcf7.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439991973351143/all_q_download_47ea8562f6b1421f88a0514b16b3f5fe.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439990978815842/all_q_download_7ce2b312da43467eaa366f7e8a1e08a0.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439989099593850/all_q_download_22cb8fc88d974b648af51f1648108a43.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439988146507417/all_q_download_139d7fc72ee94dd3a91599e16dcc7bf8.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439986982220794/all_q_download_7bf2dfad46a8458db4e1425406c06c9c.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439985946915107/all_q_download_5738f380c0b4458ea37a081b2e37e8a3.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439984785895859/all_q_download_d8d11b6d9af6492aaef56bbb1fed3dce.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439983912946354/all_q_download_0e1ae195a34a421d98f6898a3792df7f.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439982918667079/all_q_download_095563880ff54db09e3ad62c1f9cf95f.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439981925769920/all_q_download_085ccbae5d294a86a2f2d176512cb525.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439980891773949/all_q_download_e5ac0a4b329b4d11b14288b7987d451b.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439979951202451/all_q_download_653eeb29d74245a99a5a7786410051f2.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439978730190127/all_q_download_4e10ab0818144708901678034929128f.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439977865155331/all_q_download_a4e05aa3406e46a99d6163e7f0de9540.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439976911813013/all_q_download_6be3ff6a421d408aab280bc378eddc0a.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439975980454651/all_q_download_f641eb7700a64969bc077c4d3df8898f.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439975028014649/all_q_download_fa0c4c1849504c1a9a8c32af4d20ad91.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439973850851323/all_q_download_2447b550d03d45f3a682c4ddee1865f8.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439972726088500/all_q_download_24654a4e0fa04e27b7bca312973df1c0.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439972477973376/all_q_download_04f4d951485e420fbd385781269a8aaf.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439970647341923/all_q_download_6bc50d7ea31d450aa580dd642996caf3.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439969751292719/all_q_download_2ea83afaee034dec8d69374e3ed3cc96.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439966791724532/all_q_download_42fa2cc20094429a893f184959bbb6b8.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439965732643286/all_q_download_769387d63e1c49d797ad5ef019f5a649.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439964600362648/all_q_download_e5ac9dfa144a4168819576c21aef755f.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439963659372268/all_q_download_d3583791a506404091edb5a322cb48df.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439962723120785/all_q_download_6ae134af74ea472d8c3796594bf70c38.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439960970022437/all_q_download_785595bcab734f93a66f9a75f8963f7e.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439958695419209/all_q_download_eb93fa4f7f69427683898aa69fe4c307.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439956632228850/all_q_download_cc047daf845a4e4fa6703d52c7aeb4a0.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439955811608598/all_q_download_cd23d1838e944f69a0e8aeebe7868ea5.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439954802113360/all_q_download_a2df4ec5a5b046d9a2b61d21d971c811.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439952529107491/all_q_download_2fcdcc6c85684d9c987ab55c915ee17b.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439950263817537/all_q_download_0e1e1583dee14a8ab5003ae0ff772ced.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439949018547871/all_q_download_f6d1eceefd254e1b88a173be30f53dfa.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439947561256202/all_q_download_e80964a2d01943ab9b25b0ab01392c35.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439946425113378/all_q_download_3b908201b26d49a9a95e43e63ad45d13.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439945767054474/all_q_download_d510c21016794eb7abf352f9d21931a7.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439944519582780/all_q_download_f5e1a41df4cd4e42811cf8e64faababc.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439942442048154/all_q_download_9200dc1e2ccc49229c704685cb7f0630.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439941501803400/all_q_download_7fb22aea2736441e97cfd95c01e9670d.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439940496452025/all_q_download_2a03414d954a40dbb78b2c94155a4cd2.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439939352168193/all_q_download_4dc049452f724ae49a5ee69eb029565d.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439938555827511/all_q_download_43226519dd59428f9b9ff4b30013d1dc.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439937445778166/all_q_download_5daa0af6c7844219bca349d8eda068be.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439936326707495/all_q_download_e2da577e550b4189b19118ee74b74f68.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439935318871583/all_q_download_a3e89de1d2c04cf8b5b5880093a513c4.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439933293442055/all_q_download_a55df70a5f4e44b282acecdb9a20bcc7.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439932276699101/all_q_download_c8699a3c45bb432e96b8f48147129677.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439931335805605/all_q_download_2125b8dbe1ba4394989ec4f0a30c0550.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439930256701238/all_q_download_302d4952c39f48f98e8c70687894b653.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439929576943673/all_q_download_2909bb542822451fab28b86f2d302c7c.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439927247916569/all_q_download_1e46e8040a7c4af28cea1740bda483f9.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439926348099948/all_q_download_70fd1a0a98db4dce8e9f602be08248cd.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439924221823923/all_q_download_f222c1885e494a07be777e8263f7c39b.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439923467738378/all_q_download_12a4eb3446de49e69107c0040a8ef3a2.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439922486324067/all_q_download_316132da360e483abb76e34bf162f744.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439920942403112/all_q_download_a27b901748884a9294d07bc09bfd9331.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439918422480344/all_q_download_3f36f7a7380c4fca90334c28dffd8e9b.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439916125828317/all_q_download_f395bfaa9eeb41b4a1d5d0c8f6311f73.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439915122846440/all_q_download_c21524f065a04db484c9006716592542.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439914102133035/all_q_download_83a7dd2feb334040af286be14f9e4414.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439913096587428/all_q_download_ff84915de8a048888a6f4b3fc67515fb.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439912076493947/all_q_download_070ad8057e50481098062570a1d093c7.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439911123905730/all_q_download_650a8c082320403aa7151984f4f656de.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439910063769910/all_q_download_6e5b7774f82e470e84c28231923b4e9a.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439909049489752/all_q_download_c7bb818f19034f45b5a209b3f113d5a2.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439908037932082/all_q_download_7c9376cd8f5b482daf85f383bd35503e.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439907017863178/all_q_download_5aedb99bf527424cb26ce31c927eb9b8.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439906258630123/all_q_download_0b667524917c46aa9ef36334e69d7f81.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439905375172444/all_q_download_d471c1fd6b1241ac9210e3980b3c2e07.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439903003047249/all_q_download_411e5a236ef342d686690eb3ff4fd3c9.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439901037895888/all_q_download_a1fc1f73505044e3aabcc4c003abf901.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439899226362712/all_q_download_f5ae0e9d57c14fe8ad3811daafea778c.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439897540910532/all_q_download_41ff488278934917a34864a690b34646.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439895920711817/all_q_download_22191bfb340c4353a6d038309334b9ec.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439894957123184/all_q_download_f5c1f4750e9f43f7a912f6aa88920f63.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439894361519845/all_q_download_92cd5a05e28a4d93b8548a59440c200e.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439893209170235/all_q_download_505fe9d8935b478f85d2c488c8a9eb63.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439892197356904/all_q_download_c37a51bf4ed8489f8d47f37b9b1b2cba.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439891241527050/all_q_download_0640e62f5fd64c6dbe3a126519247832.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439890193076196/all_q_download_5ae34f148c5d4897b6fbb02211e9478c.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439889245875779/all_q_download_561e8f9322e74780830fe12872f3a986.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439886837768183/all_q_download_5a2f64729fb14fb6b532a7e03257073c.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439886462997974/all_q_download_d13f36d5d08a46258c3326aa9ad61823.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439884804615937/all_q_download_95fef35cbf2349c8a42d76deb328e1ed.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439884122721566/all_q_download_d1fbed6e564e4372bd513bf96383c40a.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439881970870907/all_q_download_331b88dcbf9245ab91bf1dc2282bde41.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439880192600282/all_q_download_efcdec1a0f964cc181c0c4542af2a6c4.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439869689854216/all_q_download_4d983b2841e94debba28a232633eeadf.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439869166956564/all_q_download_c9c2b11b357a437abd7c08906f4cb23e.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439867716239889/all_q_download_3baf0bb5fb0146edbafcc10e042cd48a.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439866689567041/all_q_download_679af86a0e3a4df7a15b496f37e144d6.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439865822097948/all_q_download_e9b39e1a1316431692883fee1a579677.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439864856847129/all_q_download_f4b3fd45104149be9ae6a98eff0afa7b.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439862623765290/all_q_download_256f465f042a49cf810fcfc2cd82db97.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439861612648976/all_q_download_a8b20fe5071c42d6984cfcd05b168949.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439860600913727/all_q_download_92d3b4bbd29645878fa8d3e2f36a00a3.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439859601333459/all_q_download_769f3a9f8e5f443299e74fbdf6d6fea3.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439858848026989/all_q_download_0b7e72fcab5e456e9c8a70ebb0ca536b.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439857815547903/all_q_download_ab1177493794417990f5b558273aee6e.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439856697946499/all_q_download_6f03c18bba0245d3a5745d8346cb27ae.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439854903545918/all_q_download_d3bb348731904dbfbd06753243712f9a.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439854047958964/all_q_download_c8cc7ed4c15647a6b89dbeb9bb690a81.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439852800131818/all_q_download_de4971500d6f4ce4a9df1a25f077ae04.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439850567364568/all_q_download_e0a6918ed2324747bdd26ee607082579.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439849632681716/all_q_download_a18060e33d28449582450b4ebfc90fcd.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439847505975782/all_q_download_c2782fa11f4d4cdda076e91055b692c1.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439846676049514/all_q_download_2c5ab318c5a740bb850e4265383c9a72.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439844589362423/all_q_download_8b364458124c43a8a53cb1ebeede4cec.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439844003082965/all_q_download_37dbedc97639420e9d6a21d4b43acfa4.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439842415757820/all_q_download_9195f3e956ae48a6ac1a5c99a30ec98c.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439842005492941/all_q_download_399c40e6f7404452b259966c092e0260.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439839643024565/all_q_download_79ba4b8f2e6040c5a4ab6432f90882c3.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439837016161798/all_q_download_758569f2e02c4773b39cac97d0a4c5e6.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439809656138854/all_q_download_faa7a45f0d82424d889b7d38f11454a5.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439807523502634/all_q_download_34a360e6fe444e859204dd81d586db3f.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439805348126561/all_q_download_773d7877067e4b05bf033e9fc4ef7adc.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439804291253254/all_q_download_334d9a9c24334f19918cfcf5935348e0.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439802356566025/all_q_download_a57a43a27b314d01a9190ae4f9aaf433.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439801141966535/all_q_download_43813e37cecb467fb280dae6412b0ad4.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439799651800370/all_q_download_b0d149d90c11449fa35c1056d67ee27b.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439797011800221/all_q_download_f35349eb5a764288bf24cc28c1bcbb0e.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439796581213087/all_q_download_b3c7b309df42488eb4dfc0d2d8d10096.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439795310404607/all_q_download_f08b13be0ced4cf0a294b195517c85b5.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439794654994722/all_q_download_83ffacf2ab27450aaf41c15f2d7ec533.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439791968799609/all_q_download_9904f9c849db4a8eaca9113505cbeba8.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439791009207355/all_q_download_b2e4a7a7ec284eaaa12730d93765c2d8.xlsx,\n" +
                "        https://storage-public.zhaopin.cn/innovation/gig/1671439789964638616/all_q_download_a124a176c199415cbad7ab0eca96a72e.xlsx";

        Arrays.stream(urls.split(",")).map(String :: trim).forEach(a -> {
            File file = new File("D:\\11\\");
            HttpUtil.downloadFile(a, file);
        });
    }
}