package com.migii.logicadenegocio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class ArbolNarioTest {

  private ArbolNario<Integer> arbol4;

  @Before
  public void createTree(){
    ArrayList<ArbolNario<Integer>> ramas = new ArrayList<>();
    ramas.add(new ArbolNario<>(12));
    ramas.add(new ArbolNario<>(17));
    ramas.add(new ArbolNario<>(7));
    ArbolNario<Integer> dos = new ArbolNario<Integer>(2, ramas);
    ramas = new ArrayList<>();
    ramas.add(new ArbolNario<>(9));
    ArbolNario<Integer> arbol5 = new ArbolNario<Integer>(5, ramas);
    ramas = new ArrayList<>();
    ramas.add(new ArbolNario<>(16));
    ramas.add(dos);
    ArbolNario<Integer> arbol14 = new ArbolNario<Integer>(14,ramas);
    ramas = new ArrayList<>();
    ramas.add(new ArbolNario<>(6));
    ArbolNario<Integer> arbol13 = new ArbolNario<Integer>(13,ramas);
    ramas = new ArrayList<>();
    ramas.add(new ArbolNario<>(15));
    ramas.add(arbol5);
    ramas.add(new ArbolNario<>(11));
    ArbolNario<Integer> arbol18 = new ArbolNario<Integer>(18,ramas);
    ramas = new ArrayList<>();
    ramas.add(new ArbolNario<>(20));
    ArbolNario<Integer> arbol1 = new ArbolNario<Integer>(1,ramas);
    ramas = new ArrayList<>();
    ramas.add(arbol14);
    ramas.add(new ArbolNario<>(19));
    ArbolNario<Integer> arbol8 = new ArbolNario<Integer>(8,ramas);
    ramas = new ArrayList<>();
    ramas.add(arbol13);
    ramas.add(new ArbolNario<>(3));
    ramas.add(arbol18);
    ArbolNario<Integer> arbol10 = new ArbolNario<Integer>(10,ramas);
    ramas = new ArrayList<>();
    ramas.add(arbol1);
    ramas.add(arbol8);
    ramas.add(arbol10);
    arbol4 = new ArbolNario<Integer>(4,ramas);
  }

  @Test
  public void bfs(){
    assertEquals("4-1-8-10-20-14-19-13-3-18-16-2-6-15-5-11-12-17-7-9",arbol4.bfs());
  }

  @Test
  public void convertirBinario(){
    ArbolBinario<Integer> answer = arbol4.convertirBinario();
    assertEquals("4-1-20-8-14-10-16-19-13-2-6-3-12-18-17-15-7-5-9-11",answer.bfs());
  }

  @Test
  public void convertirBinariso(){
    //ArbolNario<Integer> answer = arbol4.convertirBinario();
    //assertEquals("4-1-20-8-14-10-16-19-13-2-6-3-12-18-17-15-7-5-9-11",answer.bfs());
  }

}