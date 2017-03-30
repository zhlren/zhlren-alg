package zhlren.pre.dynamicProxy.demo.model;

import zhlren.pre.dynamicProxy.demo.model.Subject;

/**
 * Created by bjrenzhili on 17/3/30.
 */
public class RealSubject implements Subject {
    public void doSth() {
        System.out.println("doSth");
    }
}
