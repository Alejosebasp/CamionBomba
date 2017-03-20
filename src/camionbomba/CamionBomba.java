/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camionbomba;

import java.util.*;
import java.io.*;

/**
 *
 * @author Alejosebasp
 */
public class CamionBomba {
    
    public static class Bombas{
        private Node head;
        private Node tail;
        private int size;
        
        
        private class Node{
            private int cant_gas;
            private int dist_bomba;
            private Node next;
            private Node prev;
        }
    }

    public static void main(String[] args) throws IOException {
        
        //lectura numero de camiones
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int num_bombas = Integer.parseInt(line);
        
        line =br.readLine();
        for (int i = 0; i < num_bombas; i++) {
            
        }
    }
    
}
