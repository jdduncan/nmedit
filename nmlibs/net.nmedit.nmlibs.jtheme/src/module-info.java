module net.nmedit.nmlibs.jtheme {
	exports net.nmedit.nmlibs.jtheme.designer;
	exports net.nmedit.nmlibs.jtheme.reflect;
	exports net.nmedit.nmlibs.jtheme.annotation;
	exports net.nmedit.nmlibs.jtheme.image;
	exports net.nmedit.nmlibs.jtheme.designer.test;
	exports net.nmedit.nmlibs.jtheme.component.layer;
	exports net.nmedit.nmlibs.jtheme.store2;
	exports net.nmedit.nmlibs.jtheme.help;
	exports net.nmedit.nmlibs.jtheme;
	exports net.nmedit.nmlibs.jtheme.component.misc;
	exports net.nmedit.nmlibs.jtheme.store;
	exports net.nmedit.nmlibs.jtheme.component;
	exports net.nmedit.nmlibs.jtheme.util;
	exports net.nmedit.nmlibs.jtheme.component.plaf.mcui;
	exports net.nmedit.nmlibs.jtheme.cable;
	exports net.nmedit.nmlibs.jtheme.component.plaf;
	exports net.nmedit.nmlibs.jtheme.store.resource;
	exports net.nmedit.nmlibs.jtheme.css;

	requires java.datatransfer;
	requires java.desktop;
	requires java.xml;
	requires jdk.xml.dom;
	
	requires net.nmedit.nmlibs.nmutils;
	requires net.nmedit.nmlibs.jpatch;
	
	requires jdom;
	requires sac;
	requires cssparser;
	requires commons.logging;
	requires batik.transcoder;
}
