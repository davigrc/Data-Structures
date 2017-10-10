/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Davi
 */

import java.util.LinkedList;
import java.util.Scanner;

class ONP{
    static class pilha{
        private int dados[];
        private int topo;
        private int tamMax;

        public pilha(){
            tamMax = 400;
            dados = new int[tamMax];
            topo = -1;
        }
        
        public int tamanho(){
            return topo+1;
        }
        
        public boolean vazia(){
            if (topo == -1){
                return true;
            }
            else{
                return false;
            }
        }
        
        public boolean cheia(){
            if (topo == (tamMax-1))
                return true;
            else
                return false;

        }
             
        public int topo () {
            if (vazia())
            return -1; 

        return dados[topo];
        }
        
        public int pop() {
            if (vazia()){
                return -1; // Pilha vazia
            }
            int valor = dados[topo];
            topo--;
            return valor;
        }
        
        public boolean push (int valor) {
            if (cheia()){
                return false;
            }
            topo++;
            dados[topo] = valor;
            return true;
        }
        
}

    public static LinkedList<String> l = new LinkedList<String>();
    
    public static void main (String[] args){
        Scanner s = new Scanner(System.in);
        
        int n = Integer.parseInt(s.nextLine());
       
        
        for (int i = 0; i<n ;i++){
            String a = s.nextLine();
            l.add(a);
     
        }
        
        for (String w : l){
            resulta(w);
        }  
    }
    
     public static void resulta (String str){
        pilha p = new pilha();
        char equacao[] = str.toCharArray();
        
        for(int i = 0; i < str.length(); i++){
           char atual = equacao[i];
           
           if (atual == '^' || atual == '('){
            p.push(atual);
            
           }else if (atual == '*' || atual == '/') {
		if (p.topo() != '^'){
                  
                    p.push(atual);
                }
	   }else if (atual == '+' || atual == '-'){
                if (p.topo() != '^' && p.topo() != '*' && p.topo() != '/'){
                  
                    p.push(atual);
                }
	   }else if ((atual == ')')){
                while (p.topo() != '('){
		System.out.printf("%c", p.topo());
		p.pop();
            }
                p.pop();
            }else{
                System.out.printf("%c", atual);
            }
        }
        
        System.out.printf("\n");  
    }
}