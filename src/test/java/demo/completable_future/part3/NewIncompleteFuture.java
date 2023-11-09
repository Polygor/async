package demo.completable_future.part3;

import demo.completable_future.common.Demo;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewIncompleteFuture extends Demo {

    @Test
    public void testComplete() throws InterruptedException, ExecutionException {
        CompletableFuture<String> future1 = CompletableFuture.completedFuture("value1");
        assertTrue(future1.isDone());

        CompletableFuture<String> future2 = future1.newIncompleteFuture();
        assertFalse(future2.isDone());

        future2.complete("value2");

        assertTrue(future2.isDone());
        assertEquals("value2", future2.get());
    }
}
