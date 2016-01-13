
public class MarsRover {
    private int x;
    private int y;
    private DIRECTION orientation = DIRECTION.NORTH;


    public MarsRover(int x, int y, DIRECTION orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
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
                move();
                break;
        }
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
