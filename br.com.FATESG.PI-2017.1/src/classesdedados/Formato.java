/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesdedados;

import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Vicente
 */

public class Formato {
    public static JFormattedTextField getFormatado(String formato) {
        JFormattedTextField campoFormatado = null;
        MaskFormatter format = new MaskFormatter();
        format.setPlaceholderCharacter('_');
        format.setValueContainsLiteralCharacters(false);
        try {
            format.setMask(formato);
            campoFormatado = new JFormattedTextField(format);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return campoFormatado;
    }
    public static JFormattedTextField getTelefone() {
        return getFormatado("(##) ####-####");
    }
    public static JFormattedTextField getCNPJ() {
        return getFormatado("##.###.###/####-##");
    }
}