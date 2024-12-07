package dao.exceptions;

public class TipoChaveNaoEncontradaException extends Exception{
    private static final long serialVersionUID = -138994676398525746L;

    public TipoChaveNaoEncontradaException(String msg) {
        this(msg, null);
    }

    public TipoChaveNaoEncontradaException(String msg, Throwable e) {
        super(msg, e);
    }
}
