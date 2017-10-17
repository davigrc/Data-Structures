
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
public class ADAQUEUE {
    public static class Fila{
    public class No {
	private int conteudo;
	private No prox;
        private No ant;
	
	public No(){
		prox = null;
                ant = null;
                conteudo = 0;
	}

	public int getConteudo() {
		return conteudo;
	}

	public void setConteudo(int conteudo) {
		this.conteudo = conteudo;
	}

	public No getProx() {
		return prox;
	}

	public void setProx(No prox) {
		this.prox = prox;
	}
        
        public No getAnt(){
            return ant;
        }
        
        public void setAnt(No ant){
            this.ant = ant;
        }
    }
    
    No inicio;
    No fim;
    int nElementos;
    public boolean reverso = false;
    
    public boolean vazia(){
        if (nElementos == 0){
            return true;
        }
        
        return false;
    }
    
    public void toFront(int valor){
        if(reverso){
            reverse();
            push_back(valor);
        } else {
        No novoNo = new No();
        novoNo.setConteudo(valor);
        novoNo.setProx(null);
        
        if (vazia()){
            fim = novoNo;
        } else {
            novoNo.setProx(inicio);
            inicio.setAnt(novoNo);
        }
        
        inicio = novoNo;
        nElementos++;
        return;
        }
        
        reverse();
    }
    
    public void removeFront() throws Exception {
        if (vazia()){
            throw new Exception("Fila vazia");
        }
        
        if(reverso){
            reverse();
            removeBack();
        } else {
        No novoNo = inicio;
        if(inicio == fim){
            fim = null;
            inicio = null;
        } else {
            inicio = inicio.getProx();
            inicio.setAnt(null);
        }

        novoNo = null;
        nElementos--;
        return;
        }
        
        reverse();
    }

    public int front() throws Exception{
        int novo = inicio.getConteudo();
        removeFront();
        return novo;        
    }
    
    public void push_back(int valor){
        if(reverso){
            reverse();
            toFront(valor);
        } else {
        No novoNo = new No();
        novoNo.setConteudo(valor);
        novoNo.setProx(null);
        
        if (vazia()){
            novoNo.setProx(null);
            inicio = novoNo;
            fim = novoNo;
        } else {
            novoNo.setAnt(fim);
            fim.setProx(novoNo);
        }
        
        fim = novoNo;
        nElementos++;
        return;
        }
        
        reverse();
    }
    
    public void removeBack() throws Exception {
        if (vazia()){
            throw new Exception("Fila vazia");
        }
        
        if(reverso){
            reverse();
            removeFront();
        } else {
        
        No novoNo = fim;
        if(inicio == fim){
            fim = null;
            inicio = null;
        } else {
            fim = fim.getAnt();
            fim.setProx(null);
        }

        novoNo = null;
        nElementos--;
        return;
        }
        reverse();
    }
    
    public int back() throws Exception{
        int novo = fim.getConteudo();
        removeBack();
        return novo;        
    }
    
    public void reverse(){
        No novoNo = inicio;
        inicio = fim;
        reverso = !reverso;
        
    }

    }
    
    public static void main (String[] args) throws Exception {
        Fila f = new Fila();
        Scanner s = new Scanner(System.in);
        int d = s.nextInt();
        String str;
        
        for (int i = 0; i <= d; i++){
            str = s.nextLine();
            String[] string = str.split(" ");
            
            try{
            switch(string[0]){
                case "back":
                    System.out.println(f.back());
                    break;
                case "front":
                    System.out.println(f.front());
                    break;
                case "reverse":
                    f.reverse();
                    break;
                case "push_back":
                    f.push_back(Integer.parseInt(string[1]));
                    break;
                case "toFront":
                    f.toFront(Integer.parseInt(string[1]));
                    break;
                default:
                    break;
            }
            
            } catch(Exception e){
                System.out.println("No job for Ada?");
            }
        }
    }    
}
