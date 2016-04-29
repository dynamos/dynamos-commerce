package com.dynamos.web.controller;

import com.dynamos.domain.entity.User;
import com.dynamos.domain.repository.UserRepository;
import com.dynamos.domain.service.UserService;
import com.dynamos.domain.util.SecurityUtils;
import com.dynamos.dto.ManagedUserVO;
import com.dynamos.dto.Message;
import com.dynamos.dto.MessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by adelmo on 07/02/16.
 */
@Controller
@RequestMapping(value = "/perfil")
public class PerfilController extends AbstractController{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> index(ModelAndView modelAndView){
        User user = userRepository.findOneByLogin(SecurityUtils.getCurrentUserLogin()).get();

        return new ResponseEntity<ManagedUserVO>(new ManagedUserVO(user), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> salvar(@Validated @RequestBody ManagedUserVO user, Errors errors){
        if(errors.hasErrors()){
            return new ResponseEntity(addValidationErrorMessage(errors), HttpStatus.BAD_REQUEST);
        }
        try{
            userService.updateUserInformation(user.getEmail());

            return new ResponseEntity(new Message(getMessage("system.success"), getMessage("system.perfil.success_update"), MessageType.SUCCESS), HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity(new Message(getMessage("system.danger"), getMessage("system.perfil.error_update"), MessageType.DANGER), HttpStatus.OK);
        }
    }
}
