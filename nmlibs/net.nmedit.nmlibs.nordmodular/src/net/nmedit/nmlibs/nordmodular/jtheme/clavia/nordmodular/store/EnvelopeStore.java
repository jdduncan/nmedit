/* Copyright (C) 2006 Christian Schneider
 * 
 * This file is part of Nomad.
 * 
 * Nomad is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * Nomad is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Nomad; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package net.nmedit.nmlibs.nordmodular.jtheme.clavia.nordmodular.store;

import net.nmedit.nmlibs.jpatch.PModule;
import net.nmedit.nmlibs.jpatch.PModuleDescriptor;
import net.nmedit.nmlibs.jtheme.JTContext;
import net.nmedit.nmlibs.jtheme.JTException;
import net.nmedit.nmlibs.nordmodular.jtheme.clavia.nordmodular.JTEnvelopeDisplay;
import net.nmedit.nmlibs.jtheme.store.StorageContext;
import net.nmedit.nmlibs.jtheme.store2.AbstractMultiParameterElement;
import net.nmedit.nmlibs.jtheme.store2.ComponentElement;

import org.jdom.Element;

public class EnvelopeStore extends AbstractMultiParameterElement
{

    /**
     * 
     */
    private static final long serialVersionUID = -207922282356444796L;

    private String elementName;
    
    protected EnvelopeStore(String elementName)
    {
        super(JTEnvelopeDisplay.class);
        this.elementName = elementName;
    }

    public static ComponentElement createElement(StorageContext context, Element element)
    {
        EnvelopeStore e = new EnvelopeStore(element.getName());
        e.initElement(context, element);
        e.checkDimensions();
        e.checkLocation();
        return e;
    }

    @Override
    public JTEnvelopeDisplay createComponent(JTContext context, PModuleDescriptor descriptor, PModule module)
        throws JTException
    {
        JTEnvelopeDisplay component = context.createComponentInstance(JTEnvelopeDisplay.class);
        setName(component);
        setBounds(component);
        link(component, module);
        
        if ("ad-envelope".equals(elementName)) component.configureAD();
        else if ("adsr-envelope".equals(elementName)
                ||"adsr-mod-envelope".equals(elementName)) component.configureADSR();
        else if ("ahd-envelope".equals(elementName)) component.configureAHD();
        else component.configureADSR();
        
        return component; 
    }
    
}
