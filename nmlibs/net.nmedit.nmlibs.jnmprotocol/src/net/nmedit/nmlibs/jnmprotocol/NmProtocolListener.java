/*
    Nord Modular Midi Protocol 3.03 Library
    Copyright (C) 2003-2006 Marcus Andersson

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/

package net.nmedit.nmlibs.jnmprotocol;

import java.util.EventListener;

import net.nmedit.nmlibs.jnmprotocol.AckMessage;
import net.nmedit.nmlibs.jnmprotocol.ErrorMessage;
import net.nmedit.nmlibs.jnmprotocol.IAmMessage;
import net.nmedit.nmlibs.jnmprotocol.KnobAssignmentMessage;
import net.nmedit.nmlibs.jnmprotocol.LightMessage;
import net.nmedit.nmlibs.jnmprotocol.MeterMessage;
import net.nmedit.nmlibs.jnmprotocol.MorphAssignmentMessage;
import net.nmedit.nmlibs.jnmprotocol.MorphRangeChangeMessage;
import net.nmedit.nmlibs.jnmprotocol.NewPatchInSlotMessage;
import net.nmedit.nmlibs.jnmprotocol.NoteMessage;
import net.nmedit.nmlibs.jnmprotocol.ParameterMessage;
import net.nmedit.nmlibs.jnmprotocol.ParameterSelectMessage;
import net.nmedit.nmlibs.jnmprotocol.PatchListMessage;
import net.nmedit.nmlibs.jnmprotocol.PatchMessage;
import net.nmedit.nmlibs.jnmprotocol.SetPatchTitleMessage;
import net.nmedit.nmlibs.jnmprotocol.SlotActivatedMessage;
import net.nmedit.nmlibs.jnmprotocol.SlotsSelectedMessage;
import net.nmedit.nmlibs.jnmprotocol.SynthSettingsMessage;
import net.nmedit.nmlibs.jnmprotocol.VoiceCountMessage;

public abstract class NmProtocolListener implements EventListener
{
    public NmProtocolListener() {}

    public void messageReceived(IAmMessage message) {}
    public void messageReceived(LightMessage message) {}
    public void messageReceived(MeterMessage message) {}
    public void messageReceived(PatchMessage message) {}
    public void messageReceived(AckMessage message) {}
    public void messageReceived(PatchListMessage message) {}
    public void messageReceived(NewPatchInSlotMessage message) {}
    public void messageReceived(VoiceCountMessage message) {}
    public void messageReceived(SlotsSelectedMessage message) {}
    public void messageReceived(SlotActivatedMessage message) {}
    public void messageReceived(ParameterMessage message) {}
    public void messageReceived(ErrorMessage message) {}
    public void messageReceived(SynthSettingsMessage message) {}

    public void messageReceived(KnobAssignmentMessage message) {}
    public void messageReceived(MorphAssignmentMessage message) {}
    public void messageReceived(NoteMessage message) {}
    public void messageReceived(MorphRangeChangeMessage message) {}

    public void messageReceived(SetPatchTitleMessage message) { }

    public void messageReceived(ParameterSelectMessage message) { }
    
}
