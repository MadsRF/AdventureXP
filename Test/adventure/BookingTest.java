package adventure;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingTest {

        Booking b = new Booking();

    @Test
    public void getHey() {
        assertEquals(0, b.getHey());
    }
}