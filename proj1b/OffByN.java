public class OffByN implements CharacterComparator {
    private int index;

    public OffByN(int N) {
        index = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == index;
    }
}
