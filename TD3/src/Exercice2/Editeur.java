public class Editeur extends Thread{
        private Ressource ressource;
        public final int CONSTANTE_TEMPS;
    
        public Editeur(Ressource ressource){
            this.ressource = ressource;
            this.CONSTANTE_TEMPS = 1000;
        }
    
        @Override
        public void run(){
            while(true){
                try{
                    ressource.lire();
                    Thread.sleep(CONSTANTE_TEMPS);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    