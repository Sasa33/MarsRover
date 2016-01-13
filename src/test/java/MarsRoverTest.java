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

    @Test
    public void should_return_0_1_N_when_receive_M_command() {
        marsRover.execute("M");

        assertThat(marsRover.getPosition(), is("0 1"));
    }

    @Test
    public void should_return_0_2_E_when_receive_MMR_command() {
        marsRover.execute("MMR");

        assertThat(marsRover.getPosition(), is("0 2"));
        assertThat(marsRover.getOrientation(), is('E'));
    }

    @Test
    public void should_setup_a_new_start_point_and_execute_multiple_commands() {
        MarsRover newMarsRover = new MarsRover(1, 2, 'N');

        newMarsRover.execute("LMLMLMLMM");

        assertThat(newMarsRover.getPosition(), is("1 3"));
        assertThat(newMarsRover.getOrientation(), is('N'));
    }
}
