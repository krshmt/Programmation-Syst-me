package Exo1;
public class Calculatrice{

    public Calculatrice(){
    }

    public static int addition(int a, int b){
        return a+b;
    }

    public static int soustraction(int a, int b){
        return a-b;
    }

    public static int multiplication(int a, int b){
        return a*b;
    }

    public static int division(int a, int b){
        if(b == 0){
            System.out.println("Division par 0 impossible");
            return 0;
        }
        return a/b;
    }
}