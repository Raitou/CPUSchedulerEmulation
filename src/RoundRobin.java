
import java.util.Scanner;

public class RoundRobin{ 
    public static void main(String args[]) throws Exception { 
        int AT[], BT[], CT[], WT[], TAT[];
        int output[][];
        int n, maxBT = 0, complete = 0; //find highest burst time
        float AWT = 0; // average waiting time
        float ATAT = 0; // average turn around time
        

        Scanner input = new Scanner(System.in);

        System.out.print("Enter no of process: "); 
        n = input.nextInt();
        System.out.print("Enter Quantum Time: ");
        int qt = input.nextInt();

        BT=new int[n];
        WT=new int[n]; 
        TAT=new int[n]; 
        AT=new int[n];
        CT=new int[n];
        output=new int[n][6];

        System.out.println(); 
        for(int i=0;i<n;i++){ 
            System.out.print("Enter BT for process "+(i+1)+": "); 
            BT[i]= input.nextInt();
            System.out.print("Enter AT for process "+(i+1)+": "); 
            AT[i]= input.nextInt();
            output[i][0] = i+1;
            if(BT[i]>maxBT)
                maxBT = BT[i]; // sets max burst time
        }
        
        
        System.out.println();
        
       
        for(int i = 0; i < n; i++){   // loop selection sort arrange by arrival time
            int min_idx = i;
            for(int j=i+1; j<n; j++){
                if(AT[j]<AT[min_idx])
                    min_idx = j;
            }
            int tempBT = BT[min_idx];
            BT[min_idx] = BT[i];
            BT[i] = tempBT;
            int tempAT = AT[min_idx];
            AT[min_idx] = AT[i];
            AT[i] = tempAT;
            int tempOutput = output[min_idx][0];
            output[min_idx][0] = output[i][0];
            output[i][0] = tempOutput;
        }
        
        for(int i=0; i<n; i++){
            output[i][1] = BT[i];
            output[i][2] = AT[i];
        }
        
        int m = (maxBT / qt) + 1;   // sets maximum possible rounds for the round robin
        if(AT[n-1] != 0){
            m += AT[n-1];
        }
         
        for(int i=0; i<m; i++){ // || i<AT[n-1] in case the AT is not 0 <-- round counter loop
            for(int j=0; j<n; j++){ // loop for checking the arrays per round
                if(AT[j] >= i){ // if Arrival Time is equal to the round counter
                    if(BT[j]!=0){ // if burst time is not yet 0
                        if((BT[j]-qt)>=0){ // if BT - quantum time is greater than or equal to 0
                            BT[j] -= qt; // subtract quantum time
                            complete += qt; // adds quantum time to completion time
                        }else{
                            complete += BT[j]; // adds to completion time and subtracts how much left is in the process
                            BT[j] -= BT[j];
                        }
                        if(BT[j]==0){
                            CT[j] = complete; // if BT is already 0, sets its completion time
                        }
                    }
                    AT[j]++; // adds 1 to AT in every round
                }
            }
        }
        
        for(int i=0; i<n; i++){
            TAT[i] = CT[i]-output[i][2];
            WT[i] = TAT[i]-output[i][1];
            ATAT += TAT[i];
            AWT += WT[i];
        }
        
        for(int i=0; i<n; i++){
            output[i][3] = CT[i];
            output[i][4] = TAT[i];
            output[i][5] = WT[i];
        }
        
        
        System.out.println("PROCESS\tBT\tAT\tCT\tTAT\tWT");
        for(int i=0;i<n;i++){
            System.out.println(output[i][0]+1+"\t"+output[i][1]+"\t"+output[i][2]+"\t"+output[i][3]+"\t"+output[i][4]+"\t"+output[i][5]);
        }

        AWT=AWT/n; 
        System.out.println("Average WT: "+AWT);

        ATAT=ATAT/n;
        System.out.println("Avg turn around time: "+ATAT); 
    } 
}