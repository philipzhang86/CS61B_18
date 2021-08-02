package byog.lab5;

import byog.Core.Room;
import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

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
            int x=RANDOM.nextInt(WIDTH);
            int y=RANDOM.nextInt(HEIGHT);
            int width=RANDOM.nextInt(WIDTH/10)+2;
            int height=RANDOM.nextInt(HEIGHT/5)+2;

            if(y+height+1>=HEIGHT||x+width+1>=WIDTH)
                continue;
            if(isOverLap(x,y,width,height))
                continue;
            buildRoom(x,y,width,height);
            rooms.add(new Room(x,y,width,height));
        }
    }

    private void buildRoom(int x,int y,int width,int height){
        //MapGenerator.scanRoom(x, y, width, height, positionOfRoom, world);
    }

    private boolean isOverLap(int x, int y, int width, int height){
        //+1 is make sure the width and height is exactly match the existing room
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


    public int showSetSize(){
        return rooms.size();
    }


    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);
        Room_Demo room_demo=new Room_Demo();

        ter.renderFrame(room_demo.roomGenerator());
        System.out.println(room_demo.showSetSize());
    }
}
