public class Slayer extends Thread{
    
    ZombieCounter zc;

    public Slayer(ZombieCounter zc){
        this.zc=zc;
    }

    @Override
    public void run(){
        //kesin vurur ama 2 ms
        while(!zc.killed100Zombies() &&  !zc.tooManyZombiesInTheRoom()){
            
            zc.zombieKilled();

            try{
                Thread.sleep(2);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }

    }
    
}
