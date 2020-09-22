package com.example.momento_uno.Model;

public class NotaM {
    private int _id;
    private String nombre;
    private String nota;



    public NotaM(int id, String s, String numero){
        this.nombre =nombre;
        this.nota =nota;
    }

    public NotaM(String nombre, String nota){
        this._id=_id;
        this.nombre =nombre;
        this.nota =nota;
    }

    @Override
    public String toString() {
        return "NotaM{" +
                "_id=" + _id +
                ", nombre='" + nombre + '\'' +
                ", nota='" + nota + '\'' +
                '}';
    }



    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
}
