package com.intern.fooddelivery.exceptions;

public class VehicleTypeForbiddenException extends IllegalArgumentException{
    public VehicleTypeForbiddenException(){ super();}

    public VehicleTypeForbiddenException(String message){ super(message);}

    public VehicleTypeForbiddenException(String message, Throwable cause){ super(message, cause);}
}
