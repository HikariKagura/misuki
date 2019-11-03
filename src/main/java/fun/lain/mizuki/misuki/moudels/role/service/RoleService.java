package fun.lain.mizuki.misuki.moudels.role.service;

import fun.lain.mizuki.misuki.moudels.role.dao.UserPermDao;
import fun.lain.mizuki.misuki.moudels.role.dao.UserRoleDao;
import fun.lain.mizuki.misuki.moudels.role.dao.UserRoleRefDao;

import javax.annotation.Resource;
import java.util.List;

public interface RoleService {

    public List<String> getUserRole(Long id);
}
