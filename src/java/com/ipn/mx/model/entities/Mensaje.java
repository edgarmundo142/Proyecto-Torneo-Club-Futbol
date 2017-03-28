package com.ipn.mx.model.entities;

/**
 *
 * @author rafael
 */
public class Mensaje {
    
    private String destinatario;
    private String asunto;
    private String contenido;

    public String getDestinatario() {
            return this.destinatario;
    }

    /**
     * 
     * @param destinatario
     */
    public void setDestinatario(String destinatario) {
            this.destinatario = destinatario;
    }

    public String getAsunto() {
            return this.asunto;
    }

    /**
     * 
     * @param asunto
     */
    public void setAsunto(String asunto) {
            this.asunto = asunto;
    }

    public String getContenido() {
            return this.contenido;
    }

    /**
     * 
     * @param contenido
     */
    public void setContenido(String contenido) {
            this.contenido = contenido;
    }

    /**
     * 
     * @param destinatario
     * @param asunto
     * @param contenido
     */
    public Mensaje(String destinatario, String asunto, String contenido) {
            // TODO - implement Mensaje.Mensaje
            throw new UnsupportedOperationException();
    }
}
