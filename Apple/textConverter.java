import java.util.*;
import java.io.*;

public class textConverter{

  public static String textConverter(String inputUrl){
    String[] strArray = customSplit(inputUrl);
    StringBuilder sb = new StringBuilder();
    for (int i = strArray.length - 1; i >= 0; i--){
      sb.append(strArray[i]);
      if (i != 0){
        sb.append(".");
      }
    }
    return sb.toString();
  }

  public static String[] customSplit(String inputUrl){
    List<String> list = new ArrayList<>();
    int i = 0;
    for (int j = 0; j < inputUrl.length(); j++){
      if (inputUrl.charAt(j) == '.'){
        list.add(inputUrl.substring(i, j));
        i = j + 1;
      }
    }
    list.add(inputUrl.substring(i));
    return list.toArray(new String[list.size()]);
  }

  public static void main(String[] args){
    String inputUrl = "www.baidu.com";
    System.out.println(textConverter(inputUrl));
  }
}