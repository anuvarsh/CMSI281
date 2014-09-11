import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

import edu.lmu.cmsi.mike.mavenperson.person;

public class PersonTest {

    @Test
    public void personAgeTest() {
        Person p = new Person(99, "Mike", "Megally", 10, 10, true, true);
        assertEquals("failure - age didn't match", 99, p.getAge());
    }
}