package zhilian.z2024.z02;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpUtil;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;

class TestImage{

    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("https://upload-pre.esign.cn/eproxy/1111564182/df5a3dbe-4193-43fa-980d-1b3b27417678/d202ce5774fa4ddc9cb2437cfebcda13?signature=NOjHIUc5%2FpxqqwtbEhp99CMsX4Q%3D&expire=1711104141651&bucket=esignoss");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        System.out.println(HttpUtil.createGet("https://upload-pre.esign.cn/eproxy/1111564182/df5a3dbe-4193-43fa-980d-1b3b27417678/d202ce5774fa4ddc9cb2437cfebcda13?signature=NOjHIUc5%2FpxqqwtbEhp99CMsX4Q%3D&expire=1711104141651&bucket=esignoss").execute());
//        Image image = ImgUtil.read(url);
//        String encode = ImgUtil.toBase64DataUri(image, ImgUtil.IMAGE_TYPE_PNG);
//        System.out.println(encode);
    }
}