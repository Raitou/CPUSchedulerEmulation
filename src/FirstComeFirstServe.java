import java.util.Arrays;
import java.util.Scanner;

public class FirstComeFirstServe { 
    public static void main(String args[]){ 
        int n, output[][], maxAT; 
        int PrevSum = 0;
        boolean arrivalNotZero = false;
        boolean ATSkipped[];
        float AWT=0;
        float ATAT=0;
        
        Scanner input = new Scanner(System.in);
        System.out.println("FIRST COME FIRST SERVE CPU SCHEDULING");
        System.out.print("Enter no of process: "); 
        n = input.nextInt();
        
        output = new int [n][6];
        
        System.out.println();

        for(int i=0;i<n;i++){
            output[i][0] = i+1;
            System.out.print("Enter BT for process "+(i+1)+": "); 
            output[i][1]= input.nextInt();                                      //BT
            System.out.print("Enter AT for process "+(i+1)+": "); 
            output[i][2]= input.nextInt();                                      //AT
        } 
        System.out.println("*************************************************");
        
        maxAT = output[0][2];
        for(int i = 0; i < n; i++){
            if (maxAT < output[i][2])
                maxAT = output[i][2];
        }
        
        ATSkipped = new boolean[(maxAT+1 > n ? maxAT+1 : n)];
        for(int i = 0; i < (maxAT+1 > n ? maxAT+1 : n); i++){
            ATSkipped[i] = true;
        }
        for(int i = 0; i < (maxAT+1 > n ? maxAT+1 : n); i++){
            for(int j = 0; j < (maxAT+1 > n ? maxAT+1 : n); j++){
                if(i == output[j][2]){
                    output[j][3] = output[j][1] + PrevSum;                      //CT = BT + PrevSum
                    PrevSum = output[j][3];                                     //PrevSum = CT
                    output[j][4] = output[j][3] - output[j][2];                 //TAT = CT - AT
                    output[j][5] = output[j][4] - output[j][1];                 //WT = TAT - BT
                    ATAT += output[j][4];                                       //ATAT += TAT
                    AWT += output[j][5];                                        //AWT += WT
                    ATSkipped[j] = false;
                }
            }
            if(ATSkipped[i] && PrevSum <= i){
                PrevSum++;
            }
        } 
        AWT /= n;
        ATAT /= n;
        System.out.println("PROCESS\tBT\tAT\tCT\tTAT\tWT");
        for(int i=0;i<n;i++){
            System.out.println(output[i][0]+"\t"+output[i][1]+"\t"+output[i][2]+"\t"+output[i][3]+"\t"+output[i][4]+"\t"+output[i][5]);
        }
        System.out.println("Average TAT: "+ATAT); 
        System.out.println("Average WT: "+AWT);
    } 
}