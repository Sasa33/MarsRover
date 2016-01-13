
public class MarsRover {
    private int x;
    private int y;
    private char orientation;

    public MarsRover(int x, int y, char orientation) {
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
        switch (this.orientation) {
            case 'N': this.orientation = 'W'; break;
            case 'E': this.orientation = 'N'; break;
            case 'S': this.orientation = 'E'; break;
            case 'W': this.orientation = 'S'; break;
        }
    }

    public void turnRight() {
        switch (this.orientation) {
            case 'N': this.orientation = 'E'; break;
            case 'E': this.orientation = 'S'; break;
            case 'S': this.orientation = 'W'; break;
            case 'W': this.orientation = 'N'; break;
        }
    }

    public void move() {
        switch (orientation) {
            case 'N': y += 1; break;
            case 'E': x += 1; break;
            case 'S': y -= 1; break;
            case 'W': x -= 1; break;
        }
    }

    public char getOrientation() {
        return orientation;
    }

    public String getPosition() {
        return x + " " + y;
    }
}
