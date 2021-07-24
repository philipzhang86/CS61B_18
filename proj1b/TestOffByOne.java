import org.junit.Assert;
import org.junit.Test;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        boolean actural = offByOne.equalChars('a', 'b');
        Assert.assertTrue(actural);
        Assert.assertTrue(offByOne.equalChars('A', 'B'));
        Assert.assertTrue(offByOne.equalChars('%', '&'));

    }

}
