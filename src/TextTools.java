
import java.util.Arrays;
public class TextTools {

    public static boolean isPalinDrome(String text){
        if (text==null ||text.isEmpty()){
            throw new IllegalArgumentException("text cannot be empty");
        }
        StringBuilder string=new StringBuilder(text);
        return text.equalsIgnoreCase(string.reverse().toString());
    }

    public static boolean isAnagram(String first, String second){
        if (first==null||first.isEmpty() || second==null||second.isEmpty()){
            throw new IllegalArgumentException("String cannot be empty or null");
        }

        if (first.length()!=second.length()){

            return false;
        }
        first=first.toLowerCase();
        second=second.toLowerCase();
        char[] firstArray=first.toCharArray();
        char[] secondArray=second.toCharArray();
        Arrays.sort(firstArray);
        Arrays.sort(secondArray);

        return Arrays.equals(firstArray,secondArray);


    }
    public static int countWords(String sentence){
        if (sentence==null ||sentence.isEmpty()){
            throw new IllegalArgumentException(" sentence cannot be empty or null");
        }
        String cleanText=sentence.strip();

        if (cleanText.isEmpty()) {
            throw new IllegalArgumentException("Sentence cannot be blank");
        }
        int count=0;
        for (String word : cleanText.split("\\s+")){
            count++;
        }

        return count;
    }


    public static void main(String[] args) {
        String name= "abuki";
        String name1 = "level";
        String name2 ="Madam";
        String text3="A man, a plan, a canal: Panama";
        System.out.println(isPalinDrome(name));
        System.out.println(isPalinDrome(name1));
        System.out.println(isPalinDrome(name2));

        System.out.println("Anagram Check");
        System.out.println(isAnagram("carmon", "moncar"));
        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("hello", "world"));
        System.out.println(isAnagram("Heart", "Earth"));

        System.out.println("countWords");
        System.out.println(countWords(text3));
        System.out.println(countWords("I love programming"));
        System.out.println(countWords(" Java   is   powerful"));
        try {
            System.out.println(countWords("   "));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }



    }
}

