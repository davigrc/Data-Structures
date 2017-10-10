/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Davi
 */

import java.io.IOException;
import java.util.Scanner;

public class Sanidade{
    static class LDE {
    private No inicio;
    private No fim;
    private int tam;

    public LDE(){
        inicio = null;
        fim = null;
        tam = 0;
    }
    
  
    public int tamanho() {
        return tam;
    }

    void insere (No n) {
     int i = 0;
        if (tam != 0){ 
            No m = inicio;
            while(m.getProximo() != null){
               m = m.getProximo();
             }
               n.setProximo(null);
               m.setProximo(n);
               n.setAnterior(fim);
               fim.setProximo(n);
               fim = n;
               ++tam;
        
        }else{
           n.setProximo(inicio);
           n.setAnterior(null);
           fim = n;
           inicio = n;
           tam++;
        }  
        
    }
    
        No pegaNo(int pos) {
	if (pos > tam) {
            return null;
        }

	No n = inicio;
	for (int i = 0; i < pos; ++i) {
            n = n.getProximo();
	}
	return n;
    }
}
    
    static class No {
    
    private No prox;
    private No ant;
    private String conteudo;
    private String proximo;
    private String anterior;

    public No(){
        ant = null;
        proximo = null;
    }

    public No getProximo(){
        return prox;
    }

    public void setProximo(No prox){
        this.prox = prox;
    }

    public No getAnterior(){
        return ant;
    }

    public void setAnterior(No ant){
        this.ant = ant;
    }
    
    public String getConteudo(){
        return conteudo;
    }

    public void setConteudo(String conteudo){
        this.conteudo = conteudo;
    }
    
    public String getConteudoProx(){
        return proximo;
    }
    public void setConteudoProx(String proximo){
        this.proximo = proximo;
    }
    
    public String getConteudoAnt(){
        return anterior;
    }
    public void setConteudoAnt(String anterior){
        this.anterior = anterior;
    }
}

    public static void main(String[] args){
        LDE l = new LDE();
        Scanner s = new Scanner(System.in);      
        String anterior, conteudo, proximo, ant, cont, prox;
        boolean sano = true;
       
        String f = s.nextLine();
        No n = new No();
        String str = " ";
        
        
        int result = f.indexOf(str);
        conteudo = f.substring(0,result);
        n.setConteudo(conteudo);
        
        int result2 = f.lastIndexOf(str);
        anterior = f.substring(result + 1, result2);
        n.setConteudoAnt(anterior);
        
        proximo = f.substring(result2 + 1,f.length());
        n.setConteudoProx(proximo);
        l.insere(n);

        String st = s.nextLine();
        No nn = new No();
        int result3 = st.indexOf(str);
        cont = st.substring(0, result3);
        nn.setConteudo(cont);
        
        int result4 = st.lastIndexOf(str);
        ant = st.substring(result3 + 1,result4);
        nn.setConteudoAnt(ant);
        
        prox = st.substring(result4 + 1,st.length());
        nn.setConteudoProx(prox);
        
        l.insere(nn);
        
        while(true){
          
            String ss = s.nextLine();
            if(ss.isEmpty()){
                break;
            }
            
            No NovoNo = new No();
            
            String res = " ";
        
            int result5 = ss.indexOf(res);
            conteudo = ss.substring(0, result5);
            NovoNo.setConteudo(conteudo);
        
            int result6 = ss.lastIndexOf(res);
            anterior = ss.substring(result5 + 1,result6);
            NovoNo.setConteudoAnt(anterior);
        
            proximo = ss.substring(result6 + 1,ss.length());
            NovoNo.setConteudoProx(proximo);
           
            l.insere(NovoNo);
        }
        
        String Frente = new String();
        String Tras = new String();
        
        int aux = 0;
        Frente += n.getConteudo();
	for (No noo = n; n != nn; ++aux) {
		for (int i = 0; i < l.tamanho(); i++) {
			if (noo.getConteudoProx().equals(l.pegaNo(i).getConteudo())) {
				noo = l.pegaNo(i);
				Frente += l.pegaNo(i).getConteudo();
                                break; 
			}
		}
		
		if (aux > l.tamanho()) {
			sano = false;
			break;
		}
	}

        int aux2 = 0;
        Tras += nn.getConteudo();
        for (No noo = nn; noo != nn; ++aux2) {
            for (int i = 0; i < l.tamanho(); ++i) {
		if (noo.getConteudoAnt().equals(l.pegaNo(i).getConteudo())) {
                    noo = l.pegaNo(i);
                Tras += l.pegaNo(i).getConteudo();
                    break;
		}
            }
		
            if (aux2 > l.tamanho()) {
		sano = false;
		break;
		}
	}
        
        StringBuffer sb = new StringBuffer(Tras);
        
        if (Frente.equals(sb.reverse().toString()) && sano) {
		System.out.println("Sana");
	} else {
		System.out.println("Insana");
	}
    
    }    
}