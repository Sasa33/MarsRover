
public class MarsRover {
    private int x;
    private int y;
    private DIRECTION orientation = DIRECTION.NORTH;
    private int boundary_x;
    private int boundary_y;


    public MarsRover(int x, int y, DIRECTION orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.boundary_x = 5;
        this.boundary_y = 5;
    }

    public MarsRover(int x, int y, DIRECTION orientation, int boundary_x, int boundary_y) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.boundary_x = boundary_x;
        this.boundary_y = boundary_y;
    }

    public void execute(String commands) {
        for (char command : commands.toCharArray())
            execute(command);
    }

    public void execute(char command) {
        switch (command) {
            case 'L':
                turnLeft();
                break;
            case 'R':
                turnRight();
                break;
            case 'M':
                if( !isCrossingBoundary())
                    move();
                break;
        }
    }

    public boolean isCrossingBoundary() {
        return (this.orientation.equals(DIRECTION.NORTH) && this.y == this.boundary_y)
                || (this.orientation.equals(DIRECTION.EAST) && this.x == this.boundary_x)
                || (this.orientation.equals(DIRECTION.SOUTH) && this.y == 0)
                || (this.orientation.equals(DIRECTION.WEST) && this.x == 0);
    }

    public void turnLeft() {
        int index = this.orientation.ordinal();
        int length = DIRECTION.values().length;
        this.orientation = (index <= 0) ? DIRECTION.values()[index + length - 1] : DIRECTION.values()[index - 1];
    }

    public void turnRight() {
        int index = this.orientation.ordinal();
        int length = DIRECTION.values().length;
        this.orientation = (index >= (length - 1)) ? DIRECTION.values()[index - length + 1] : DIRECTION.values()[index + 1];
    }

    public void move() {
        switch (this.orientation) {
            case NORTH: y += 1; break;
            case EAST: x += 1; break;
            case SOUTH: y -= 1; break;
            case WEST: x -= 1; break;
        }
    }

    public DIRECTION getOrientation() {
        return orientation;
    }

    public String getPosition() {
        return x + " " + y;
    }
}
