import java.util.*;

public class textConversion2 {

  public static String textConverter(String url){
    String[] arr = customSplit(url);
    StringBuilder sb = new StringBuilder();
    for (int i = arr.length - 1; i >= 0; i--){
      sb.append(arr[i]);
      if (i != 0){
        sb.append('.');
      }
    }
    return sb.toString();
  }

  public static String[] customSplit(String str){
    List<String> list = new ArrayList<>();
    int i = 0;
    for (int j = 0; j < str.length(); j++){
      if (str.charAt(j) == '.'){
        list.add(str.substring(i, j));
        i = j + 1;
        j = i + 1;
      }
    }
    list.add(str.substring(i));
    String[] result = new String[list.size()];
    for (int k = 0; k < list.size(); k++){
      result[k] = list.get(k);
    }
    return result;
  }

  public static void main(String[] args){
    System.out.println(textConverter("www.baidu.com.abf.uuu"));
  }
}