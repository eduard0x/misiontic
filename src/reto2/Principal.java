package reto2;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EDUARDO
 */
public class Principal {
    
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        int cantidad = Integer.parseInt(teclado.nextLine());
       
            double[] valores = new double [cantidad];
            for(int i=0;i<valores.length;i++){
                
                valores[i] = Double.parseDouble(teclado.nextLine());
            }
            double promedio = sacarPromedio(valores);
            String nivelRiesgo = nivelRiesgo(promedio);
            String entidad = entidadAactuar(promedio);
            double masAlto = masAlto(valores);
            String nivelRiesgoAlto = nivelRiesgo(masAlto);
            
            System.out.println(nivelRiesgo);
            System.out.println(entidad);
            System.out.println(nivelRiesgoAlto);

        
       
    }
    
    public static double sacarPromedio(double[] valores){
        
        double sumatoria = 0;
        double numeroValores = valores.length;
        for(int i=0; i<valores.length; i++){
            sumatoria += valores[i];
            
        }
        
        double promedio = sumatoria / numeroValores;
        
        return promedio;
    }
    
    public static double masAlto(double[] valores){
        double tallest = 0;
        for(int i=0; i< valores.length;i++){
            if(valores[i]>tallest){
                tallest = valores[i];
            }
        }
        
        return tallest;
    }
    
    public static String entidadAactuar(double valor){
        if(valor >= 0 && valor <= 5){
            return "CONTINUAR-VIGILANCIA";
        }
        else if(valor > 5 && valor <=14){
            return "PERSONA-PRESTADORA";
        }
        else if(valor > 14 && valor <=35){
            return "PERSONA-PRESTADORA";
        }
        else if(valor> 35 && valor <= 80){
                return "ALCALDIA";
        }
        else if(valor > 80 && valor <=100){
                return "GOBERNACION";
        }
        else {
                return "VALOR INVALIDO";
        }
    }
    
    public boolean vacio(int[] valores){
        if(valores.length > 0){
            return false;
        }
        else {
            return true;
        }
    }
    
    public static String nivelRiesgo(double valor){
       if(valor >= 0 && valor <= 5){
            return "SIN-RIESGO";
        }
        else if(valor > 5 && valor <=14){
            return "BAJO";
        }
        else if(valor > 14 && valor <=35){
            return "MEDIO";
        }
        else if(valor> 35 && valor <= 80){
                return "ALTO";
        }
        else if(valor > 80 && valor <=100){
                return "INVIABLE-SANITARIAMENTE";
        }
        else {
                return "VALOR INVALIDO";
        }
    }
    
}
