package _003_base;

/**
 * @Author:Dyy
 * @Description:
 * @Date: Created in 15:26 2019/2/25
 */
public class Circle {
    private double radius = 0;
    public static int count =1;
    public Circle(double radius) {
        this.radius = radius;
    }

    public interface  dd{
        public void show111();
    }
    public Circle show(){
        class Woman extends Circle{

            public Woman(double radius) {
                super(radius);
            }
        }

        Woman woman = new Woman(11);


        Draw draw = new Draw();
        draw.drawSahpe();
        draw.drawdd();
        return  woman;
    }
     class Draw{
        public double radius = 0;
        public void drawSahpe(){
            System.out.println(radius);
            System.out.println(count);
        }

        private void drawdd(){

        }
    }
    class  nn implements dd{

        @Override
        public void show111() {

        }
    }
}
