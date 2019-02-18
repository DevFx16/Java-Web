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
    
    public float Operacion(String Op){
        if(Op.equals("+")){
            return X + Y;
        }else if(Op.equals("-")){
            return X - Y;
        }else if(Op.equals("*")){
            return X * Y;
        }else {
            return X / Y;
        }
    }
}
