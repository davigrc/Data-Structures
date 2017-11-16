
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Davi
 */
public class BST {
    public static class Binary_Search_Tree{
        public class No {
                private int conteudo;
                private No esq;
                private No dir;

                public No(int conteudo){
                    this.conteudo = conteudo;
                    esq = null;
                    dir = null;
                }

                public int getConteudo() {
                        return conteudo;
                }
                public void setConteudo(int conteudo) {
                        this.conteudo = conteudo;
                }

                public No getEsq() {
                        return esq;
                }
                public void setEsq(No esq) {
                        this.esq = esq;
                }

                public No getDir() {
                        return dir;
                }

                public void setDir(No dir) {
                        this.dir = dir;
                }
        }    
        
        private No raiz;
        private int c;

        public Binary_Search_Tree(){
            raiz = null;
            c = 0;
        }
        
        public void insere_na_raiz(int x){
            No novoNo = new No(x);
            raiz = novoNo;
        }
        public void insere(int x, No n){
            while(true){
                c++;
                if(x < n.conteudo){
                    if(n.esq == null){
                        No novoNo = new No(x);
                        n.esq = novoNo;
                        break;
                    } else {
                        n = n.esq;
                    }
                } else {
                    if (n.dir == null){
                        No novoNo = new No(x);
                        n.dir = novoNo;
                        break;
                    } else {
                        n = n.dir;
                    }
                } 
            }
        }
    }
    
    public static void main (String[] args) throws IOException{
        try{
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        Binary_Search_Tree t = new Binary_Search_Tree();
        
        int tam = Integer.parseInt(b.readLine());
        
        for (int i = 0; i < tam; i++){
            int num_da_seq = Integer.parseInt(b.readLine());
                if(i == 0){
                t.insere_na_raiz(num_da_seq);
                System.out.println(t.c);
                } else {
                t.insere(num_da_seq, t.raiz);
                System.out.println(t.c);                
                }
        }
        } catch (Exception e){

        }
    }
}
