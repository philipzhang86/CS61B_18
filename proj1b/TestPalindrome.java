import org.junit.Assert;
import org.junit.Test;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

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
    }

    @Test
    public void testIsPalindromeOverloading() {
        CharacterComparator cc = new OffByOne();
        Assert.assertTrue(palindrome.isPalindrome("ab", cc));
        Assert.assertTrue(palindrome.isPalindrome("", cc));
        Assert.assertFalse(palindrome.isPalindrome("abcba", cc));
        Assert.assertTrue(palindrome.isPalindrome("gdseh", cc));

    }
}
