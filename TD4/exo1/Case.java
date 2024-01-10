public class Case{
    private int valeurCase;

    public Case(){
        this.valeurCase = 0;
    }

    public int getvaleurCase(){
        return this.valeurCase;
    }

    public void augmentationFeu(){
        this.valeurCase +=1;
    }
}