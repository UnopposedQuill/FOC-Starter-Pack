/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertidormultibase;

import com.sun.istack.internal.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author Esteban
 */
public class Calculadora {
    
    private Numero numero1;
    private Numero numero2;
    private Procedimiento procedimiento;
    private int baseSalida;

    //constructor donde se mete todo lo que se desea que haga de una vez
    public Calculadora(Numero numero1, Numero numero2, Procedimiento procedimiento, int baseSalida) {
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.procedimiento = procedimiento;
        this.baseSalida = baseSalida;
    }

    //en este constructor no se inicializa nada, sólo se pide memoria
    public Calculadora() {
        this.baseSalida = 10;
        this.numero1 = null;
        this.numero2 = null;
        this.procedimiento = null;
    }

    //area de setters
    public void setNumero1(Numero numero1) {
        this.numero1 = numero1;
    }

    public void setNumero2(Numero numero2) {
        this.numero2 = numero2;
    }

    public void setProcedimiento(Procedimiento procedimiento) {
        this.procedimiento = procedimiento;
    }

    public void setBaseSalida(int baseSalida) {
        this.baseSalida = baseSalida;
    }
    
    /**
     * Método encargado de ingresar los valores correspondientes a la calculadora
     * @param procedimiento Una instancia del enum procedimiento que le dirá a la calculadora qué operación se desea hacer
     * @param numero1 El primer operando de la operación
     * @param numero2 El segundo operando de la operación
     * @param baseSalida La base en la que se desea que esté el resultado de la operación
     */
    public void ingresarProcedimiento(Procedimiento procedimiento,Numero numero1, Numero numero2,int baseSalida){
        //este método ingresa todos los datos a la calculadora independiente de lo que sean
        this.baseSalida = baseSalida;
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.procedimiento = procedimiento;
    }

    /**
     * Método que hará el procedimiento de la calculadora, este está clasificado en:
     * - Cálculos sin Operandos
     * - Cálculos con un Operando
     * - Cálculos con dos Operandos
     * @return Un String dependiendo de los valores interiores actuales de la calculadora
     */
    public String realizarProcedimiento(){
        //primero reviso las operaciones sin operando, que sería la máxima capacidad
        if((this.procedimiento == Procedimiento.MaximaCapacidadBase)){
            if(this.baseSalida < 11){
                return String.valueOf(baseSalida-1);
            }
            else{
                String resultado = "";//aquí irá el resultado a mostrar
                int mayorLetraInt = ((baseSalida-10) % 26 + 65);
                char mayorLetra = (char) (mayorLetraInt);//consigo la mayor letra posible en el sistema numérico
                resultado = resultado.concat(String.valueOf(mayorLetra));
                //sólo falta pegarle la cantidad de techos
                int cantidadTechos = (baseSalida-10) / 26;
                for (int i = 0; i < (cantidadTechos); i++) {
                    resultado = resultado.concat("'");
                }
                System.out.println("Resultado: " + resultado + ". Mayor Letra: " + mayorLetraInt + ". Cantidad de Techos: " + cantidadTechos);
                return resultado;
            }
        }
        if ((this.numero1 == null && this.numero2 == null) || this.procedimiento == null){
            return " ";
        }
        else{
            if(this.numero1.getBase()!=10){
                System.out.println("Cambiando primer número");
                this.numero1.cambiarBase(10);
            }
            else{
                System.out.println("El número 1 ya estaba en base 10");
            }
            if(this.numero2 != null){
                if(this.numero2.getBase()!=10){
                    this.numero2.cambiarBase(10);
                    System.out.println("Cambiando segundo número");
                }
                else{
                    System.out.println("El número 2 ya estaba en base 10");
                }
            }
            else{
                //System.out.println("El número 2 ya estaba en base 10");
            }
            if(this.procedimiento == Procedimiento.Conversion){
                //si el procedimiento es igual a 'c', entonces se desea convertir a otra base
                //este es un procedimiento de operando unario, entonces no se necesita numero2
                if(this.numero1.getBase() != 10){
                    this.numero1.cambiarBase(baseSalida);
                    return this.numero1.getValor();
                }
                else{
                    //saca el valor de una
                    if(this.baseSalida == 10){
                        return this.numero1.getValor();
                    }
                    else{
                        this.numero1.cambiarBase(baseSalida);
                        return this.numero1.getValor();
                    }
                }
            }
            else{
                if(this.numero2!=null){
                    int resultado = 0;
                    //a partir de aquí son operaciones de operandos binarios, para lo cual ingreso un switch
                    switch(this.procedimiento){
                        case Suma:{
                            //se desea sumar
                            resultado = Integer.parseInt(this.numero1.getValor()) + Integer.parseInt(this.numero2.getValor());
                            break;
                        }
                        case Resta:{
                            //se desea restar
                            resultado = Integer.parseInt(this.numero1.getValor()) - Integer.parseInt(this.numero2.getValor());
                            break;
                        }
                        case Division:{
                            //se desea dividir
                            resultado = Integer.parseInt(this.numero1.getValor()) / Integer.parseInt(this.numero2.getValor());
                            break;
                        }
                        case Residuo:{
                            //se desea conseguir el residuo/módulo
                            resultado = Integer.parseInt(this.numero1.getValor()) % Integer.parseInt(this.numero2.getValor());
                            break;
                        }
                        case Multiplicacion:{
                            //se desea conseguir la multiplicación
                            resultado = Integer.parseInt(this.numero1.getValor()) * Integer.parseInt(this.numero2.getValor());
                            break;
                        }
                        case Potencia:{
                            //se desea potenciar
                            resultado = ConvertidorMultibase.potenciarNumero(Integer.parseInt(this.numero1.getValor()),Integer.parseInt(this.numero2.getValor()));
                            break;
                        }
                        case Logaritmo:{
                            //se desea conseguir el segundo número elevando al primero
                            //(averiguar el logaritmo de base <segundo número> del <primer número>)
                            int contador = 0;
                            //cuentaValores consigue el valor del primer número
                            int cuentaValores = Integer.parseInt(this.numero1.getValor());

                            //meta significa el número que se quiere conseguir
                            int meta = Integer.parseInt(this.numero2.getValor());
                            //mientras que cuentaValores^contador < meta
                            while(ConvertidorMultibase.potenciarNumero(cuentaValores, contador) < meta){
                                contador++;
                            }
                            if(ConvertidorMultibase.potenciarNumero(cuentaValores, contador)!=meta){
                                //significa que en el while se pasó, por lo cual no es un valor
                                //conseguible en logaritmo
                                return "No es logaritmo";
                            }
                            else{
                                /*
                                retorna el contador
                                esto es para aprovechar el motor cambia bases de abajo
                                */
                                resultado = contador;
                            }
                            break;
                        }
                    }
                    System.out.println("Resultado de Operación " + this.procedimiento + " : " + resultado);
                    if(this.baseSalida==10){
                        //se tira el valor de un solo
                        return String.valueOf(resultado);
                    }//fin de bloque if con salida en base 10
                    else{
                        if(this.baseSalida != 1){
                            /*
                            se desea que la salida no sea en base 10
                            lo que hice fue que creé un nuevo ejemplar de clase Numero, ya que con un valor, y como ya estaba todo en
                            base 10, entonces lo único que se necesita es aprovechar su funcionalidad de cambio de base
                            */
                            try{
                                Numero salida = new Numero(10,String.valueOf(resultado));
                                salida.cambiarBase(baseSalida);
                                System.out.println(salida.toString());
                                return salida.getValor();
                            }catch(DigitOutOfBaseBoundsException exc){
                                Logger.getLogger(Calculadora.class).log(Level.SEVERE, null, exc);
                            }
                        }
                        else{
                            String unosResultado = "";
                            for (int i = 0; i <= resultado; i++) {
                                unosResultado = unosResultado.concat("1");
                            }
                            return unosResultado;
                        }
                    }
                }//fin del if de operaciones de operandos binarios
            }//fin del else de operación de conversión
        }//fin de else de validación de valores nulos en la calculadora
        return "";
    }//fin de método
    
    public void limpiar(){
        this.baseSalida = 10;
        this.numero1 = null;
        this.numero2 = null;
        this.procedimiento = null;
    }
}

