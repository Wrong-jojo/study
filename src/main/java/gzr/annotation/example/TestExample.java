package gzr.annotation.example;

/**
 * Created by gaozengrong on 17/1/5.
 */
@TesterInfo(
        priority = TesterInfo.Priority.HIGH,
        createdBy = "mkyong.com",
        tags = {"sales","test" }
)
class TestExample {
    @Test
    void testA() {
        throw new RuntimeException("This test always failed");
    }

    @Test(enabled = false)
    void testB() {
        throw new RuntimeException("This test always passed");
    }

    @Test(enabled = true)
    void testC() {
        // do nothing, this test always passed.
    }

}
