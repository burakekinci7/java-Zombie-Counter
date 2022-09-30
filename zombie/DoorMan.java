public class DoorMan extends Thread{
    ZombieCounter zc;

    public DoorMan(ZombieCounter zombieCounter) {
        this.zc=zombieCounter;
    }

    @Override
    public void run(){
        //%50 ve 2 ms ile zombie birakir
        
        while(!zc.killed100Zombies() &&  !zc.tooManyZombiesInTheRoom()){
            double r =Math.random();
            if(r<0.5){
            zc.zombieEntered();
            }
            try{
                Thread.sleep(2);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
