public class Carte {
  private Case[][] carte;
  private Case[][] carteT1;
  private Integer tailleCarte;
  private boolean hasChanged;

  public Carte(Integer taille){
      this.tailleCarte = taille;
      this.hasChanged = false;
      for(Integer i = 0; i < this.tailleCarte; i++){
        for(Integer j = 0; j < this.tailleCarte; j++){
          this.carte[i][j] = new Case();
          this.carteT1[i][j] = new Case();
        }
      }
    }

  public Case getCase(Integer i, Integer j){
    return this.carte[i][j];
  }

  public void setChanged(boolean condition){
    this.hasChanged = condition;
  }

  public void actualisation(){

  }

  public void propagationCase(Integer i, Integer j) {
    Case val = this.carte[i][j];
    

    //augmentation des flames
    if (val.getvaleurCase() > 0 && val.getvaleurCase() <= 3) {
      this.carteT1.getCase(i, j) +=1;
      this.setChanged(true);
    }
    //zone intact
    else if (val == 0) {
      for (int k = i - 1; k <= i + 1; k++) {
        if (k >= 0 && k < this.carte.length) {
          for (int l = j - 1; l <= j + 1; l++) {
            if (l >= 0 && l < this.carte[i].length) {
              if (this.carte[k][l] < 4) val += this.carte[k][l];
            }
          }
        }
      }
      // voisins suffisamment enflammes, la case s'enflamme
      if (val >= 6) {
        this.carteT1[i][j] = 1;
        this.setChanged(true);
      }
      // voisins pas assez en feu, la case reste intact, recopie de l'ancienne valeur
      else
	  this.carteT1[i][j] = this.carte[i][j];
    }
    else
       this.carteT1[i][j] = this.carte[i][j];
  }

}
