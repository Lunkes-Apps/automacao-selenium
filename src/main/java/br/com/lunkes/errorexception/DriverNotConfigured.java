package br.com.lunkes.errorexception;

public class DriverNotConfigured extends Exception{

    public DriverNotConfigured(){
        super("Driver ainda não foi configurado!");
    }

}
