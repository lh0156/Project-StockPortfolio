package seop.com.stockportfolio.signup.service;

public interface SignUpService {

    boolean isNotKorean(String name);
    boolean isNotPhoneNumber(String phoneNumber);

}
