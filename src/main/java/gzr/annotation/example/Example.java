package gzr.annotation.example;

/**
 * Created by gaozengrong on 17/1/5.
 */
@ClassAnnotation(
        priority = ClassAnnotation.Priority.HIGH,
        createdBy = "mkyong.com",
        tags = {"sales","test" }
)
class Example {
    @MethodAnnotation
    void testA() {
        throw new RuntimeException("This test always failed");
    }

    @MethodAnnotation(enabled = false)
    void testB() {
        throw new RuntimeException("This test always passed");
    }

    @MethodAnnotation(enabled = true)
    void testC() {
        // do nothing, this test always passed.
    }

}
