package seop.com.stockportfolio.signup.service;

import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpService {


    @Override
    public boolean isNotKorean(String name) {
        boolean isNotKorean = false;
        for(char c : name.toCharArray()) {
            if (!(Character.UnicodeBlock.of(c) == Character.UnicodeBlock.HANGUL_SYLLABLES)) {
                isNotKorean = true;
                break;
            }
        }
        return isNotKorean;
    }

    @Override
    public boolean isNotPhoneNumber(String phoneNumber) {

        String deleteBarPhoneNumber = phoneNumber.replace("-", "");

        if (deleteBarPhoneNumber.length() != 11) {
            return true;

        }

        if (!deleteBarPhoneNumber.substring(0, 3).equals("010")) {
            return true;
        }

        for (int i=0; i<deleteBarPhoneNumber.length(); ++i) {
            if (deleteBarPhoneNumber.charAt(i) < 0 || deleteBarPhoneNumber.charAt(i) > 9) {
                return true;
            }
        }

        return false;

    }
}
