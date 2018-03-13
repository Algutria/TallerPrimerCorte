package com.tallerzapatoszxy.tallerzapatoszxy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void price_calculator_test_for_men_classic_addidas() {
        double price = 80000;
        double cant = 2;

        assertEquals(Methods.calculatePrice(price, cant), 160000.00, 0);
    }

    @Test
    public void price_calculator_test_for_women_sneaker_puma() {
        double price = 110000;
        double cant = 1;

        assertEquals(Methods.calculatePrice(price, cant), 110000.00, 0);
    }

    @Test
    public void total_value_from_shoe_characteristics_for_men() {
        // 1 Man, Sneaker, Nike should be 120000
        int genderID = 0;
        int shoeTypeID = 0;
        int brandID = 0;
        double cant = 1.0;

        assertEquals(Methods.getShoesValueFromCharacteristics(genderID, shoeTypeID, brandID, cant), 120000.00, 0);
    }

    @Test
    public void total_value_from_shoe_characteristics_for_women() {
        // 2 Women, Classic, Puma should be 240000
        int genderID = 1;
        int shoeTypeID = 1;
        int brandID = 2;
        double cant = 2.0;

        assertEquals(Methods.getShoesValueFromCharacteristics(genderID, shoeTypeID, brandID, cant), 240000.00, 0);
    }
}