package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuario.class)
public abstract class Usuario_ {

	public static volatile SingularAttribute<Usuario, String> senha;
	public static volatile SingularAttribute<Usuario, Integer> estado;
	public static volatile SingularAttribute<Usuario, Date> data;
	public static volatile SingularAttribute<Usuario, String> nome;
	public static volatile SingularAttribute<Usuario, Integer> id;
	public static volatile SingularAttribute<Usuario, String> email;
	public static volatile SingularAttribute<Usuario, String> confirmarsenha;

	public static final String SENHA = "senha";
	public static final String ESTADO = "estado";
	public static final String DATA = "data";
	public static final String NOME = "nome";
	public static final String ID = "id";
	public static final String EMAIL = "email";
	public static final String CONFIRMARSENHA = "confirmarsenha";

}

