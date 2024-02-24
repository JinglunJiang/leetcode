import java.util.*;

public class AuthenticationSystem2{

  Map<String, String> users = new HashMap<>();
  Set<String> loggedInUsers = new HashSet<>();

  public String register(String userName, String password){
    if (!user.containsKey(userName)){
      users.put(userName, password);
      return "log in successful.";
    }
    else{
      return "login unsuccessful.";
    }
  }

  public String login(String userName, String password){
    if ()
  }

  public String logout(String userName){

  }

  public static void main(String[] args) {
    AuthenticationSystem system = new AuthenticationSystem();

    // Test the system
    System.out.println(system.register("john_doe", "password123")); // Registered Successfully
    System.out.println(system.register("john_doe", "password123")); // Username already exists
    System.out.println(system.login("john_doe", "password123"));     // Logged In Successfully
    System.out.println(system.logout("john_doe"));                   // Logged Out Successfully
  }
}