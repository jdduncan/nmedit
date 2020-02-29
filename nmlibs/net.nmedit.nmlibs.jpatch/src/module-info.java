module net.nmedit.nmlibs.jpatch {
	exports net.nmedit.nmlibs.jpatch.history2;
	exports net.nmedit.nmlibs.jpatch.util;
	exports net.nmedit.nmlibs.jpatch.test;
	exports net.nmedit.nmlibs.jpatch.history;
	exports net.nmedit.nmlibs.jpatch.impl;
	exports net.nmedit.nmlibs.jpatch.js;
	exports net.nmedit.nmlibs.jpatch.event;
	exports net.nmedit.nmlibs.jpatch;
	exports net.nmedit.nmlibs.jpatch.transform;
	exports net.nmedit.nmlibs.jpatch.dnd;

	requires java.datatransfer;
	requires java.desktop;
	requires java.xml;
	
	requires junit;
	requires commons.logging;

	requires net.nmedit.nmlibs.nmutils;
}