public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new LinkedListDeque<>();

        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }

        return deque;
    }

    public boolean isPalindrome(String word) {
        if (word.length() < 1) {
            return true;
        }

        Deque<Character> deque = wordToDeque(word);
        while (deque.size() > 1) {
            if (!deque.removeLast().equals(deque.removeFirst())) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() < 1) {
            return true;
        }

        Deque<Character> deque = wordToDeque(word);
        while (deque.size() > 1) {
            if (!cc.equalChars(deque.removeFirst(), deque.removeLast())) {
                return false;
            }
        }
        return true;
    }

}
