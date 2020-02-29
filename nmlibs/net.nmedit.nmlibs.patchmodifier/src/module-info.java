module net.nmedit.nmlibs.patchmodifier {
	exports net.nmedit.nmlibs.patchmodifier.randomizer;
	exports net.nmedit.nmlibs.patchmodifier.mutator;

	requires java.datatransfer;
	requires java.desktop;
	requires net.nmedit.nmlibs.jpatch;
	requires commons.logging;
}