import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MarsRoverTest {
    private MarsRover marsRover;

    @Before
    public void setUp() {
        marsRover = new MarsRover(0, 0, 'N');
    }

    @Test
    public void should_return_0_0_W_when_receive_L_command() {
        marsRover.execute("L");

        assertThat(marsRover.getOrientation(), is('W'));
    }

    @Test
    public void should_return_0_0_E_when_receive_R_command() {
        marsRover.execute("R");

        assertThat(marsRover.getOrientation(), is('E'));
    }


}