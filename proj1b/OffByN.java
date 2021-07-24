public class OffByN implements CharacterComparator {
    private final int index;

    public OffByN(int N) {
        this.index = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == index;
    }
}
