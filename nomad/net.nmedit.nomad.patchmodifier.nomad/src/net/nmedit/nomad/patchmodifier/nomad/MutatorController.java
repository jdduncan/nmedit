package net.nmedit.nomad.patchmodifier.nomad;

import javax.swing.JFrame;

import net.nmedit.nmlibs.nomad.core.swing.document.Document; 

import net.nmedit.nmlibs.jpatch.PPatch;
import net.nmedit.nmlibs.nomad.core.swing.document.DocumentEvent;
import net.nmedit.nmlibs.nomad.core.swing.document.DocumentListener;
import net.nmedit.nmlibs.patchmodifier.mutator.Mutator;

public class MutatorController implements DocumentListener
{

    private static MutatorController instance = new MutatorController();
    
    private static final boolean DEBUG= false;
    
    public static MutatorController sharedInstance()
    {
        return instance;
    }
    
    private Mutator mutator;
    
    private void ensureMutatorCreated()
    {
        if (mutator == null)
        {
            mutator = new Mutator();
            mutator.getFrame().setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }
    }

    public void openMutatorWindow()
    {
        ensureMutatorCreated();
        mutator.getFrame().setVisible(true);
    }

    private PPatch getPatch(Document d)
    {
        Object maybePatch = d.getProperty("patch");
        if (maybePatch != null && maybePatch instanceof PPatch)
            return (PPatch) maybePatch;
        return null;
    }
    
	public void documentAdded(DocumentEvent e) {
		ensureMutatorCreated();
		PPatch patch = getPatch(e.getDocument());
		if (patch != null)   
		{
    		// TODO addPatch is not called for already existing documents
    		mutator.addPatch(patch);
    		mutator.selectPatch(patch);
		}
	}

	public void documentRemoved(DocumentEvent e){
		ensureMutatorCreated();
        PPatch patch = getPatch(e.getDocument());
        if (patch != null)
		    mutator.removePatch(patch);	
		
	}

	public void documentSelected(DocumentEvent e) {
		ensureMutatorCreated();
		Document d = e.getDocument();
		
		if (d != null) {
			PPatch patch = getPatch(d);
			mutator.selectPatch(patch);	
		} else {
			mutator.selectPatch(null);
		}
	
	}

}
