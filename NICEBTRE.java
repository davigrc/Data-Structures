
import java.util.Scanner;
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Davi
 */
public class NICEBTRE {
    public static class Tree{
        public class No {
                private char conteudo;
                private No esq;
                private No dir;

                public No(){
                        esq = null;
                        dir = null;
                }

                public int getConteudo() {
                        return conteudo;
                }
                public void setConteudo(char conteudo) {
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

        private String sequencia;
        private No raiz;
        private int i;

        public Tree(String seq){
            sequencia = seq;
            i = 0;

            No novoNo = new No();
            raiz = novoNo;
            raiz.setConteudo(sequencia.charAt(i));

            if(raiz.getConteudo() == 'l'){
                raiz.setEsq(null);
                raiz.setDir(null);
            } else {
                raiz.setEsq(insere(raiz, sequencia.charAt(++i)));
                raiz.setDir(insere(raiz, sequencia.charAt(++i)));
            }
        }

            private No insere(No pai, char conteudo){
                No novoNo = new No();
                novoNo.setConteudo(conteudo);

                if(conteudo == 'l'){
                    novoNo.setDir(null);
                    novoNo.setEsq(null);
                } else {
                    novoNo.setEsq(insere(novoNo, sequencia.charAt(++i)));
                    novoNo.setDir(insere(novoNo, sequencia.charAt(++i)));
                }

                return novoNo;

            }

            public int profundidade(){
                return profundidade(raiz) - 1;
            }

            public int profundidade(No no){
                if (no == null){
                    return 0;
                }

                int esqProfundis = profundidade(no.getEsq());
                int dirProfundis = profundidade(no.getDir());

                if (esqProfundis > dirProfundis){
                    return ++esqProfundis;
                } else {
                    return ++dirProfundis;
                }
            }
    }

public static void main (String[] args) throws IOException{
    Scanner s = new Scanner(System.in);
    int tam = s.nextInt();
    s.nextLine();
    String sequencia;
    
    for(int i = 0; i < tam; i++ ){
        sequencia = s.nextLine();
        
        Tree t = new Tree(sequencia);
        System.out.println(t.profundidade());
    }
    
}
}


