/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.notes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author thomas.teixeira
 */
public class GetNewMusicalNotes {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int MINUS_ONE = -1;
    private static final String DASH = "/";
    private static final String EMPTY_STRING = "";
    private static final String EMPTY_VALUE = " ";
    private static final String SHARP = "#";
    private static final List<String> NOTAS = Arrays.asList("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B");
    private static final Map<String, Integer> MAP_NOTAS = new HashMap(NOTAS.size());

    static {
        for (int i = ZERO; i < NOTAS.size(); i++) {
            MAP_NOTAS.put(NOTAS.get(i), i + ONE);
        }
    }

    public static String getNota(String notas, String notaNovaEscala) {
        String[] notasEntrada = notas.split(EMPTY_VALUE);
        List<String> notasOutput = pegaNotasCorrespondentes(notasEntrada, notaNovaEscala);
        return printResult(notasOutput);
    }

    private static String printResult(List<String> notasOutput) {
        String result = EMPTY_STRING;
        int count = ONE;
        for (String out : notasOutput) {
            result += out + (count++ == notasOutput.size() ? EMPTY_STRING : EMPTY_VALUE);
        }
        return result;
    }

    private static List<String> pegaNotasCorrespondentes(String[] notasEntrada, String novaEscala) {
        if (notasEntrada == null || notasEntrada.length == ZERO) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        int positionNovaEscala = MAP_NOTAS.get(novaEscala);
        int positionPrimeiraNota = MAP_NOTAS.get(notasEntrada[ZERO]);

        int range;
        if (positionPrimeiraNota > positionNovaEscala) {
            range = (NOTAS.size() - positionPrimeiraNota) + positionNovaEscala;
        } else {
            range = positionNovaEscala - positionPrimeiraNota;
        }

        for (String nota : notasEntrada) {
            String complementoNota = EMPTY_STRING;
            if (nota.contains(SHARP)) {
                complementoNota = nota.substring(TWO, nota.length());
                nota = nota.substring(ZERO, TWO);
            } else if (nota.length() > ONE) {
                complementoNota = nota.substring(ONE, nota.length());
                nota = nota.charAt(ZERO) + EMPTY_STRING;
            }
            result.add(getNota(nota, range, complementoNota));
        }
        return result;
    }

    private static String getNota(String nota, int range, String complementoNota) {
        int position = getNewPosition(nota, range) - 1;
        if (position == MINUS_ONE) {
            position = NOTAS.size() - ONE;
        }

        String newNota = NOTAS.get(position);
        if (complementoNota.contains(DASH)) {
            newNota += DASH + NOTAS.get(getNewPosition(complementoNota.charAt(complementoNota.length() - ONE) + EMPTY_STRING, range) - ONE);
        } else {
            newNota += complementoNota;
        }
        return newNota;
    }

    private static int getNewPosition(String nota, int range) {
        int currentPosition = MAP_NOTAS.get(nota);
        currentPosition += range;
        if (currentPosition >= NOTAS.size()) {
            currentPosition -= NOTAS.size();
        }
        return currentPosition;
    }
}
