
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Area;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JPanel;

/**
 *
 * @author ROBERTO CB
 */
public class JuegoPanelCanvas extends JPanel implements KeyListener{
    
    private ArrayList<Rectangle2D> rectangulos = new ArrayList();
    private ArrayList<Rectangle2D> rectangulos2 = new ArrayList();
    private ArrayList<Point2D> puntos = new ArrayList();
    private ArrayList<Point2D> puntos2 = new ArrayList();
    private ArrayList<Point2D> puntosp = new ArrayList();
      
    private String[] numeros = new String[15];
    private String[] numeros2 = new String[15];
    private int[] coincidencias = new int[15];
    private int[] coincidencias_neg = new int[15];
    
    private int x=50,y=50,cond=4,x1=0,y1=0,verificacion=0,a=400;
 
    
    public JuegoPanelCanvas(){        
        setPreferredSize(new Dimension(700,400));
        setBackground(new Color(48,15,120));
        
               
         
        this.addKeyListener(this);
        this.setFocusable(true);
    }
    public void paintComponent(Graphics g){        
	super.paintComponent(g);        
	Graphics2D g2 = (Graphics2D)g;        
        g2.setColor(Color.white);
        g2.draw(new Rectangle2D.Double(50,50,200,200));
        if (verificacion!=15) {
            verificacion=0;
        }
        
        for (int i = 0; i < puntos2.size(); i++) {
            if((int) puntos.get(i).getX()== (int)puntos2.get(i).getX() && (int) puntos.get(i).getY()== (int)puntos2.get(i).getY()){
                verificacion++;
            }
        }
        
        
        if(puntos2.isEmpty()){
            puntos2.add(new Point2D.Double(200,100));
            puntos2.add(new Point2D.Double(50,50));
            puntos2.add(new Point2D.Double(100,150));
            puntos2.add(new Point2D.Double(150,50));
            puntos2.add(new Point2D.Double(150,100));
            puntos2.add(new Point2D.Double(200,50));
            puntos2.add(new Point2D.Double(150,150));
            puntos2.add(new Point2D.Double(50,100));
            puntos2.add(new Point2D.Double(100,50));
            puntos2.add(new Point2D.Double(100,100));
            puntos2.add(new Point2D.Double(50,150));
            puntos2.add(new Point2D.Double(50,200));
            puntos2.add(new Point2D.Double(100,200));
            puntos2.add(new Point2D.Double(150,200));
            puntos2.add(new Point2D.Double(200,150));
        }
        
        if(puntosp.isEmpty()){
            for(int i=0;i<15;i++){
                numeros2[i]=""+(i+1);
                numeros[i]=""+(i+1);
                
            }
            puntosp.add(new Point2D.Double(200+a,100));
            puntosp.add(new Point2D.Double(50+a,50));
            puntosp.add(new Point2D.Double(100+a,150));
            puntosp.add(new Point2D.Double(150+a,50));
            puntosp.add(new Point2D.Double(150+a,100));
            puntosp.add(new Point2D.Double(200+a,50));
            puntosp.add(new Point2D.Double(150+a,150));
            puntosp.add(new Point2D.Double(50+a,100));
            puntosp.add(new Point2D.Double(100+a,50));
            puntosp.add(new Point2D.Double(100+a,100));
            puntosp.add(new Point2D.Double(50+a,150));
            puntosp.add(new Point2D.Double(50+a,200));
            puntosp.add(new Point2D.Double(100+a,200));
            puntosp.add(new Point2D.Double(150+a,200));
            puntosp.add(new Point2D.Double(200+a,150));
        }
        if(rectangulos2.isEmpty()) {
            for (int i = 0; i < puntosp.size(); i++) {
                rectangulos2.add(new Rectangle2D.Double(puntosp.get(i).getX(),puntosp.get(i).getY(),50,50));
            }
        }
        Font f = new Font("Arial",Font.BOLD,20);
        g2.setFont(f);
        if (verificacion!=15) {
            for (int i = 0; i < rectangulos2.size(); i++) {
                if (i%2==0) {
                    g2.setColor(Color.red);
                }else{
                    g2.setColor(Color.blue);
                }
                
                g2.fill(rectangulos2.get(i));

                g2.setColor(Color.yellow);
                g2.draw(rectangulos2.get(i));
                x1=(int) puntosp.get(i).getX();
                y1=(int) puntosp.get(i).getY();             
                g2.drawString(numeros2[i],x1+15,y1+30);
            
            }
        }
        
     
        if(rectangulos.isEmpty()){
            for (int i = 0; i < 4; i++) {
                if (i==3){
                    cond=3;
                }
                for (int j = 0; j < cond; j++) {
                    puntos.add(new Point2D.Double(50+(x*j),50+(y*i)));
                    
                }
            }
            
            for (int i = 0; i < puntos.size(); i++) {
                rectangulos.add(new Rectangle2D.Double(puntos.get(i).getX(),puntos.get(i).getY(),50,50));              
            }
        }
        for (int i = 0; i < puntos.size(); i++) {
           rectangulos.set(i,new Rectangle2D.Double(puntos.get(i).getX(),puntos.get(i).getY(),50,50));              
        }
        
        
        if (verificacion!=15) {
            for (int i = 0; i < rectangulos.size(); i++) {
                if (i%2==0) {
                    g2.setColor(Color.red);
                }else{
                    g2.setColor(Color.blue);
                }
                
                g2.fill(rectangulos.get(i));
                g2.setColor(Color.yellow);
                g2.draw(rectangulos.get(i));
                x=(int) puntos.get(i).getX();
                y=(int) puntos.get(i).getY();

                g2.drawString(numeros[i],x+15,y+30);
            
            
            }
        }
        
        if (verificacion==15) {
            g2.setColor(Color.red);
            g2.fill(new Rectangle2D.Double(0,0,700,400));
            f = new Font("Arial",Font.BOLD,60);
            g2.setFont(f); 
            g2.setColor(Color.black);
            g2.drawString("Ganaste!",200,200);
            
        }
        for(int w=0;w<coincidencias.length;w++){
            coincidencias[w]=0;
        }
        for(int w=0;w<coincidencias_neg.length;w++){
            coincidencias_neg[w]=0;
        }
        
        
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
            
        
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        x=0;
        y=0;
        
        if (ke.getKeyCode()==KeyEvent.VK_RIGHT){
        
            for (int i = 0 ; i < puntos.size(); i++) {
                  
                    
                    for (int j = 0; j < puntos.size(); j++) {
                        if (puntos.get(i).getX()+50!=puntos.get(j).getX() && puntos.get(i).getY()==puntos.get(j).getY() && puntos.get(i).getX()+50<=200) {
                            coincidencias[i]=1;
                        }
                        else{
                            if (puntos.get(i).getY()==puntos.get(j).getY()) {
                                
                                coincidencias_neg[i]=1;
                            }
                        }
                    }
                    if(coincidencias[i]==1 && coincidencias_neg[i]!=1 && puntos.get(i).getX()+50<=200){
                            
                            x=(int) puntos.get(i).getX();
                            y=(int) puntos.get(i).getY();
                            puntos.set(i, new Point2D.Double(x+50,y));
                            repaint();
                            break;
                    }
                    for(int w=0;w<coincidencias.length;w++){
                        coincidencias[w]=0;
                    }
                    for(int w=0;w<coincidencias_neg.length;w++){
                        coincidencias_neg[w]=0;
                    }
                }
            
        }
        
        if (ke.getKeyCode()==KeyEvent.VK_LEFT){
            for (int i = puntos.size()-1 ; i >= 0; i--) {
                    
                    
                    for (int j = puntos.size()-1; j >= 0; j--) {
                        if (puntos.get(i).getX()-50!=puntos.get(j).getX() && puntos.get(i).getY()==puntos.get(j).getY() && puntos.get(i).getX()-50>=50) {
                            coincidencias[i]=1;
                        }
                        else{
                            if (puntos.get(i).getY()==puntos.get(j).getY()) {
                                coincidencias_neg[i]=1;
                            }
                        }
                    }
                    if(coincidencias[i]==1 && coincidencias_neg[i]!=1 && puntos.get(i).getX()-50>=50){
                            
                            x=(int) puntos.get(i).getX();
                            y=(int) puntos.get(i).getY();
                            puntos.set(i, new Point2D.Double(x-50,y));
                            repaint();
                            break;
                    }
                    for(int w=0;w<coincidencias.length;w++){
                        coincidencias[w]=0;
                    }
                    for(int w=0;w<coincidencias_neg.length;w++){
                        coincidencias_neg[w]=0;
                    }
                }
        }   
        
            if (ke.getKeyCode()==KeyEvent.VK_DOWN){
            
                for (int i = 0 ; i < puntos.size(); i++) {
                    
                    for (int j = 0; j < puntos.size(); j++) {
                        if (puntos.get(i).getY()+50!=puntos.get(j).getY() && puntos.get(i).getX()==puntos.get(j).getX() && puntos.get(i).getY()+50<=200) {
                            coincidencias[i]=1;
                        }
                        else{
                            if (puntos.get(i).getX()==puntos.get(j).getX()) {
                                coincidencias_neg[i]=1;
                            }
                        }
                    }
                    if(coincidencias[i]==1 && coincidencias_neg[i]!=1 && puntos.get(i).getY()+50<=200){
                            
                            x=(int) puntos.get(i).getX();
                            y=(int) puntos.get(i).getY();
                            puntos.set(i, new Point2D.Double(x,y+50));
                            repaint();
                            break;
                    }
                    for(int w=0;w<coincidencias.length;w++){
                        coincidencias[w]=0;
                    }
                    for(int w=0;w<coincidencias_neg.length;w++){
                        coincidencias_neg[w]=0;
                    }
                }
            }
           
            
            if (ke.getKeyCode()==KeyEvent.VK_UP){
            
                for (int i = puntos.size()-1 ; i >=0 ; i--) {
                   
                    
                    for (int j = puntos.size()-1 ; j >=0; j--) {
                        if (puntos.get(i).getY()-50!=puntos.get(j).getY() && puntos.get(i).getX()==puntos.get(j).getX() && puntos.get(i).getY()-50>=50) {
                            coincidencias[i]=1;
                        }
                        else{
                            if (puntos.get(i).getX()==puntos.get(j).getX()) {
                                coincidencias_neg[i]=1;
                            }
                        }
                    }
                    if(coincidencias[i]==1 && coincidencias_neg[i]!=1 && puntos.get(i).getY()-50>=50){
                            
                            x=(int) puntos.get(i).getX();
                            y=(int) puntos.get(i).getY();
                            puntos.set(i, new Point2D.Double(x,y-50));
                            repaint();
                            break;
                    }
                    for(int w=0;w<coincidencias.length;w++){
                        coincidencias[w]=0;
                    }
                    for(int w=0;w<coincidencias_neg.length;w++){
                        coincidencias_neg[w]=0;
                    }
                }
            }
            
    }   


}
