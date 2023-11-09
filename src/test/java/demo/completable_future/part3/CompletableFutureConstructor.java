package demo.completable_future.part3;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompletableFutureConstructor {

    @Test
    public void testConstructor() throws InterruptedException, ExecutionException {
        CompletableFuture<String> future = new CompletableFuture<>();

        assertFalse(future.isDone());

        future.complete("value");

        assertTrue(future.isDone());
        assertEquals("value", future.get());
    }
}
