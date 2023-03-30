import java.util.Random;
import java.util.Scanner;

//@20z301

public class bully
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
    public void bullyAlgo()
    {
        process[] processq = new process[100];
        Random rand = new Random();
        for (int i = 0; i < processq.length; i++) {
            int stat = rand.nextInt(3) + 1;
            processq[i] = new process(i + 1, i + 1, stat < 2);

        }
        process coordinator = processq[max - 1];
        if(coordinator.status){
            System.out.println("Coordinator is Active.Its Process Details.\n");
            System.out.println(coordinator.deets());
        }
        else
        {
            processq[49].status = true;
            System.out.println("\nProcess "+(50)+" detects that Co-Ordinator has failed");
            System.out.println("\nBully Algorithmn Initiated...");
            int maxVal = -100;
            for (int i = 49; i < processq.length; i++) 
            {
                if(processq[i].status==false)
                    continue;
                int livecount = 0;
                int alive[] = new int[50];
                for (int j = i; j < processq.length; j++) 
                {
                    if(processq[j].status){
                        if(j > maxVal)
                        {
                            maxVal = j;
                        }
                        alive[livecount] = j + 1;
                        livecount++;
                    }
                }
            
                System.out.println("\n\nFor Process " + (i+1) + ", the Bully Algorithm detects the following processes:");
                for (int j = 1; j < livecount; j++)
                {
                    System.out.print(alive[j] + ", ");
                }
            }
            System.out.println("\nBully Algo elects Process Number - " + (maxVal+1)+ " as the next Coordinator.\nIts details are as follows :");
            System.out.println(processq[maxVal].deets());
        }
    }
    
    public static void main(String[] args) 
    {
        bully a = new bully();
        a.bullyAlgo();
        
    }
}
