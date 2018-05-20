/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.modelo.estructuraDatosLineales;

/**
 *
 * @author migi
 */
public interface Lista<T> 
{
    public boolean vacio();
    public void insertar(T d);
    public T eliminar(int pos);
    //aniadido 28/04/2017
    public T eliminar(T d);
    //
    public void copiar(Lista<T> l);
    public int longitud();
    public T acceder(int i);
    public String mostrar();
    public void invertir();
    public Lista<T> unir(Lista<T> l);
    public void vaciar();
    public Lista<T> dividir();
    public T buscarDato(T d);
    public T accederUlt();
}

