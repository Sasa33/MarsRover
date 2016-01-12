
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
        if(commands.equals("L")){
            this.orientation = 'W';
        } else if(commands.equals("R")){
            this.orientation = 'E';
        }
    }

    public char getOrientation() {
        return orientation;
    }
}
