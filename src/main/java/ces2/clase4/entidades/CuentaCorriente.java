/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ces2.clase4.entidades;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author alejo
 */
public class CuentaCorriente implements CuentaBancaria {

    private int numeroCuenta;
    private double balance = 0;
    private boolean esExtranjero = false;
    List<String> movimientos = new LinkedList<>();
    
    public CuentaCorriente(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    
    @Override
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public boolean esExtranjero() {
        return esExtranjero;
    }

    @Override
    public void setExtranjero(boolean esExtranjero) {
        this.esExtranjero = esExtranjero;
    }

    @Override
    public void depositar(double cantidad) {
        balance += cantidad;
    }

    @Override
    public boolean tieneGarantia(double cantidad) {
        return balance >= 2 * cantidad/3;
    }
    
    public String toString(){
        return "Cuenta corriente " + numeroCuenta
                + ": balance = " + balance
                + ", es " + (esExtranjero ? "extranjero" : "local");
    }

    @Override
    public int compareTo(CuentaBancaria t) {
        double bal1 = this.getBalance();
        double bal2 = t.getBalance();
        
        if (bal1 == bal2) {
            return this.getNumeroCuenta() - t.getNumeroCuenta();
        } else {
            return (int) (bal1 - bal2);
        }
    }
 
    //Implementar funcion retirar(double cantidad)

    @Override
    public void retirar(double cantidad) {
        balance -= cantidad;
    }

    @Override
    public void agregarMovimiento(String movimiento) {
        this.movimientos.add(movimiento);
    }

    @Override
    public List<String> getMovimientos() {
        return this.movimientos;
    }
    
}
