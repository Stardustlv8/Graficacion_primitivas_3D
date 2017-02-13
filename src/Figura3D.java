
import java.awt.Graphics;
import java.util.LinkedList;
/**
 *
 * @author Aviel Aldama Diaz
 * @version 3.0
 * 
 */
public class Figura3D{
    LinkedList fig;
    /**
     * 
     * 
     */
    public Figura3D(LinkedList figura){
        this.fig=figura;
    }
    public LinkedList getFigura(){
        return fig;
    }
    
     public void pintar(Graphics g){
        int x,x1;
        int y,y1;
        for(int i=0;i<fig.size();i++){
            x=((Punto3D)fig.get(i)).get_X();
            y=((Punto3D)fig.get(i)).get_Y();
            for(int j=0;j<fig.size();j++){
                    if(j!=fig.size()-(i+2))
                    {
                        x1=((Punto3D)fig.get(j)).get_X();
                        y1=((Punto3D)fig.get(j)).get_Y();
                        g.drawLine(x,y,x1,y1);
                    }
            }
        }        
    }
     public void pintar2(Graphics g){
        int x,x1;
        int y,y1;
        for(int i=0;i<fig.size();i++){
            x=((Punto3D)fig.get(i)).get_X();
            y=((Punto3D)fig.get(i)).get_Y();
            for(int j=0;j<fig.size();j++){
                if(i%2==0 && j%2!=0)
                    {
                        if(j!=fig.size()-(i+1)){
                            x1=((Punto3D)fig.get(j)).get_X();
                            y1=((Punto3D)fig.get(j)).get_Y();
                            g.drawLine(x,y,x1,y1);
                        }
                    }
                if(i%2!=0 && j%2==0)
                    {
                        if(j!=fig.size()-(i+1)){
                            x1=((Punto3D)fig.get(j)).get_X();
                            y1=((Punto3D)fig.get(j)).get_Y();
                            g.drawLine(x,y,x1,y1);
                        }
                    }
             }
        }        
     }
     public void pintar3(Graphics g){
        int x,x1;
        int y,y1;
        for(int i=0;i<fig.size();i++){
            x=((Punto3D)fig.get(i)).get_X();
            y=((Punto3D)fig.get(i)).get_Y();
            for(int j=0;j<fig.size();j++){
                    //if(j!=fig.size()-(i+2))
                    {
                        x1=((Punto3D)fig.get(j)).get_X();
                        y1=((Punto3D)fig.get(j)).get_Y();
                        g.drawLine(x,y,x1,y1);
                    }
            }
        }        
    }
    public void Traslacion(int Ex, int Ey,int Ez){
        //System.out.println("Figura Trasladada: ");
        Punto3D x;
        for(int i=0;i<fig.size();i++){
            x=((Punto3D)fig.get(i));
            x.traslacion(Ex, Ey, Ez);
            //System.out.println(x);
        }
    }
    public void to_z(){
        Punto3D x;
        for(int i=0;i<fig.size();i++){
            x=((Punto3D)fig.get(i));
            x.to_Z();
        
    }
    }
    
    public void Escala(int Sx,int Sy,int Sz){
        int x,y;
        for(int i=0;i<fig.size();i++){
            ((Punto3D)fig.get(i)).escala(Sx, Sy, Sz);
        }
    }
    public void Escala_inv(int Sx,int Sy,int Sz){
        int x,y;
        for(int i=0;i<fig.size();i++){
            ((Punto3D)fig.get(i)).escala_inv(Sx, Sy, Sz);
        }
    }

    public void rotacion_X(int angulo){
        Punto3D a;
        for(int i=0;i<fig.size();i++){
            a=(Punto3D)fig.get(i);
            a.Rotacion_X(angulo);
        }
    }
    public void rotacion_Y(int angulo){
        LinkedList p=new LinkedList();
        Punto3D a;
        for(int i=0;i<fig.size();i++){
            a=(Punto3D)fig.get(i);
            a.Rotacion_Y(angulo);
        }
    }
    
    public void rotacion_Z(int angulo){
        LinkedList p=new LinkedList();
        Punto3D a;
        for(int i=0;i<fig.size();i++){
            a=(Punto3D)fig.get(i);
            a.Rotacion_Z(angulo);
        }
    }
    
    public void Perspectiva(int Xc,int Yc,int Zc){ 
        LinkedList p=new LinkedList();
        Punto3D a;
        double alp;
        for(int i=0;i<fig.size();i++){
            a = (Punto3D) fig.get(i);
            a.Perspectiva(Xc, Yc, Zc);
        }
    }
 
    public int [] Centroide(){
         int x[]=new int[3];

         int ax[]=(this.max_minX());
         int ay[]=(this.max_minY());
         int az[]=(this.max_minZ());

         int sum_X=(int)Math.round((double)((ax[1]+ax[0])/2));
         int sum_Y=(int)Math.round((double)((ay[1]+ay[0])/2));
         int sum_Z=(int)Math.round((double)((az[1]+az[0])/2));

         x[0]=sum_X;
         x[1]=sum_Y;
         x[2]=sum_Z;

         return x;
     }
    
    private int [] max_minX(){
        int aux;
        int a[]=new int[2];
        
        a[0]=a[1]=((Punto3D)fig.get(0)).get_X();
        
        for(int i=1;i<fig.size();i++){
            aux=((Punto3D)fig.get(i)).get_X();
            if(aux>a[0]){
                a[0]=aux;
            }
            else if(aux<a[1]){
                a[1]=aux;
            }
            
        }
         return a;
    }
    private int [] max_minY(){
        int aux;
        int a[]=new int[2];
        
        a[0]=a[1]=((Punto3D)fig.get(0)).get_Y();
        
        for(int i=1;i<fig.size();i++){
            aux=((Punto3D)fig.get(i)).get_Y();
            if(aux>a[0]){
                a[0]=aux;
            }
            else if(aux<a[1]){
                a[1]=aux;
            }
            
        }
         return a;
    }
    private int [] max_minZ(){
        int aux;
        int a[]=new int[2];
        
        a[0]=a[1]=((Punto3D)fig.get(0)).get_Z();
        
        for(int i=1;i<fig.size();i++){
            aux=((Punto3D)fig.get(i)).get_Z();
            if(aux>a[0]){
                a[0]=aux;
            }
            else if(aux<a[1]){
                a[1]=aux;
            }
            
        }
         return a;
    }
    
}
