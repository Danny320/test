/**
 * @author ：LD
 * @description：TODO
 * @date ：2021/1/16 15:37
 */
public class MyTread extends Thread {
    @Override
    public void run() {
        System.out.println("线程启动啦");
    }

    public static void main(String[] args) {
        MyTread myTread = new MyTread();
        System.out.println("主线程也启动啦");
        myTread.start();
        System.out.println("主线程也启动啦");
    }
}
