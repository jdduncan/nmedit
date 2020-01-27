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
package net.nmedit.nmlibs.jpatch;

/**
 * Descriptor for a {@link PConnector connector}.
 * 
 * @author Christian Schneider
 */
public interface PConnectorDescriptor extends PDescriptor
{

    /**
     * Returns true if this connector is an output, false if it is an input
     * @return true if this connector is an output, false if it is an input.
     */
    boolean isOutput();
    
    /**
     * Returns the default signal type of the connector.
     * The return value is always non-null.
     * @return the default signal of the connector
     */
    PSignal getDefaultSignalType();
    
    /**
     * Returns the parent module descriptor.
     * The return value is always non-null.
     * @return the parent descriptor.
     */
    PModuleDescriptor getParentDescriptor();

    /**
     * Returns the defined signals.
     * @return the defined signals
     */
    PSignalTypes getDefinedSignals();
    
}
