
import java.util.Scanner;

public class Test { 
    public static void main(String args[]) throws Exception { 
        int n, AT[], BT[], WT[], TAT[]; 

        float AWT=0;
        float ATAT=0;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter no of process: "); 
        n = input.nextInt();

        BT=new int[n]; 
        WT=new int[n]; 
        TAT=new int[n]; 
        AT=new int[n]; 

        System.out.println(); 
        for(int i=0;i<n;i++){ 
            System.out.print("Enter BT for process "+(i+1)+": "); 
            BT[i]= input.nextInt();
            System.out.print("Enter AT for process "+(i+1)+": "); 
            AT[i]= input.nextInt();
        } 
        System.out.println("***********************************************");

        WT[0]=0;
        for(int i=1;i<n;i++){ 
            WT[i]=WT[i-1]+BT[i-1]+AT[i-1]; 
            WT[i]=WT[i]-AT[i]; 

            TAT[i]=WT[i]+BT[i]; 
            AWT=AWT+WT[i]; 
            ATAT=ATAT+TAT[i];
        }

        System.out.println("  PROCESS   BT      WT      TAT     ");
        for(int i=0;i<n;i++){
            System.out.println("    "+i+ "       "+BT[i]+"       "+WT[i]+"       "+TAT[i]);
        }

        AWT=AWT/n; 
        System.out.println("Average WT: "+AWT);

        ATAT=ATAT/n;
        System.out.println("Avg turn around time: "+ATAT); 
    } 
}