/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.notes;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author thomas.teixeira
 */
public class GetNewMusicalNotesTest {
    
    @Test
    public void shouldConvertAToF(){
        String result = GetNewMusicalNotes.getNota("A G A7 D/E", "F");
        
        assertNotNull(result);
        assertEquals(result, "F D# F7 A#/C");
    }
    
    @Test
    public void shouldConvertGToC(){
        String result = GetNewMusicalNotes.getNota("G D C Em", "C");
        
        assertNotNull(result);
        assertEquals(result, "C G F Am");
    }
    
    @Test
    public void shouldConvertAToD(){
        String result = GetNewMusicalNotes.getNota("A F#m D Bm E", "D");
        
        assertNotNull(result);
        assertEquals(result, "D Bm G Em A");
    }
}
