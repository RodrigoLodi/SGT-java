package br.unigran.model;

import br.unigran.model.Users;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-07T21:02:02", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Task.class)
public class Task_ { 

    public static volatile SingularAttribute<Task, Date> date;
    public static volatile SingularAttribute<Task, String> description;
    public static volatile SingularAttribute<Task, Integer> id;
    public static volatile SingularAttribute<Task, String> title;
    public static volatile SingularAttribute<Task, String> priority;
    public static volatile SingularAttribute<Task, Users> userTask;
    public static volatile SingularAttribute<Task, Boolean> status;

}