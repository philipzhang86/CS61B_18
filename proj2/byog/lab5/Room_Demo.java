/*
package byog.lab5;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import javax.swing.text.Position;
import java.util.HashSet;
import java.util.Random;

public class Room_Demo {
    private static final int WIDTH = 120;
    private static final int HEIGHT = 60;

    private static final long SEED = 2873123;
    private static final Random RANDOM = new Random(SEED);

    private  TETile[][]positionOfRoom;
    private  TETile[][]world;
    private  HashSet<Room> rooms;

    public Room_Demo(){
        positionOfRoom=new TETile[WIDTH][HEIGHT];
        world=new TETile[WIDTH][HEIGHT];
        rooms=new HashSet<>();
    }

    private void initializeWorldArray(){
        for (int x=0;x<WIDTH;x++)
            for (int y=0;y<HEIGHT;y++){
                positionOfRoom[x][y]=Tileset.NOTHING;
                world[x][y]= Tileset.NOTHING;
            }
    }

    private void fillWithRoom(){
        for(int i=0;i<50;i++){
            Position p= new Position(RANDOM.nextInt(WIDTH),RANDOM.nextInt(HEIGHT));

            int width=RANDOM.nextInt(WIDTH/10)+2;
            int height=RANDOM.nextInt(HEIGHT/5)+2;

            if(p.getY()+height+1>=HEIGHT||p.getX()+width+1>=WIDTH)
                continue;
            if(isOverLap(p,width,height))
                continue;
            buildRoom(p,width,height);
            //rooms.add(new Room(p,width,height));
        }
    }

    private void buildRoom(Position p ,int width,int height){
        int x=p.getX();
        int y=p.getY();
        scanRoom(x, y, width, height, positionOfRoom, world);
    }

    public static void scanRoom(int x, int y, int width, int height, TETile[][] positionOfRoom, TETile[][] world) {
        for (int i = x; i <= x + width + 1; i++) {
            for (int j = y; j <= y + height + 1; j++) {
                if (i == x || i == x + width + 1 || j == y || j == y + height + 1) {
                    positionOfRoom[i][j] = Tileset.WALL;
                    world[i][j] = Tileset.WALL;
                    continue;
                }
                //由于FLOOR和在房间外的迷宫的连通条件相冲突，
                //所以先在房间内部填GRASS
                world[i][j] = Tileset.GRASS;
                positionOfRoom[i][j] = Tileset.GRASS;
            }
        }
    }

    private boolean isOverLap(Position p, int width, int height){
        //+1 is make sure the width and height is exactly match the existing room
        int x=p.getX();
        int y=p.getY();
        for (int i=x;i<=x+width+1;i++){
            for (int j=y;j<=y+height+1;j++){
                if(positionOfRoom[i][j]==Tileset.WALL||positionOfRoom[i][j]==Tileset.GRASS){
                    return true;
                }
            }
        }
        return false;
    }

    public TETile[][] roomGenerator(){
        initializeWorldArray();
        fillWithRoom();
        return world;
    }


//    public int showSetSize(){
//        return rooms.size();
//    }


    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);
        Room_Demo room_demo=new Room_Demo();

        ter.renderFrame(room_demo.roomGenerator());
        //System.out.println(room_demo.showSetSize());
    }
}
*/
