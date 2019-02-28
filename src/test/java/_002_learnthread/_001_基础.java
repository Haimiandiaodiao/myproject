package _002_learnthread;

import com.example.entity.exclude.Son;
import org.junit.Test;

/**
 * @Author Dyy <br/>
 * @Description <br/>
 * @Date 2019/2/17 4:17 PM<br/>
 */
public class _001_基础 {

    @Test
    public void name() {
        Thread thread = new Thread();
        System.out.println(thread.getName());
        Thread thread1 = new Thread();
        System.out.println(thread1.getName());

        Thread thread2 = new Thread("A");
        System.out.println(thread2.getName());

        

    }


    @Test
    public void interrupterde使用() {
        Thread.currentThread().interrupt();
        System.out.println("是否停止1？"+Thread.interrupted());
        System.out.println("是否停止1？"+Thread.interrupted());

    }


    @Test
    public void 终止进程的方法() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 500000; i++) {
                        //判断是否进程是中断的状态
                        if (this.isInterrupted()) {
                            System.out.println("已经是停止状态了！我要退出了～");
                            throw new InterruptedException();
                        }
                        System.out.println("i=" + (i + 1));
                    }
                    System.out.println("我在for下面");
                } catch (Exception e) {
                    System.out.println("进MyThread。java类run方法中的catch了！");
                    e.printStackTrace();
                }
            }
        };
        try {
            thread.start();
            //让主进程不退出
            Thread.sleep(2000);
            //让子进程中断
            thread.interrupt();
        }catch (Exception e){
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end!");
    }


    @Test
    public void 线程在sleep状态下停止线程() {
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("run begin");
                    Thread.sleep(200000);
                    System.out.println("run end");
                }catch (Exception e){
                    System.out.println("在沉睡中被停止！进入catch！"+this.isInterrupted());
                    e.printStackTrace();
                }
            }
        };


        try{
            thread.start();
//            Thread.sleep(200);
            thread.interrupt();
        }catch(Exception e){
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end");
    }


    @Test
    public void 先执行interrupt停止线程() {
        Thread thread = new Thread(){
            @Override
            public void run() {

                try {
                    for (int i = 0; i < 1000000; i++) {
                        System.out.println("i="+(1+i));
                    }
                    System.out.println("run begin");
                    Thread.sleep(200000);
                    System.out.println("run end");
                }catch (Exception e){
                    System.out.println("先停止，再遇到了sleep！进入catch！");
                    e.printStackTrace();
                }
            }
        };

        thread.start();
        thread.interrupt();
        System.out.println("end!");

        while (true){}
    }

   @Test
    public void show111(){
       Son son = new Son();
       son.panduan();
   }



}
