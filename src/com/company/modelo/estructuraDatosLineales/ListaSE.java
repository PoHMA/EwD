/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.modelo.estructuraDatosLineales;

/**
 *
 * @author migi
 * @param <T>
 */

public class ListaSE<T> implements Lista<T>
{
    private T ini;
    private ListaSE<T> sig;
    int longitud;
    public ListaSE()
    {
        ini=null;
        sig=null;
        longitud=0;
    }
    @Override
    public boolean vacio()
    {
        return ini==null;
    }
    @Override
    public void insertar (T d)
    {
        if(vacio())
        {
            ini=d;
            sig=new ListaSE<>();
        }else
        {
            sig.insertar(d);         
        }
        longitud++;
    }
    @Override
    public int longitud()
    {
        if(vacio())
        {
            return 0;
        }else
        {
            return longitud;
        }
    }
    @Override
    public T eliminar(int pos)
    {
        T res;
        if(vacio())
        {
            res=null;
        }else
        {
            if(pos==0)
            {
                res=ini;
                ini=sig.ini;
                sig=sig.sig;
            }else
            {
                res=sig.eliminar(pos-1);
            }
            longitud--;
        }
        return res;
    }
    @Override
    public T acceder(int i)
    {
        T res;
        if(vacio())res=null;
        else if(i==0)res=ini;
        else res=sig.acceder(i-1);
        return res;
    }
    @Override
    public String mostrar()
    {
        String res="";
        if(!vacio())
        {
            res+=ini;
            if(!sig.vacio())
            {
                res+=",";
                res+=sig.mostrar();
            }
        }
        return res;
    }
    @Override
    public void invertir()
    {
        if(!vacio())
        {
            sig.invertir();
            sig.insertar(ini);
            ini=sig.ini;
            sig=sig.sig;
        }
    }
    @Override
    public T eliminar(T d)
    {
        T res;
        if(vacio())res=null;
        else if(ini.equals(d))
        {
            res=ini;
            ini=sig.ini;
            sig=sig.sig;
        }else
        {
            res=sig.eliminar(d);
        }
        longitud--;
        return res;
    }
    public boolean insertar(T d,int i)
    {
        boolean res;
        if(vacio())
        {
            if(i==0)
            {
                res=true;
                ini=d;
                sig=new ListaSE<>();
            }else
            {
                res=false;
            }
        }else if(i==0)
        {
            sig.insertar(ini,0);
            ini=d;
            res=true;
        }else
        {
            res=sig.insertar(d,i-1);
        }
        longitud++;
        return res;
    }
    @Override
    public void vaciar()
    {
        ini=null;
        sig=null;
        longitud=0;
    }
    @Override
    public Lista<T> unir(Lista<T> l)
    {
        Lista<T> res=new ListaSE<>();
        if(vacio())
           res.copiar(l);
        else
        {
            res.copiar(this);
            res.copiar(l);
        }
        return res;
    }
    @Override
    public void copiar(Lista<T> l)
    {
        copiar(l,0);
    }
    private void copiar(Lista<T> l,int p)
    {
        if(p<l.longitud())
        {
            insertar(l.acceder(p));
            copiar(l,p+1);
        }
    }
    public T Functor1(T elem)
    {
        T res;
        if(vacio())
        {
            res=null;
        }else
        {
            if(ini.equals(elem))
            {
                res=ini;
                ini=sig.ini;
                sig=sig.sig;
            }else
            {
                res=sig.Functor1(elem);
            }
        }
        return res;
    }
    public T Functor2(T elem1,T elem2)
    {
        T res=null;
        if(!vacio())
        {
            if(ini.equals(elem1)||ini.equals(elem2))
            {
                res=ini;
                ini=sig.ini;
                sig=sig.sig;
            }else
            {
                res=sig.Functor2(elem1,elem2);
            }
        }
        return res;
    }
    @Override
    public Lista<T> dividir()
    {
        Lista<T> res=new ListaSE<>();
        if(!vacio())
        {
            res=dividir((longitud()/2)-1);
        }
        res.invertir();
        return res;
    }
    private Lista<T> dividir(int pos)
    {
        Lista<T> res=new ListaSE<>();
        if(!vacio())
        {
            if(pos==0)
            {
                res.insertar(ini);
                eliminar(ini);
            }else
            {
                res=sig.dividir(pos-1);
                res.insertar(ini);
                eliminar(ini);
            }
        }
        return res;
    }
    @Override
    public T buscarDato(T d)
    {
        T res=null;
        if(vacio())
        {
            res=null;
        }else
        {
            if(ini.equals(d))res=ini;
            else if(ini==null&&sig==null)res=null;
            else res=sig.buscarDato(d);
        }     
        return res;
    }
    public int indiceDe(T d)
    {
        int res;
        try
        {
            if(ini.equals(d))res=0;
            else if(sig==null)res=-1;
            else
            {
                res=sig.indiceDe(d);
                if(res!=-1)res++;
            }
        }catch(NullPointerException e)
        {
            res=-1;
        }
        return res;
    }
    @Override
    public T accederUlt()
    {
        return acceder(longitud()-1);
    }
    public ListaSE<T> recorrido()
    {
        ListaSE<T> res=new ListaSE<>();
        res.insertar(acceder(0));
        recorrido(2,res,0);
        return res;
    }
    private ListaSE<T> recorrido(int posA,ListaSE<T> res,int nroAnt)
    {
        int nro=posA+nroAnt;
        if(posA<longitud())
        {
            res.insertar(acceder(nro));
            nroAnt=nro;
            recorrido(posA+1,res,nroAnt);
        }
        return res;
    }
}