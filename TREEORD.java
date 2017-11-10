/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Davi
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.in;

class Tree_order{
    class No{
        private int conteudo;
        private No esq;
        private No dir;
        
        public int getConteudo(){
            return conteudo;
        }
        
        public void setConteudo(int conteudo){
            this.conteudo = conteudo;
        }
        
        public No getEsq(){
            return esq;
        }
        
        public void setEsq(No n){
            esq = n;
        }
        
        public No getDir(){
            return dir;
        }
        
        public void setDir(No n){
            dir = n;
        }
        
    }    
    private No raiz; 
    private int tamanho;
    private int[] inOrdem, posOrdem, preOrdem;
    private int preIndex, posIndex;
    
    public Tree_order(int[] pre, int[] pos, int[] in, int s){
        inOrdem = in;
        posOrdem = pos;
        preOrdem = pre;
        preIndex = 0;
        posIndex = 0;
        tamanho = s;
        
        raiz = Tree(0, tamanho);
    }
    
    private No Tree(int inicio, int fim){
        if (inicio > fim){
            return null;
        }
       
        No novoNo = new No();
        novoNo.setConteudo(preOrdem[preIndex++]);
  
        
        if (inicio == fim){
            return novoNo;
        }
        
        int inIndex = pesquisa(inicio, fim, novoNo.getConteudo());
  
        novoNo.setEsq(Tree(inicio, inIndex - 1)) ;
        novoNo.setDir(Tree(inIndex + 1, fim)) ;
  
        return novoNo;
        
    }

    public int pesquisa(int inicio, int fim, int valor) {
        int i;
        for (i = inicio; i <= fim; i++) {
            if (inOrdem[i] == valor){
                return i;
            }
        }
       
       return i;
    }
    
    public boolean PosOrd(){
        try{
           PosOrd(raiz);
           return true; 
        }catch (Exception e){
            return false;
        }
    }
    
    private void PosOrd(No n) throws Exception{
        if (n == null) 
            return;
        
        PosOrd(n.getEsq());
        PosOrd(n.getDir());
        
        if(posOrdem[posIndex++] != n.getConteudo()){
            throw new Exception ("Mismatch traveral");
        }
    }
    
    
}

public class TREEORD {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        
        int[][]seq = new int[3][n];
        int i; 
        
        String aux[]; 
                
        aux = in.readLine().split(" ");
        for(i = 0; i < n; i++){
            seq[0][i] = Integer.parseInt(aux[i]);
        }
        
        aux = in.readLine().split(" ");
         for(i = 0; i < n; i++){
            seq[1][i] = Integer.parseInt(aux[i]);
        }
        
        aux = in.readLine().split(" ");
        for(i = 0; i < n; i++){
            seq[2][i] = Integer.parseInt(aux[i]);
        }
                
        Tree_order t = new Tree_order(seq[0], seq[1], seq[2], n - 1);      
        
        if(t.PosOrd()){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
      
    }
}