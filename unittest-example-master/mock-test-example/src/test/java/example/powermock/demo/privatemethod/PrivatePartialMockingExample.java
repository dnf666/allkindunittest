package example.powermock.demo.privatemethod;

/**
 * Created by Administrator on 15-7-16.
 */
public final class PrivatePartialMockingExample {
    public String methodToTestPrivate() {
        return privateMethod("input");
    }

    private String privateMethod(String input) {
        return "REAL VALUE = " + input;
    }

    public final String finalMethod(String input) {
        return "REAL VALUE = " + input;
    }

    public String methodToTestFinal() {
        return finalMethod("input");
    }
}