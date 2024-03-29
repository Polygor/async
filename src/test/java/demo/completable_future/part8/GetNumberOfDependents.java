package demo.completable_future.part8;

import demo.completable_future.common.Demo;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetNumberOfDependents extends Demo {

    @Test
    public void testGetNumberOfDependents() {
        CompletableFuture<String> future = CompletableFuture.completedFuture("value");
        assertEquals(0, future.getNumberOfDependents());
    }
}