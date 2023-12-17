class FoodRatings {
    HashMap<String, PriorityQueue<Food>> map = new HashMap<>();
    HashMap<String, Food> menu = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++){
            Food curr = new Food(foods[i], cuisines[i], ratings[i]);
            if (!map.containsKey(cuisines[i])){
                map.put(cuisines[i], new PriorityQueue<>((a, b) -> {
                    if (b.rating == a.rating){
                        return a.name.compareTo(b.name);
                    }
                    else{
                        return b.rating - a.rating;
                    }
                }));
            }
            PriorityQueue<Food> pq = map.get(cuisines[i]);
            pq.add(curr);
            menu.put(foods[i], curr);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Food curr = menu.get(food);
        PriorityQueue<Food> pq = map.get(curr.cuisine);
        pq.remove(curr);
        curr.rating = newRating;
        pq.add(curr);
    }
    
    public String highestRated(String cuisine) {
        return map.get(cuisine).peek().name;
    }
}

class Food{
    int rating;
    String name, cuisine;
    Food(String name, String cuisine, int rating){
        this.name = name;
        this.cuisine = cuisine;
        this.rating = rating;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */