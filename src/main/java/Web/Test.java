package Web;

public class Test {
    public static void main(String[] args) {

        try {
            if (1 == 2) {
                System.out.println("1111111");
                return;
            }
            try {
                return;
            } finally {
                System.out.println("444444444444");
            }
        } catch (Exception e) {
            System.out.println("22222222222");
        }

    }

}
