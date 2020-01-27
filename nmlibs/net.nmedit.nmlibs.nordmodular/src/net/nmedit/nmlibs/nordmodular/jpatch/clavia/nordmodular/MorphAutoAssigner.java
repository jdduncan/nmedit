package net.nmedit.nmlibs.nordmodular.jpatch.clavia.nordmodular;

import net.nmedit.nmlibs.jpatch.PModule;
import net.nmedit.nmlibs.jpatch.PModuleContainer;
import net.nmedit.nmlibs.jpatch.PParameter;
import net.nmedit.nmlibs.nordmodular.jpatch.clavia.nordmodular.PNMMorphSection.Assignments;
import net.nmedit.nmlibs.jpatch.event.PModuleContainerEvent;
import net.nmedit.nmlibs.jpatch.event.PModuleContainerListener;
import net.nmedit.nmlibs.jpatch.event.PParameterEvent;
import net.nmedit.nmlibs.jpatch.event.PParameterListener;

public class MorphAutoAssigner implements PModuleContainerListener,
    PParameterListener
{

    private NMPatch patch;

    public MorphAutoAssigner(NMPatch patch)
    {
        this.patch = patch;
    }
    
    public void installAt(PModuleContainer c)
    {
        c.addModuleContainerListener(this);
        installAtModules(c);
    }
    
    public void uninstallFrom(PModuleContainer c)
    {
        c.removeModuleContainerListener(this);
        uninstallFromModules(c);
    }

    private void installAtModules(PModuleContainer c)
    {
        for (PModule module: c)
            installAt(module);
    }

    private void uninstallFromModules(PModuleContainer c)
    {
        for (PModule module: c)
            uninstallFrom(module);
    }

    public void moduleAdded(PModuleContainerEvent e)
    {
        installAt(e.getModule());
    }

    public void moduleRemoved(PModuleContainerEvent e)
    {
        uninstallFrom(e.getModule());
    }

    private void installAt(PModule module)
    {
        for (int i = module.getParameterCount()-1;i>=0;i--)
        {
            PParameter param = module.getParameter(i);
            if (param.getExtensionParameter() != null)
                installAt(param, param.getExtensionParameter());
        }
    }

    private void uninstallFrom(PModule module)
    {
        for (int i = module.getParameterCount()-1;i>=0;i--)
        {
            PParameter param = module.getParameter(i);
            if (param.getExtensionParameter() != null)
                uninstallFrom(param.getExtensionParameter());
        }
    }

    private void installAt(PParameter parameter, PParameter extensionParameter)
    {
        extensionParameter.addParameterListener(this);
    }

    private void uninstallFrom(PParameter extensionParameter)
    {
        extensionParameter.removeParameterListener(this);
    }

    public void parameterValueChanged(PParameterEvent e)
    {
        PParameter extensionParameter = e.getParameter();
        PModule module = extensionParameter.getParentComponent();
        for (int i=module.getParameterCount()-1;i>=0;i--)
        {
            PParameter extendedParameter = module.getParameter(i);
            if (extendedParameter.getExtensionParameter() == extensionParameter)
            {
                // found
                parameterValueChanged(extendedParameter, extensionParameter);
                return;
            }
        }
    }

    private void parameterValueChanged(PParameter parameter, 
            PParameter extensionParameter)
    {
        // now check if parameter was assigned to a morph group
        if (patch.getMorphSection().getAssignedMorph(parameter) < 0)
        {
            // not assigned
            int nextFreeGroup = findNextFreeMorphGroup();
            if (nextFreeGroup>=0) // free group found
            {
                if (patch.getMorphSection().assign(nextFreeGroup, parameter))
                {
                    return ; // assigned
                }
            }

            // no morph assigned - reset value
            extensionParameter.setValue(0);
        }
        else
        {
            // morph already assigned
        }
    }
    
    private int findNextFreeMorphGroup()
    {
        PNMMorphSection morphs = patch.getMorphSection();
        for (int i=0;i<morphs.getMorphCount();i++)
        {
            Assignments a = morphs.getAssignments(i);
            if (!a.isFull())
                return i;
        }
        return -1;
    }

    public void focusRequested(PParameterEvent e)
    {
        // no op
    }

}
