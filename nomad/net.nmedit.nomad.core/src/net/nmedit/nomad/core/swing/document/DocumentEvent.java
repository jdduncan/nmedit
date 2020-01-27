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

/*
 * Created on May 24, 2006
 */
package net.nmedit.nomad.core.swing.document;

public class DocumentEvent
{

    public final static int DOCUMENT_ADDED      = 0;
    public final static int DOCUMENT_REMOVED    = 1;
    public final static int DOCUMENT_SELECTED   = 2;
    
    private final int ID;
    private Document document;

    public DocumentEvent(int ID, Document document)
    {
        this.ID = ID;
        this.document = document;
    }
    
    public int getID()
    {
        return ID;
    }
    
    public Document getDocument()
    {
        return document;
    }

}
