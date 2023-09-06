package ibs;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class ApiTest {

    @Test
    public void testAddVegetable() throws SQLException {
        PojoFood potato = new PojoFood("Картофель", "Овощ", false, "VEGETABLE");
        CheckAPI.postElemTest(potato);
        CheckAPI.getElemTest2(potato);
    }

    @Test
    public void testAddFruit() throws SQLException {
        PojoFood pinp = new PojoFood("Ананас", "Фрукт", true, "FRUIT");
        CheckAPI.postElemTest(pinp);
        CheckAPI.getElemTest2(pinp);
    }

    @BeforeEach
    public  void setUp() {
        CheckAPI.getElemTest();
    }

    @AfterEach
    public void tearDown() throws SQLException {
        CheckAPI.dataReset();
    }
}
