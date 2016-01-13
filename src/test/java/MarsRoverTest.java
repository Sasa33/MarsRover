import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MarsRoverTest {
    private MarsRover marsRover;

    @Before
    public void setUp() {
        marsRover = new MarsRover(0, 0, DIRECTION.NORTH);
    }

    @Test
    public void should_return_0_0_W_when_receive_L_command() {
        marsRover.execute("L");

        assertThat(marsRover.getOrientation(), is(DIRECTION.WEST));
    }

    @Test
    public void should_return_0_0_E_when_receive_R_command() {
        marsRover.execute("R");

        assertThat(marsRover.getOrientation(), is(DIRECTION.EAST));
    }

    @Test
    public void should_return_0_1_N_when_receive_M_command() {
        marsRover.execute("M");

        assertThat(marsRover.getPosition(), is("0 1"));
    }

    @Test
    public void should_return_0_2_E_when_receive_MMR_commands() {
        marsRover.execute("MMR");

        assertThat(marsRover.getPosition(), is("0 2"));
        assertThat(marsRover.getOrientation(), is(DIRECTION.EAST));
    }

    @Test
    public void should_return_1_3_N_when_start_at_1_2_N_and_receive_LMLMLMM_commands() {
        MarsRover newMarsRover = new MarsRover(1, 2, DIRECTION.NORTH);

        newMarsRover.execute("LMLMLMLMM");

        assertThat(newMarsRover.getPosition(), is("1 3"));
        assertThat(newMarsRover.getOrientation(), is(DIRECTION.NORTH));
    }

    @Test
    public void should_return_5_1_E_when_start_at_3_3_E_and_receive_MMRMMRMRRM_commands() {
        MarsRover newMarsRover = new MarsRover(3, 3, DIRECTION.EAST);

        newMarsRover.execute("MMRMMRMRRM");

        assertThat(newMarsRover.getPosition(), is("5 1"));
        assertThat(newMarsRover.getOrientation(), is(DIRECTION.EAST));
    }

    @Test
    public void should_return_1_0_E_when_receive_LMMRRM_commands() {
        marsRover.execute("LMMRRM");

        assertThat(marsRover.getPosition(), is("1 0"));
        assertThat(marsRover.getOrientation(), is(DIRECTION.EAST));
    }

    @Test
    public void should_return_5_1_N_when_start_at_4_0_N_and_receive_RMMRMMLLM_commands() {
        MarsRover newMarsRover = new MarsRover(4, 0, DIRECTION.NORTH);

        newMarsRover.execute("RMMRMMLLM");

        assertThat(newMarsRover.getPosition(), is("5 1"));
        assertThat(newMarsRover.getOrientation(), is(DIRECTION.NORTH));
    }
}
