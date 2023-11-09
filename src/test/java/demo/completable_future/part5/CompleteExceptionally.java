package demo.completable_future.part5;

import demo.completable_future.common.Demo;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class CompleteExceptionally extends Demo {

    @Test
    public void testCompleteExceptionally() throws InterruptedException {
        CompletableFuture<String> future = new CompletableFuture<>();

        assertFalse(future.isDone());
        assertFalse(future.isCompletedExceptionally());

        boolean hasCompleted = future.completeExceptionally(new RuntimeException("exception"));

        assertTrue(hasCompleted);
        assertTrue(future.isDone());
        assertTrue(future.isCompletedExceptionally());

        try {
            future.get();
            fail();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            assertEquals(RuntimeException.class, cause.getClass());
            assertEquals("exception", cause.getMessage());
        }
    }
}
