package com.yangsx95.proxy.dynamic.custom;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class MyClassLoader extends ClassLoader {

    private File baseDir;

    public MyClassLoader() {
        String basePath = MyClassLoader.class.getResource("").getPath();
        this.baseDir = new java.io.File(basePath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = MyClassLoader.class.getPackage().getName() + "." + name;
        if (baseDir != null) {
            File classFile = new File(baseDir, name.replaceAll("\\.", "/") + ".class");
            if (classFile.exists()) {
                try (FileInputStream in = new FileInputStream(classFile); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                    byte[] buff = new byte[1024];
                    int len;
                    while ((len = in.read(buff)) != -1) {
                        out.write(buff, 0, len);
                    }
                    return defineClass(className, out.toByteArray(), 0, out.size());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
