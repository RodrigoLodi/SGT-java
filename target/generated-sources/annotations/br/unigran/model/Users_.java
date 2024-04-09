package br.unigran.model;

import br.unigran.model.Task;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-08T22:44:08", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, char[]> password;
    public static volatile SingularAttribute<Users, Task> task;
    public static volatile SingularAttribute<Users, String> mail;
    public static volatile SingularAttribute<Users, String> name;
    public static volatile SingularAttribute<Users, Integer> id;

}