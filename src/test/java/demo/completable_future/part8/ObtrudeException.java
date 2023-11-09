package demo.completable_future.part8;

import demo.completable_future.common.Demo;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ObtrudeException extends Demo {

    @Test
    public void testObtrudeException1() throws InterruptedException, ExecutionException {
        CompletableFuture<String> future = CompletableFuture.completedFuture("value");

        assertTrue(future.isDone());
        assertFalse(future.isCompletedExceptionally());
        assertEquals("value", future.get());

        future.obtrudeException(new RuntimeException("exception"));

        assertTrue(future.isDone());
        assertTrue(future.isCompletedExceptionally());
    }

    @Test
    public void testObtrudeException2() {
        CompletableFuture<String> future = CompletableFuture.failedFuture(new RuntimeException("exception1"));

        assertTrue(future.isDone());
        assertTrue(future.isCompletedExceptionally());

        future.obtrudeException(new RuntimeException("exception2"));

        assertTrue(future.isDone());
        assertTrue(future.isCompletedExceptionally());
    }
}
