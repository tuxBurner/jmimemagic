/*
jMimeMagic(TM) is a Java library for determining the content type of files or
streams.

Copyright (C) 2004 David Castro

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

For more information, please email arimus@users.sourceforge.net
*/
package net.sf.jmimemagic.detectors;

import net.sf.jmimemagic.MagicDetector;

import org.apache.commons.io.ByteOrderMark;
import org.apache.commons.io.input.BOMInputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.oro.text.perl.Perl5Util;

import java.io.*;

import java.util.Map;


/**
 * DOCUMENT ME!
 *
 * @author $Author$
 * @version $Revision$
  */
public class TextFileDetector implements MagicDetector
{
    private static Log log = LogFactory.getLog(TextFileDetector.class);

    /**
     * Creates a new TextFileDetector object.
     */
    public TextFileDetector()
    {
        super();
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String getDisplayName()
    {
        return "Text File Detector";
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String getVersion()
    {
        return "0.1";
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String[] getHandledExtensions()
    {
        return new String[] { "txt", "text" };
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String[] getHandledTypes()
    {
        return new String[] { "text/plain" };
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String getName()
    {
        return "textfiledetector";
    }

    /**
     * DOCUMENT ME!
     *
     * @param data DOCUMENT ME!
     * @param offset DOCUMENT ME!
     * @param length DOCUMENT ME!
     * @param bitmask DOCUMENT ME!
     * @param comparator DOCUMENT ME!
     * @param mimeType DOCUMENT ME!
     * @param params DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String[] process(byte[] data, int offset, int length, long bitmask, char comparator,
        String mimeType, Map<String,String> params)
    {
        log.debug("processing stream data");

        Perl5Util util = new Perl5Util();

        try {
            BOMInputStream bomIn = new BOMInputStream(new ByteArrayInputStream(data), ByteOrderMark.UTF_8, ByteOrderMark.UTF_16LE, ByteOrderMark.UTF_16BE);
            if (bomIn.hasBOM()) {
                return new String[] { "text/plain" };
            }
        } catch (IOException e) {
            log.error("TextFileDetector: error detecting byte order mark");
        }

        try {
            String s = new String(data, "UTF-8");

            if (!util.match("/[^[:ascii:][:space:]]/", s)) {
                return new String[] { "text/plain" };
            }
        } catch (UnsupportedEncodingException e) {
            log.error("TextFileDetector: failed to process data");
        }

        return null;
    }

    /**
     * DOCUMENT ME!
     *
     * @param file DOCUMENT ME!
     * @param offset DOCUMENT ME!
     * @param length DOCUMENT ME!
     * @param bitmask DOCUMENT ME!
     * @param comparator DOCUMENT ME!
     * @param mimeType DOCUMENT ME!
     * @param params DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String[] process(File file, int offset, int length, long bitmask, char comparator,
        String mimeType, Map<String,String> params)
    {
        log.debug("processing file data");

        try {
            BufferedInputStream is = new BufferedInputStream(new FileInputStream(file));

            byte[] b = new byte[length];
            int n = is.read(b, offset, length);
            if (n > 0) {
                return process(b, offset, length, bitmask, comparator, mimeType, params);
            }
        } catch (IOException e) {
            log.error("TextFileDetector: error", e);
        }

        return null;
    }
}
