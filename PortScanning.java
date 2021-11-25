public class PortScanning extends Victim{
    Victim victim;

    public PortScanning(Victim vm){
        this.victim = vm;
    }

    public void displayInfo(){
        int size=victim.packets.size();

        if(size>999)
        {
            this.victim.packets.get(0).print();
        }
        else
        for(int i=0; i<size; i++)
        {
            this.victim.packets.get(i).print();
        }
    }
}

