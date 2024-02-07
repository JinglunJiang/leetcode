class Solution {
    public boolean isRobotBounded(String instructions) {
        //Execute all the instruction once, if it change direction / didn't move => will stay in circle

        int[] start = {0, 0};
        String direction = "North";
        for (char c : instructions.toCharArray()){
            if (c == 'G'){
                if (direction.equals("North")){
                    start[1]++;
                }
                if (direction.equals("South")){
                    start[1]--;
                }
                if (direction.equals("East")){
                    start[0]--;
                }
                if (direction.equals("West")){
                    start[0]++;
                }
            }
            else if (c == 'L'){
                if (direction.equals("North")){
                    direction = "East";
                }
                else if (direction.equals("East")){
                    direction = "South";
                }
                else if (direction.equals("South")){
                    direction = "West";
                }
                else {
                    direction = "North";
                }
            }
            else if (c == 'R'){
                if (direction.equals("North")){
                    direction = "West";
                }
                else if (direction.equals("West")){
                    direction = "South";
                }
                else if (direction.equals("South")){
                    direction = "East";
                }
                else{
                    direction = "North";
                }
            }
        }
        if (start[0] == 0 && start[1] == 0){
            return true;
        }
        if (!direction.equals("North")){
            return true;
        }
        return false;
    }
}