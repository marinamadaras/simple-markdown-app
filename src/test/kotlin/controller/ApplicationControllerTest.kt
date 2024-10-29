package controller

import com.marina.controller.ApplicationController
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

class ApplicationControllerTest {

    @Test
    fun `startApplication should initialize mainFrame`() {
        val latch = CountDownLatch(1)
        ApplicationController.startApplication()

        // Wait for the main frame to be initialized,
        // as it is done on the EDT.
        latch.await(1, TimeUnit.SECONDS)
        assertThat(ApplicationController.mainFrame).isNotNull
    }

    @AfterEach
    fun tearDown() {
        ApplicationController.mainFrame?.dispose()
    }

}