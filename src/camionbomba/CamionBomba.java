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
        
        public Bombas(){
            head = null;
            tail = null;
            size = 0;
        }
        
        public int Size(){
            return this.size;
        }
        
        public boolean vacia(){
            return Size() == 0;
        }
        
        public void add(int cant_gas, int dist_bomba){
            
            if (vacia()) {
                head = new Node(cant_gas, dist_bomba, null, null);
                tail = head;
                head.prev = tail;
                tail.next = head;
                size++;
            }
            else{
                Node aux = tail;
                tail = new Node(cant_gas, dist_bomba, null, aux);
                aux.next = tail;
                head.prev = tail;
                tail.next = head;
                size++;
            }
        }
        
        public Node obtener(){
            Node aux = head;
            int acumulado = 0;
            
            //boolean condicion = true;
            
            while (true) {
                acumulado = (acumulado + aux.cant_gas) - aux.dist_bomba;
                
                if (acumulado >= 0) {
                    aux = aux.next;
                    if (aux == tail) {
                        return aux;
                    }
                }
                else{
                    head = head.next;
                    tail = tail.next;
                    aux = aux.next;
                    acumulado = 0;
                }
            }
        }
        
        public void imprimir(){
            Node aux = head;
            for (int i = 0; i < Size(); i++) {
                System.out.println(aux.cant_gas);
                aux = aux.next;
            }
        }
        
        private class Node{
            
            private int cant_gas;
            private int dist_bomba;
            private Node next;
            private Node prev;

            public Node(int cant_gas, int dist_bomba, Node next, Node prev) {
                this.cant_gas = cant_gas;
                this.dist_bomba = dist_bomba;
                this.next = next;
                this.prev = prev;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        
        //lectura numero de camiones
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int num_bombas = Integer.parseInt(line);
        
        Bombas bombas = new Bombas();
        
        for (int i = 0; i < num_bombas; i++) {
            line = br.readLine();
            String[] datos = line.split(" ");
            int cant_gas = Integer.parseInt(datos[0]);
            int dist_bomba = Integer.parseInt(datos[1]);
            
            bombas.add(cant_gas, dist_bomba);
            
        }
        
        System.out.println(bombas.obtener().cant_gas);
    }
    
}
