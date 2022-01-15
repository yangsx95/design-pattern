## Wiki

**[查看wiki](https://zh.wikipedia.org/wiki/%E7%AD%96%E7%95%A5%E6%A8%A1%E5%BC%8F)**

策略模式作为一种软件设计模式，指对象有某个行为，但是在不同的场景中，该行为有不同的实现算法。比如每个人都要“交个人所得税”，但是“在美国交个人所得税”和“在中国交个人所得税”就有不同的算税方法。

策略模式：

- 定义了一族算法（业务规则）；
- 封装了每个算法；
- 这族的算法可互换代替（interchangeable）。


## JDK中的策略模式

- `java.util.Comparator#compare()`
- `javax.servlet.http.HttpServlet`的`service()` 和 `doXXX()`: 实现Sevlet时，需要继承HttpServlet类，并重写此方法；Tomcat就是Client对象，会调用不同的HttpServlet实现（从而对不同的请求处理），每个实现都是一种不同的策略。
- `javax.servlet.Filter#doFilter()`，同上。


