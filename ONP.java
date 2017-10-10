/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Davi
 */

import java.util.Scanner;
public class ONP {
    public static class Pilha {
        public class No {
            private char conteudo;
            private No prox;

            public No(char conteudo, No prox){
                    this.conteudo = conteudo;
                    this.prox = prox;
            }

            public char getConteudo() {
                    return conteudo;
            }

            public void setConteudo(char conteudo) {
                    this.conteudo = conteudo;
            }

            public No getProx() {
                    return prox;
            }

            public void setProx(No prox) {
                    this.prox = prox;
            }   
        }

        No topo = null;

        public boolean vazia () {
            return topo == null;
        }

        public char topo(){
            return topo.getConteudo();
        }

        public void push(char conteudo){
            No novoNo = new No(conteudo, topo);
            topo = novoNo;
        }

        public char pop(){
            if(vazia()){
                return 0;
            }

            No aux = topo;
            char conteudo = aux.getConteudo();
            topo = aux.getProx();
            aux = null;

            return conteudo;
        }

    }

    public static void main (String[] args) throws java.lang.Exception{
        Scanner s = new Scanner(System.in);
        String e;
        int n = s.nextInt();
        
       
        for (int i = 0; i < n; i++){
            e = s.nextLine();
            Pilha p = new Pilha();
            
            for (int j = 0; j < e.length(); j++){
                char valor = e.charAt(j);
                
                if (operacao(valor)){
                    System.out.print(valor);
                } else if (operador(valor)){
                    while (!p.vazia() && maiorPrecedencia(valor, p.topo())){
                        System.out.print(p.pop());
                    }
                    
                    p.push(valor);
                } else if (valor == '('){
                    p.push(valor);
                } else if (valor == ')'){
                    while (!p.vazia() && p.topo() != '('){
                        System.out.print(p.pop());
                    }
                    
                    p.pop();
                }
                
            }
            
            while (!p.vazia()){
                System.out.print(p.pop());
            }
            
            System.out.println("");
        }
        
    }
    
    public static boolean operacao(char valor){
        return valor >= 'a' && valor <= 'z';
    }
    
    public static boolean operador(char valor){
        return valor == '+' || valor == '-' || valor == '*' || valor == '/' || valor == '^';
    }
    
    public static boolean maiorPrecedencia(char valor, char topo){
        switch(valor){
            case '+':
                return topo == '+' || topo == '-' || topo == '*' || topo == '/';
            case '-':
                return topo == '-' || topo == '*' || topo == '/';
            case '*':
                return topo == '*' || topo == '/';
            case '/':
                return topo == '/';
            default:
                return false;
        }
    }
}


