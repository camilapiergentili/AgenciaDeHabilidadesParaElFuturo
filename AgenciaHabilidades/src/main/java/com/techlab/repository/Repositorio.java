package com.techlab.repository;

import com.techlab.interfaces.Identificable;

import java.util.ArrayList;

public class Repositorio<T extends Identificable> {

    private final ArrayList<T> db = new ArrayList<>();

    public boolean create(T objeto){
        if (objeto == null) return false;
        if(findByCodigo(objeto.getCodigo()) != null) return false;

        return db.add(objeto);
    }

    public T findByCodigo(int codigo){
        for (T elemento : db){
            if(elemento.getCodigo() == codigo) return elemento;
        }

        return null;
    }

    public ArrayList<T> listar(){
        return new ArrayList<>(db);
    }

    public boolean eliminar(T objeto) {
        if (objeto == null) return false;
        return db.remove(objeto);
    }

}
