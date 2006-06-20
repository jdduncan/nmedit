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
 * Created on Jun 18, 2006
 */
package net.sf.nmedit.jsynth.generic;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiDevice.Info;

import net.sf.nmedit.jsynth.SynthException;
import net.sf.nmedit.jsynth.Synthesizer;
import net.sf.nmedit.jsynth.event.SynthStateChangeEvent;
import net.sf.nmedit.jsynth.event.SynthStateListener;

public abstract class AbstractSynthesizer implements Synthesizer
{

    private final String name;
    private final String vendor;
    private final String version;
    private MidiDevice.Info midiInInfo;
    private MidiDevice.Info midiOutInfo;
    private List<SynthStateListener> stateListenerList = new ArrayList<SynthStateListener>();

    public AbstractSynthesizer( String name, String vendor, String version )
    {
        this.name = name;
        this.vendor = vendor;
        this.version = version;
        this.midiInInfo = null;
        this.midiOutInfo = null;
    }

    public String getName()
    {
        return name;
    }

    public String getVendor()
    {
        return vendor;
    }

    public String getVersion()
    {
        return version;
    }

    protected void failIfConnected( String message )
    {
        if (isConnected())
        {
            throw new IllegalStateException( "Synthesizer is connected:"
                    + message );
        }
    }

    public void setMidiIn( Info in )
    {
        failIfConnected( "Can't set MIDI input device." );
        this.midiInInfo = in;
    }

    public void setMidiOut( Info out )
    {
        failIfConnected( "Can't set MIDI output device." );
        this.midiOutInfo = out;
    }

    public Info getMidiIn()
    {
        return midiInInfo;
    }

    public Info getMidiOut()
    {
        return midiOutInfo;
    }

    protected void fireSynthStateEvent()
    {
        SynthStateChangeEvent e = new SynthStateChangeEvent( this );
        for (int i = stateListenerList.size() - 1; i >= 0; i--)
        {
            stateListenerList.get( i ).synthStateChanged( e );
        }
    }

    public void addSynthStateListener( SynthStateListener l )
    {
        if (!stateListenerList.contains( l ))
        {
            stateListenerList.add( l );
        }
    }

    public void removeSynthStateListener( SynthStateListener l )
    {
        stateListenerList.remove( l );
    }

    public String toString()
    {
        return getName() + "[Version=" + getVersion() + ", Vendor="
                + getVendor() + "]";
    }

    protected void checkPreconditions(boolean connect) throws SynthException
    {
        if (connect == isConnected()) return;
        
        if (connect)
        {
            if (midiInInfo == null) throw new SynthException("MIDI input device not set.");
            if (midiOutInfo == null) throw new SynthException("MIDI output device not set.");
        }
    }
    
}
