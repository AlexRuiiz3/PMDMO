package es.iesnervion.aruiz.pruebasegundaevaluacion.dataaccess.entidades.bo;

public class ProductosCestaBO {

    private int codigoProducto;
    private int codigoCesta;

    public ProductosCestaBO(int codigoProducto, int codigoCesta) {
        this.codigoProducto = codigoProducto;
        this.codigoCesta = codigoCesta;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public int getCodigoCesta() {
        return codigoCesta;
    }
}
