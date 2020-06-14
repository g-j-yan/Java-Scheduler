public class Talk implements Comparable<Talk> {
    
    public String name;
    public Integer startTime;
    public Integer endTime;
    
    private static Integer ordering = 0; //order that the talk will be scheduled
    
    public Talk(String nameIn, Integer startTimeIn, Integer endTimeIn) {
        name = nameIn;
        startTime = startTimeIn;
        endTime = endTimeIn;        
    }
    
   
    public int compareTo(Talk other) {          
        return this.endTime.compareTo(other.endTime); 
    }          
    
    public String toString() {          //returns info and increments ordering
        ordering++;
        return ordering+") "+name+", Start @ "+startTime+", End @ "+endTime;
    }
        
}