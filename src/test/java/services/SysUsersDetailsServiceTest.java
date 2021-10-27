package services;

import entities.user;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import reposotories.userRepo;

import static org.junit.jupiter.api.Assertions.*;

class SysUsersDetailsServiceTest {
   @Mock
   SysUserDetails sysUserDetails;
   @Mock
   userRepo UserREPO;
   @InjectMocks
   SysUsersDetailsService sysUsersDetailsService;
    @BeforeEach
    public void Mocksinit() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void loadUserByUsername() {
        user User = new user();
        User.setId(5L);
        User.setUsername("amooraaaaaa");
        User.s
        Mockito.when(UserREPO.findByusername(Mockito.anyString())).thenReturn(User);
        Mockito.when(new SysUserDetails(Mockito.any())).thenReturn(null);
        assertNull(sysUsersDetailsService.loadUserByUsername(Mockito.any()));

    }
}