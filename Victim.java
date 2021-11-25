import java.util.*;

public class Victim{
    ArrayList<Packets> packets=new ArrayList<Packets>();
    Traffic tf=new Traffic();
    Traffic.normalTraffic nt= tf. new normalTraffic();
    Traffic.attackTraffic at= tf. new attackTraffic();

    public Victim(){}
    public Victim(Traffic.normalTraffic nt){
        this.nt=nt;
    }
    
    public Victim(Traffic.attackTraffic at){
        this.at=at;
    }

    public void Store(Traffic.normalTraffic nt){
        for(int i=0; i<5; i++){
            this.packets.add(this.nt.packets.get(i));
        }
    }

    public void Store(Traffic.attackTraffic at){
    
            for(int i=0; i<1050; i++)
            {
                this.packets.add(this.at.packets.get(i));
                if(this.packets.size()>999){
                    System.out.println("An Attack is Happening!");
                    System.out.println("Number of packets recieved: "+ this.packets.size());
                    break;
                }
            }
    }

}