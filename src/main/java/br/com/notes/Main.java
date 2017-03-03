/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.notes;

/**
 *
 * @author thomas.teixeira
 */
public class Main {
    public static void main(String[] args) {

        String notaNovaEscala = "F";
        String in = "A G A7 D/E";

        String result = GetNewMusicalNotes.getNota(in, notaNovaEscala);
        System.out.println(result);
    }
}
