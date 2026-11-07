

public class TextTools {

    public static boolean isPalinDrome(String text){
        if (text==null ||text.isEmpty()){
            throw new IllegalArgumentException("text cannot be empty");
        }
        StringBuilder string=new StringBuilder(text);
        return text.equalsIgnoreCase(string.reverse().toString());
    }


    public static void main(String[] args) {
        String name= "abuki";
        String name1 = "level";
        String name2 ="Madam";
        System.out.println(isPalinDrome(name));
        System.out.println(isPalinDrome(name1));
        System.out.println(isPalinDrome(name2));


    }
}

