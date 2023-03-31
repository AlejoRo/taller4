/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ces2.clase4.entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author alejo
 */
public class Reporte extends Banco {

    public String[] imprimirInformacionTodasCuentas() {
        HashMap cuentas = getCuentas();
        String[] cuentasString = new String[cuentas.size()];
        int indice = 0;
        for (int i = 1000; i < cuentas.size(); i++) {
            cuentasString[indice] = cuentas.get(i).toString();
            indice++;
        }
        return cuentasString;
    }

    public String imprimirInformacionUnaCuenta(int numcta) {
        String cuenta = getCuentas().get(numcta).toString();
        return cuenta;
    }

    public String imprimirCuentaConMayorBalance() {
        List<CuentaBancaria> cuentas;
        cuentas = new ArrayList<CuentaBancaria>(getCuentas().values());

        CuentaBancaria maxbal = Collections.max(cuentas);
        return maxbal.toString();
    }

    public String imprimirCuentaConMenorBalance() {
        List<CuentaBancaria> cuentas;
        cuentas = new ArrayList<CuentaBancaria>(getCuentas().values());

        CuentaBancaria minbal = Collections.min(cuentas);
        return minbal.toString();
    }

}
