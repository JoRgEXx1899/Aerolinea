package aerolinea;

/**
 *
 * @author JORGE GOMEZ
 */
public class Avion {
    String ID;
    Asiento [][] sillas=new Asiento[15][5];

    public Avion() {
        for (int i=0;i<14;i++){
            for (int k=0;k<4;k++){
                sillas[i][k].fila=FilaNumL(i);
                sillas[i][k].numero=k+1;
            }
        }
    }
    
    public String FilaNumL(int i){
        switch(i){
            case 0:
                return "A";
            case 1:
                return "B";
            case 2:
                return "C";
            case 3:
                return "D";
            case 4:
                return "E";
            case 5:
                return "F";
            case 6:
                return "G";
            case 7:
                return "H";
            case 8:
                return "I";
            case 9:
                return "J";
            case 10:
                return "K";
            case 11:
                return "L";
            case 12:
                return "M";
            case 13:
                return "N";
            case 14:
                return "O";
            default:
                return"";                       
        }
    }  
    public int FilaLNum(String a){
        switch(a){
            case "A":
                return 0;
            case "B":
                return 1;
            case "C":
                return 2;
            case "D":
                return 3;
            case "E":
                return 4;
            case "F":
                return 5;
            case "G":
                return 6;
            case "H":
                return 7;
            case "I":
                return 8;
            case "J":
                return 10;
            case "K":
                return 11;
            case "L":
                return 12;
            case "M":
                return 13;
            case "N":
                return 14;
            case "O":
                return 15;
            default:
                return 0; 
        }
    }
    public boolean getDisponibilidadAsiento(String a,int n){
        return this.sillas[FilaLNum(a)][n-1].isEstado();
    }
    
}
