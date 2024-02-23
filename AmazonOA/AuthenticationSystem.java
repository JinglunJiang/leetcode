import java.util.*;

public class AuthenticationSystem{

  Map<String, String> users = new HashMap<>();
  Set<String> loggedInUsers = new HashSet<>();

  public String register(String userName, String password){
    if (!users.containsKey(userName)){
      users.put(userName, password);
      return "Registered Successfully.";
    }
    else{
      return "Username already Exists.";
    }
  }

  public String login(String userName, String password){
    if (users.containsKey(userName) && users.get(userName).equals(password)){
      loggedInUsers.add(userName);
      return "Login Successfully.";
    }
    else{
      return "Login Unsuccessfully.";
    }
  }

  public String logout(String userName){
    if (loggedInUsers.contains(userName)){
      return "Logged out Successfully.";
    }
    else{
      return "Log out Unsuccessful.";
    }
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