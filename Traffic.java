import java.util.*;

public class Traffic extends Packets{

    String ip0to255 = "(\\d{1,2}||(0|1)\\d{2}||2[0-4]\\d||25[0-5])";
                // String to check if the inputted IP address are correct
    public String pattern = ip0to255 + "\\." + ip0to255 + "\\." + ip0to255 + "\\." + ip0to255; 

    ArrayList<Packets> packets=new ArrayList<>();
    
    class normalTraffic extends Traffic{
        int count=0;{
            header();
        }
    
        public void IPScan(){
            System.out.println("Input 5 Valid Source IP address: ");

            for(int i=0; i<5;)
            {
                String s=Sniffer.scan.nextLine();
                if(s.matches(pattern))
                    {
                        sourceIP.add(s);
                        i++;
                    }
                else
                    System.out.println("Input Valid IP address again: ");
            }

            System.out.println("Valid IP addresses inputted, next:");

        }
        
        public void PortScan(){
            System.out.println("Input 5 Valid Source Port: ");

            for(int i=0; i<5;){
                
                int port=Sniffer.scan.nextInt();
                
                if(port<65536){
                    sourcePort.add(port);
                    i++;
                }
                else
                {
                    System.out.println("Invalid Port, please Input it again");
                }
            }
            System.out.println("Valid Ports inputted, next:");

        }
        public void makePackets(){
            for(int i=0; i<5; i++){
                String s=sourceIP.get(i);
                int x=sourcePort.get(i);
                Packets p=new Packets(s, x);
                this.packets.add(p);
            }
        }

    }


    
    class attackTraffic extends Traffic{
        
        int count=0;
        
        public void IPScan(){
            sourceIP=new ArrayList<>();
            System.out.println("Input Source IP address: ");
            int i=-1;
            Return :
            while(i<0){
                
                storeSourceIP=Sniffer.scan.nextLine();
                if(storeSourceIP.matches(pattern))
                    i++;
                else{
                    System.out.println("Input the Source IP again");
                    continue Return;
                }
            }
            System.out.println("Valid IP address inputted, next:");
        }
        
        public void PortScan(){
            System.out.println("Input Source Port: ");
            int i=-1;
            Return :
            while(i<0){
                
                storeSourcePort=Sniffer.scan.nextInt();
                if(storeSourcePort<65536)
                    i++;
                else{
                    System.out.println("Input the Source IP again");
                    continue Return;
                }
            }
            System.out.println("Source port valid, next");
        }
        public void makePackets(){
        	
        	String s=storeSourceIP;
            int x=storeSourcePort;
            Packets p=new Packets(s, x);
            
            for(int i=0; i<1050; i++){
                this.packets.add(p);
                }
        }
        }
}
