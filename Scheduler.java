import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.util.Collections;

public class Scheduler{
    
    public static ArrayList<Talk> makeTalks(String fileName) throws IOException
    {
        ArrayList<Talk> talkList = new ArrayList<>();
        try{ 
            File inFile = new File(fileName); //get file for scanner
            Scanner input = new Scanner(inFile);
            
            while(input.hasNext()){
              
              String name = input.next();
              Integer startTime = Integer.parseInt(input.next());
              Integer endTime = Integer.parseInt(input.next());
              
              Talk newTalk = new Talk(name, startTime, endTime);
              talkList.add(newTalk); //add new talk object
            }
        
            Collections.sort(talkList); //sort by end time
            input.close();
            
        }
        catch(NumberFormatException e) {    //if input file isn't right format
            System.out.println("The file formatting is not usable! Try again");
            talkList = new ArrayList<>(); //blank out talkList
            return talkList;
        }
        catch(IOException e) { 
            System.out.println("The file is not usable! Try again");
            talkList = new ArrayList<>();
            return talkList;
        }

        
        return talkList;
    }
    

    public static ArrayList<Talk> scheduleTalks(ArrayList<Talk> talks) 
    {
        ArrayList<Talk> newList = new ArrayList<>();
        Integer currentLatestOpening = 0; //set earliest opening
        
        for (int i = 0; i < talks.size(); i++) {
            if (talks.get(i).startTime >= currentLatestOpening){
                newList.add(talks.get(i));
                currentLatestOpening = talks.get(i).endTime;//update latest opening
            }
        }
        
        return newList;
    }
   

    
    
}