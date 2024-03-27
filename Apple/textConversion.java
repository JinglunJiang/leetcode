import java.util.*;

public class textConversion {
  public static String textConversion(String url){
    String[] arr = url.split("\\.");
    StringBuilder sb = new StringBuilder();
    for (int i = arr.length - 1; i >= 0; i--){
      sb.append(arr[i]);
      if (i != 0){
        sb.append('.');
      }
    }
    return sb.toString();
  }

  public static void main(String[] args){
    System.out.println(textConversion("com.baidu.www"));
  }
}



