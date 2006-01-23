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
 * Created on Jan 20, 2006
 */
package org.nomad.main;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import org.nomad.xml.dom.module.DModule;
import org.nomad.xml.dom.module.DToolbarGroup;
import org.nomad.xml.dom.module.DToolbarSection;
import org.nomad.xml.dom.module.ModuleDescriptions;

public class ModuleGroupsMenu extends JMenu {

	private static ModuleGroupsMenu menu = null;
	
	public static ModuleGroupsMenu getMenu() {
		if (menu==null)
			menu = new ModuleGroupsMenu();
		
		return menu;
	}
	
	public ModuleGroupsMenu() {
		super("Modules");
		ModuleDescriptions m = ModuleDescriptions.sharedInstance();
		for (int i=0;i<m.getGroupCount();i++)
			add (new ModuleGroupMenu(m.getGroup(i)));
	}
	
}

class ModuleGroupMenu extends JMenu {
	public ModuleGroupMenu(DToolbarGroup group) {
		super(group.getName());
		for (int i=0;i<group.getSectionCount();i++) {
			DToolbarSection section = group.getSection(i);
			for (int j=0;j<section.getModuleCount();j++) {
				DModule module = section.getModule(j);
				
				add(new JMenuItem(module.getName(), new ImageIcon(module.getIcon())));
			}
			if (i+1<group.getSectionCount())
				this.addSeparator();
		}
	}
}