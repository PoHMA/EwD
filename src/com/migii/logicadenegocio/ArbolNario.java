package com.migii.logicadenegocio;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ArbolNario<T> {
  private T raiz;
  private List<ArbolNario<T>> ramas;
  private String recorrido = "";

  public ArbolNario(T r, List<ArbolNario<T>> ramas){
    this.raiz = r;
    this.ramas = ramas;
  }

  public ArbolNario(T r){
    this.raiz = r;
    ramas = new ArrayList<>();
  }

  public void dfs() {

  }

  String bfs(){
    String answer = ""+raiz;
    Queue<ArbolNario<T>> cola = new LinkedList<>();
    ArbolNario<T> branch;
    List<ArbolNario<T>> hijos;
    cola.addAll(ramas);
    while(!cola.isEmpty()){
      branch = cola.poll();
      answer = answer + "-" + branch.raiz;
      hijos = branch.getHijos();
      for(int i = 0; i < hijos.size(); i++){
        cola.add(hijos.get(i));
      }
    }
    return answer;
  }

  ArbolBinario<T> convertirBinario(){
    ArbolNario<T> branch;
    List<ArbolBinario<T>> nuevoArbol = new ArrayList<>();
    for(int i = 0; i < ramas.size(); i++){
      branch = ramas.get(i);
      nuevoArbol.add(branch.convertirBinario());
    }
    return transformar(nuevoArbol);
  }

  private ArbolBinario<T> transformar(List<ArbolBinario<T>> nuevoArbol) {
    int tam = nuevoArbol.size();
    ArbolBinario<T> answer;
    switch (tam){
      case 0:
        answer = new ArbolBinario<>(this.raiz,null,null);
        break;
      case 1:
        answer = new ArbolBinario<>(this.raiz,nuevoArbol.get(0),null);
        break;
      default:
        answer = new ArbolBinario<T>(this.raiz, unir(nuevoArbol), null);
        break;
    }
    return answer;
  }

  private ArbolBinario<T> unir(List<ArbolBinario<T>> nuevoArbol) {
    ArbolBinario<T> answer = nuevoArbol.get(nuevoArbol.size()-1);
    ArbolBinario<T> copia;
    for(int i = nuevoArbol.size() - 2 ; i>=0 ;i--){
      copia = answer;
      answer = nuevoArbol.get(i);
      answer.setBranchRight(copia);
    }
    return answer;
  }


  private List<ArbolNario<T>> getHijos(){
    return ramas;
  }

  @Override
  public String toString(){
    return recorrido;
  }

}

