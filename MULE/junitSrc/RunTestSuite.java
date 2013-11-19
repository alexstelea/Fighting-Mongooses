import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.Result;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

public class RunTestSuite {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestSuite.class);
        for (Failure failure: result.getFailures()) {
            System.out.println(failure.toString());
        }
    }
}
