import java.awt.Toolkit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start OnlMuerMukG Project");
        Toolkit toolkit= Toolkit.getDefaultToolkit();

        for(int i=0; i<5; i++) {
            toolkit.beep();
            try {
                Thread.sleep(1000);
                //Thread.sleep(1000)은 () 안에 1/1000(초) 단위 이므로, 1초 간격으로 들리고 찍는다.
            } catch (Exception e) {
                System.out.println(e);
                //Thread가 들어간 문장은 반드시 예외처리를 해야 한다. 잠시 Thread 처리를 1초간 멈춰라 ~
            }
        }
    }
}