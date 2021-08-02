package byog.Core;

import byog.TileEngine.TERenderer;

public class MapVisualTest {
    public static void main(String[] args) {
        TERenderer ter =new TERenderer();
        ter.initialize(100,50);
        MapGenerator map =new MapGenerator(100,50,2356);
        ter.renderFrame(map.mapGenerator());
    }
}
