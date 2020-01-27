package net.nmedit.nmlibs.jpatch.dnd;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.datatransfer.Transferable;
import java.util.Collection;

import net.nmedit.nmlibs.jpatch.PModule;
import net.nmedit.nmlibs.jpatch.PModuleContainer;
import net.nmedit.nmlibs.jpatch.PPatch;

public interface PModuleTransferData extends Transferable {
	PModuleContainer getSourceModuleContainer();
	PPatch getSourcePatch();
	Collection<? extends PModule> getModules();
	Point getDragStartLocation();
	Rectangle getBoundingBox();
	Rectangle getBoundingBox(Rectangle r);
}
