import java.io.IOException;
import java.util.*;

public class CountOfSubstring {

    Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
    Map<Character, Integer> freqs = new HashMap<>();
    int consnantCount = 0;
    int limit = 0;


/*
    public long countOfSubstrings(String word, int k) {
        return substringsWithAtMost(word, k) - substringsWithAtMost(word, k - 1);
    }
*/
    // Return the number of substrings containing every vowel with at most k
    // consonants.
    private long substringsWithAtMost(String word, int k) {
        if (k == -1)
            return 0;

        long res = 0;
        int vowels = 0;
        int uniqueVowels = 0;
        Map<Character, Integer> vowelLastSeen = new HashMap<>();

        for (int l = 0, r = 0; r < word.length(); ++r) {
            if (isVowel(word.charAt(r))) {
                ++vowels;
                if (!vowelLastSeen.containsKey(word.charAt(r)) || vowelLastSeen.get(word.charAt(r)) < l)
                    ++uniqueVowels;
                vowelLastSeen.put(word.charAt(r), r);
            }
            while (r - l + 1 - vowels > k) {
                if (isVowel(word.charAt(l))) {
                    --vowels;
                    if (vowelLastSeen.get(word.charAt(l)) == l)
                        --uniqueVowels;
                }
                ++l;
            }
            if (uniqueVowels == 5) {

                final int minVowelLastSeen = Arrays.asList('a', 'e', 'i', 'o', 'u')
                        .stream()
                        .mapToInt(vowel -> vowelLastSeen.get(vowel))
                        .min()
                        .getAsInt();
                res += minVowelLastSeen - l + 1;
            }
        }

        return res;
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

    public long countOfSubstrings(String word, int k) {
        limit = k;

        int lead = 0;
        int pre = 0;
        long res = 0;

        for (;lead < word.length(); lead++) {
            char ch = word.charAt(lead);
            if (vowels.contains(ch)) {
                this.freqs.put(ch,freqs.getOrDefault(ch, 0) + 1);
                if (this.checkCondition()) {
                    res++;
                }
            }else if (this.checkCondition()) {
                while(this.consnantCount == this.limit && pre < lead) {
                    char preCh = word.charAt(pre);
                    if (vowels.contains(preCh)) {
                        if (this.freqs.get(preCh) == 1) {
                            this.freqs.remove(preCh);
                        }
                        else {
                            this.freqs.put(ch,freqs.getOrDefault(ch, 0) - 1);
                            if (this.checkCondition()) {
                                res++;
                            }
                        }
                    }
                    else {
                        this.consnantCount--;
                    }
                    pre++;
                }
                this.consnantCount++;
            }
            else if (this.consnantCount == this.limit) {

            }

        }

        return res;
    }

    private boolean checkCondition() {
        return freqs.containsKey('a')
                && freqs.containsKey('e')
                && freqs.containsKey('i')
                && freqs.containsKey('o')
                && freqs.containsKey('u')
                && this.consnantCount == this.limit;
    }

    private boolean letterOk(Map<Character, Integer> freqs) {
        return freqs.containsKey('a') && freqs.containsKey('e') && freqs.containsKey('i') && freqs.containsKey('o') && freqs.containsKey('u');
    }

    public static void main(String[] args) throws IOException {

        CountOfSubstring sum = new CountOfSubstring();
        long r = sum.countOfSubstrings("ieaouqqieaouqq",1);
        System.out.println(r);

    }
}
