package com.migii.logicadenegocio;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public  class ArbolBinario<T>{
  public T raiz;
  private ArbolBinario<T> izq,der;
  public ArbolBinario (T r, ArbolBinario<T> i, ArbolBinario<T> d){
    this.raiz = r;
    this.izq = i;
    this.der = d;
  }

  public void setBranchRight(ArbolBinario<T> right) {
    this.der = right;
  }

  String bfs(){
    String answer = ""+raiz;
    Queue<ArbolBinario<T>> cola = new LinkedList<>();
    ArbolBinario<T> branch;
    List<ArbolNario<T>> hijos;
    if(izq != null)
      cola.add(izq);
    if(der != null)
      cola.add(der);
    while(!cola.isEmpty()){
      branch = cola.poll();
      answer = answer + "-" + branch.raiz;
      if(branch.getIzq() != null)
        cola.add(branch.izq);
      if(branch.getDer() != null)
        cola.add(branch.der);
    }
    return answer;
  }

  private ArbolBinario<T> getDer() {
    return der;
  }

  private ArbolBinario<T> getIzq() {
    return izq;
  }

}
