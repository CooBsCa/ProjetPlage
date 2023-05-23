package fr.plage.reservation.exception;

public class ParasolDejaReserve extends RuntimeException{

                private static final long serialVersionUID = 1L;

                public ParasolDejaReserve(String message) {
                    super(message);
                }
}
