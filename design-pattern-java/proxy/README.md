# Proxy Pattern 代理模式

**定义**：为其他对象提供一种代理，以控制对这个对象的访问。

uml: [proxy.puml](./uml/proxy.puml)  
code: `me.feathers.proxy.statics`

![](art/.README_images/134bfa6d.png)

> 简单点来说，就是RealSubject类想要为Client类提供一些功能，但是RealSubject类又不能暴露自己的存在，
> 所以，委托代理Proxy类，让Proxy类调用RealSubject类的功能，从而让Client类间接使用RealSubject类的功能。  
> 这样，代理中介就会将客户端与委托类隔离，还可以增加一些其他的功能。

哈哈，设计模式之禅以及大话设计模式都举了一个有趣的例子，其中设计模式之禅中的例子记忆尤为深刻：
> 西门庆找潘金莲，那潘金莲不好意思答复呀，咋办，找那个王婆做代理

# 动态代理

## JDK动态代理

[点我查看](./doc/jdk动态代理.md)

