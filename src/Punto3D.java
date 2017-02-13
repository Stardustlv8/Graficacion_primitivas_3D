/**
 *
 * @author Aviel Aldama Diaz
 * @version 3.0
 * 
 */
public class Punto3D {
    private int x;
    private int y;
    private int z;
    
    public Punto3D(int xc,int yc, int zc){
        x=xc;
        y=yc;
        z=zc;
    }
    public int get_X(){
        return x;
    }
    public int get_Y(){
        return y;
    }
    public int get_Z(){
        return z;
    }
    /**
     * @param Sx Factor de reduccion para la Coordenada x
     * @param Sy Factor de reduccion para la Coordenada y
     * @param Sz Factor de reduccion para la Coordenada z
     * 
     * Aplica reduccion a los puntos actuales
     */
    public void escala_inv(int Sx,int Sy,int Sz){
        this.x/=Sx;
        this.y/=Sy;
        this.z/=Sz;
    }
    /**
     * @param Sx Factor de escala para la Coordenada x
     * @param Sy Factor de escala para la Coordenada y
     * @param Sz Factor de escala para la Coordenada z
     * 
     * Aplica escala a los puntos actuales
     */

    public void escala(int Sx,int Sy,int Sz){
        this.x*=Sx;
        this.y*=Sy;
        this.z*=Sz;
    }
    /**
     * @param Ex Factor de traslacion para la Coordenada x
     * @param Ey Factor de traslacion para la Coordenada y
     * @param Ez Factor de traslacion para la Coordenada z
     * 
     * Aplica traslacion a los puntos actuales
     */
    public void traslacion(int Ex,int Ey,int Ez){
        this.x+=Ex;
        this.y+=Ey;
        this.z+=Ez;
        System.out.println("traslacion Punto: "+this);
    }
    
    public void to_Z(){
        System.out.println("to Z Punto: "+this);
        this.z=-1*z;
        System.out.println("to Z Punto: "+this);
    }
    /**
     * @param a Grados a rotar para el punto actual
     * se aplica la rotacion sobre el eje X en a grados
     */
    public void Rotacion_X(int a){
        double angulo=Math.toRadians(a);
        double aux_y= Math.round(y*Math.cos(angulo) - z*Math.sin(angulo));
        double aux_z= Math.round(y*Math.sin(angulo) + z*Math.cos(angulo));
        this.y=(int)aux_y;
        this.z=(int)aux_z;
        System.out.println("rx Punto: "+this);
    }
    /**
     * @param a Grados a rotar para el punto actual
     * 
     * se aplica la rotacion sobre el eje Y en a grados
     */
    public void Rotacion_Y(int a){
        
        double angulo=Math.toRadians(a);
        double aux_x= Math.round(x*Math.cos(angulo) + z*Math.sin(angulo));
        double aux_z= Math.round(-x*Math.sin(angulo) + z*Math.cos(angulo));
        
        this.x=(int)aux_x;
        this.z=(int)aux_z;
        System.out.println("ry Punto: "+this);

    }
    /**
     * @param a Grados a rotar para el punto actual
     * se aplica la rotacion sobre el eje Z en a grados
     */
    public void Rotacion_Z(int a){
        double angulo=Math.toRadians(a);
        double aux_x= Math.round(x*Math.cos(angulo) - y*Math.sin(angulo));
        double aux_y= Math.round(x*Math.sin(angulo) + y*Math.cos(angulo));
        
        this.x=(int)aux_x;
        this.y=(int)aux_y;
        System.out.println("rZ Punto: "+this);
    }
    /**
     * @param Xc Factor de visualizacion para la coordenada x
     * @param Yc Factor de visualizacion para la coordenada y
     * @param Zc Factor de visualizacion para la coordenada z
     */
    
    public void Perspectiva(int Xc,int Yc,int Zc){
        
        double alp=this.alpha(z, Zc);
        
        double aux1=(alp * x) + ((1-alp) * Xc);
        double aux2=(alp * y) + ((1-alp) * Yc);
        
        x=(int)Math.round(aux1);
        y=(int)Math.round(aux2);
        //z=0;
        System.out.println("Perspectiva Punto: "+this +" alfa: "+alp);
        
    }
    /**
     * @param Zc punto 3 de la perspectiva del observador
     * @param z  Coordenada actual del eje Z
     * @return double para la operacion sobre las ecuaciones parametricas
     */
    private double alpha(double z,double Zc){
        return (double)((-Zc)/(z-Zc));
    }
    
    @Override
    public String toString(){
        return "x: "+this.x+" y: "+this.y+" z: "+this.z;
    }
}
