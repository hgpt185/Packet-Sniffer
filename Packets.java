import java.util.*;
import java.net.*;

public class Packets{
    public String storeSourceIP=new String();
    public int storeSourcePort;

    public ArrayList<String> sourceIP=new ArrayList<>();
    public ArrayList<Integer> sourcePort=new ArrayList<>();

    public String destinationIP=new String();
    public int destinationPort = 32;
    public Packets(){}

    public Packets(String s, int x){
        this.storeSourceIP=s;
        this.storeSourcePort=x;
        header();

    }

    public void header(){
        try{
        InetAddress localhost = InetAddress.getLocalHost();
        this.destinationIP=(localhost.getHostAddress()).trim();
        }
        catch(Exception e){
            System.out.println(e);
        }

    }

    public void print(){
        System.out.println("Source IP:"+this.storeSourceIP+
        " Source Port:"+this.storeSourcePort+
        " Destination IP:" + this.destinationIP+
        " Destination Port:"+this.destinationPort);

    }
}