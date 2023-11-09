package demo.completable_future.part5;

import demo.completable_future.common.Demo;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompleteAsync extends Demo {

    @Test
    public void testCompleteAsync() throws InterruptedException, ExecutionException {
        CompletableFuture<String> future1 = new CompletableFuture<>();

        assertFalse(future1.isDone());

        CompletableFuture<String> future2 = future1.completeAsync(() -> "value");
        sleep(1);

        assertTrue(future2.isDone());
        assertEquals("value", future2.get());
    }
}
