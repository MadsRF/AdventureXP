package adventure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActivityTest {

    Activity activity = new Activity();


    @Test
    void addActivty() {
        activity.addActivity();
    }

    @Test
    void deleteActivity() {
        assertFalse(activity.deleteActivity());
    }

    @Test
    void editActivity() {
        assertFalse(activity.editActivity());
    }
}