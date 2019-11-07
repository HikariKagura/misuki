package fun.lain.mizuki.misuki.moudels.user.service;

import fun.lain.mizuki.misuki.moudels.user.entity.UserInfo;

public interface UserService {
    boolean login(String email,String password);
    boolean reg(UserInfo info);
}
