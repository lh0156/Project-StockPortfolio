package seop.com.stockportfolio.login.service;

public interface LoginService {

    boolean isNotKorean(String name);
    boolean isNotPhoneNumber(String phoneNumber);

}
