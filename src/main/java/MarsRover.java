
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
                this.orientation = 'W';
                break;
            case 'R':
                this.orientation = 'E';
                break;
            case 'M':
                move();
                break;
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
