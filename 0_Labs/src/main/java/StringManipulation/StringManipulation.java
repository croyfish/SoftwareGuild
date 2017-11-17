/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringManipulation;

/**
 *
 * @author jeffc
 */
public class StringManipulation {

    public static void main(String[] args) {

        String model = "I am the very model of a modern Major-General\n"
                + "I've information vegetable, animal, and mineral\n"
                + "I know the kings of England, and I quote the fights historical\n"
                + "From Marathon to Waterloo, in order categorical\n"
                + "I'm very well acquainted, too, with matters mathematical\n"
                + "I understand equations, both the simple and quadratical\n"
                + "About binomial theorem I am teeming with a lot o' news\n"
                + "With many cheerful facts about the square of the hypotenuse";
        

        System.out.println(model);
        System.out.println("\n\n\n");

        // charAt
        System.out.println("The 4th character (3rd index) in the string is: " + model.charAt(3));

        System.out.println("It should be 'm'\n\n\n");

        // split
        String[] tokens = model.split(" ");
        System.out.println("This is the string split by words into tokens:");
        for (String currentToken : tokens) {
            System.out.println(currentToken);
        }

        System.out.println("\n\n\n");

        // subSequence
        System.out.println("This is a subsequence of the string before index 45:");
        System.out.println(model.subSequence(0, 45));

        System.out.println("This is the string split before index 44 (one character too short):");
        System.out.println(model.subSequence(0, 44));

        System.out.println("\n\n\n");

        // trim
        System.out.println("This is the string with all blank spaces removed (at the beginning and end):");
        System.out.println(model.trim());

        System.out.println("\n\n\n");

        // toLowerCase / toUpperCase
        System.out.println("This is the string in all lower case letters:");
        System.out.println(model.toLowerCase());
        
        System.out.println("\n\n\n");

        System.out.println("This is the string in all upper case letters:");
        System.out.println(model.toUpperCase());

        System.out.println("\n\n\n");

        // indexOf / lastIndexOf
        System.out.println("The first index of the character 'v' is: " + model.indexOf('v'));
        
        System.out.println("\n\n\n");        
        
        System.out.println("The last index of the character 'v' is: " + model.lastIndexOf('v'));

        System.out.println("\n\n\n");        

        System.out.println("The first index of lower case a (#97) is: " + model.indexOf(97));
        
        System.out.println("\n\n\n");        
        
        System.out.println("The last index of lower case a (#97) is: " + model.lastIndexOf(97));

        System.out.println("\n\n\n");

        // contains
        System.out.println("Does the string contain a capital letter 'W'? " + model.contains("W"));
        
        System.out.println("\n\n\n");        
        
        System.out.println("Does the string contain a capital letter 'Z'? " + model.contains("Z"));

        System.out.println("\n\n\n");

        // replace / replaceAll / replaceFirst
        System.out.println("This is the string with all a's replaced by e's: " + model.replace('a', 'e'));
        
        System.out.println("\n\n\n");        
        
        System.out.println("This is the string with all the's replaced by da's: " + model.replace("the", "da"));
        
        System.out.println("\n\n\n");        
        
        System.out.println("This is the string with all words starting with 'I' replaced with 'eye':"
                + model.replaceAll("I* ", "eye"));
        
        System.out.println("\n\n\n");        
        
        System.out.println("This is the string with the first instance of 'the' replaced with 'firstthe': "
                + model.replaceFirst("t*e", "firstthe"));

        // reverse
        System.out.println("Here is the string 'horse' reversed: " + anotherReverse("horse"));
        
    }

    public static String reverse(String input) {
        char[] in = input.toCharArray();
        int begin = 0;
        int end = in.length - 1;
        char temp;
        while (end > begin) {
            temp = in[begin];
            in[begin] = in[end];
            in[end] = temp;
            end--;
            begin++;
        }
        return new String(in);
    }
    
    public static String anotherReverse(String input) {
        
        char[] in = input.toCharArray();
        char[] out = in;
        
        for (int i = 0; i < in.length; i++) {
            char currentValue = in[in.length-i-1];
            out[i] = currentValue;
        }
        return new String(out);
    }

    
    
}
