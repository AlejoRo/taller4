/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ces2.clase4.entidades;

import java.util.List;

/**
 *
 * @author alejo
 */
public interface CuentaBancaria extends Comparable<CuentaBancaria>{

    int getNumeroCuenta();
    double getBalance();
    boolean esExtranjero();
    void setExtranjero(boolean esExtranjero);
    void depositar(double cantidad);
    void retirar(double cantidad);
    void agregarMovimiento(String movimiento);
    List<String> getMovimientos();
    
    boolean tieneGarantia(double cantidad);
    String toString();
    

    
}
