/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camionbomba;

import camionbomba.CamionBomba.Bombas.Node;
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
        
        public void add(long cant_gas, long dist_bomba){
            
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
            long acumulado = 0;
            
            //boolean condicion = true;
            
            while (true) {
                acumulado = (acumulado + aux.cant_gas) - aux.dist_bomba;
                
                if (acumulado >= 0) {
                    aux = aux.next;
                    if (aux == head) {
                        return aux;
                    }
                }
                else{
                    tail = tail.next;
                    head = head.next;
                    aux = head;
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
        
        public class Node{
            
            private long cant_gas;
            private long dist_bomba;
            private Node next;
            private Node prev;

            public Node(long cant_gas, long dist_bomba, Node next, Node prev) {
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
            long cant_gas = Integer.parseInt(datos[0]);
            long dist_bomba = Integer.parseInt(datos[1]);
            
            bombas.add(cant_gas, dist_bomba);
        }
        
        Node resultado = bombas.obtener();
        Node aux = resultado.prev;
        
        int contador = 0;
        while (aux != resultado) {            
            contador++;
            aux = aux.prev;
        }
        System.out.println(contador);
    }
    
}
