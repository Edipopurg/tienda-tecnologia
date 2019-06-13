package persistencia.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dominio.Producto;
import dominio.repositorio.RepositorioProducto;
import persistencia.builder.ProductoBuilder;
import persistencia.entitad.ProductoEntity;
import persistencia.repositorio.jpa.RepositorioProductoJPA;

public class RepositorioProductoPersistente implements RepositorioProducto, RepositorioProductoJPA {

	private static final String CODIGO = "codigo";
	private static final String PRODUCTO_FIND_BY_CODIGO = "Producto.findByCodigo";
	
	private EntityManager entityManager;

	public RepositorioProductoPersistente(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Producto obtenerPorCodigo(String codigo) {
		
		ProductoEntity productoEntity = obtenerProductoEntityPorCodigo(codigo);
		return ProductoBuilder.convertirADominio(productoEntity);
	}
	
	@Override
	public ProductoEntity obtenerProductoEntityPorCodigo(String codigo) {
		
		Query query = entityManager.createNamedQuery(PRODUCTO_FIND_BY_CODIGO);
		query.setParameter(CODIGO, codigo);

		return (ProductoEntity) query.getSingleResult();
	}

	@Override
	public void agregar(Producto producto) {
		entityManager.persist(ProductoBuilder.convertirAEntity(producto));
	}	

	
	@Override
	public boolean codigoProductoTieneTresVocales(String codigoProducto) {
		int numVocales = 0 ;
	   	String uppercodigoProducto = new String(codigoProducto);
	   	
	   	uppercodigoProducto = uppercodigoProducto.toUpperCase();
	   	
		for (int i=0; i<uppercodigoProducto.length() ; i++ ) {
			
			if ( (uppercodigoProducto.charAt(i)=='A') || (uppercodigoProducto.charAt(i)=='E') 
				|| (uppercodigoProducto.charAt(i)=='I')  || (uppercodigoProducto.charAt(i)=='O')  
				|| (uppercodigoProducto.charAt(i)=='U')  ) {
				numVocales++ ;
			}
		}
			
		return ( numVocales >= 3 ) ;
	}

}
