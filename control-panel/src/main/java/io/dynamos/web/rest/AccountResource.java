package io.dynamos.web.rest;

import io.dynamos.domain.entity.PersistentToken;
import io.dynamos.domain.repository.PersistentTokenRepository;
import io.dynamos.domain.repository.UserRepository;
import io.dynamos.domain.service.MailService;
import io.dynamos.domain.service.UserService;
import io.dynamos.domain.util.SecurityUtils;
import io.dynamos.dto.KeyAndPassword;
import io.dynamos.dto.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AccountResource {

    private final Logger log = LoggerFactory.getLogger(AccountResource.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PersistentTokenRepository persistentTokenRepository;

    @Autowired
    private MailService mailService;


    @GetMapping("activate")
    public ResponseEntity<String> activateAccount(@RequestParam(value = "key") String key) {
        return Optional.ofNullable(userService.activateRegistration(key))
                .map(user -> new ResponseEntity<String>(HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @GetMapping("authenticate")
    public String isAuthenticated(HttpServletRequest request) {
        return request.getRemoteUser();
    }

    @GetMapping("account")
    public ResponseEntity<UserVO> getAccount() {
        return Optional.ofNullable(userService.getUserWithAuthorities())
                .map(user -> new ResponseEntity<>(new UserVO(user), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @PostMapping("account")
    public ResponseEntity<String> saveAccount(@RequestBody UserVO UserVO) {
        return userRepository
                .findOneWithAuthoritiesById(UserVO.getLogin())
                .filter(u -> u.getLogin().equals(SecurityUtils.getCurrentUserLogin()))
                .map(u -> {
                    userService.updateUserInformation(UserVO.getEmail());
                    return new ResponseEntity<String>(HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @PostMapping("/account/change_password")
    public ResponseEntity<?> changePassword(@RequestBody String password) {
        if (!checkPasswordLength(password)) {
            return new ResponseEntity<>("Incorrect password", HttpStatus.BAD_REQUEST);
        }
        userService.changePassword(password);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/account/sessions")
    public ResponseEntity<List<PersistentToken>> getCurrentSessions() {
        return userRepository.findOneWithAuthoritiesById(SecurityUtils.getCurrentUserLogin())
                .map(user -> new ResponseEntity<>(
                        persistentTokenRepository.findByUser(user),
                        HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @DeleteMapping("/account/sessions/{series}")
    public void invalidateSession(@PathVariable String series) throws UnsupportedEncodingException {
        String decodedSeries = URLDecoder.decode(series, "UTF-8");
        userRepository.findOneWithAuthoritiesById(SecurityUtils.getCurrentUserLogin()).ifPresent(u -> {
            persistentTokenRepository.findByUser(u).stream()
                    .filter(persistentToken -> StringUtils.equals(persistentToken.getSeries(), decodedSeries))
                    .findAny().ifPresent(t -> persistentTokenRepository.delete(decodedSeries));
        });
    }

    @PostMapping("/account/reset_password/init")
    public ResponseEntity<?> requestPasswordReset(@RequestBody String mail, HttpServletRequest request) {
        return userService.requestPasswordReset(mail)
                .map(user -> {
                    String baseUrl = request.getScheme() +
                            "://" +
                            request.getServerName() +
                            ":" +
                            request.getServerPort();
                    mailService.sendPasswordResetMail(user, baseUrl);
                    return new ResponseEntity<>("e-mail was sent", HttpStatus.OK);
                }).orElse(new ResponseEntity<>("e-mail address not registered", HttpStatus.BAD_REQUEST));
    }

    @PostMapping("/account/reset_password/finish")
    public ResponseEntity<String> finishPasswordReset(@RequestBody KeyAndPassword keyAndPassword) {
        if (!checkPasswordLength(keyAndPassword.getNewPassword())) {
            return new ResponseEntity<>("Incorrect password", HttpStatus.BAD_REQUEST);
        }
        return userService.completePasswordReset(keyAndPassword.getNewPassword(), keyAndPassword.getKey())
                .map(user -> new ResponseEntity<String>(HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    private boolean checkPasswordLength(String password) {
        return (!StringUtils.isEmpty(password) &&
                password.length() >= UserVO.PASSWORD_MIN_LENGTH &&
                password.length() <= UserVO.PASSWORD_MAX_LENGTH);
    }
}