package clases;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author artea
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
public class FechaHoraJava {
 static  long milisegundos_dia = 24 * 60 * 60 * 1000;
    public static void main(String[] args) {
    /**llamamos el metodo StringToDate para convertir la cadena en un objeto de la clase date
     este metodo recive la fecha en cualquier formato
     */

        Date fechaInicial= FechaHoraJava.StringToDate("2014/10/09 19:59:44", "/", 0);//yyyy-MM-dd
        Date fechaFinal= FechaHoraJava.StringToDate("2014/10/09 22:35:46", "/", 0);
 /**Creamos una instancia de la clase calendar*/
        Calendar calFechaInicial=Calendar.getInstance();
        Calendar calFechaFinal=Calendar.getInstance();

 /**Le pasamos el objeto Date al metodo set time*/
        calFechaInicial.setTime(fechaInicial);
        calFechaFinal.setTime(fechaFinal);
 //Numero total de minutos que hay entre las dos Fechas
        System.out.println("Numero Total de Horas" +
        " Entre las dos Fechas: "+
        cantidadTotalHoras(calFechaInicial,calFechaFinal));
        //Numero total de horas que hay entre las dos Fechas
        System.out.println("Numero Total de Minutos" +
        " Entre las dos Fechas: "+
        cantidadTotalMinutos(calFechaInicial,calFechaFinal));
        //Numero total de segundos que hay entre las dos Fechas
        System.out.println("Numero Total de segundos" +
        " Entre las dos Fechas: "+
        cantidadTotalSegundos(calFechaInicial,calFechaFinal));
/**Llamamos el metodo diferenciaHorasDias y diferenciaHoras
 y retamos para que nos de el total de horas
 */
        long horas=diferenciaHorasDias(calFechaInicial,
                calFechaFinal)+diferenciaHoras(calFechaInicial,calFechaFinal);
        long minutos=diferenciaMinutos(calFechaInicial,calFechaFinal);

  /** si los minutos son iguales menores a cero hay que restarle 1 hora  al total que dio
   las horas
   */
        if(minutos<0)
        System.out.println("Horas: "+(horas-1)+" Minutos: " +(minutos+60));
        else
          System.out.println("Horas: "+(horas)+" Minutos : "+minutos);
       

     
    }
    /*Metodo que calcula la diferencia de las horas que han pasado entre dos fechas en java
*/
public static long diferenciaHorasDias(Calendar fechaInicial ,Calendar fechaFinal){
    //Milisegundos al día
    long diferenciaHoras=0;
    //Restamos a la fecha final la fecha inicial y lo dividimos entre el numero de milisegundos al dia
    diferenciaHoras=(fechaFinal.getTimeInMillis()-fechaInicial.getTimeInMillis())/milisegundos_dia;
   if(diferenciaHoras>0){
  // Lo Multiplicaos por 24 por que estamos utilizando el formato militar
    diferenciaHoras*=24;
   }
    return diferenciaHoras;
}
 /*Metodo que calcula la diferencia de los minutos entre dos fechas
*/
public static long diferenciaMinutos(Calendar fechaInicial ,Calendar fechaFinal){

    long diferenciaHoras=0;
    diferenciaHoras=(fechaFinal.get(Calendar.MINUTE)-fechaInicial.get(Calendar.MINUTE));
    return diferenciaHoras;
}
/*Metodo que devuelve el Numero total de minutos que hay entre las dos Fechas */
public static long cantidadTotalMinutos(Calendar fechaInicial ,Calendar fechaFinal){

    long totalMinutos=0;
    totalMinutos=((fechaFinal.getTimeInMillis()-fechaInicial.getTimeInMillis())/1000/60);
    return totalMinutos;
}
/*Metodo que devuelve el Numero total de horas que hay entre las dos Fechas */
public static long cantidadTotalHoras(Calendar fechaInicial ,Calendar fechaFinal){

    long totalMinutos=0;
    totalMinutos=((fechaFinal.getTimeInMillis()-fechaInicial.getTimeInMillis())/1000/60/60);
    return totalMinutos;
}
/*Metodo que devuelve el Numero total de Segundos que hay entre las dos Fechas */
public static long cantidadTotalSegundos(Calendar fechaInicial ,Calendar fechaFinal){

    long totalMinutos=0;
    totalMinutos=((fechaFinal.getTimeInMillis()-fechaInicial.getTimeInMillis())/1000);
    return totalMinutos;
}
 /*Metodo que calcula la diferencia de las horas entre dos fechas*/
public static long diferenciaHoras(Calendar fechaInicial ,Calendar fechaFinal){
    long diferenciaHoras=0;
    diferenciaHoras=(fechaFinal.get(Calendar.HOUR_OF_DAY)-fechaInicial.get(Calendar.HOUR_OF_DAY));

    return diferenciaHoras;
}
/* Convierte una fecha en date a string*/
public static String DateToString(Date fecha,String caracter,int op){
    String formatoHora=" HH:mm:ss";//Formato de hora
    //caracter hace referencia al separador / -
   String formato="yyyy"+caracter+"MM"+caracter+"dd"+formatoHora;
    if(op==1)
        //
        formato="yyyy"+caracter+"dd"+caracter+"MM"+formatoHora;
    else if(op==2)
        formato="MM"+caracter+"yyyy"+caracter+"dd"+formatoHora;
     else if(op==3)
        formato="MM"+caracter+"dd"+caracter+"yyyy"+formatoHora;
     else if(op==4)
        formato="dd"+caracter+"yyyy"+caracter+"MM"+formatoHora;
      else if(op==5)
        formato="dd"+caracter+"MM"+caracter+"yyyy"+formatoHora;

  SimpleDateFormat sdf = new SimpleDateFormat(formato, Locale.getDefault());
 String fechaFormato=null;


            sdf.setLenient(false);
            fechaFormato=sdf.format(fecha);

return fechaFormato;
}
/*Convertir fecha date en string*/
public static Date StringToDate(String fecha,String caracter,int op){
    String formatoHora=" HH:mm:ss";
     String formato="yyyy"+caracter+"MM"+caracter+"dd"+formatoHora;
    if(op==1)
        //
        formato="yyyy"+caracter+"dd"+caracter+"MM"+formatoHora;
    else if(op==2)
        formato="MM"+caracter+"yyyy"+caracter+"dd"+formatoHora;
     else if(op==3)
        formato="MM"+caracter+"dd"+caracter+"yyyy"+formatoHora;
     else if(op==4)
        formato="dd"+caracter+"yyyy"+caracter+"MM"+formatoHora;
      else if(op==5)
        formato="dd"+caracter+"MM"+caracter+"yyyy"+formatoHora;
 SimpleDateFormat sdf = new SimpleDateFormat(formato, Locale.getDefault());
 Date fechaFormato=null;
        try {

            sdf.setLenient(false);
            fechaFormato=sdf.parse(fecha);
        } catch (ParseException ex) {

        }
return fechaFormato;
}
}

