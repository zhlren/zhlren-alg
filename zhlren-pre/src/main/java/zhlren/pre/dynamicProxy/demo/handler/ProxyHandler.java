package zhlren.pre.dynamicProxy.demo.handler;

import zhlren.pre.dynamicProxy.demo.model.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by bjrenzhili on 17/3/30.
 */
public class ProxyHandler implements InvocationHandler{

    private Subject subject;

    public ProxyHandler(Subject subject){
        this.subject = subject;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("===before===");
        method.invoke(subject,args);
        System.out.println("===after===");
        return null;
    }

}
