import java.util.*;

public class Sniffer{

    public static final Scanner scan=new Scanner(System.in);
    public static void main(String [] args){
    	System.out.println("Enter normal or attack.");
        int i=0;
        while(i==0){
        String s=Sniffer.scan.nextLine();
        if(s.trim().equals("normal")){
            Traffic traffic=new Traffic();  //Create objects for traffic and
            Traffic.normalTraffic nt=traffic. new normalTraffic(); // normal traffic
            
            nt.IPScan();  // Scan IP addresses from user.
            nt.PortScan(); // Scan Port number from user.
            nt.makePackets();
            
            Victim vm=new Victim(nt);
            vm.Store(nt);   // We send this packet information to victim
            
            PortScanning ps=new PortScanning(vm);
            ps.displayInfo();
            i=1;
            }
        else if(s.trim().equals("attack")){
            Traffic traffic=new Traffic();
            Traffic.attackTraffic at= traffic. new attackTraffic();
            
            at.IPScan();
            at.PortScan();
            at.makePackets();
            
            Victim vm=new Victim(at);
            vm.Store(at);
            
            PortScanning ps=new PortScanning(vm);
            ps.displayInfo();
            i=1;
        }
        else
        System.out.println("Please Input valid information");
    }
        
        Sniffer.scan.close();
    }

}