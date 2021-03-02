package my.compary.service;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class CallServiceTest {

    @Inject
    private CallService callService;

    @Test
    public void setUp() {
        Assertions.assertNotNull(callService);
    }
}