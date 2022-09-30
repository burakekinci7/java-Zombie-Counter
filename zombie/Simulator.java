public class Simulator {
    
    public static void main(String[] args) {
    
        DoorMan[] dormen;
        Slayer slayer;
        
        ZombieCounter zc = new ZombieCounter();
        slayer=new Slayer(zc);
        
        int n= Integer.parseInt(args[0]);
        dormen=new DoorMan[n];

        for(int i = 0;i<n;i++){
            dormen[i]=new DoorMan(zc);
        }

        for (int i = 0;i < n ;i++){
            dormen[i].start();
        }

        slayer.start();

        try{
            slayer.join();
            for(int i = 0;i < n; i++){
                dormen[i].join();
            }
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("GaMe OvEr!\n" +"You"+(zc.getKilledCount() >=100? "Won!" : "Lost!") );
        System.out.println("The number of zombies in the room:" + zc.getInTheRoomCount());
        System.out.println("The number of zombies killed:" + zc.getKilledCount());

    }

}