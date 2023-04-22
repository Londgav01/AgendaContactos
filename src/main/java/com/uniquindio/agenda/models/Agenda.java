package com.uniquindio.agenda.models;

import com.uniquindio.agenda.exceptions.ContactoException;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.swing.JOptionPane;
public class Agenda {
    private String nombre;
    private Contacto[] listaContactos;
    private Grupo[] listaGrupos;
    private Reunion[] listaReuniones;


    public Agenda(String nombre, int numeroContactos,int numeroGrupos,int numeroReuniones) {
        super();
        this.nombre = nombre;
        this.listaContactos = new Contacto[numeroContactos];
        this.listaGrupos = new Grupo[numeroGrupos];
        this.listaReuniones = new Reunion[numeroReuniones];
    }

    public Agenda(String nombre) {
        this.nombre = nombre;

    }

    public Agenda() {
        super();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static Contacto[] getListaContactos() {
        return listaContactos;
    }

    public void setListaContactos(Contacto[] listaContactos) {
        this.listaContactos = listaContactos;
    }

    public Grupo[] getListaGrupos() {
        return listaGrupos;
    }

    public void setListaGrupos(Grupo[] listaGrupos) {
        this.listaGrupos = listaGrupos;
    }

    public Reunion[] getListaReuniones() {
        return listaReuniones;
    }

    public void setListaReuniones(Reunion[] listaReuniones) {
        this.listaReuniones = listaReuniones;
    }

    @Override
    public String toString() {
        return "Agenda [nombre=" + nombre + "]";
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Agenda other = (Agenda) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }


    public void aniadirContacto(Contacto newContacto) throws ContactoException {

        Contacto contacto = buscarContacto(newContacto);
        int posDisponible = 0;

        if(contacto != null){
            throw new ContactoException("El contacto ya existe");
        }
        posDisponible = obtenerPosicion();

        if(posDisponible == -1){
            throw new ContactoException("Agenda llena");
        }
        listaContactos[posDisponible] = newContacto;
    }

    public boolean eliminarContacto(Contacto contacto) {
        boolean eliminado = false;

        for (int i = 0; i < listaContactos.length; i++) {
            if (listaContactos[i] != null && listaContactos[i].equals(contacto)) {
                listaContactos[i] = null;
                eliminado = true;
                break;
            }
        }
        return eliminado;
    }

    private int obtenerPosicion() {
        OptionalInt indice = IntStream.range(0, listaContactos.length)
                .filter(i -> listaContactos[i] == null)
                .findFirst();
        return indice.isPresent() ? indice.getAsInt() : -1;
    }

    private Contacto buscarContacto(Contacto newContacto) throws ContactoException {
        List<Contacto> asList = Arrays.asList(listaContactos);
        Optional<Contacto> contactoOpcional = asList.stream().filter(c -> c.equals(newContacto)).findFirst();

        if (contactoOpcional.isPresent()) {
            return contactoOpcional.get();
        } else {
            throw new ContactoException("Contacto no existente");
        }
    }

    private boolean existeContacto(Contacto newContacto) {
        List<Contacto> asList = Arrays.asList(listaContactos);
        return asList.stream().anyMatch(c -> c.equals(newContacto));
    }

    private int huecosLibres() {
        long huecosDisponibles = Arrays.stream(listaContactos)
                .filter(Objects::isNull)
                .count();
        if(huecosDisponibles == 0) {
            JOptionPane.showMessageDialog(null, "no hay huecos disponibles");
        }
        return (int)huecosDisponibles;
    }

    public void buscarContactoPorNombre(String nombre) throws ContactoException {

        Optional<Contacto> contactoOpcional = Arrays.stream(listaContactos)
                .filter(contacto -> contacto != null && contacto.getNombre().equals(nombre))
                .findFirst();

        if(contactoOpcional.isPresent()){
            Contacto contacto= contactoOpcional.get();
            JOptionPane.showMessageDialog(null, contacto.getNombre() + " su número de telefono es: "
                    + contacto.getTelefono());
        }else{
            throw new ContactoException("Contacto no encontrado");
        }
    }

}
