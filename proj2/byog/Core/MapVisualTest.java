
package byog.Core;

import byog.TileEngine.TERenderer;

public class MapVisualTest {
    public static void main(String[] args) {
        TERenderer ter=new TERenderer();
        ter.initialize(101,51);
        WorldGenerator map=new WorldGenerator(101,51,423234124);
        ter.renderFrame(map.mapGenerator());
    }
}
