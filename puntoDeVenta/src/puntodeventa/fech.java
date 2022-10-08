
package puntodeventa;

import java.sql.Date;

public class fech {
    Date fechaCompra;

    public fech(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    
}
