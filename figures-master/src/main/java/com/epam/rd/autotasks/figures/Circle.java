package com.epam.rd.autotasks.figures;

class Circle extends Figure{
    Point center;
    double radius;

    public Circle(Point center, double radius) {
        if(center==null || radius==0.0)
        {
            try{  throw new IllegalArgumentException();
            }
            catch(IllegalArgumentException ob){throw new  RuntimeException();}
        }
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI*radius*radius;
    }

    @Override
    public String pointsToString() {
        return "("+center.getX()+","+center.getY()+")";
    }

    @Override
    public Point leftmostPoint() {

        return new Point(center.getX()-radius, center.getY() );
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + radius+"]";
    }
}
