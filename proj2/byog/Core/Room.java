package byog.Core;

public class Room {
    private final int x;
    private final int y;
    private final int WIDTH;
    private final int HEIGHT;

    public Room(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.WIDTH = width;
        this.HEIGHT = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }
}
