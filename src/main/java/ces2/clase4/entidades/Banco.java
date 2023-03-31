/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ces2.clase4.entidades;

import java.util.HashMap;

/**
 *
 * @author alejo
 */
public class Banco {

    private HashMap<Integer, CuentaBancaria> cuentas;

    private int siguienteCuenta;

    public Banco() {
        this.cuentas = new HashMap();
        this.siguienteCuenta = 1000;
    }

    public int nuevaCuenta(int tipo, boolean esExtranjero) {
        int numcta = this.siguienteCuenta++;
        CuentaBancaria cta_banc;
        if (tipo == 1) {
            cta_banc = new CuentaDeAhorros(numcta);
        } else {
            cta_banc = new CuentaCorriente(numcta);
        }
        cta_banc.setExtranjero(esExtranjero);
        this.cuentas.put(numcta, cta_banc);
        return numcta;
    }

    public double getBalance(int numcta) {
        CuentaBancaria cb = this.cuentas.get(numcta);
        return cb.getBalance();
    }

    public void depositar(double cant, int numcta) {
        CuentaBancaria cb = this.cuentas.get(numcta);
        cb.depositar(cant);
        System.out.println("hola");
        cb.agregarMovimiento("Deposito por " + cant);
    }

    public boolean autorizarPrestamo(double cant, int numcta) {
        boolean resultado = false;
        CuentaBancaria cb = this.cuentas.get(numcta);
        if (cb.tieneGarantia(cant)) {
            cb.depositar(cant);
            resultado = true;
            cb.agregarMovimiento("Préstamo por " + cant);
        }
        return resultado;
    }

    public boolean addInteres(int numcta) {
        boolean resultado = false;
        CuentaBancaria cb = this.cuentas.get(numcta);
        if (cb instanceof CuentaDeAhorros) {
            CuentaDeAhorros cda = (CuentaDeAhorros) cb;
            double movimiento = cda.addInteres();
            resultado = true;
            cda.agregarMovimiento("Interes por " + movimiento);
        }
        return resultado;
    }

    public HashMap<Integer, CuentaBancaria> getCuentas() {
        return cuentas;
    }

    public void cambiarNacionalidad(boolean nacionalidad, int numcta) {
        CuentaBancaria cb = this.cuentas.get(numcta);
        cb.setExtranjero(nacionalidad);
    }

    public void retirar(double cant, int numcta) {
        CuentaBancaria cb = this.cuentas.get(numcta);
        if (cb.getBalance() >= cant) {
            cb.retirar(cant);
            cb.agregarMovimiento("Retiro por " + cant);
        }
    }

}
