package com.epam.rd.autotasks.figures;

import static java.lang.Math.sqrt;

class Triangle extends Figure{
    Point a,b,c;
    double ab,bc,ca;
    public Triangle(Point a,Point b,Point c) {
        this.a=a;
        this.b=b;
        this.c=c;
        if(a == null || b == null || c==null) {
            try{  throw new IllegalArgumentException();
            }
            catch(IllegalArgumentException ob){throw new  RuntimeException();}
        }
        double res=a.getX()*(b.getY()-c.getY()) + b.getX()*(c.getY()-a.getY()) + c.getX()*(a.getY()-b.getY());
        if(res==0.0)
        {
            try{  throw new IllegalArgumentException();

            }
            catch(IllegalArgumentException ob){throw new  RuntimeException();}
        }

        ab = sqrt(Math.pow((a.getX()- b.getX()),2.0)+Math.pow ((a.getY()- b.getY()),2.0));
        bc = sqrt(Math.pow((b.getX()- c.getX()),2.0)+Math.pow ((b.getY()- c.getY()),2.0));
        ca = sqrt(Math.pow((c.getX()- a.getX()),2.0)+Math.pow ((c.getY()- a.getY()),2.0));
        if((ab+bc<ca) ||(bc+ca<ab)|| (ca+ab<bc)) {
            try{  throw new IllegalArgumentException();

            }
            catch(IllegalArgumentException ob){throw new  RuntimeException();}
        }
    }

    public double area(){
        double s=(ab+bc+ca)/2.0;
        return sqrt(s*(s-ab)*(s-bc)*(s-ca));
    }

    @Override
    public String pointsToString() {
        return "("+a.getX()+","+a.getY()+")("+b.getX()+","+b.getY()+")("+c.getX()+","+c.getY()+")";
    }

    @Override
    public Point leftmostPoint() {
        if(a.getX()<=b.getX()&&a.getX()<=c.getX())
            return a;
        if(b.getX()<=a.getX()&&b.getX()<=c.getX())
            return b;
        if(c.getX()<=a.getX()&&c.getX()<=b.getX())
            return c;
        return null;
    }
}
