public class Train {
    private String name, product, origin, destination;
    private int weight, miles;

    public Train( String n, String p, String o, String d, int w, int m){
        name = n; product = p; origin = o; destination = d; weight = w; miles = m;
    }//end of method 

    public Train(String n, String d){
        name = n; destination = d;
    }//end of method 

    public String getName(){
        return name;
    }//end of method 
    public String getProduct(){
        return product; 
    }//end of method 
    public String getOrigin(){
        return origin;
    }//end of method 
    public String getDestination(){
        return destination;
    }//end of method 
    public int getWeight(){
        return weight;
    }//end of method 
    public int getMiles(){
        return miles;
    }//end of method 

    public String toString(){
        return name + " containg " + product;
    }//end of method 
}//end of class 
