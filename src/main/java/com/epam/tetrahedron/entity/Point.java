package com.epam.tetrahedron.entity;

public class Point {
    private final double x;
    private final double y;
    private final double z;

    public Point(final double x, final  double y, final double z){
        this.x=x;
        this.y=y;
        this.z=z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
    @Override
    public String toString(){
        return "Point{"+
                "x=" + x +
                ", y="+y+
                ", z="+z+
                '}';
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) {
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        Point that = (Point) obj;
        if(x!=that.getX()){
            return  false;
        }
        if(y!=that.getY()){
            return false;
        }
        return z == that.getZ();
    }

    @Override
    public int hashCode(){
        int result = 1;
        result=31*result+(int)x;
        result=31*result+(int)y;
        result=31*result+(int)z;
        return result;
    }

}
