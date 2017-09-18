/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Davi
 */

import java.util.*;
public class ADAINDEX{
    static class No {
        private String conteudo;
        private No proximo;

        public No() {
            setProximo(null);
        }

        public No getProximo(){
            return proximo;
        }

        public void setProximo(No proximo){
            this.proximo = proximo;
        }

        public String getConteudo(){
            return conteudo;
        }

        public void setConteudo(String conteudo){
            this.conteudo = conteudo;
        }
    }
    
    public static class Lista{
        private No cabeca;
        private int tamanho;
        private boolean vazia;

        public Lista(int t) {
            cabeca = null;
            tamanho = t;
            vazia = true;
        }


        public void insere(String dado){
            No novoNo = new No();
            novoNo.setConteudo(dado);

            if(vazia){
                cabeca = novoNo;
                vazia = false;
            }else{
                No aux = cabeca;
            }

            No aux = this.cabeca;
            while(aux.getProximo() != null){
                aux = aux.getProximo();
            }

            novoNo.setProximo(null);
            aux.setProximo(novoNo);
        }
        
        public int buscar(String dado){
            int palavra = 0;
            No aux = cabeca;
            
            for (int i = 0; i < tamanho; i++){
                if(aux.getConteudo().startsWith(dado)){
                    palavra++;
                }
                aux = aux.getProximo();
            }
            
            return palavra;
        }
 
    }
    
    
    public static void main(String args[]) throws java.lang.Exception{
        int l, qtd;
        String prefixo, t, aux;
        Scanner s = new Scanner(System.in);
        
        t = s.nextLine();
        String[] array = t.split(" ");
        l = Integer.parseInt(array[0]);
        qtd = Integer.parseInt(array[1]);
        
        Lista TODO;
        TODO = new Lista(l);
        
        for(int i = 0; i < l; i++){
            aux = s.nextLine();
            TODO.insere(aux);
        }
        
        for(int i = 0; i < qtd; i++){
            prefixo = s.nextLine();
            
            int valor = TODO.buscar(prefixo);
            System.out.println(valor);
        }
        
    }
}

