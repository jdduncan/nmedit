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
 * Created on Nov 24, 2006
 */
package net.nmedit.nomad.core.utils;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class ImageFiles extends Images
{

    private ClassLoader rsClassLoader;
   
    public ImageFiles()
    {
        this(null);
    }
    
    public ImageFiles(ClassLoader classLoader)
    {
        this.rsClassLoader = classLoader;
    }

    public Image getImage( String baseName )
    {   
        URL url = getResourceURL(baseName);

        if (url == null)
            resourceNotFound(baseName);

        Image img = 
            Toolkit.getDefaultToolkit().getImage(url);
        
        if (img == null)
            resourceNotFound(baseName);

        return img;
    }

    public ClassLoader getResourceClassLoader()
    {
        return rsClassLoader;
    }
    
    private URL getResourceURL(String baseName)
    {
        URL url = getResourceClassLoader().getResource(baseName);
        if (url == null)
            resourceNotFound(baseName);
        return url;
    }

    public void flush()
    {
        // not caching images 
    }

    public boolean isCaching()
    {
        // not caching images
        return false;
    }
    
    
}
