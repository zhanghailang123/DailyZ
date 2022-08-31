//package com.zhanghl.first.gen;
//
//import com.google.auto.service.AutoService;
//import com.squareup.javapoet.JavaFile;
//import com.squareup.javapoet.MethodSpec;
//import com.squareup.javapoet.TypeSpec;
//
//import javax.annotation.processing.*;
//import javax.lang.model.SourceVersion;
//import javax.lang.model.element.Modifier;
//import javax.lang.model.element.TypeElement;
//import java.io.IOException;
//import java.util.Collections;
//import java.util.Set;
//
///**
// * @author zhanghailang
// * @since 2022/8/31 22:05
// **/
//@AutoService(Processor.class)
//public class TestGenProcessor extends AbstractProcessor {
//
//    private Filer filer;
//
//
//    @Override
//    public synchronized void init(ProcessingEnvironment processingEnv) {
//        super.init(processingEnv);
//        filer = processingEnv.getFiler();
//    }
//
//    @Override
//    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
//        for (TypeElement element : annotations) {
//            if (element.getQualifiedName().toString().equals(TestGen.class.getCanonicalName())) {
//                //TODO Review
//                MethodSpec main = MethodSpec.methodBuilder("main")
//                        .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.PUBLIC)
//                        .returns(void.class)
//                        .addParameter(String.class, "args")
//                        .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
//                        .build();
//
//                TypeSpec helloworld = TypeSpec.classBuilder("TestGen")
//                        .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
//                        .addMethod(main)
//                        .build();
//
//                try {
//                    // build com.example.HelloWorld.java
//                    JavaFile javaFile = JavaFile.builder("com.zhanghl.first.gen", helloworld)
//                            .addFileComment(" This codes are generated automatically. Do not modify!")
//                            .build();
//                    // write to file
//                    javaFile.writeTo(filer);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return true;
//    }
//
//    @Override
//    public Set<String> getSupportedAnnotationTypes() {
//        return Collections.singleton(TestGen.class.getCanonicalName());
//    }
//
//    @Override
//    public SourceVersion getSupportedSourceVersion() {
//        return SourceVersion.latestSupported();
//    }
//
//
//}
