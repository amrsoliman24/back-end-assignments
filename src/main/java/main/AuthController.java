package main;


import Dtos.AuthenticationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import services.SysUserDetails;
import services.SysUsersDetailsService;

@RestController
public class AuthController {
 @Autowired
 AuthenticationManager authenticationManager;
 @Autowired
 SysUsersDetailsService sysUsersDetailsService;
 @Autowired
 JwtManager jwtManager;

    @RequestMapping(value ="/Authenticate" , method = RequestMethod.POST)
    public ResponseEntity<?> Authenticate(@RequestBody AuthenticationDto authDto) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authDto.getUsername() ,authDto.getPassword())
            );
        }catch (BadCredentialsException e){
            throw new Exception("Invalid creedentials", e);
        }

        final SysUserDetails  sysUserDetails = (SysUserDetails) sysUsersDetailsService.loadUserByUsername(authDto.getUsername());

        final String Jwt = jwtManager.generateleken(sysUserDetails);

        return ResponseEntity.ok(Jwt);




    }
 }
