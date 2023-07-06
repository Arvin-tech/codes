/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.projectbankaccountsystem.cpuprocessscheduling;

/**
 *
 * @author Acer
 */
import java.util.*;
public class ProcessScheduling {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[]args){
        int choice;
        do{
            System.out.print("\f\tMenu");
            System.out.print("\n1.First Come First Serve (Non-Preemptive)\n2.Shortest Job First (Non-Preemptive)"
                +"\n3.Shortest Job First (Preemptive)\n4.Round Robin"
                +"\n5.Shortest Remaining Time First\n0.Exit Application");

            System.out.print("\n");
            System.out.print("\nChoose a Scheduling Algorithm:");
            choice = sc.nextInt();

            switch(choice){
                case 1: System.out.println("\nChoosen Algorithm: First Come First Serve algorithm");
                    FirstComeFirstServe(); //method call
                    break;

                case 2: System.out.println("\nChoosen Algorithm: Shortest Job First (Non-Preemptive)");
                    ShortestJobNonPreemptive(); //method call
                    break;

                case 3: System.out.println("\nChoosen Algorithm: Shortest Job First (Preemptive)");
                    ShortestJobPreemptive(); //method call
                    break;

                case 4: System.out.println("\nChoosen Algorithm: Round Robin Algorithm");
                    RoundRobin(); //method call
                    break;

                case 5: System.out.println("\nChoosen Algorithm: Shortest Remaining Time First Algorithm");
                    ShortestRemainingTimeFirst(); //method call
                    break;

                case 0: System.out.print("Application has been terminated!"); //exit prompt
            }

        }while(choice !=0); //quit when 0

    }//end of main method
    
    //methods
    public static void FirstComeFirstServe(){
        int numOfProcesses;

        System.out.print("\n---------------------------");
        System.out.print("\nEnter number of processes: ");
        numOfProcesses = sc.nextInt();
        
        //store input array
        int processID[] = new int[numOfProcesses];
        int arrivalT[] = new int[numOfProcesses];
        int burstT[] = new int[numOfProcesses];
        int finishT[] = new int[numOfProcesses];
        int turnAroundT[] = new int[numOfProcesses];
        int waitingT[] = new int[numOfProcesses];
        int responseT[] = new int[numOfProcesses];
        float avwaitingT = 0,avturnAroundT = 0; //average
        int temp;

        //input each
        for(int i=0; i < numOfProcesses; i++){
            System.out.print("Enter process ["+(i+1)+"]'s Arrival time: ");
            arrivalT[i] = sc.nextInt();
            System.out.print ("Enter process ["+(i+1)+"]'s Burst time: ");
            burstT[i] = sc.nextInt();
            processID[i] = i+1; //+1
        }
        //sort arrival
        for(int i = 0 ; i <numOfProcesses; i++)
        {
            for(int  j=0;  j < numOfProcesses-(i+1) ; j++)
            {
                if( arrivalT[j] > arrivalT[j+1] )
                {
                    temp = arrivalT[j];
                    arrivalT[j] = arrivalT[j+1];
                    arrivalT[j+1] = temp;
                    temp = burstT[j];
                    burstT[j] = burstT[j+1];
                    burstT[j+1] = temp;
                    temp = processID[j];
                    processID[j] = processID[j+1];
                    processID[j+1] = temp;
                }
            }
        }
        // find completion time
        for(int  i = 0 ; i < numOfProcesses; i++)
        {
            if( i == 0)
            {    
                finishT[i] = arrivalT[i] + burstT[i];
            }
            else
            {
                if( arrivalT[i] > finishT[i-1])
                {
                    finishT[i] = arrivalT[i] + burstT[i];
                }
                else
                    finishT[i] =  finishT[i-1] + burstT[i];
            }  
            //formula
            turnAroundT[i] =  finishT[i] - arrivalT[i] ;          
            waitingT[i] = turnAroundT[i] - burstT[i] ; 
            //
            avwaitingT += waitingT[i] ;             
            avturnAroundT += turnAroundT[i] ;             
        }
        //print table
        System.out.println("\nPID  ArrivalTime  BurstTime  FinishTime TurnAroundTime WaitingTime");
        for(int  i = 0 ; i< numOfProcesses;  i++)
        {
            System.out.println(processID[i] + "  \t " + arrivalT[i] + "\t\t" + burstT[i] + "\t" + finishT[i] + "\t\t" + turnAroundT[i] + "\t"  + waitingT[i] ) ;
        }
        //print average
        System.out.println("\nAverage Waiting Time: "+ (avwaitingT/numOfProcesses));     
        System.out.println("Average Turn Around Time:"+(avturnAroundT/numOfProcesses));

        //prompt user
        System.out.print("\nDo you want to continue operation? [1]Choose Algorithm [2] Continue this Algorithm [3]Exit Application : ");
        int response = sc.nextInt();

        if(response==1){
            return; //return main menu
        }
        else if(response==2){
            FirstComeFirstServe(); //method call this algo
        }
        else if(response==3){
            System.out.println("Application has been terminated!");
            System.exit(0); //exit app
        }    

    }

    public static void ShortestJobNonPreemptive(){

        System.out.print("\n----------------------------");
        System.out.print("\nEnter number of processes: ");
        int numOfProcesses = sc.nextInt();

        //store input array
        int processID[] = new int[numOfProcesses];
        int arrivalT[] = new int[numOfProcesses];
        int burstT[] = new int[numOfProcesses];
        int finishT[] = new int[numOfProcesses];
        int turnAroundT[] = new int[numOfProcesses];
        int waitingT[] = new int[numOfProcesses];
        int flag[] = new int[numOfProcesses];
        int st = 0, total = 0;
        float avwaitingT = 0,avturnAroundT = 0; //average

        //input every processId
        for(int i=0; i < numOfProcesses; i++){
            System.out.print("Enter process ["+(i+1)+"]'s Arrival time: ");
            arrivalT[i] = sc.nextInt();
            System.out.print ("Enter process ["+(i+1)+"]'s Burst time: ");
            burstT[i] = sc.nextInt();
            processID[i]= i+1;
            flag[i] = 0;
        }

        boolean a = true;
        while(true)
        {
            int comp=numOfProcesses, min=999;
            if (total == numOfProcesses) 
                break;

            for (int i=0; i<numOfProcesses; i++)
            {

                if ((arrivalT[i] <= st) && (flag[i] == 0) && (burstT[i]<min))
                {
                    min=burstT[i];
                    comp=i;
                }
            }

            if (comp==numOfProcesses) 
                st++;
            else
            {
                finishT[comp]=st+burstT[comp];
                st+=burstT[comp];
                turnAroundT[comp]=finishT[comp]-arrivalT[comp];
                waitingT[comp]=turnAroundT[comp]-burstT[comp];
                flag[comp]=1;
                total++;
            }
        }
        //print table
        System.out.println("\nPID  ArrivalTime BurstTime  FinishTime TurnAroundTime WaitingTime");
        for(int i=0; i < numOfProcesses; i++)
        {
            avwaitingT += waitingT[i];
            avturnAroundT += turnAroundT[i];
            System.out.println(processID[i] + "  \t " + arrivalT[i] + "\t\t" + burstT[i] + "\t" + finishT[i] + "\t\t" + turnAroundT[i] + "\t"  + waitingT[i] ) ;
        }
        //print average
        System.out.println ("\nAverage Turn Around Time: "+ (float)(avturnAroundT/numOfProcesses));
        System.out.println ("Average Waiting Time: "+ (float)(avwaitingT/numOfProcesses)); 

        //prompt user
        System.out.print("\nDo you want to continue operation? [1]Choose Algorithm [2] Continue this Algorithm [3]Exit Application : ");
        int response = sc.nextInt();

        if(response==1){
            return; //return main menu
        }
        else if(response==2){
            ShortestJobNonPreemptive(); //method call this algo
        }
        else if(response==3){
            System.out.println("Application has been terminated!");
            System.exit(0); //exit app
        }    

    }

    public static void ShortestJobPreemptive(){
        boolean valid = true;

        do{
            System.out.print("Enter number of processes: ");
            int numOfProcesses = sc.nextInt();

            //validate
            if(numOfProcesses <= 0){
                System.out.println("Number of processes can't be negative!");
                valid = false;
            }            
            else if(numOfProcesses < 5){
                System.out.println("Number of processes should be atleast 5!");
                valid = false;
            }
            else if(numOfProcesses > 10){
                System.out.println("Number of processes should not exceed to 10!");
                valid = false;
            }

            if(numOfProcesses >= 5 && numOfProcesses <=10){
                valid = true;
                //proceed to process arrival and burst time input
            }

            //store input array
            int[] processID = new int[numOfProcesses];
            int[] arrivalT = new int[numOfProcesses];
            int[] burstT = new int[numOfProcesses];
            int[] completionT = new int[numOfProcesses];
            int[] turnAroundT = new int[numOfProcesses];
            int[] waitingT = new int[numOfProcesses];

            //input every processId
            if(valid==true){
                for(int i=0; i < numOfProcesses; i++){
                    System.out.print("Enter process ["+(i+1)+"]'s Arrival time: ");
                    arrivalT[i] = sc.nextInt();
                    System.out.print ("Enter process ["+(i+1)+"]'s Burst time: ");
                    burstT[i] = sc.nextInt();
                }
            }

        }while(valid!=true);

    }

    public static void RoundRobin(){

    }

    public static void ShortestRemainingTimeFirst(){

    }
}
