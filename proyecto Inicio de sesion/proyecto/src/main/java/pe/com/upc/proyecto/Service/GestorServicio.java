package pe.com.upc.proyecto.Service;

import pe.com.upc.proyecto.Entities.Gestor;

import java.util.List;

public interface GestorServicio {
    //solo se declaran las funciones
    public abstract Gestor createGestor(Gestor gestor);
    public abstract void updateGestor(Gestor gestor);
    public abstract Gestor getGestorById(int id);
    public abstract void deleteGestor(int id);
    public abstract List<Gestor> getAllGestor();
    public abstract boolean isGestorExists(int id);

}
