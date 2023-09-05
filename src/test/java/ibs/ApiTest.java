package ibs;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class ApiTest {

    @Test
    public void testAddVegetable() throws SQLException {
        PojoFood kart = new PojoFood("Картофель", "Овощ", false, "VEGETABLE");
        CheckAPI.getElemTest();
        CheckAPI.postElemTest(kart);
        CheckAPI.dataReset();
    }

    @Test
    public void testAddFruit() throws SQLException {
        PojoFood kart = new PojoFood("Ананас", "Фрукт", true, "FRUIT");
        CheckAPI.getElemTest();
        CheckAPI.postElemTest(kart);
        CheckAPI.dataReset();
    }
}
