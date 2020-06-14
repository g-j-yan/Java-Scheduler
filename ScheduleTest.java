import java.util.ArrayList;
import java.io.*;

public class ScheduleTest{

    public static void main(String[] args){

        if (args.length>0)
        {
	        try
            {   //make ArrayList of talks
                ArrayList<Talk> talks = Scheduler.makeTalks(args[0]);
                  
                // pass the ArrayList of talks to scheduleTalks
                ArrayList<Talk> scheduledTalks=Scheduler.scheduleTalks(talks);

                // print list of scheduled talks
                for (Talk talk:scheduledTalks){
                    System.out.println(talk);
                }
            }		
	        catch(IOException e)
            {	    
                System.out.println("There is a problem with the file you specified");
            }

        }
	    else
        {
            System.out.println("You must specify a file name at the command line");
        }
    }
}    
