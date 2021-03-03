/**
 * @author ：LD
 * @description：TODO
 * @date ：2021/1/18 10:28
 */

/**
 * 演示 synchronized 关键字的语法
 */
public class SynchronizedSyntaxDemo {
    private volatile static  SynchronizedSyntaxDemo n = null;
     private SynchronizedSyntaxDemo() {}
    public  static SynchronizedSyntaxDemo haha() {
        if(n == null) {
            synchronized (SynchronizedSyntaxDemo.class) {
                if(n == null) {
                    n = new SynchronizedSyntaxDemo();
                }
            }
        }
        return n;
    }

}
