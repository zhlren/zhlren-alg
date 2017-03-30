package zhlren.pre.dynamicProxy.demo;

import org.junit.Test;
import zhlren.pre.dynamicProxy.demo.handler.ProxyHandler;
import zhlren.pre.dynamicProxy.demo.model.RealSubject;
import zhlren.pre.dynamicProxy.demo.model.Subject;

import java.lang.reflect.Proxy;

/**
 * Created by bjrenzhili on 17/3/30.
 */
public class DynamicProxyDemo {

    @Test
    public void test(){
        RealSubject realSubject = new RealSubject();
        ProxyHandler handler = new ProxyHandler(realSubject);
        Subject proxySubject = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(),RealSubject.class.getInterfaces(),handler);
        proxySubject.doSth();
    }

}
