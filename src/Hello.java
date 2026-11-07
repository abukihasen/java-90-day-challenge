public class Hello {
    public static void main(String[]args){
        System.out.println("Hello, java");
        System.out.println("java version: " + System.getProperty("java.version"));
        System.out.println("java vendor : " + System.getProperty("java.vendor"));
        System.out.println("OS Name     : " + System.getProperty("os.name"));
        System.out.println("OS Arch     : " + System.getProperty("os.arch"));
        System.out.println("User Name   : " + System.getProperty("user.name"));


    }
}
