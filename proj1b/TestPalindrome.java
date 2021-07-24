import org.junit.Assert;
import org.junit.Test;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        Assert.assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        boolean actual = palindrome.isPalindrome("level");
        Assert.assertTrue(actual);
        Assert.assertTrue(palindrome.isPalindrome("civic"));
        Assert.assertTrue(palindrome.isPalindrome("flake", offByOne));
    }

}
