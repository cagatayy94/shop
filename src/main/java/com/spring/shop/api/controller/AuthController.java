package com.spring.shop.api.controller;

import com.spring.shop.bussiness.abstracts.AdminUserService;
import com.spring.shop.bussiness.abstracts.PlatformUserService;
import com.spring.shop.core.entities.JwtAdminResponse;
import com.spring.shop.core.entities.JwtRequest;
import com.spring.shop.core.entities.JwtResponse;
import com.spring.shop.core.entities.dtos.RegisterDto;
import com.spring.shop.core.util.JwtTokenUtil;
import com.spring.shop.auth.JwtUserDetailsService;
import com.spring.shop.entities.AdminUser;
import com.spring.shop.core.entities.Permission;
import com.spring.shop.entities.PlatformUser;
import com.spring.shop.core.entities.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private PlatformUserService platformUserService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        final PlatformUser platformUser = this.platformUserService.getFirstByEmail(userDetails.getUsername());

        if (platformUser == null || platformUser.isDeleted()){
            return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
        }

        if (!platformUser.isEmailApproved()){
            return new ResponseEntity<String>("Please approve your email",HttpStatus.UNAUTHORIZED);
        }

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @RequestMapping(value = "admin/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationTokenForAdmin(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);
        final AdminUser adminUser = adminUserService.getFirstByEmail(userDetails.getUsername());

        if (adminUser == null){
            return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
        }

        StringBuilder permissions = new StringBuilder();

        for (Profile profile: adminUser.getProfiles()) {
            for (Permission permission:profile.getPermissions()) {
                permissions.append(permission.getSlug()+",");
            }
        }

        return ResponseEntity.ok(new JwtAdminResponse(token, permissions.toString()));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @PostMapping("/register")
    public void register(@RequestBody RegisterDto registerDto, HttpServletRequest request) throws Exception {
        registerDto.setIpAddress(request.getRemoteAddr());
        this.platformUserService.registerNewUser(registerDto);
    }
}
