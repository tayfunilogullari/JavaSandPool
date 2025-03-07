import java.io.IOException;

public class SentenceSimilarity {

    public boolean areSentencesSimilar(String sentence1, String sentence2) {

        if (sentence1.equals(sentence2))
            return true;

        if (sentence1.length() < sentence2.length()){
            return areSentencesSimilar(sentence2, sentence1);
        }

        if (sentence1.charAt(0) == sentence2.charAt(0))
        {
            /*if (sentence1.startsWith(sentence2))
                return true;*/

            int lastSpaceIndex = -1;
            int i = 1;
            for (; i <sentence2.length(); i++)
            {
                if (sentence1.charAt(i) != sentence2.charAt(i))
                    break;
                else if (sentence1.charAt(i) == ' ')
                    lastSpaceIndex = i;
            }

            if (sentence2.length() == i && sentence1.charAt(i) == ' ')
                return true;

            sentence2 = sentence2.substring(lastSpaceIndex+1);
        }

        if (sentence1.endsWith(sentence2))
        {
            if (sentence1.charAt(sentence1.lastIndexOf(sentence2) - 1 ) == ' ')
                return true;

            return  false;
        }

        return false;

        /*

        String[] arr1 = sentence1.split("\\s+");
        String[] arr2 = sentence2.split("\\s+");
        int length1 = arr1.length;
        int length2 = arr2.length;

        if (arr1 == arr2 || length1 == 0 || length2 == 0)
            return true;

        if (length1 < length2)
        {
            arr1 = sentence2.split("\\s+");
            arr2 = sentence1.split("\\s+");

            length1 = arr1.length;
            length2 = arr2.length;
        }

        if (arr1[0].equals(arr2[0]))
        {
            if (length2 == 1)
                return true;

            int index = 1;
            while (arr1[index].equals(arr2[index]))
            {
                index++;
                if (index == length2)
                    return true;
            }

            length1--;
            length2--;
            while (arr1[length1].equals(arr2[length2]))
            {
                if (index == length2)
                    return true;

                length1--;
                length2--;
            }

            return false;
        }
        else if (arr1[length1 - 1].equals(arr2[length2 - 1]))
        {
            length1--;
            length2--;
            while (arr1[length1].equals(arr2[length2]))
            {
                length1--;
                length2--;

                if (-1 == length2)
                    return true;
            }
            return  false;
        }
        else
            return false;*/
    }



    public static void main(String[] args) throws IOException {

        SentenceSimilarity sen = new SentenceSimilarity();
        boolean r = sen.areSentencesSimilar("Eating right now", "Eating");
        System.out.println(r);
        r = sen.areSentencesSimilar("Frog cool", "Frogs are cool");
        System.out.println(r);

    }
}
