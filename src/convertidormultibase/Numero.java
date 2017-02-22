/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertidormultibase;

import java.util.*;

/**
 * Esta clase va a representar los números, así como las diferentes representaciones
 * en diferentes sistemas numéricos. También almacena los métodos para cambiar la
 * base en la que está la representación del número
 * @author Esteban
 */
public class Numero {
    private int base;
    private String valor;

    /**
     * Este es el constructor obligatorio para crear un nuevo número, recibe una base en su representación decimal, y
     * un string con su supuesto valor
     * @param base La base a la cual pertenece el número a crear
     * @param valor El supuesto valor que representa el número, al momento de combinarlo con la base
     * @throws DigitOutOfBaseBoundsException Si uno de los dígitos del valor no es representable utilizando los dígitos del sistema numérico seleccionado
     * @see convertidormultibase.Calculadora
     */
    public Numero(int base, String valor) throws DigitOutOfBaseBoundsException{
        /*
        Pasa todo el string a mayúsculas
        */
        String valorMayus = valor.toUpperCase(Locale.ROOT);
        //recorre todo el string valor recibido, cuya variable por cada iteración se llamará "get"
        for (int i = 0; i < valorMayus.length(); i++) {
            char get = valorMayus.charAt(i);
            //reduce el get que contiene el caracter del string y lo pasa a número y le pasa el número a getNumero            
            int getNumero = get-48;
            //averigua si el número es un número o letra
            if(getNumero < 10){
                /*
                si entra aquí el character es un número
                por lo que tiene que averiguar si el número es muy grande para la base
                si es muy grande para la base entonces lanza una excepción de dígito fuera de capacidad
                */
                if (getNumero >= base && (getNumero != 1 || base != 1)){//la única manera de que quepa en la base es que sea unario
                    throw new DigitOutOfBaseBoundsException("El dígito: " + get + " no cabe en el límite de la base especificada, para el número : " + valor);
                }
            }
            else{
                //si entra el get es diferente a un número, si la base es menor o igual a 10 definitivamente no cabrá, y dispara una excepción
                if (base <= 10){
                    throw new DigitOutOfBaseBoundsException("El dígito: " + get + " no cabe en el límite de la base especificada, para el número : " + valor);
                }
                else{
                    //convierte la letra a un número decimal, por ejemplo, la A será un 10, para esto debe restarle 7 adicionales, pues ya le había
                    //restado 48, y necesito restarle 55
                    getNumero = getNumero - 7;
                    if(getNumero >= base){//si entra quiere decir que la letra no cabía en la base
                        throw new DigitOutOfBaseBoundsException("El dígito: " + get + " no cabe en el límite de la base especificada, para el número : " + valor);
                    }
                }
            }
            /*
            ahora lo que falta de revisar es si el caracter leído es un <'> entonces entrará hasta aquí, pues el caracter
            getNumero resultó en -9, así que ahora tengo que averiguar si el "dígito compuesto" cabe en la base, ahora 
            tengo que averiguar el valor del dígito leyendo caracteres del string
            */
            if(get == 39){
                //creo una nueva lista para almacenar temporalmente todos los caracteres del dígito compuesto
                ArrayList <Character> digitosAVerificar = new ArrayList<>();
                digitosAVerificar.add(valor.charAt(i-1));//agrego la letra que encabeza el dígito compuesto
                try{
                    while(valor.charAt(i) == 39){//mientras el dígito sea igual a un <'>, avance agregándole el caracter a la lista a verificar
                        digitosAVerificar.add(valor.charAt(i));
                        i++;
                    }
                }catch(IndexOutOfBoundsException ex){
                    //este catch es cuando es una sola letra de dígito compuesto, o bien el último dígito del número, ya que daba un error de índice
                    System.out.println("Le entró una sola letra, o era el último dígito");
                }
                i--; //para no dañar el for principal, esto es cuando ya haya encontrado un caracter diferente a <'>

                int contador = 0;//este contador va a contar la cantidad de techos que posee el dígito
                for (int j = 1; j < digitosAVerificar.size(); j++) {//este for podría cambiarlo por algo por el size, pues sólo cuenta, pero mejor dejarlo
                    char simbolo = digitosAVerificar.get(j);//simbolo no se usa en ningún lugar del programa, sólo lo dejé ahí en caso de cualquier incidente
                    contador++;//incrementa el contador por 1
                    //System.out.println(simbolo);
                }
                int resultado = 26;//le mueve al resultado un 26, pues es el contenido del abecedario
                resultado *= contador;//ahora multiplica el 26 por la cantidad de techos que posee el abecedario
                
                //al restarle un 55 se deja un algo mayor o igual a 10 en caso de que sea la letra más baja: la A
                if(digitosAVerificar.get(0)-55<10){
                    throw new DigitOutOfBaseBoundsException("El dígito: " + get + " no cabe en el límite de la base especificada, para el número : " + resultado);
                }
                else{
                    //letra almacena el número en el abecedario que tiene contado desde el 1-basado, la cual se le agregará al resultado al final
                    resultado += (digitosAVerificar.get(0)-64) + 9;   
                }
                
                //System.out.println("Digito Compuesto: "+ resultado);
                if (resultado>=base){//si el resultado es mayor o igual a la base, entonces no cabe, así que se lanza error
                    throw new DigitOutOfBaseBoundsException("El dígito: " + get + " no cabe en el límite de la base especificada, para el número : " + resultado);
                }
            }
        } //salida del for
        //si no hubo error, se crea
        this.base = base;
        this.valor = valorMayus;
    }
    
    //setters y getters
    public int getBase() {
        return base;
    }

    public String getValor() {
        return valor;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
    /**
     * Este método hace que el número cambie sus valores para averiguar su representación en la nueva base, para al final terminar representado en
     * la nueva base especificada
     * @param nuevabase La nueva base que se desea que posea el número
     */
    public void cambiarBase(int nuevabase){
        if (nuevabase==10){
            if(this.base != 1){
                System.out.println("Método General");
                this.metodoGeneral();
            }
            else{
                int resultado = 0;
                for (int i = 0; i < this.valor.length(); i++) {
                    resultado++;
                }
                this.valor = String.valueOf(resultado);
                this.base = 10;
            }
        }
        else{
            if(nuevabase != 1){
                System.out.println("Método Divisiones");
                this.metodoDivision(nuevabase);
            }
            else{
                this.metodoGeneral();
                int cuentaUnos = Integer.parseInt(this.valor);
                String resultado = "";
                for (int i = 0; i < cuentaUnos; i++) {
                    resultado = resultado.concat("1");
                }
                this.valor = resultado;
                this.base = 1;
            }
        }
    }
    
    //este método SÓLO debe llamarse mediante cambiarBase, por lo cual lo puse privado
    private void metodoGeneral() {
        ArrayList <Character> numero = new ArrayList<>();
        for (int i = 0; i < this.valor.length(); i++) {
            numero.add(this.valor.charAt(i));
        }
        
        //for y sout para validar
        /*
        for (int i = 0; i < numero.size(); i++) {
            Character get = numero.get(i);
            System.out.println(get);
        }
        System.out.println(numero);
        */
        
        //La función de este arraylist será contener el conjunto de números enteros que representan los números y letras recibidos
        ArrayList <Integer> numeroEntero= new ArrayList<>();
        
        //Un bello for inverso
        for (int i = numero.size()-1; i >= 0; i--) {
            Character get = numero.get(i);
            System.out.println("get: " + get);
            
            //getInteger guarda el entero conseguido del caracter get
            int getInteger = get-48;
            
            //si es un numerito menor a 10 se guarda de una
            if(((getInteger)>=0) && ((getInteger)<10)){
                numeroEntero.add(getInteger);
            }
            else{
                //si es mayor a 10, es letra, se convierte a número y se guarda
                if(getInteger>10){
                    getInteger -= 7;
                    numeroEntero.add(getInteger);
                }
            }
            if (get == 39){
                //cantidadTechos recibe la cantidad de techos, la cual se multiplicará y se sumará a una letra
                int cantidadTechos = 1;
                i--;
                char getWhile = numero.get(i);
                while(getWhile == 39){
                    cantidadTechos +=1;
                    i--;
                    getWhile = numero.get(i);
                }
                //encontró una letra, se almacena como entero en getIntegerWhile
                int getIntegerWhile = getWhile - 64;
                int resultado = 26;
                resultado *= cantidadTechos;
                resultado += getIntegerWhile + 9;
                
                numeroEntero.add(resultado);
                
                //i--; //para no dañar el for principal, mentira. NO descomentar esto, no debía hacerlo jaja
            }
        }
        System.out.println("numeroEntero en lista: "+numeroEntero);
        
        //ahora mismo sólo logré pasarlo a lista la ptm
        //cuenta espacio cuenta en qué posición se está
        int cuentaEspacio = 0;
        int resultado = 0;
        
        //un for inverso para la lista que es la conversión final
        for (int i = 0; i < numeroEntero.size(); i++) {
            int get = numeroEntero.get(i);
            int potencia = Calculadora.potenciarNumero(this.base, cuentaEspacio);
            
            
            //Estos prints son para validar lo que va saliendo de la conversión
            System.out.println("get: "+get);
            System.out.println("potencia: "+potencia);
            
            resultado += get * (potencia);
            
            //print del resultado
            System.out.println("resultado: "+resultado);
            cuentaEspacio++;
        }
        
        this.valor = String.valueOf(resultado);
        this.base = 10;
    }
    
    //este método SÓLO debe llamarse mediante cambiarBase, por lo cual lo puse privado
    private void metodoDivision(int nuevaBase) {
        
        long numero = 0;
        //la base se supone que debería ser 10, pero por si acaso pongo esto con un catch
        //hago un parse int al número
        try{
            numero = Long.parseLong(this.valor);
        }catch(NumberFormatException ex){
            System.out.println("El número logró burlar las defensas");
            throw ex;
        }
        /*
        no hubo error al parsear el entero
        variable que conservará cada dígito conforme se va consiguiendo, cada dígito se guarda como entero en base 10 y luego se convierte
        */
        ArrayList <Long> digitos = new ArrayList<>();

        /*
        recordar número parseado hace algunas líneas
        este while debe dar vueltas hasta que la magnitud sea menor a la base destino 
        recordar bien cómo es el método de las divisiones
        mientras el número parseado sea menor a la nueva base, se debe hacer el ciclo de las vueltas
        */
        //System.out.println("numero parseado: " + numero);
        while(numero >= nuevaBase){
            //agrega el nuevo dígito al array, el dígito menos significativo estará al final
            digitos.add(numero % nuevaBase);
            System.out.println("Agrego el " + (numero % nuevaBase));
            //se hace que número disminuya, haciendo que se realice una división
            numero = numero / nuevaBase;
            System.out.println("Resta analizar: " + numero);
        } 
        //al final del while en "número" sólo quedará un cociente, que es el dígito más significativo del número, no olvidar esto
        System.out.println("Agrego el " + numero);
        digitos.add(numero);

        System.out.println("Digitos parseados:");
        for (int i = 0; i < digitos.size(); i++) {
            Long get = digitos.get(i);
            System.out.println("\tDígito parseado: " + get);
        }

        //Este ArrayList va a conseguir los dígitos en orden y los va a pasar a caracteres de una vez
        ArrayList <Character> resultado = new ArrayList<>();

        //bello for inverso
        for (int i = digitos.size()-1; i >= 0; i--) {
            Long get = digitos.get(i);

            //imprime qué es lo que pilla
            System.out.println("get: "+get);

            //declaración de variable
            char getChar;

            /*
            pasa el get a char, para que pueda ser pasado a string
            tiene que decidir si es un número o es una letra (obviamente con techitos)
            */
            if(get <= 9){
                //es un dígito menor a 10, algo normalito
                System.out.println("Es un número");
                getChar = (char) (get+48);
                //System.out.println("getChar: "+ getChar);
                //pasa lo que pilla a la nueva lista para que quede en orden
                resultado.add(getChar);
            }
            else{
                if(get<=35){
                    //es una letra, sigue siendo normal, o tal vez no tanto
                    //recordar el número parseado
                    System.out.println("Número Parseado: " + numero);
                    if(numero > 35){
                        getChar = (char) (get+64);
                        System.out.println("Mayor a 35");
                        System.out.println("Caracter "+ getChar);
                        //pasa lo que pilla a la nueva lista para que quede en orden
                        resultado.add(getChar);
                    }
                    else{
                        getChar = (char) (get+64-9);
                        System.out.println("Menor a 35");
                        System.out.println("Caracter "+ getChar);
                        //pasa lo que pilla a la nueva lista para que quede en orden
                        resultado.add(getChar);
                    }
                }
                else{
                    //es una letra con techito, aquí ya se pone divertido
                    //se le quitan los 9 dígitos numerales que no se necesitan
                    get -= 10;

                    //consigueTechos busca la cantidad de techos que puede llegar a representar ese número
                    Long consigueTechos = get / 26;

                    //se convierte el get a una sola letra, mientras que la cantidad de techos que la acompañaban ahora estarán en una nueva variable
                    get %= 26;

                    getChar = (char) (get+59);
                    resultado.add(getChar);

                    //se iguala a getChar a un ', que es la notación para vueltas del abecedario
                    getChar = 39;

                    while (consigueTechos>=0) {

                        resultado.add(getChar);
                        consigueTechos--;
                    }
                }
            }
        }

        /*
        hice todo el proceso, pero nunca hice que se sobreescribiera al valor,
        que buena esa
        lo que falta ahora sólo es pasar de ese ArrayList a string
        lo que hice fue hacer un arreglo, este permite pasar todo a string,
        dado que no podía hacerlo directamente del arraylist
         */

        //declaración, tamaño de un sólo jaja
        char[] arregloResultado = new char[resultado.size()];

        for (int i = 0; i < resultado.size(); i++) {
            Character get = resultado.get(i);
            //imprime lo que se consiguió
            //System.out.println("digitos del resultado: " + get);
            //lo pasa al arreglo
            arregloResultado[i] = get;
        }
        this.valor = String.copyValueOf(arregloResultado);
        this.base = nuevaBase;
    }
    
    /**
     * Este método lo que hace es agarrar el valor de un número, e intentar reducir una cantidad de techos mayor a 4 en sandwiches
     * @param numeroAEmpanizar El valor en string de algún número
     * @return Un string que representa el nuevo valor del número, ya empanizado
     */
    public static String empanizarNumero(String numeroAEmpanizar){
        String resultado = "";
        for (int i = 0; i < numeroAEmpanizar.length(); i++) {
            char getChar = numeroAEmpanizar.charAt(i);
            resultado = resultado.concat(String.valueOf(getChar));//sea como sea, siempre tengo que agregar el nuevo caracter, la excepción sucede cuando
            //tengo que agregar sandwiches, en cuyo caso lo hago más abajo
            if(getChar == 39){//encontró un techo en el string
                int contador = 1;//cuento el primer techo
                int j = 1;//avanzo a la siguiente posición
                try{
                    while(numeroAEmpanizar.charAt(i+j) == 39){//mientras la siguiente posición sea igual a un techo, avance
                        j++;contador++;
                    }
                }catch(IndexOutOfBoundsException exc){
                    //si entra aquí, quiere decir que se salió del string, lo que significa que leyó el último techo
                }finally{//esto lo tiene que hacer crome o no crome
                    if(contador >= 4){
                        resultado = resultado.concat(String.valueOf(contador));//le agrego la cantidad de techos que contó
                        //si la cantidad es mayor a 4, entonces no tengo que agregar los siguientes techos, sino, entonces no hago avanzar la cabeza lectora
                        i += j-1;//le agrego al i la cantidad que tenía j, para que quede justo en el último techo
                    }
                }
            }
        }
        return resultado;
    }
    
    @Override
    public String toString(){
        
        //recorre todos los dígitos del campo "valor" del objeto
        /*
        for (int i = 0; i < this.valor.length(); i++) {
            char get = this.valor.charAt(i);
            System.out.println(get);
        }
        */
        return "El número es: " + this.valor + ". En base: " + this.base;
    }
}