package byog.Core;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.LinkedList;
import java.util.Random;

public class HallWay {
    public static TETile[][] world;

    public TETile[][] HallwayGenerator(){
        world = new TETile[101][51];//基数才不会空一行
        initializeHallWay(world);
        System.out.println(RandomStart(world,315332));
        System.out.println(generateHallWay(world,315332));
        return world;
    }

    //随机找一个起始点
    public static Position RandomStart(TETile[][] world, long seed){
        Random RANDOM = new Random(seed);

        while (true){
            int startX=RANDOM.nextInt(world.length-2);
            if(startX>= world.length){
                continue;
            }
            int startY=RANDOM.nextInt(world[0].length-2);
            if(startY>= world[0].length){
                continue;
            }
            startX=startX%2==1?startX:startX+1;
            startY=startY%2==1?startY:startY+1;
            if (world[startX][startY]==Tileset.NOTHING){
                return new Position(startX,startY);
            }
        }
    }

    //初始化
    public static void initializeHallWay(TETile[][] world){
        for(int i=0;i<= world.length-1;i++){
            for(int j=0;j<=world[0].length-1;j++){
                world[i][j]= Tileset.WALL;
            }
        }
        for (int i=1;i<=world.length-2;i+=2){
            for (int j=1;j<=world[0].length-2;j+=2){
                world[i][j]=Tileset.NOTHING;
            }
        }
    }

    public static void pingPoint(Position p, TETile[][] world){
        world[p.getX()][p.getY()]=Tileset.GRASS;
    }

    //凿墙的
    private static void availablePositions(Position p, TETile[][] world, LinkedList<Position> pList,long seed){
        int[][]nextDirection={
                {2,0},
                {0,-2},
                {-2,0},
                {0,2}
        };
        Random RANDOM =new Random(seed);
        //标记每一个方向是否走过
        boolean[] book =new boolean[4];
        //只能连接一次
        boolean isConnected=false;
        while (!book[0] || !book[1] || !book[2] || !book[3] ){
             //随机选取一个方向
            int next=RANDOM.nextInt(4);
            //如果这个方向已经走过了，则重新选择方向
            if(book[next]) continue;
            book[next] =true;
            int nextX=p.x+nextDirection[next][0];
            int nextY=p.y+nextDirection[next][1];
            //如果这个点越界了，就选下一个点
            if (nextX<0||nextX>world.length-1||nextY<0||nextY>world[0].length-1)
                continue;
            //如果这个点什么也没有，符合要求，加入候选队列
            if (Tileset.NOTHING.equals(world[nextX][nextY])){
                //将该点变为Flower，标记它在候选队列中
                world[nextX][nextY]=Tileset.FLOWER;//我将Flower改成floor
                pList.offer(new Position(nextX,nextY));
            }
            //如果这个点已经经过，就将它们相连，即打通它们之间的墙
            if(Tileset.FLOOR.equals(world[nextX][nextY]) && !isConnected){
                int mx=(p.x+nextX)/2;
                int my=(p.y+nextY)/2;
                //将它们之间的墙变为FLOOR
                world[mx][my]=Tileset.FLOOR;
                isConnected=true;
            }
        }
    }


    private static void generateHallWay(TETile[][] world, Position start, long seed){
        LinkedList<Position> pList=new LinkedList<>();
        pList.add(start);
        Random RANDOM =new Random(seed);
        while (!pList.isEmpty()){
            //随机获取一个点
            int index=RANDOM.nextInt(pList.size());
            Position cirPos=pList.get(index);
            //当前点的位置
            int curX=cirPos.x;
            int curY=cirPos.y;
            //将该点置为FLOOR，标记该点已经被走过
            world[curX][curY]=Tileset.FLOOR;
            //将这个点周围的空的点加入候选队列，顺便打通和已经过的点之间的墙
            availablePositions(cirPos,world,pList,seed);
            pList.remove(index);
        }
    }

    public static boolean generateHallWay(TETile[][] world, long seed){
        //随机找一个起始点
        Position start=RandomStart(world,seed);
        generateHallWay(world,start,seed);
        //必须保证生成的地图所有地点都可达，如果有没有连接到的点，就存在不可达的点，需要重新生成地图
        for (TETile[] teTiles : world) {
            for (int j = 0; j < world[0].length; j++) {
                if (teTiles[j].equals(Tileset.NOTHING)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(101, 51);
        HallWay hallWay=new HallWay();
        ter.renderFrame(hallWay.HallwayGenerator());

    }
}
