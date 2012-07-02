package net.sf.jmimemagic;

import java.util.List;

public class MimeMagicTest {


    public static boolean checkIfMatchesMimeType(final MagicMatch match, final String mimeType) {
        if (match == null) {
            return false;
        }

        if (mimeType == null || "".equals(mimeType) == true) {
            return false;
        }

        final String matchType = match.getMimeType();
        if (matchType != null && matchType.startsWith(mimeType) == true) {
            return true;
        }

        List<MagicMatch> subMatches = match.getSubMatches();
        if (subMatches != null && subMatches.size() > 0) {
            for (MagicMatch subMatch : subMatches) {
                boolean checkIfMatches = checkIfMatchesMimeType(subMatch, mimeType);
                if (checkIfMatches == true) {
                    return true;
                }
            }
        }
        return false;
    }

}
