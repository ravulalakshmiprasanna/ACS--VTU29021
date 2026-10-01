import java.util.*;

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<>();

        for (String email : emails) {
            String[] parts = email.split("@");

            String local = parts[0];
            String domain = parts[1];

            int plus = local.indexOf('+');

            if (plus != -1) {
                local = local.substring(0, plus);
            }

            local = local.replace(".", "");

            unique.add(local + "@" + domain);
        }

        return unique.size();
    }
}