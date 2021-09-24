package task.com.example.demo.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import task.com.example.demo.Constants.MasterConstants;
import task.com.example.demo.DTO.RoleDto;
import task.com.example.demo.DTO.UserDto;
import task.com.example.demo.DTO.UserSignupRequestVO;
import task.com.example.demo.Model.Role;
import task.com.example.demo.Model.User;
import task.com.example.demo.Model.UserRole;
import task.com.example.demo.Repository.RoleRepository;
import task.com.example.demo.Repository.UserRepository;
import task.com.example.demo.Repository.UserRoleRepository;
import task.com.example.demo.Serviceinterface.ServiceRole;
import task.com.example.demo.util.Constants;
import task.com.example.demo.util.JwtUtil;

import java.util.*;

@Service
@Transactional
public class ServiceImpl implements ServiceRole {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserDto Saveuser(UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUsername());
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        user.setPassword(bcrypt.encode(userDto.getPassword()));
        userRepository.save(user);
        saveRole(userDto.getRoles(), user);
       return userDto;
    }

    private void saveRole(List<RoleDto> roles, User userDetail) {
        List<UserRole> userRoles = new LinkedList<>();
        try {
            if (Objects.nonNull(roles) && roles.size() > 0) {
                roles.stream().forEachOrdered(role -> {
                    Role role1 = roleRepository.findById(role.getId())
                            .orElseThrow(() -> new RuntimeException(MasterConstants.ERROR_MESSAGE2));
                    UserRole userRole = new UserRole();
                    userRole.setUser(userDetail);
                    userRole.setRole(role1);
                    userRoles.add(userRole);
                });
                userRoleRepository.saveAll(userRoles);
            }
        } catch (NoSuchElementException e) {
           throw new RuntimeException(MasterConstants.ERROR_MESSAGE3);
        }
    }

    @Override
    public UserSignupRequestVO logOfUser(UserSignupRequestVO userSignupRequestVO) {
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        List<Role> roles = new LinkedList<>();
        try {
            Optional<User> user = userRepository.findByUserName(userSignupRequestVO.getUserName());
            boolean status = bCrypt.matches(userSignupRequestVO.getPassword(), user.get().getPassword());
            if (user.isPresent() && status == true) {
                List<UserRole> userRoles = userRoleRepository.findByUserId(user.get().getId());
                userRoles.stream().forEachOrdered(userRole -> {
                    Role role = userRole.getRole();
                    roles.add(role);
                });
                String Token = JwtUtil.generateToken(Constants.SIGNIN_KEY, user.get().getId(), "user", user.get().getUserName(), roles);
                userSignupRequestVO.setUserName(user.get().getUserName());
                userSignupRequestVO.setId(user.get().getId());
                userSignupRequestVO.setRoleList(user.get().getRoles());
                userSignupRequestVO.setJwtToken(Token);
            }else throw new RuntimeException(MasterConstants.ERROR_MESSAGE4);
        } catch (Exception e) {
            e.printStackTrace();
        }
       return userSignupRequestVO;

    }

    public UserDetails loadByUserName(String username) throws UsernameNotFoundException {
        Optional<User> userDetail = userRepository.findByUserName(username);
        List<Role> roles = new LinkedList<>();
        if (userDetail == null) {
            throw new RuntimeException(MasterConstants.ERROR_MESSAGE4);
        }
        else{
            List<UserRole> userRoles = userRoleRepository.findByUserId(userDetail.get().getId());
            userRoles.stream().forEachOrdered(userRole -> {
                Role role = userRole.getRole();
                roles.add(role);
    });
            return new org.springframework.security.core.userdetails.User(userDetail.get().getUserName(), userDetail.get().getPassword(), getAuthority(roles));
        }
    }

    private List getAuthority(List<Role> role){
        List authorities=new ArrayList();
        role.stream().forEachOrdered(role1 -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" +role1.getRoleName()));
        });
        return authorities;
    }
}

