package demo.completable_future.part1.accept;

import demo.completable_future.common.Demo;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ThenAcceptBoth extends Demo {

    @Test
    public void testThenAcceptBoth() throws InterruptedException, ExecutionException {
        CompletionStage<String> stage1 = supplyAsync(() -> sleepAndGet(1, "parallel1"));
        CompletionStage<String> stage2 = supplyAsync(() -> sleepAndGet(2, "parallel2"));

        CompletionStage<Void> stage = stage1.thenAcceptBoth(stage2,
                (s1, s2) -> logger.info("consumes both: {} {}", s1, s2));

        assertNull(stage.toCompletableFuture().get());
    }
}
