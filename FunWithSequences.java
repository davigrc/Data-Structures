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
public class FunWithSequences {
    static int n, m, i, j;
    public static void main (String args[]){
        Scanner dados = new Scanner(System.in);
       
        n = dados.nextInt();
        int s[] = new int[n];
        
        for(i = 0; i<s.length; i++){
            s[i] = dados.nextInt();
            
        }
        
        m = dados.nextInt();
        int q[] = new int[m];
        
        for(i = 0; i<q.length; i++){
            q[i] = dados.nextInt();
            
        }
        
        boolean b;
        for (i = 0; i < n; i++){
            b = true;
            for (j = 0; j < m; j++){
                if(q[j] == s[i]){
                    b = false;
                    break;
                } else {
                    break;
                }
                
            }
            
            if(b){
                System.out.println(s[i] + " ");
            }
        }  
    }
}