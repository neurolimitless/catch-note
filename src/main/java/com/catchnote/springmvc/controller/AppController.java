package com.catchnote.springmvc.controller;

import com.catchnote.springmvc.model.User;
import com.catchnote.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class AppController {
    @Autowired
    UserService userService;

    @Autowired
    MessageSource messageSource;


    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String getLogin(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "allusers";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String addUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        return "registration";
    }


    @RequestMapping(value = {"/"}, method = RequestMethod.POST)

    public String login(@RequestParam(value = "name", required = false) String name,
                        @RequestParam(value = "pass", required = true) String pass,
                        ModelMap model) {
        User user = userService.findUserByName(name);
        if (null != user && userService.isCorrectPassword(pass, user.getPass())) {
            model.addAttribute("logged", true);
            model.addAttribute("user", name);
            return "main";
        } else {
            model.put("error", "Invalid username/password");
            return "login";
        }
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result,
                           ModelMap model) {

        if (result.hasErrors()) {
            return "registration";
        }

        if (!userService.isUserUnique(user.getId(), user.getEmail(), user.getName())) {
            FieldError emailError = new FieldError("user", "email", messageSource.getMessage("non.unique.email", new String[]{user.getEmail()}, Locale.getDefault()));
            FieldError nameError = new FieldError("user", "name", messageSource.getMessage("non.unique.name", new String[]{user.getName()}, Locale.getDefault()));
            result.addError(emailError);
            result.addError(nameError);
            return "registration";
        }
        user.setPass(DigestUtils.md5DigestAsHex(user.getPass().getBytes()));
        userService.saveUser(user);

        model.addAttribute("success", "User " + user.getName() + " registered successfully");
        return "success";
    }

    /*
 * This method will provide the medium to update an existing user.
 */
    @RequestMapping(value = {"/edit-{email}-user"}, method = RequestMethod.GET)
    public String editUser(@PathVariable String email, ModelMap model) {
        User user = userService.findUserByEmail(email);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        return "registration";
    }

    /*
     * This method will be called on form submission, handling POST request for
     * updating user in database. It also validates the user input
     */
    @RequestMapping(value = {"/edit-{email}-user"}, method = RequestMethod.POST)
    public String updateUser(@Valid User user, BindingResult result,
                             ModelMap model, @PathVariable String email) {

        if (result.hasErrors()) {
            return "registration";
        }

        if (!userService.isUserUnique(user.getId(), user.getEmail(), user.getName())) {
            FieldError emailError = new FieldError("user", "email", messageSource.getMessage("non.unique.email", new String[]{user.getEmail()}, Locale.getDefault()));
            result.addError(emailError);
            return "registration";
        }

        userService.updateUser(user);

        model.addAttribute("success", "User " + user.getName() + " updated successfully");
        return "success";
    }


    /*
     * This method will delete an user by it's SSN value.
     */
    @RequestMapping(value = {"/delete-{email}-user"}, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String email) {
        userService.deleteUserByEmail(email);
        return "redirect:/list";
    }
}
