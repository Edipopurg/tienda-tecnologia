package dominio;

import dominio.repositorio.RepositorioProducto;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import dominio.excepcion.GarantiaExtendidaException;
import dominio.repositorio.RepositorioGarantiaExtendida;

public class Vendedor {

    public static final String EL_PRODUCTO_TIENE_GARANTIA = "El producto ya cuenta con una garantia extendida";
    public static final String PRODUCTO_NO_CUENTA_CON_GARANTIA = "Este producto no cuenta con garantía extendida";
    public static final String FALTA_COD_PRODUCTO_NOM_CLIENTE = "No se puede generar una garantia sin el codigo del producto o sin el nombre del cliente";
    
    public static final double VALOR_GARANTIA_PORCENTAGE_PRODUCTO_COSTO_MAYOR_CORTE = 20.0 ;
    public static final double VALOR_GARANTIA_PORCENTAGE_PRODUCTO_COSTO_MENOR_IGUAL_CORTE = 10.0 ;
    
    public static final double VALOR_PRODUCTO_CORTE = 500000.0 ;
    
    public static final int NUM_DIAS_GARANTIA_MAYOR = 200 ;
    public static final int NUM_DIAS_GARANTIA_MENOR = 100 ;
    
    private RepositorioProducto repositorioProducto;
    private RepositorioGarantiaExtendida repositorioGarantia;

    List<Calendar> diasFestivos;
    
    public Vendedor(RepositorioProducto repositorioProducto, RepositorioGarantiaExtendida repositorioGarantia) {
        this.repositorioProducto = repositorioProducto;
        this.repositorioGarantia = repositorioGarantia; 
        
        diasFestivos = new LinkedList<Calendar>();
        
        //        1	enero	Año Nuevo 2018
        Calendar diaFestivo = Calendar.getInstance();
        diaFestivo.set(2018, Calendar.JANUARY, 1);
        diasFestivos.add(diaFestivo);
        
        //        8	enero	Día de los Reyes Magos
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2018, Calendar.JANUARY, 8);
        diasFestivos.add(diaFestivo);
        
        //        19	marzo	Día de San José
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2018, Calendar.MARCH, 19);
        diasFestivos.add(diaFestivo);

        //        25	marzo	Domingo de Ramos
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2018, Calendar.MARCH, 25);
        diasFestivos.add(diaFestivo);

        //        29	marzo	Jueves Santo
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2018, Calendar.MARCH, 29);
        diasFestivos.add(diaFestivo);

        //        30	marzo	Viernes Santo
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2018, Calendar.MARCH, 30);
        diasFestivos.add(diaFestivo);

        //        1	abril	Domingo de Resurrección
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2018, Calendar.APRIL , 1);
        diasFestivos.add(diaFestivo);

        //        1	mayo	Día del Trabajo
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2018, Calendar.MAY , 1);
        diasFestivos.add(diaFestivo);

        //        14	mayo	Día de la Ascensión
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2018, Calendar.MAY , 14);
        diasFestivos.add(diaFestivo);

        //        4	junio	Corpus Christi
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2018, Calendar.JUNE , 4);
        diasFestivos.add(diaFestivo);

        //        11	junio	Sagrado Corazón
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2018, Calendar.JUNE , 11);
        diasFestivos.add(diaFestivo);

        //        2	julio	San Pedro y San Pablo
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2018, Calendar.JULY , 2);
        diasFestivos.add(diaFestivo);

        //        20	julio	Día de la Independencia
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2018, Calendar.JULY , 20);
        diasFestivos.add(diaFestivo);

        //        7	agosto	Batalla de Boyacá
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2018, Calendar.AUGUST , 7);
        diasFestivos.add(diaFestivo);

        //        20	agosto	La asunción de la Virgen
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2018, Calendar.AUGUST , 20);
        diasFestivos.add(diaFestivo);

        //        15	octubre	Día de la Raza
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2018, Calendar.OCTOBER , 15);
        diasFestivos.add(diaFestivo);

        //        5	noviembre	Todos los Santos
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2018, Calendar.NOVEMBER , 5);
        diasFestivos.add(diaFestivo);

        //        12	noviembre	Independencia de Cartagena
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2018, Calendar.NOVEMBER , 12);
        diasFestivos.add(diaFestivo);

        //        8	diciembre	Día de la Inmaculada Concepción
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2018, Calendar.DECEMBER , 8);
        diasFestivos.add(diaFestivo);

        //        25	diciembre	Día de Navidad        
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2018, Calendar.DECEMBER , 25);
        diasFestivos.add(diaFestivo);
        
        
        // 1	enero	Año Nuevo 2019
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2019, Calendar.JANUARY, 1);
        diasFestivos.add(diaFestivo);
        
        // 7	enero	Día de los Reyes Magos
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2019, Calendar.JANUARY, 7);     
        diasFestivos.add(diaFestivo);
        
        // 25	marzo	Día de San José
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2019, Calendar.MARCH, 25);     
        diasFestivos.add(diaFestivo);

        // 14	abril	Domingo de Ramos
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2019, Calendar.APRIL, 14);     
        diasFestivos.add(diaFestivo);
        
        // 18	abril	Jueves Santo
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2019, Calendar.APRIL, 18);     
        diasFestivos.add(diaFestivo);
        
        // 19	abril	Viernes Santo
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2019, Calendar.APRIL, 19);     
        diasFestivos.add(diaFestivo);

        // 21	abril	Domingo de Resurrección
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2019, Calendar.APRIL, 21);     
        diasFestivos.add(diaFestivo);
        
        // 1	mayo	Día del Trabajo
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2019, Calendar.MAY, 1);     
        diasFestivos.add(diaFestivo);
        
        // 3	junio
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2019, Calendar.JUNE, 3);     
        diasFestivos.add(diaFestivo);
        
        // 24	junio
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2019, Calendar.JUNE, 24);
        diasFestivos.add(diaFestivo);
        
        // 1	julio
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2019, Calendar.JULY, 1);
        diasFestivos.add(diaFestivo);
        
        // 20	julio	Día de la Independencia
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2019, Calendar.JULY, 20);
        diasFestivos.add(diaFestivo);
        
        // 7	agosto	Batalla de Boyacá
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2019, Calendar.AUGUST, 7);
        diasFestivos.add(diaFestivo);
        
        // 19	agosto	La asunción de la Virgen
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2019, Calendar.AUGUST, 19);
        diasFestivos.add(diaFestivo);
        
        // 14	octubre	Día de la Raza
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2019, Calendar.OCTOBER, 14);
        diasFestivos.add(diaFestivo);

        // 4	noviembre	Todos los Santos
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2019, Calendar.NOVEMBER, 4);
        diasFestivos.add(diaFestivo);

        // 11	noviembre	Independencia de Cartagena
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2019, Calendar.NOVEMBER, 11);
        diasFestivos.add(diaFestivo);

        // 8	diciembre	Día de la Inmaculada Concepción
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2019, Calendar.DECEMBER, 8);
        diasFestivos.add(diaFestivo);

        // 25	diciembre	Día de Navidad       
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2019, Calendar.DECEMBER, 25);
        diasFestivos.add(diaFestivo);

        
        // 1	enero	Año Nuevo 2020
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2020, Calendar.JANUARY, 1);
        diasFestivos.add(diaFestivo);
        
        // 6	enero	Día de los Reyes Magos
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2020, Calendar.JANUARY, 6);
        diasFestivos.add(diaFestivo);
        
        // 23	marzo	Día de San José
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2020, Calendar.MARCH, 23);
        diasFestivos.add(diaFestivo);
        
        // 5	abril	Domingo de Ramos
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2020, Calendar.APRIL, 5);
        diasFestivos.add(diaFestivo);
        
        // 9	abril	Jueves Santo
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2020, Calendar.APRIL, 9);
        diasFestivos.add(diaFestivo);
        
        // 10	abril	Viernes Santo
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2020, Calendar.APRIL, 10);
        diasFestivos.add(diaFestivo);
        
        // 12	abril	Domingo de Resurrección
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2020, Calendar.APRIL, 12);
        diasFestivos.add(diaFestivo);
        
        // 1	mayo	Día del Trabajo
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2020, Calendar.MAY, 1);
        diasFestivos.add(diaFestivo);
        
        // 25	mayo	Día de la Ascensión
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2020, Calendar.MAY, 25);
        diasFestivos.add(diaFestivo);
        
        // 15	junio	Corpus Christi        
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2020, Calendar.JUNE, 15);
        diasFestivos.add(diaFestivo);        
        
        // 22	junio	Sagrado Corazón
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2020, Calendar.JUNE, 22);
        diasFestivos.add(diaFestivo);
        
        // 29	junio	San Pedro y San Pablo
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2020, Calendar.JUNE, 29);
        diasFestivos.add(diaFestivo);
        
        // 20	julio	Día de la Independencia
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2020, Calendar.JULY, 20);
        diasFestivos.add(diaFestivo);
        
        // 7	agosto	Batalla de Boyacá
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2020, Calendar.AUGUST, 7);
        diasFestivos.add(diaFestivo);
        
        // 17	agosto	La asunción de la Virgen
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2020, Calendar.AUGUST, 17);
        diasFestivos.add(diaFestivo);
        
        // 12	octubre	Día de la Raza
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2020, Calendar.OCTOBER, 12);
        diasFestivos.add(diaFestivo);
        
        // 2	noviembre	Todos los Santos
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2020, Calendar.NOVEMBER, 2);
        diasFestivos.add(diaFestivo);
        
        // 16	noviembre	Independencia de Cartagena
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2020, Calendar.NOVEMBER, 16);
        diasFestivos.add(diaFestivo);
        
        // 8	diciembre	Día de la Inmaculada Concepción
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2020, Calendar.DECEMBER, 8);
        diasFestivos.add(diaFestivo);
        
        // 25	diciembre	Día de Navidad
        diaFestivo = Calendar.getInstance();
        diaFestivo.set(2020, Calendar.DECEMBER, 25);
        diasFestivos.add(diaFestivo);        
    }

    public GarantiaExtendida generarGarantia(String codigoProducto, String nombreCliente) throws GarantiaExtendidaException {

    	Producto producto = null ; 
        int diasDeGarantia = 0; 
        int numDias = 1;
		Date fechaFinGarantia = null ;
		Date fechaSolicitudGarantia = null ; 
		double precioGarantia = 0.0 ;
		
		if ( (codigoProducto==null) || codigoProducto.isEmpty() ||  (nombreCliente==null) || nombreCliente.isEmpty()  ) {
			throw new GarantiaExtendidaException(Vendedor.FALTA_COD_PRODUCTO_NOM_CLIENTE);
		} 
		
		if ( repositorioProducto.codigoProductoTieneTresVocales(codigoProducto) ) {
			throw new GarantiaExtendidaException(Vendedor.PRODUCTO_NO_CUENTA_CON_GARANTIA); 
		}
		
		if ( this.repositorioGarantia.tieneGarantia(codigoProducto) ) {
			throw new GarantiaExtendidaException(Vendedor.EL_PRODUCTO_TIENE_GARANTIA);
		}		

		producto = this.repositorioProducto.obtenerPorCodigo(codigoProducto);
		
        Calendar diaActual = Calendar.getInstance();
        fechaSolicitudGarantia = diaActual.getTime() ;
    	
    	/* Vamos a ver si diaActual es lunes */
    	if ( diaActual.get(Calendar.DAY_OF_WEEK)==Calendar.MONDAY ) {
    		numDias = 0;
    	}
    	        
    	if ( producto.getPrecio() > Vendedor.VALOR_PRODUCTO_CORTE ) { 
    		diasDeGarantia = Vendedor.NUM_DIAS_GARANTIA_MAYOR ; 
    		precioGarantia = producto.getPrecio() * ( Vendedor.VALOR_GARANTIA_PORCENTAGE_PRODUCTO_COSTO_MAYOR_CORTE / 100.0 ) ;
    		    		
    	}
    	else {
    		diasDeGarantia = Vendedor.NUM_DIAS_GARANTIA_MENOR ;
    		precioGarantia = producto.getPrecio() * ( Vendedor.VALOR_GARANTIA_PORCENTAGE_PRODUCTO_COSTO_MENOR_IGUAL_CORTE / 100.0 ) ;    		
    	}
    	
		/* Invariante: 'numDias' es el numero de dias validos (sin contar los lunes) que han corrido de la garantia hasta 'diaActual' 
		 diaActual es un dia que esta cubierto por la garantia
		*/
		while ( numDias < diasDeGarantia) {
			diaActual.add(Calendar.DAY_OF_MONTH, 1);
	    	if ( diaActual.get(Calendar.DAY_OF_WEEK)!=Calendar.MONDAY ) {
	    		numDias++;
	    	}
		}

		diaActual.add(Calendar.DAY_OF_MONTH, 1);

		/* El dia diaActual es el primer dia candidato a ser el dia de finalizacion de la garantia */
		
        /* Vamos a buscar que el dia de finalizacion de la garantia no sea ni domingo ni festivo */
       
        while ( esDomingoOEsDiaFestivo(diaActual) ) {
   		   diaActual.add(Calendar.DAY_OF_MONTH, 1);
        }
        /* diaActual es el dia de finalizacion de la garantia */

        // int diaDeSemana = diaActual.get( Calendar.DAY_OF_MONTH);
        // int mes =  diaActual.get( Calendar.MONTH);
        // int agno = diaActual.get( Calendar.YEAR);
       
        fechaFinGarantia = diaActual.getTime() ;
       		
	    GarantiaExtendida garantiaExtendida = new GarantiaExtendida(producto, fechaSolicitudGarantia, fechaFinGarantia,
	            precioGarantia, nombreCliente);
		
		repositorioGarantia.agregar(garantiaExtendida);
		
        return garantiaExtendida;
    }    
 
    private boolean esDomingoOEsDiaFestivo(Calendar diaActual) {
    	boolean encontro = false;
    	if ( diaActual.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY ) {
    		return true;
    	}
    	
    	for (Calendar diaFestivo: diasFestivos) {
    		if ( esElMismoDia(diaActual,diaFestivo) ) {
    			encontro = true ;
    			break;
    		}
    	}
    	
        return encontro;
    }
    
    private boolean esElMismoDia(Calendar primerDia, Calendar segundoDia) {
       return ( primerDia.get(Calendar.YEAR)==segundoDia.get( Calendar.YEAR) ) 
    		   && (primerDia.get(Calendar.MONTH)==segundoDia.get( Calendar.MONTH)) 
    		   && (primerDia.get(Calendar.DAY_OF_MONTH)==segundoDia.get( Calendar.DAY_OF_MONTH))  ;	
    }
    
    
    
    public boolean tieneGarantia(String codigoProducto) {
    	Producto producto = repositorioGarantia.obtenerProductoConGarantiaPorCodigo(codigoProducto);
    	return (producto!=null);
        //return this.repositorioGarantia.tieneGarantia(codigoProducto);
    }
    
    public void crearProducto(Producto producto) {
    	this.repositorioProducto.agregar(producto);	
    }
    
}
