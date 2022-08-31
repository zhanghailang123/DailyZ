package com.zhanghl.first.gen;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;

/**
 * @author zhanghailang
 * @since 2022/8/31 22:43
 **/
public class Test {
    public static void main(String[] args) throws Exception {
        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(whatsMyName("slimShady"))
                .addMethod(whatsMyName("eminem"))
                .addMethod(whatsMyName("marshallMathers"))
                .build();

        JavaFile javaFile = JavaFile.builder("com.zhanghl.first.gen", helloWorld)
                .build();

        javaFile.writeTo(System.out);
    }

    private static MethodSpec whatsMyName(String name) {
        return MethodSpec.methodBuilder(name)
                .returns(String.class)
                .addStatement("return $S", name)
                .build();
    }
}
