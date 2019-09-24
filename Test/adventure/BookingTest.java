package adventure;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookingTest {

        Booking b = new Booking();

    @Test
    public void getHey() {
        assertEquals(0, b.getHey());
    }
}