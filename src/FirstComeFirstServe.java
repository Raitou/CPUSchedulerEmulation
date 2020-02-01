import java.util.Arrays;
import java.util.Scanner;

public class FirstComeFirstServe { 
    public static void main(String args[]){ 
        int n, output[][]; 
        int PrevSum = 0;
        boolean arrivalNotZero = false;
        boolean runned[];
        int minimum;
        float AWT=0;
        float ATAT=0;
        
        Scanner input = new Scanner(System.in);
        System.out.println("FIRST COME FIRST SERVE CPU SCHEDULING");
        System.out.print("Enter no of process: "); 
        n = input.nextInt();
        
        output = new int [n][6];
        runned = new boolean[n];
        for(int i = 0; i < n; i++){
            runned[i] = false;
        }
            
        System.out.println();

        for(int i=0;i<n;i++){ 
            System.out.print("Enter BT for process "+(i+1)+": "); 
            output[i][1]= input.nextInt();                                      //BT
            System.out.print("Enter AT for process "+(i+1)+": "); 
            output[i][2]= input.nextInt();                                      //AT
        } 
        System.out.println("*************************************************");
        
        minimum = output[0][2];                                                 //minimum = AT
        int arrangement[] = new int[n];
        for(int i=0;i<n;i++){                                                   
            if(minimum > output[i][2]){                                         //minimum > AT            
                minimum = output[i][2];                                         //minimum = AT
            }
        }
        if (minimum != 0){  
            PrevSum = minimum;
        }
        for(int i = 0; i < n; i++){
            arrangement[i] = output[i][2];                                      //arrangement = AT
        }
        Arrays.sort(arrangement);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arrangement[i] == output[j][1] && !runned[j]){
                    output[j][3] = output[j][1] + PrevSum;                      //CT = BT + PrevSum
                    PrevSum = output[j][3];                                     //PrevSum = CT
                    output[j][4] = output[j][3] - output[j][2];                 //TAT = CT - AT
                    output[j][5] = output[j][4] - output[j][1];                 //WT = TAT - BT
                    ATAT += output[j][4];                                       //ATAT += TAT
                    AWT += output[j][5];                                        //AWT += WT
                    runned[j] = true;
                    break;
                }
            } 
        } 
        AWT /= n;
        ATAT /= n;
        System.out.println("PROCESS\tBT\tAT\tCT\tTAT\tWT");
        for(int i=0;i<n;i++){
            System.out.println(output[i][0]+1+"\t"+output[i][1]+"\t"+output[i][2]+"\t"+output[i][3]+"\t"+output[i][4]+"\t"+output[i][5]);
        }
        System.out.println("Average TAT: "+ATAT); 
        System.out.println("Average WT: "+AWT);
    } 
}