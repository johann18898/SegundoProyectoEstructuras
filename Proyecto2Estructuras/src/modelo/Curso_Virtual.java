/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Johann
 */
public class Curso_Virtual {
    private int Id_Curso;
    private String Nombre_Curso;
    private String Tema_Curso;
    private int Creditos;
    
    public int getId_Curso() {
        return Id_Curso;
    }
    
    public void setId_Curso(int Id_Curso) {
        this.Id_Curso = Id_Curso;
    }
    
    public String getNombre_Curso() {
        return Nombre_Curso;
    }
    
    public void setNombre_Curso(String Nombre_Curso) {
        this.Nombre_Curso = Nombre_Curso;
    }
    
    public String getTema_Curso() {
        return Tema_Curso;
    }
    
    public void setTema_Curso(String Tema_Curso) {
        this.Tema_Curso = Tema_Curso;
    }
    
    public int getCreditos() {
        return Creditos;
    }
    
    public void setCreditos(int Creditos) {
        this.Creditos = Creditos;
    }
    
    public Curso_Virtual(int Id_Curso, String Nombre_Curso, String Tema_Curso, int Creditos) {
        this.Id_Curso = Id_Curso;
        this.Nombre_Curso = Nombre_Curso;
        this.Tema_Curso = Tema_Curso;
        this.Creditos = Creditos;
    }

    public Curso_Virtual() {
    }
    
    
}
