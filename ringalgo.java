import java.util.Random;
import java.util.Scanner;

//@20z301

public class ringalgo
{
    int max = 100;
    class process
    {
        int id, priority;
        boolean status;
        String name;

        public process(int id, int priority, boolean status) 
        {
            this.id = id;
            this.priority = priority;
            this.status = status;
        }

        public String deets() 
        {
            return "\nProcess ID = " + id +"\nProces Priority = " + priority + "\nProcess Status = " + (status?"Alive":"Dead");
        }
        
        
    }
    public void ringelect()
    {
        process[] processq = new process[100];
        Random rand = new Random();
        for (int i = 0; i < processq.length; i++) 
        {
            int stat = rand.nextInt(3) + 1;
            processq[i] = new process(i + 1, i + 1, stat < 2);
            //System.out.println(processq[i].id+" "+processq[i].status);
        }
        process coordinator = processq[max - 1];
        
        if(coordinator.status)
        {
            System.out.println("Coordinator is Alive. Its Process Details.\n");
            System.out.println(coordinator.deets());      
        }
        else
        {
            //int elect = rand.nextInt(100);
            processq[49].status = true;
            System.out.println("\nProcess "+(50)+" detects that Co-Ordinator has failed");
            System.out.println("\nElection Message Sent...");
           
            int maxVal = -100;
            int i = 50;
            int livecount = 1;
            int alive[] = new int[100];
            alive[0]=50;
            while(i!=49)
            {
                //System.out.println("hello "+(i));
                if(i==100) 
                    i=0;
                if(processq[i].status==false)
                {
                    i++;
                    continue;
                }
                else
                {
                    alive[livecount]=i+1;
                    livecount++;
                }
                i=i+1;
            }
            System.out.println("\n\nThe following are the Alive Processes :");
            for (int j = 0; j < livecount; j++)
            {
                System.out.print((alive[j]) + ", ");
                if(alive[j]>maxVal)
                    maxVal=alive[j];
            }
            System.out.println("\n\nRing Algo elects Process Number - " + maxVal+ " as the next Coordinator.\nIts details are as follows :");
            System.out.println(processq[maxVal-1].deets());//-1 because we are accesing address
            System.out.println("\nAll processes accept Process "+maxVal+" as the Coordinator.");
        }
    }
    
    public static void main(String[] args) 
    {
        ringalgo a = new ringalgo();
        a.ringelect();
        
    }
}
