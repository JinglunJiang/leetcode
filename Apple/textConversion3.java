import java.util.*;

class textConversion {

    public String textConversion(String inputString){
        /*
        Input:
        Output:
        
        */
        // Store the input string in an array seperated by the seperator '.'.
        String[] array = inputString.split('\\.');
        StringBuilder sb = new StringBuilder();
        
        // Iterate through the array backwards
        for (int i = array.length - 1; i >= 0; i--){
            sb.append(array[i]);
            // When it is not the last part, append the '.' back.
            if (i != 0){
                sb.append('.');
            }
        }

        // Convert back to string type and return.
        return sb.toString();
    }

    public static void main(String[] args){

    }
}
