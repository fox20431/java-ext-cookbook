package com.hihusky.elk;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ElkTests {

    @Test
    public void testSendLog() {
        log.info("HI HERE");
    }
}
