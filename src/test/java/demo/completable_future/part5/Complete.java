package demo.completable_future.part5;

import demo.completable_future.common.Demo;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Complete extends Demo {

    @Test
    public void testComplete() throws InterruptedException, ExecutionException {
        CompletableFuture<String> future = new CompletableFuture<>();

        assertFalse(future.isDone());

        boolean hasCompleted = future.complete("value");

        assertTrue(hasCompleted);
        assertTrue(future.isDone());
        assertEquals("value", future.get());
    }
}
