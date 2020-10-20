import java.util.*;

class PhoneNumbers {

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        Map<String, Boolean> map = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {
            String str = phone_book[i];

            Set<String> keys = map.keySet();

            for (String key : keys) {
                if (str.contains(key) && (str.charAt(0) == key.charAt(0))) {
                    return false;
                }
            }

            map.put(str, true);
        }

        return true;
    }
}