package net.sf.nmedit.jpdl2.test;

import java.io.StringReader;

import org.junit.Test;

import net.sf.nmedit.jpdl2.bitstream.BitStream;
import net.sf.nmedit.jpdl2.PDLDocument;
import net.sf.nmedit.jpdl2.PDLException;
import net.sf.nmedit.jpdl2.PDLPacket;
import net.sf.nmedit.jpdl2.format.PDL2Parser;
import net.sf.nmedit.jpdl2.parser.PDLBitstreamParser;

public class BitstreamParseTests
{

    public PDLPacket test(BitStream stream, String pdlsrc) throws PDLException
    {
        PDL2Parser parser = new PDL2Parser(new StringReader("start start;"+pdlsrc));
        parser.parse();
        PDLDocument doc = parser.getDocument();
        
        PDLBitstreamParser bsparse = new PDLBitstreamParser();
        return bsparse.parse(stream, doc);
    }
    
    private BitStream stream(int ... data)
    {
        BitStream bs = new BitStream();
        for (int i=0;i<data.length;i+=2)
            bs.append(data[i],data[i+1]);
        bs.setPosition(0);
        return bs;
    }

    @Test
    public void parseNothing() throws PDLException
    {
        test(stream(), "start := ;");
    }

    @Test(expected=PDLException.class) 
    public void constBitsNotAvailable() throws PDLException
    {
        test(stream(), "start := 0:1;");
    }

    @Test(expected=PDLException.class) 
    public void varBitsNotAvailable() throws PDLException
    {
        test(stream(), "start := v:1;");
    }

    @Test
    public void parseConst0x00() throws PDLException
    {
        test(stream(0x00,8), "start := 0:8;");
    }

    @Test
    public void parseConst0xFF() throws PDLException
    {
        test(stream(0xFf,8), "start := 0xFf:8;");
    }

    @Test
    public void parseVariable() throws PDLException
    {
        for (int i=0;i<=0xFf;i+=0xFf)
        {
            PDLPacket packet = test(stream(i,8), "start := v:8;");
            if (packet.getVariable("v")!=i)
                throw new PDLException("variable has wrong value: "+packet.getVariable("v")+" expected:"+i);
        }
    }

    @Test
    public void parse2Variables() throws PDLException
    {
        int[] v = {0xFf, 0x01}; 
        PDLPacket packet = test(stream(v[0],8, v[1], 8), "start := v1:8 v2:8;");
        for (int i=1;i<=2;i++)
            if (packet.getVariable("v"+i)!=v[i-1])
                throw new PDLException("variable has wrong value: "+packet.getVariable("v"+i)+" expected:"+v[i-1]);
    }

}
