package com.fl.core.utilz;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.ParameterizedType;
import org.hibernate.usertype.UserType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EnumStringUserType implements UserType, ParameterizedType {
    
    private Method   recreateEnumMthd;
    private Method   recreateStringMthd;
    private Class<?> enumClass;
                     
    @Override
    public void setParameterValues(Properties parameters) {
        if (parameters != null) {
            String enumMthd = parameters.getProperty("recreateEnumMthd");
            String strMthd = parameters.getProperty("recreateStringMthd");
            String className = parameters.getProperty("enumClassName");
            Class<?> returnType = null;
            
            try {
                enumClass = Class.forName(className);
                recreateStringMthd = enumClass.getMethod(strMthd, new Class[] {});
                returnType = recreateStringMthd.getReturnType();
                recreateEnumMthd = enumClass.getMethod(enumMthd, new Class[] { returnType });
            } catch (ClassNotFoundException e) {
                log.error("", e);
            } catch (SecurityException e) {
                log.error("", e);
            } catch (NoSuchMethodException e) {
                log.error("", e);
            }
        }
    }
    
    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return cached;
    }
    
    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }
    
    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) value;
    }
    
    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        if (x == y) {
            return true;
        }
        
        if (x == null || y == null) {
            return false;
        }
        
        if (x.equals(y)) {
            return true;
        }
        
        return false;
    }
    
    @Override
    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }
    
    @Override
    public boolean isMutable() {
        return false;
    }
    
    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return original;
    }
    
    @Override
    public Class<?> returnedClass() {
        return enumClass;
    }
    
    @Override
    public int[] sqlTypes() {
        return new int[] { Types.VARCHAR };
    }
    
    @Override
    public Object nullSafeGet(ResultSet paramResultSet, String[] paramArrayOfString, SessionImplementor paramSessionImplementor, Object paramObject) throws HibernateException, SQLException {
        String value = paramResultSet.getString(paramArrayOfString[0]);
        Object returnVal = null;
        
        if (value == null)
            return null;
        else {
            try {
                returnVal = recreateEnumMthd.invoke(enumClass, new Object[] { value });
            } catch (IllegalArgumentException e) {
                log.error("", e);
            } catch (IllegalAccessException e) {
                log.error("", e);
            } catch (InvocationTargetException e) {
                log.error("", e);
            }
        }
        
        return returnVal;
    }
    
    @Override
    public void nullSafeSet(PreparedStatement paramPreparedStatement, Object paramObject, int paramInt, SessionImplementor paramSessionImplementor) throws HibernateException, SQLException {
        String prepStmtVal = null;
        
        if (paramObject == null) {
            paramPreparedStatement.setObject(paramInt, null);
        } else {
            try {
                prepStmtVal = (String) recreateStringMthd.invoke(paramObject, new Object[] {});
                paramPreparedStatement.setString(paramInt, prepStmtVal);
            } catch (IllegalArgumentException e) {
                log.error("", e);
            } catch (IllegalAccessException e) {
                log.error("", e);
            } catch (InvocationTargetException e) {
                log.error("", e);
            }
        }
    }
}
