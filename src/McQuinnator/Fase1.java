/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package McQuinnator;

import java.util.ArrayList;

/**
 *
 * @author Esteban
 */
public class Fase1 {
    
    private ArrayList <Tabla> tablas;
    private int cantidadBits;
    private ArrayList <Integer> terminosOriginales;

    /**
     * Constructor en caso de que ya haya algunas tablas existentes, aunque sinceramente ni será utilizado
     * @param tablas Un arreglo de tablas
     * @param cantidadBits Cantidad de bits que tendrá la función a la cual se le hará el quine-mcCluskey
     */
    public Fase1(ArrayList<Tabla> tablas, int cantidadBits) {
        this.tablas = tablas;
        this.cantidadBits = cantidadBits;
    }

    /**
     * Este constructor es para crear una nueva fase 1 desde un string almacenando la representación oficial del curso de F0C de cada función a simplificar
     * @param funcionK Este es el String a ser ingresado. Tiene que estar del formato obligatorio: E7:(0,1,2,3,4) donde el 7 al lado de la E significa la cantidad de variables de la función
     */
    public Fase1(String funcionK) {

        //Primero pasaré los caracteres a un nuevo string, para luego pasarlos a un entero, donde pasaran el resto de la existencia
        String cantidadBitsString = "";
        funcionK = funcionK.trim();
        
        //Este contador va a ser para recorrer el string de la función hasta que se encuentre los dos puntos
        int i = 1;
        //Comienzo a pasar los caracteres de los números al nuevo string
        while(funcionK.charAt(i) != ':' && funcionK.charAt(i) != '('){
            cantidadBitsString = cantidadBitsString + funcionK.charAt(i);
            i++;
        }
        
        //este va a ser la cantidad de bits por defecto de la aplicación
        int cantidadBitsEntero = 5;
        //En caso de que el tipo la haya cagado
        try{
            //Intenta parsearlo
            cantidadBitsEntero = Integer.parseInt(cantidadBitsString);
            System.out.println("Cantidad de bits: " + cantidadBitsEntero);
        }catch(NumberFormatException exc){
            //No pudo parsearlo
            System.out.println("Hubo un error al parsear el string " + cantidadBitsString + " y se colocó el valor por defecto (5)");
        }
        //Lo establezco en la fase 1, ya sea con el valor por defecto o bien el ingresado
        this.cantidadBits = cantidadBitsEntero;
        
        //Aquí necesito sólo enfocarme en lo que necesito para el resto del constructor
        String restoAProcesar = funcionK.substring(i+1);
        //ahora le quito el paréntesis
        restoAProcesar = restoAProcesar.substring(1);
        
        //el nuevo arrayL para almacenar todos los términos
        ArrayList <Termino> terminosDeLaPrimeraTabla = new ArrayList<>();
        ArrayList <Integer> terminosOriginalesATomar = new ArrayList<>();
        //ahora reinicio el contador para leer a partir de la primera letra, que es el inicio del primer número
        i = 0;
        //mientras sea diferente de un ")", lo que significa que llegó al final
        while(!(restoAProcesar.equals(")") || restoAProcesar.equals(""))){
            //todavía quedan números para procesar
            //hace un recorrido para conseguir el número por cada iteración del ciclo principal
            while(restoAProcesar.charAt(i) != ',' && restoAProcesar.charAt(i) != ')'){
                //hay más dígitos, así que se mueve el contador i para avanzar a la siguiente posición
                i++;
            }
            //ya se encontró con un ',', lo que significa que ya tengo el número completo del término
            try{
                if(!terminosDeLaPrimeraTabla.add(new Termino(Integer.parseInt(restoAProcesar.substring(0, i))))){
                    //no logró meterlo
                    System.out.println("Por algún motivo no se rompió, pero no pudo meterlo");
                }
                else{
                    System.out.println("Pudo meter correctamente el: " + restoAProcesar.substring(0,i));
                    System.out.println("Y falta por procesar: " + restoAProcesar.substring(i));
                    if(!terminosOriginalesATomar.add(Integer.parseInt(restoAProcesar.substring(0,i)))){
                        System.out.println("Por algún motivo sí se logró introducir el término a la tabla, pero no a los términos originales");
                    }
                    else{
                        System.out.println("Introducido correctamente en ambos");
                    }
                }
            }catch(NumberFormatException exc){
                System.out.println("Error al parsear el string: " + restoAProcesar.substring(0, i));
            }
            
            //ahora lo que acercará el programa más al punto de parada
            restoAProcesar = restoAProcesar.substring(i+1);
            i = 0;
        }
        //ya terminó de procesar todo el string en busca de los términos, así que falta
        //hacer los niveles de la tabla y acomodar los términos uno a uno
        //acomodarlos según su representación en binario por cada uno de los niveles
        
        ArrayList <Nivel> niveles = new ArrayList<>();
        for (int j = 0; j <= cantidadBitsEntero; j++) {
            //crea un arraylist de niveles con todos los niveles vacíos
            niveles.add(new Nivel(new ArrayList<>()));
        }
        
        //ahora a acomodar los términos
        for (int j = 0; j < terminosDeLaPrimeraTabla.size(); j++) {
            
            //Un print de control
            //System.out.println(terminosDeLaPrimeraTabla.get(j).getNumeros().get(0));
            //ahora a recorrer los niveles
            for (int k = 0; k < niveles.size(); k++) {
                //consigue el término que esté al inicio del arrayList
                
                if(Integer.bitCount(terminosDeLaPrimeraTabla.get(j).getNumeros().get(0)) == k){
                    //la cantidad de bits encendidos equivale al nivel procesado actualmente
                    //así que pego el término de la lista de términos en el nivel que le corresponde                
                    niveles.get(k).getTerminos().add(terminosDeLaPrimeraTabla.get(j));
                }
            }
        }
        
        //agrega las tablas a la fase
        this.tablas = new ArrayList<>();
        this.tablas.add(new Tabla(niveles));
        
        //y ahora los términos de la función original
    }

    public ArrayList<Tabla> getTablas() {
        return tablas;
    }

    public void setTablas(ArrayList<Tabla> tablas) {
        this.tablas = tablas;
    }

    public int getCantidadBits() {
        return cantidadBits;
    }

    public void setCantidadBits(int cantidadBits) {
        this.cantidadBits = cantidadBits;
    }

    public ArrayList<Integer> getTerminosOriginales() {
        return terminosOriginales;
    }

    public void setTerminosOriginales(ArrayList<Integer> terminosOriginales) {
        this.terminosOriginales = terminosOriginales;
    }
    
    /**
     * Este recorre todos los términos averiguando cuantos no están equisados
     * @return La cantidad de términos no equisados (primos)
     */
    public int cantidadTerminosPrimos(){
        //recoge las tablas
        int cuentaPrimos = 0;
        for (int i = 0; i < tablas.size(); i++) {
            Tabla getTabla = tablas.get(i);
            
            //por cada uno de los niveles de esta tabla
            for (int j = 0; i < getTabla.getNiveles().size(); i++) {
                Nivel getNivel = getTabla.getNiveles().get(j);
                
                //recorre todos los términos
                for (int k = 0; k < getNivel.getTerminos().size(); k++) {
                    Termino getTermino = getNivel.getTerminos().get(k);
                    //necesito saber si está equisado
                    if(!getTermino.equisado()){
                        //no está equisado
                        cuentaPrimos++;
                    }
                }//fin del for para recorrer los términos
            }//fin del for para recorrer los niveles
        }//fin del for para recorrer las tablas
        return cuentaPrimos;
    }
    
    /**
     * Este método pone todos los términos primos colapsados en un mismo arrayList y los retorna
     * @return Todos los términos primos de la primera fase
     */
    public ArrayList<Termino> getPrimos(){
        
        ArrayList <Termino> terminosPrimos = new ArrayList<>();
        for (int i = 0; i < tablas.size(); i++) {
            Tabla getTabla = tablas.get(i);
            
            for (int j = 0; j < getTabla.getNiveles().size(); j++) {
                Nivel getNivel = getTabla.getNiveles().get(j);
                
                for (int k = 0; k < getNivel.getTerminos().size(); k++) {
                    Termino getTermino = getNivel.getTerminos().get(k);
                    
                    System.out.print(getTermino.toString() + "\t");
                    //si no está equisado
                    if(!getTermino.equisado()){
                        //ahora tengo que averiguar si no hay un término que contenga los mismos números ya ingresado
                        //para esto llamo a la función estática
                        if(!isContained(terminosPrimos, getTermino)){
                            //no hay un término primo ya existente que lo contuviera, por lo que se agrega
                            System.out.println("X");
                            terminosPrimos.add(getTermino);
                        }
                    }   
                }
            }    
        }
        System.out.println("");
        return terminosPrimos;
    }
    
    /**
     * Este método pone todos los términos primos no colapsado en un mismo arrayList y los retorna
     * @return Todos los términos primos de la primera fase
     */
    public ArrayList<Termino> getPrimosNoColapsado(){
        
        ArrayList <Termino> terminosPrimos = new ArrayList<>();
        for (int i = 0; i < tablas.size(); i++) {
            Tabla getTabla = tablas.get(i);
            
            for (int j = 0; j < getTabla.getNiveles().size(); j++) {
                Nivel getNivel = getTabla.getNiveles().get(j);
                
                for (int k = 0; k < getNivel.getTerminos().size(); k++) {
                    Termino getTermino = getNivel.getTerminos().get(k);
                    
                    //si no está equisado
                    if(!getTermino.equisado()){    
                       terminosPrimos.add(getTermino);
                    }
                }
            }
        }
        return terminosPrimos;
    }
    
    /**
     * Este método es simplemente un método que automatiza la fabricación de tablas
     */
    public void hacerTablas(){
        while(!tablas.get(tablas.size()-1).isEmpty()){
            this.analizarUltimaTabla();
        }
    }
    
    /**
     * Este método se encarga de analizar todas las tablas a partir de la fase 1 recién creada
     */
    public void analizarUltimaTabla(){
        //lo que importa es analizar a partir de la última tabla
        //y generar una tabla a partir de ella
        Tabla ultimaTabla = tablas.get(tablas.size()-1);
        //tengo que crear n-1 niveles, donde n es la cantidad de niveles que van a ser procesados
        ArrayList <Nivel> nivelesNuevos = new ArrayList<>();
        for (int i = 0; i < ultimaTabla.getNiveles().size()-1; i++) {
            nivelesNuevos.add(new Nivel(new ArrayList<>()));
        }
        
        //empiezo a recorrer todos los niveles de la tabla, salvo el primero, que no es preocupante
        for (int i = 1; i < ultimaTabla.getNiveles().size(); i++) {
            
            //para recorrer todos los términos del nivel bajo de la primera tabla de la que se van a comparar
            for (int j = 0; j < ultimaTabla.getNiveles().get(i-1).cantidadTerminos(); j++) {
                
                //para recorrer todos los términos del nivel alto de la primera tabla de la que se van a a comparar
                for (int k = 0; k < ultimaTabla.getNiveles().get(i).cantidadTerminos(); k++) {
                    
                    //ahora hay que ver si alguno de ellos comparte la diferencia
                    if(ultimaTabla.getNiveles().get(i).getTerminos().get(k).getDiferencia().equals(ultimaTabla.getNiveles().get(i-1).getTerminos().get(j).getDiferencia())){
                        //comparten la diferencia
                        //ahora hay que ver si la resta de ellos es potencia de dos
                        if(isPotenciaDeDos((ultimaTabla.getNiveles().get(i).getTerminos().get(k).getNumeros().get(0))-(ultimaTabla.getNiveles().get(i-1).getTerminos().get(j).getNumeros().get(0)))){
                            //los dos términos califican para ser unidos y movidos al nuevo nivel
                            ArrayList <Integer> numerosNuevoTermino = new ArrayList<>();
                            //agrega los números del primer término
                            numerosNuevoTermino.addAll(ultimaTabla.getNiveles().get(i).getTerminos().get(k).getNumeros());
                            //agrega los números del segundo término
                            numerosNuevoTermino.addAll(ultimaTabla.getNiveles().get(i-1).getTerminos().get(j).getNumeros());
                            //coloca la nueva diferencia a un nuevo string
                            String diferencia = ultimaTabla.getNiveles().get(i).getTerminos().get(k).getDiferencia() + "," + String.valueOf((ultimaTabla.getNiveles().get(i).getTerminos().get(k).getNumeros().get(0))-(ultimaTabla.getNiveles().get(i-1).getTerminos().get(j).getNumeros().get(0)));
                            
                            //un pequeño cosmético hacia la diferencia:
                            if(diferencia.startsWith(",")){
                                diferencia = diferencia.substring(1);
                            }
                            //agrega el nuevo término
                            Termino nuevoTermino = new Termino(numerosNuevoTermino, diferencia);
                            nivelesNuevos.get(i-1).getTerminos().add(nuevoTermino);
                            
                            //ahora sólo queda engatusar los dos términos y ya quedó todo listo
                            ultimaTabla.getNiveles().get(i).getTerminos().get(k).equisar();
                            ultimaTabla.getNiveles().get(i-1).getTerminos().get(j).equisar();
                            //debería estar listo ya
                        }
                    }
                }//final del for para recorrer los términos del nivel alto, así que seguirá con el siguiente término bajo
            }//final del for para recorrer los términos del nivel bajo, así que seguirá con el siguiente nivel
        }//final del for para recorrer los niveles, cuando este termina, se ha terminado la tabla completa
        //hago la nueva tabla
        if(this.tablas.add(new Tabla(nivelesNuevos))){
            System.out.println("Creada una nueva tabla sin problemas :)");
        }
        else{
            System.out.println("Algo malo pasó al final :(");
        }
    }

    @Override
    public String toString() {
        String salida = "Tablas de la Fase 1: \n";
        for (int i = 0; i < tablas.size(); i++) {
            Tabla get = tablas.get(i);
            salida = salida + "Tabla: " + (i+1) + "\n" +  get.toString();
        }
        return salida;
    }
    
    public static boolean isContained(ArrayList<Termino> arrayListBuscar, Termino terminoBuscar){
        for (int i = 0; i < arrayListBuscar.size(); i++) {
            Termino get = arrayListBuscar.get(i);
            if(get.getNumeros().containsAll(terminoBuscar.getNumeros())){
                return true;
            }
        }
        return false;
    }
    
    public static boolean isPotenciaDeDos(int i){
        int contador = 1;
        while(contador != i){
            if(contador > i){
                return false;
            }
            contador = contador * 2;
        }
        return true;
    }
}