package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import utilities.ConfigReader;

/**
 * @author alpinaro (Alper Çınaroğlu)
 * https://github.com/alpinaro
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseDummy {

    public RequestSpecification specDummy;

    @BeforeAll
    public void setUp() {

        specDummy = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("DummyBaseURL")).build();
    }
}
