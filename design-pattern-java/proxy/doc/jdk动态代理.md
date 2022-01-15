jdk动态代理主要涉及两个类：`java.lang.reflect.InvocationHandler`和`java.lang.reflect.Proxy`。

code: `com.yangsx95.proxy.dynamic`

jdk动态代理的使用比较简单，具体不在赘述。

# jdk动态代理原理

```java
Proxy.newProxyInstance(cl, subject.getClass().getInterfaces(), handler)
```

我们通过`newProxyInstance`生成了一个代理对象实例，在查看ProxyInstance之前，预测一下动态代理的大致实现。

## 预测
😂 如果我是代码设计者，我会进行如下的简单设计：
1. 要想创建一个代理类，首先要确认委托类的类型，因为代理类要保证与委托类的功能一致（实现统一接口）
2. 所以，需要传入`subject.getClass().getInterfaces()` 即 subject实现的所有接口数组
3. Proxy拿到接口后，使用一些字节码生成工具，生成代理对象的字节码，写入到缓存中或者是磁盘 （这个步骤应该对java字节码非常熟悉）
4. 此代理对象必须关联对象 InvocationHandler，代理对象的方法实现大致应该是调用 handler.invoke()方法
5. 读取class文件/缓存，用反射创建对象返回

总结：获取委托类接口、配合代理处理对象、生成一个新的类的class，这个class的实例就是代理对象的实例

## 源代码分析

newProxyInstance 源码（删除了无关紧要的代码）：
```java
public class Proxy implements java.io.Serializable {
    @CallerSensitive
    public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h) throws IllegalArgumentException {
        final Class<?>[] intfs = interfaces.clone();
        // 通过委托对象的接口，生成的代理对象的Class实例
        Class<?> cl = getProxyClass0(loader, intfs);
        
        try {
            final Constructor<?> cons = cl.getConstructor(constructorParams);
            
            final InvocationHandler ih = h;
            if (!Modifier.isPublic(cl.getModifiers())) {
                AccessController.doPrivileged(new PrivilegedAction<Void>() {
                    public Void run() {
                        cons.setAccessible(true);
                        return null;
                    }
                });
            }
            return cons.newInstance(new Object[]{h});
        } catch (IllegalAccessException|InstantiationException e) {
            throw new InternalError(e.toString(), e);
        } // .....
    }
}
```
