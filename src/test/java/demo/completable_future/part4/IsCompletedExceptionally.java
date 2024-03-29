package demo.completable_future.part4;

import demo.completable_future.common.Demo;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsCompletedExceptionally extends Demo {

    @Test
    public void testIsCompletedExceptionallyFalse() throws InterruptedException, ExecutionException {
        CompletableFuture<String> future = CompletableFuture.completedFuture("value");

        assertTrue(future.isDone());
        assertFalse(future.isCompletedExceptionally());
        assertFalse(future.isCancelled());
        assertEquals("value", future.get());
    }

    @Test
    public void testIsCompletedExceptionallyTrue() {
        CompletableFuture<String> future = CompletableFuture.failedFuture(new RuntimeException("exception"));

        assertTrue(future.isDone());
        assertTrue(future.isCompletedExceptionally());
        assertFalse(future.isCancelled());
    }
}
