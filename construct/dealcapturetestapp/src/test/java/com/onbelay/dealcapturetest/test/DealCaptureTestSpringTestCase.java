package com.onbelay.dealcapturetest.test;

import com.onbelay.core.entity.persistence.TransactionalSpringTestCase;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;

@ComponentScan(basePackages = {"com.onbelay.core.*", "com.onbelay.shared.*", "com.onbelay.dealcapturetest.*"})
@EntityScan(basePackages = {"com.onbelay.*"})
@TestPropertySource( locations="classpath:application-integrationtest.properties")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DealCaptureTestSpringTestCase extends TransactionalSpringTestCase {

}
