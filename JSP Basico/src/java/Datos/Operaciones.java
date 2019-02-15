package Datos;

public class Operaciones {
    
    private float X;
    private float Y;
    
    public Operaciones(){}
    
    public boolean Verificar(String X, String Y){
        try {
            this.X = new Float(X);
            this.Y = new Float(Y);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
