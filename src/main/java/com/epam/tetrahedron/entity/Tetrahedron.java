package com.epam.tetrahedron.entity;

import com.epam.tetrahedron.creation.identification.IdGenerator;

public class Tetrahedron {
    private Point point;
    private double edgeLength;
    private final int id;
    public Tetrahedron(final Point point, final double edgeLength){
        this.point = new Point(point.getX(),point.getY(),point.getZ());
        this.edgeLength=edgeLength;
        id = IdGenerator.generateId();
    }
    public void setEdgeLength(double edgeLength){

        this.edgeLength=edgeLength;
    }
    public void setPoint(Point point){
        this.point=point;
    }
    public double getEdgeLength(){

        return  edgeLength;
    }
    public Point getPoint(){
        return point;
    }
    public int getId(){
        return id;
    }
    @Override
    public String toString() {
        return "Tetrahedron{" +
                "x=" + point.getX() +
                ", y="+point.getY()+
                ", z="+point.getZ()+
                ", edgeLength=" + edgeLength +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        Tetrahedron that = (Tetrahedron) obj;
        if(edgeLength != that.getEdgeLength()){
            return false;
        }
        return point.equals(that.getPoint());
    }

    @Override
    public int hashCode() {
        int result = point.hashCode()*31+(int)edgeLength;
        return result*31;
    }
}
