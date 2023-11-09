package com.ingesoft;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Tag("integration")
class BicicletasApplicationTests {

    @Test
    @Tag("slow")
    void contextLoads() {
        // Tu lógica de prueba aquí
    }
}
