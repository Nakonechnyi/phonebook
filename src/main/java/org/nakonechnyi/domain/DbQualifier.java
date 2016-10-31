package org.nakonechnyi.domain;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @autor A_Nakonechnyi
 * @date 30.10.2016.
 */
@Target({ElementType.TYPE,
        ElementType.PARAMETER,
        ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface DbQualifier {
    DbSource value();

    public static enum DbSource {
        MY_SQL,
        MONGO_DB
    }
}
