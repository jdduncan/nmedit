package net.nmedit.nomad.core.utils;

import java.util.Properties;

import net.nmedit.nmlibs.nmutils.properties.RootSystemProperties;
import net.nmedit.nmlibs.nmutils.properties.SystemProperties;
import net.nmedit.nmlibs.nmutils.properties.SystemPropertyFactory;

public class NomadPropertyFactory extends SystemPropertyFactory
{

    private RootSystemProperties properties;
    
    public NomadPropertyFactory(RootSystemProperties properties)
    {
        this.properties = properties;
    }
    
    public Properties getProperties()
    {
        return properties.getProperties();
    }
    
    protected String getIdFor(Class<?> forClass)
    {
        return forClass.getName()+"."; 
    }
    
    public SystemProperties getPropertiesForClass(Class<?> forClass)
    {
        return new SystemProperties(properties, getIdFor(forClass));
    }

}
