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
package net.nmedit.nmlibs.jtheme.store2;

import net.nmedit.nmlibs.jpatch.PModule;
import net.nmedit.nmlibs.jpatch.PModuleDescriptor;
import net.nmedit.nmlibs.jtheme.JTContext;
import net.nmedit.nmlibs.jtheme.JTException;
import net.nmedit.nmlibs.jtheme.component.JTComponent;
import net.nmedit.nmlibs.jtheme.store.StorageContext;

import org.jdom.Element;

public abstract class ComponentElement
{

    protected ComponentElement()
    {
        super();
    }
    
    public void initializeElement(StorageContext context)
    {
        // no op
    }
    
    public static ComponentElement createElement(JTContext context, Element element)
    {
        throw new UnsupportedOperationException("createElement(JTContext, Element) not implemented");
    }
    
    public abstract JTComponent createComponent(JTContext context, PModuleDescriptor descriptor, PModule module)
        throws JTException;

    public boolean isReducible()
    {
        return false;
    }
    
}
