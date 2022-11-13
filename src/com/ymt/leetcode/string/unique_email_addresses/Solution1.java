package com.ymt.leetcode.string.unique_email_addresses;

import java.util.HashSet;
import java.util.Set;

/**
 * @description
 * @author yumingtao
 * @date 2022-11-13 17:13
 */
public class Solution1 {
    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for (String email : emails) {
            String[] emailSplit = email.split("@");
            String localName = emailSplit[0];
            int plusIndex = localName.indexOf("+");
            if (plusIndex > 0) {
                localName = localName.substring(0, plusIndex);
            }
            emailSet.add(localName.replace(".", "") + "@" + emailSplit[1]);
        }
        return emailSet.size();
    }
}
