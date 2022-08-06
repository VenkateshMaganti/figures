package com.epam.rd.autotasks.figures;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

class Quadrilateral extends Figure{
    Point a,b,c,d;
    double ab,bc,cd,da;
    public Quadrilateral(Point a,Point b,Point c,Point d) {

        if(a == null || b == null || c==null ||d==null) {
            try{  throw new IllegalArgumentException();
            }
            catch(IllegalArgumentException ob){throw new  RuntimeException();}
        }
        this.a=a;
        this.c=c;
        this.b=b;
        this.d=d;

        ab = sqrt(Math.pow((a.getX()- b.getX()),2.0)+Math.pow ((a.getY()- b.getY()),2.0));
        bc = sqrt(Math.pow((b.getX()- c.getX()),2.0)+Math.pow ((b.getY()- c.getY()),2.0));
        cd = sqrt(Math.pow((c.getX()- d.getX()),2.0)+Math.pow ((c.getY()- d.getY()),2.0));
        da = sqrt(Math.pow((d.getX()- a.getX()),2.0)+Math.pow ((d.getY()- a.getY()),2.0));
        if(ab==0.0||bc==0.0||cd==0.0||da==0.0){
            try{  throw new IllegalArgumentException();
            }
            catch(IllegalArgumentException ob){throw new  RuntimeException();}
        }
    }



    @Override
    public double area() {
        double x1,y1,x2,y2,x3,y3,x4,y4;
        x1=a.getX(); y1=a.getY();
        x2=b.getX(); y2=b.getY();
        x3=c.getX(); y3=c.getY();
        x4=d.getX(); y4=d.getY();
        double p1=(x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2))/2.0;
        double p2=(x1*(y3-y4)+x3*(y4-y1)+x4*(y1-y3))/2.0;
        return abs(p1+p2);
    }

    @Override
    public String pointsToString() {
        return "("+a.getX()+","+a.getY()+")("+b.getX()+","+b.getY()+")("+c.getX()+","+c.getY()+")("+d.getX()+","+ d.getY()+")";
    }

    @Override
    public Point leftmostPoint() {
        if(a.getX()<=b.getX()&&a.getX()<=c.getX()&&a.getX()<=d.getX())
            return a;
        if(b.getX()<=a.getX()&&b.getX()<=c.getX()&&b.getX()<=d.getX())
            return b;
        if(c.getX()<=a.getX()&&c.getX()<=b.getX()&&c.getX()<=d.getX())
            return c;
        if(d.getX()<=a.getX()&&d.getX()<=b.getX()&&d.getX()<=c.getX())
            return d;
        return null;
    }
}
