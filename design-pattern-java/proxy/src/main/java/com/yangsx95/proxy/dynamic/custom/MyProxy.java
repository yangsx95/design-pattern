package com.yangsx95.proxy.dynamic.custom;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MyProxy {

    private static final String LN = "\r\n";

    /**
     * 创建一个代理对象实例
     *
     * @param classLoader     classloader
     * @param interfaces 代理类实现的接口
     * @param h          invocationHandler
     * @return 代理对象实例
     */
    public static Object newProxyInstance(MyClassLoader classLoader,
                                          Class<?>[] interfaces,
                                          MyInvocationHandler h) {
        // 1. 生成源代码
        String src = genSrc(interfaces);

        // 2. 将生成的源代码输出到磁盘，保存为.java文件
        File srcF = new File(MyProxy.class.getResource("").getPath() + "/$Proxy0.java");
        try (Writer w = new FileWriter(srcF)) {
            w.write(src);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // 3. 编译源代码，并且生成.class文件
        JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
        try (StandardJavaFileManager manager = javac.getStandardFileManager(null, null, null)) {
            Iterable iter = manager.getJavaFileObjects(srcF);
            JavaCompiler.CompilationTask task = javac.getTask(null, manager, null, null, null, iter);
            task.call();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // 4. 将class文件动态加载到jvm中
        try {
            Class<?> $Proxy0 = classLoader.findClass("$Proxy0");
            Constructor<?> constructor = $Proxy0.getConstructor(MyInvocationHandler.class);
            // 5. 返回被代理后的代理对象实例
            return constructor.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 不支持生成多参方法
    private static String genSrc(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer("package me.feathers.proxy.dynamic.custom; " + LN);
        sb.append("import me.feathers.proxy.dynamic.custom.MyProxy;" + LN);
        sb.append("import me.feathers.proxy.dynamic.custom.MyInvocationHandler;" + LN);
        sb.append("import me.feathers.proxy.dynamic.custom.MyClassLoader;" + LN);
        sb.append("import java.lang.reflect.Method;" + LN);
        sb.append("public class $Proxy0 extends MyProxy " + LN);
        sb.append("implements ");
        for (Class<?> anInterface : interfaces) {
            sb.append(anInterface.getName());
            sb.append(LN);
        }
        sb.append("{" + LN);
        // InvocationHandler 实例
        sb.append("private MyInvocationHandler h;");

        //region 构造器
        sb.append("public $Proxy0(MyInvocationHandler h) {" + LN);
        sb.append(" this.h = h;");
        sb.append("}" + LN);
        //endregion

        for (Class<?> anInterface : interfaces) {
            for (Method m : anInterface.getMethods()) {
                sb.append("public " + m.getReturnType().getName() + " " + m.getName() + " () throws Throwable { " + LN);
                sb.append("Method m = " + anInterface.getName() + ".class.getMethod( \"" + m.getName() + "\", null);" + LN);
                sb.append(" this.h.invoke(this, m, null );" + LN);
            }
        }
        sb.append("}" + LN);
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) {
        newProxyInstance(null, new Class[]{Subject.class}, new SubjectHandler(new RealSubject()));
        
    }
}
