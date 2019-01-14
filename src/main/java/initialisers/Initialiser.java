package initialisers;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import tests.TitleTest;

public class Initialiser {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TitleTest.class);
        for (Failure failure : result.getFailures()) System.out.println(failure.toString());
        System.out.println(result.wasSuccessful());
    }
}
