package view;

public class NewOiseau extends Thread {
    private final VueOiseau vueOiseau;

    public NewOiseau(VueOiseau v) {
        vueOiseau = v;
        start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
                vueOiseau.generer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
